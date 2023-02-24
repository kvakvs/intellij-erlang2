package se.clau.ironclad.parsercombinators

import com.intellij.psi.tree.IElementType

object Matcher {
    /**
     * Returns a void parser which matches a single token
     */
    fun token(
        tok: IElementType
    ): Parser<IElementType> {
        return fun(input: IParserInput, state: IParserState?): ParserResult<IElementType> {
            val actual = input.take()
            if (actual != null && actual.sameElementType(tok)) {
                return ParserResult(input.clone(), tok, EmptyState)
            }
            throw ParserCombinatorError("Expected token ${tok} not found, instead found ${actual}")
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
                    throw ParserCombinatorError("Expected token ${tok} not found, instead found ${actual}")
                }
            }
            return ParserResult(input.clone(), Unit, EmptyState)
        }
    }

}