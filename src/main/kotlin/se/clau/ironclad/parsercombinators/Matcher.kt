package se.clau.ironclad.parsercombinators

import com.intellij.psi.tree.IElementType

object Matcher {
    /**
     * Returns a void parser which matches a single token
     */
    fun token(
        tok: IElementType
    ): Parser<Unit> {
        return fun(input: IParserInput, state: IParserState?): ParserResult<Unit> {
            val actual = input.take()
            if (actual != null && actual.sameElementType(tok)) {
                return ParserResult(input, Unit, EmptyState)
            }
            throw ParseCombinatorError("Expected token ${tok} not found, instead found ${actual}")
        }
    }

   /**
     * Returns a void parser which matches a sequence of tokens from the paramters
     */
    fun tokenSequence(
        vararg tokens: IElementType
    ): Parser<Unit> {
        return fun(input: IParserInput, state: IParserState?): ParserResult<Unit> {
            for (tok in tokens) {
                val actual = input.take()
                if (actual == null || !actual.sameElementType(tok)) {
                    throw ParseCombinatorError("Expected token ${tok} not found, instead found ${actual}")
                }
            }
            return ParserResult(input, Unit, EmptyState)
        }
    }

}