package se.clau.ironclad.language

import com.intellij.lexer.FlexAdapter
import com.intellij.lexer.LexerBase
import com.intellij.psi.tree.IElementType

//@Deprecated(message = "Use ErlangLexer Flex wrapper")
//class ModifiedErlangLexer : GeneratedErlangLexer() {
//    data class CacheRecord(val element: IElementType?, val start: Int, val end: Int) {
//        fun applyState(lexer: ModifiedErlangLexer) {
//            lexer.start = start
//            lexer.end = end
//        }
//    }
//
//    // Entire output from superclass is stored in the cache, we preprocess its contents, interpreting
//    // the defines, undefs and conditions, and then we feed from it.
//    val outputCache = ArrayList<CacheRecord>()
//
//    var cacheReadIndex = 0
////    var start: Int;
////    var end: Int;
//
//    //    var preprocessor = Preprocessor()
////
//    private fun haveTokenInCache() = cacheReadIndex < outputCache.size
//    private fun nextFromCache(): CacheRecord =
//        outputCache[cacheReadIndex++]
//
//    //    /**
////     * Call super.advance() and store in the outputTokens
////     * @return The token retrieved (and stored)
////     */
////    private fun advanceAndCache(): IElementType? {
////        val nextElement = super.advance()
////        outputCache.add(cacheReadIndex, nextElement)
////        return nextElement
////    }
////
//    override fun advance(): IElementType? {
//        if (haveTokenInCache()) {
//            val next = nextFromCache()
//            next.applyState(this) // write lexer state from the cache
//        }
//        return null
//    }
////        // This allows feeding from the outputCache, if it has elements ahead of outputIndex.
////        // If there were tokens pasted, they would be read here.
////
////        val nextElement = advanceAndCache()
////        if (nextElement == ErlangElementTypes.PP_PASTE) {
////            // Paste token modifies the outputTokens and pastes the macro contents
////            val macroName = this.yytext().toString()
////            val id = Preprocessor.MacroArity(macroName, 0)
////            // TODO: Extract paste macro name from nextElement
////            // TODO: Parse paste with parameters
////
////            val macro = preprocessor.findMacro(id)
////
////            if (macro != null) {
////                outputCache.addAll(cacheReadIndex, macro.tokens)
////            }
////        } else if (nextElement == ErlangElementTypes.PP_DEFINE
////            && tryMatchDefineDirective()
////        ) {
////            return advance() // step once more, after the match has finished
////        }
////
////        return nextFromCache()
////    }
////
////    /**
////     * "-" already matched, continue matching the directive body
////     */
////    private fun tryMatchDefineDirective(): Boolean {
////        if (tryMatchNextToken(ErlangElementTypes.L_PAREN) == null) {
////            return false
////        }
////        return true
////    }
////
////    private fun tryMatchNextToken(vararg expectElement: IElementType): IElementType? {
////        val next = advanceAndCache()
////        for (i in expectElement) {
////            if (i == next) {
////                return next
////            }
////        }
////        return null
////    }
////
////    private fun pushback() {
////        // Step back in the paste array if its not empty
////        if (cacheReadIndex >= 0) {
////            cacheReadIndex--
////            return
////        }
////        // If there are still steps to step back
////        super.yypushback(1)
////    }
////
////    override fun yypushback(number: Int) {
////        for (i in 0..number) {
////            pushback()
////        }
////    }
//
//    override fun reset(buffer: CharSequence, start: Int, end: Int, initialState: Int) {
//        super.reset(buffer, start, end, initialState)
//        resetCache()
//    }
//
//    private fun resetCache() {
//        var tok: IElementType? = super.advance()
//        while (tok != null) {
////            outputCache.add(createCacheRecord(tok))
//            tok = super.advance()
//        }
//    }
//}

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
                    wrappedLexer.tokenStart,
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
