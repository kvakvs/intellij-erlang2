package se.clau.ironclad.language.preprocessor

import com.intellij.psi.tree.IElementType
import se.clau.ironclad.language.ErlangElementTypes
import se.clau.ironclad.parsercombinators.IParserInput

/**
 * Filter the raw tokens list produced by the GeneratedErlangLexer.
 * Contains code to detect and execute preprocessor directives
 */
object Preprocessor {
    fun preprocess(
        input: IParserInput,
        output: MutableList<CachedLexerStep>,
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
                output.add(input.take()!! as CachedLexerStep)
            }
        }
    }

    private fun parseAnyDirective(
        input: IParserInput,
        preprocessorScope: PreprocessorScope
    ): IPreprocessorDirective? {
        val nextTok = input.take() as CachedLexerStep
        return when (nextTok.element) {
            ErlangElementTypes.PP_DEFINE -> {
                val result = DefineDirective.parser()(input, preprocessorScope)
                return result.result
            }
            else -> null // not detected one
        }
    }

//    private fun tryDefine(
//        input: IPreprocessorInput,
//        output: IPreprocessorOutput,
//        preprocessorScope: PreprocessorScope
//    ): IPreprocessorDirective? {
//        expectToken(input, 1, ErlangElementTypes.L_PAREN)
//    }

    /**
     * Throw an exception if `offset`-th token is not `tok`
     */
//    private fun expectToken(input: IPreprocessorInput, offset: Int, tok: IElementType) {
//        val actual = input.peek(offset)
//        if (actual.element != tok) {
//            throw PreprocessorError("Token $tok was expected, but found $actual")
//        }
//    }
}