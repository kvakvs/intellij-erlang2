package se.clau.ironclad.language

import com.intellij.psi.tree.IElementType
import se.clau.ironclad.filetype.ErlangLanguage

//class ErlangElementType(s: String) : IElementType(s, ErlangLanguage), ICompositeElementType {
class ErlangElementType(s: String) : IElementType(s, ErlangLanguage) {
//    override fun createCompositeNode(): ASTNode {
//        return ErlangElementTypes.Factory.createElement().node
//    }
}
