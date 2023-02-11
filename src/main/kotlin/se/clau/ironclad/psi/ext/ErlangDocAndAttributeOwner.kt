package se.clau.ironclad.psi.ext

import ErlangMetaItemPsiOrStub

//interface ErlangDocAndAttributeOwner: ErlangElement, NavigatablePsiElement, ErlangAttributeOwnerPsiOrStub {
//    override val rawMetaItems: Sequence<ErlangMetaItem>
//        get() = ErlangInnerAttributeOwnerRegistry.rawMetaItems(this)
//}

//fun ErlangDocAndAttributeOwner.getTraversedRawAttributes(withCfgAttrAttribute: Boolean = false): QueryAttributes<ErlangMetaItem> {
//    return QueryAttributes(rawMetaItems.withFlattenCfgAttrsAttributes(withCfgAttrAttribute))
//}

//class QueryAttributes<out T : ErlangMetaItemPsiOrStub>(
//    val metaItems: Sequence<T>
//) {
//}