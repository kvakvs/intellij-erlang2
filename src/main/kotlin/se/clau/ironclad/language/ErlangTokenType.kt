package se.clau.ironclad.language

import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.TokenSet
import se.clau.ironclad.filetype.ErlangLanguage

open class ErlangTokenType(debugName: String) : IElementType(debugName, ErlangLanguage) {
    override fun toString(): String {
        return "ErlangToken \"${super.toString()}\""
    }
}

fun tokenSetOf(vararg tokens: IElementType) = TokenSet.create(*tokens)
