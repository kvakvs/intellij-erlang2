package se.clau.ironclad.language.preprocessor

import com.intellij.psi.tree.IElementType
import se.clau.ironclad.parsercombinators.IParserInputItem

// Stores lexer state for one step (step is done earlier on start()) and allows to replay the lexer
// from the outputCache
data class CachedLexerStep(val element: IElementType?, val start: Int, val end: Int, val state: Int): IParserInputItem {
    override fun sameElementType(tok: IElementType): Boolean = tok == this.element
}