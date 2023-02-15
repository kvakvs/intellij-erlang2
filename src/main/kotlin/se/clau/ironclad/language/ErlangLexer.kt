package se.clau.ironclad.language

import com.intellij.lexer.FlexAdapter
import com.intellij.psi.tree.IElementType

class ModifiedErlangLexer : GeneratedErlangLexer() {
    // As we encounter a token, it is added here and is fed from here
    // As we encounter a preprocessor paste ?TOKEN, its contents are inserted here
    val outputCache = ArrayList<IElementType>()
    var outputIndex = -1
    var preprocessorCache = Preprocessor()

    private fun haveToken() = outputIndex < outputCache.size
    private fun nextFromCache() = outputCache[outputIndex++]

    /**
     * Call super.advance() and store in the outputTokens
     * @return The token retrieved (and stored)
     */
    private fun advanceAndCache(): IElementType {
        val nextElement = super.advance()
        outputCache.add(outputIndex, nextElement)
        return nextElement
    }

    override fun advance(): IElementType {
        // This allows feeding from the outputCache, if it has elements ahead of outputIndex.
        // If there were tokens pasted, they would be read here.
        if (haveToken()) {
            return nextFromCache()
        }

        val nextElement = advanceAndCache()
        if (nextElement == ErlangElementTypes.PP_PASTE) {
            // Paste token modifies the outputTokens and pastes the macro contents
            val macroName = this.yytext().toString()
            val id = Preprocessor.MacroArity(macroName, 0)
            // TODO: Extract paste macro name from nextElement
            // TODO: Parse paste with parameters

            val macro = preprocessorCache.findMacro(id)

            if (macro != null) {
                outputCache.addAll(outputIndex, macro.tokens)
            }
        } else if (nextElement == ErlangElementTypes.PP_DEFINE
            && tryMatchDefineDirective()) {
            return advance() // step once more, after the match has finished
        }

        return nextFromCache()
    }

    /**
     * "-" already matched, continue matching the directive body
     */
    private fun tryMatchDefineDirective(): Boolean {
        if (tryMatchNextToken(ErlangElementTypes.L_PAREN) == null) { return false; }
        return true
    }

    private fun tryMatchNextToken(vararg expectElement: IElementType): IElementType? {
        val next = advanceAndCache()
        for (i in expectElement) {
            if (i == next) {
                return next
            }
        }
        return null
    }

    private fun pushback() {
        // Step back in the paste array if its not empty
        if (outputIndex >= 0) {
            outputIndex--
            return
        }
        // If there are still steps to step back
        super.yypushback(1)
    }

    override fun yypushback(number: Int) {
        for (i in 0..number) {
            pushback()
        }
    }
}

class ErlangLexer : FlexAdapter(ModifiedErlangLexer())
//class ErlangLexer : ErlangFlexAdapter()
