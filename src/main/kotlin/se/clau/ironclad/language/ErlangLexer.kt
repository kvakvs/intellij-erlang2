package se.clau.ironclad.language

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType

//class ErlangLexer : ErlangFlexAdapter()
class ErlangLexer : LexerBase() {
    val wrappedLexer = FlexAdapter(GeneratedErlangLexer())

    // Stores lexer state for one step (step is done earlier on start()) and allows to replay the lexer
    // from the outputCache
    data class CachedLexerStep(val element: IElementType?, val start: Int, val end: Int, val state: Int)

    // Entire output from the wrapped lexer is stored in the cache, we preprocess its contents,
    // interpreting the defines, undefs and conditions, and then we feed from it
    val outputCache = ArrayList<CachedLexerStep>()

    var readIndex = 0

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        wrappedLexer.start(buffer, startOffset, endOffset, initialState)
        readIndex = 0;

        var tokenType: IElementType?

        while (wrappedLexer.tokenType.also { tokenType = it } != null) {
            outputCache.add(
                CachedLexerStep(
                    tokenType,
                    (wrappedLexer.flex as GeneratedErlangLexer).tokenStart,
                    wrappedLexer.tokenEnd,
                    wrappedLexer.state
                )
            )
            wrappedLexer.advance()
        }
    }

    override fun getState(): Int {
        return outputCache[readIndex].state
    }

    override fun getTokenType(): IElementType? {
        if (readIndex >= outputCache.size) {
            return null
        }
        return outputCache[readIndex].element
    }

    override fun getTokenStart(): Int {
        return outputCache[readIndex].start
    }

    override fun getTokenEnd(): Int {
        return outputCache[readIndex].end
    }

    override fun advance() {
        readIndex++
    }

    override fun getBufferSequence(): CharSequence {
        return wrappedLexer.bufferSequence
    }

    override fun getBufferEnd(): Int {
        return wrappedLexer.bufferEnd
    }
}
