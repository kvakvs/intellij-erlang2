package se.clau.ironclad.language

import com.intellij.lang.ASTNode
import com.intellij.psi.tree.ICompositeElementType
import com.intellij.psi.tree.IElementType
import se.clau.ironclad.filetype.ErlangLanguage

class ErlangElementType(s: String) : IElementType(s, ErlangLanguage), ICompositeElementType {
    override fun createCompositeNode(): ASTNode {
        return ErlangElementTypes.Factory.createElement(this.createCompositeNode()).node
    }
}
