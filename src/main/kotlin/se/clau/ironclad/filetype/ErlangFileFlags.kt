package se.clau.ironclad.filetype

import com.intellij.psi.stubs.StubInputStream

data class ErlangFileFlags(val isModule: Boolean) {

    fun serializeFlags(): String {
        return "{}"
    }

    companion object {
        fun from(dataStream: StubInputStream): ErlangFileFlags {
            return ErlangFileFlags(isModule = false)
        }
    }
}