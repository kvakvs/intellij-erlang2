interface ErlangMetaItemPsiOrStub {
}

interface ErlangAttributeOwnerPsiOrStub<T : ErlangMetaItemPsiOrStub> {
    val rawMetaItems: Sequence<T>
}

interface ErlangAttributeOwnerStub<T : ErlangMetaItemPsiOrStub> : ErlangAttributeOwnerPsiOrStub<T> {
//    companion object {
//        fun extractFlags(
//            element: ErlangDocAndAttributeOwner,
//            bitflagsKind: Any = CommonStubAttrFlags
//        ): ErlangFileFlags =
//            extractFlags(element.getTraversedRawAttributes(withCfgAttrAttribute = true), bitflagsKind)
//    }

    object CommonStubAttrFlags {
//        val HAS_ATTRS: Int = nextBitMask()
//        val MAY_HAVE_CFG: Int = nextBitMask()
//        val HAS_CFG_ATTR: Int = nextBitMask()
//        val MAY_HAVE_CUSTOM_DERIVE: Int = nextBitMask()
//        val MAY_HAVE_CUSTOM_ATTRS: Int = nextBitMask()
    }

    object FileStubAttrFlags {
    }
}

