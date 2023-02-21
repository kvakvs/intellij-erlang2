package se.clau.ironclad.language

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType
import se.clau.ironclad.language.preprocessor.*
import se.clau.ironclad.parsercombinators.IParserInput

//class ErlangLexer : ErlangFlexAdapter()
class ErlangLexer : LexerBase() {
    val wrappedLexer = FlexAdapter(GeneratedErlangLexer())

    // Entire output from the wrapped lexer is stored in the cache, we preprocess its contents,
    // interpreting the defines, undefs and conditions, and then we feed from it
    val outputCache = ArrayList<CachedLexerStep>()

    var readIndex = 0

    class InputImpl(val input: ArrayList<CachedLexerStep>, var position: Int = 0) : IParserInput {
        override fun have(): Boolean = position < input.size
        override fun take(): CachedLexerStep? = if (!have()) null else input[position++]
        override fun pushBack(n: Int) {
            position -= n
        }

        override fun peek(offset: Int): CachedLexerStep = input.elementAtOrElse(position + offset) { BLANK; }
    }

    override fun start(buffer: CharSequence, startOffset: Int, endOffset: Int, initialState: Int) {
        wrappedLexer.start(buffer, startOffset, endOffset, initialState)
        readIndex = 0

        var tokenType: IElementType?
        val rawTokens = ArrayList<CachedLexerStep>()

        // Parse entire input and store all tokens and positions for later replay
        while (wrappedLexer.tokenType.also { tokenType = it } != null) {
            rawTokens.add(
                CachedLexerStep(
                    element = tokenType,
                    start = (wrappedLexer.flex as GeneratedErlangLexer).tokenStart,
                    end = wrappedLexer.tokenEnd,
                    state = wrappedLexer.state
                )
            )
            wrappedLexer.advance()
        }

        // Try find known sequences of preprocessor directive tokens and execute their effect
        outputCache.clear()
        Preprocessor.preprocess(
            input = InputImpl(rawTokens),
            output = outputCache,
            PreprocessorScope()
        )
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

    companion object {
        private val BLANK = CachedLexerStep(null, 0, 0, 0)
    }
}
