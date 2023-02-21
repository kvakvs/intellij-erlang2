package se.clau.ironclad.language.preprocessor

import se.clau.ironclad.language.ErlangElementTypes
import se.clau.ironclad.parsercombinators.*

/**
 * A named macro directive
 * -define(NAME <optional args> (ARG1, ARG2, ...)], <tokens>).
 */
class DefineDirective(
    val name: String,
    val args: List<String>,
    val tokens: List<CachedLexerStep>
) : IPreprocessorDirective {
    companion object {
        /**
         * Attempt to parse the define directive from input
         * -define is matched in the caller. Here we match ( and inside ).
         */
        fun parser(): Parser<DefineDirective> {
            // try match args list
            return Combinator.delimited(
                Matcher.token(ErlangElementTypes.L_PAREN),
                DefineDirective::defineDirectiveParser,
                Matcher.tokenSequence(ErlangElementTypes.R_PAREN, ErlangElementTypes.PERIOD)
            )
        }

        private fun defineDirectiveParser(
            input: IParserInput,
            state: IParserState
        ): ParserResult<DefineDirective> {
            val macroName = Combinator.either(
                Matcher.token(ErlangElementTypes.ATOM_NAME),
                Matcher.token(ErlangElementTypes.VAR)
            )(input, state)
            val params = Multi.separated0(
                Matcher.token(ErlangElementTypes.VAR),
                Matcher.token(ErlangElementTypes.COMMA)
            )(macroName.input, macroName.state)
            return ParserResult(input, DefineDirective("", emptyList(), emptyList()), params.state)
        }
    }
}
