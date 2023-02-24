package se.clau.ironclad.language.preprocessor

import se.clau.ironclad.language.ErlangElementTypes
import se.clau.ironclad.parsercombinators.IParserInput

/**
 * Filter the raw tokens list produced by the GeneratedErlangLexer.
 * Contains code to detect and execute preprocessor directives
 */
object Preprocessor {
    fun preprocess(
        input: IParserInput,
        output: MutableList<TokenWithLexerState>,
        preprocessorScope: PreprocessorScope
    ) {
        // Go through every input token and try match -<directive> <optional body> .
        // if the match is found, the directive is executed and applied to the preprocessor scope
        // if no match, the token goes inchanged into the output
        while (input.have()) {
            val directive = parseAnyDirective(input, preprocessorScope)

            if (directive != null) {
                directive.execute(input, output, preprocessorScope)
            } else {
                val next = input.take()
                if (next != null) {
                    output.add(next as TokenWithLexerState)
                } else {
                    break
                }
            }
        }
    }

    private fun parseAnyDirective(
        input: IParserInput,
        preprocessorScope: PreprocessorScope
    ): IPreprocessorDirective? {
        val nextTok = input.take() as TokenWithLexerState
        return when (nextTok.element) {
            ErlangElementTypes.PP_DEFINE -> {
                val result = ParsedDefineDirective.parser(input, preprocessorScope)
                return result.value
            }

            else -> null // not detected one
        }
    }
}