package se.clau.ironclad.language.preprocessor

import com.intellij.psi.tree.IElementType
import se.clau.ironclad.parsercombinators.IParserInputItem

/**
 * Stores lexer state for one step (step is done earlier on start()) and allows to replay
 * the preprocessed token stream via the lexer.
 */
data class TokenWithLexerState(val element: IElementType?, val start: Int, val end: Int, val state: Int): IParserInputItem {
    override fun sameElementType(tok: IElementType): Boolean = tok == this.element
}
