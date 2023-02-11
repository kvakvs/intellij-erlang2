package se.clau.ironclad.psi.ext

import com.intellij.openapi.util.UserDataHolderEx
import com.intellij.psi.PsiElement

interface ErlangElement : PsiElement, UserDataHolderEx {
//    // Find parent module
//    val containingMod: ErlangMod
//        get() = contextStrict<ErlangMod>()?.getOriginalOrSelf()
//            ?: error("Element outside of module: $text")
//
//    val crateRoot: ErlangMod?
//        get() = containingErlangFileSkippingCodeFragments?.crateRoot
}
