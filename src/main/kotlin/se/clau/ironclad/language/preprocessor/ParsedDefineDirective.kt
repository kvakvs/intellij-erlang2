package se.clau.ironclad.language.preprocessor

import com.intellij.psi.tree.IElementType
import se.clau.ironclad.language.ErlangElementTypes
import se.clau.ironclad.parsercombinators.*

/**
 * A named macro directive parsed from the token stream.
 * Contains data necessary for populating the scope with this new definition and nothing more.
 * -define(NAME <optional args> (ARG1, ARG2, ...)], <tokens>).
 */
class ParsedDefineDirective(
    val name: String,
    val vars: Collection<String>,
    val tokens: Collection<TokenWithLexerState>
) : IPreprocessorDirective {
    companion object {
        /**
         * Attempt to parse the define directive from input
         * "-define" is matched by the caller. Here we match "(" and contents before ")."
         */
        fun parser(input: IParserInput, state: IParserState): ParserResult<ParsedDefineDirective> {
            // try match args list
            return Combinator.delimited(
                Matcher.token(ErlangElementTypes.L_PAREN),
                ParsedDefineDirective::defineDirectiveParser,
                Matcher.tokenSequence(ErlangElementTypes.R_PAREN, ErlangElementTypes.PERIOD)
            )(input.clone(), state)
        }

        private fun defineDirectiveParser(
            input: IParserInput,
            state: IParserState
        ): ParserResult<ParsedDefineDirective> {
            // Inside -define(NAME ...
            // Parse name which is lowercase (atom syntax) or uppercase (Var syntax)
            val macroName = Combinator.context(
                "Expected: a name for the definition, word starting from any letter or an underscore",
                Combinator.either(
                    Matcher.token(ErlangElementTypes.ATOM_NAME),
                    Matcher.token(ErlangElementTypes.VAR)
                )
            )(input.clone(), state)

            // Parse optional parameters -define(NAME, ( ARG1, ARG2, ... ), ...
            val params: ParserResult<List<IElementType>> = Combinator.opt(
                Combinator.delimited(
                    Matcher.token(ErlangElementTypes.L_PAREN),
                    Multi.separated0(
                        Matcher.token(ErlangElementTypes.VAR),
                        Matcher.token(ErlangElementTypes.COMMA)
                    ),
                    Matcher.token(ErlangElementTypes.R_PAREN),
                )
            ) { emptyList() }(macroName.input.clone(), macroName.state)

            return ParserResult(
                input.clone(),
                ParsedDefineDirective("", emptyList(), emptyList()),
                params.state
            )
        }
    }

    override fun execute(input: IParserInput, output: MutableList<TokenWithLexerState>, scope: PreprocessorScope) {
        scope.addDefinition(this.name, this.vars, this.tokens)
    }
}
