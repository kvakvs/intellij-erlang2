package se.clau.ironclad.filetype

import com.intellij.lang.Language

open class ErlangFamilyLanguage(id: String, mimeType1: String, mimeType2: String, mimeType3: String) :
    Language(id, mimeType1, mimeType2, mimeType3) {
    override fun isCaseSensitive() = true
}

object ErlangLanguage : ErlangFamilyLanguage(
    "Erlang",
    "text/erlang",
    "text/x-erlang",
    "application/x-erlang"
) {
    override fun getDisplayName(): String = "Erlang"
}

object ErlangHeaderLanguage :
    ErlangFamilyLanguage(
        "Erlang Header",
        "text/erlang-header",
        "text/x-erlang-header",
        "application/x-erlang-header"
    ) {
    override fun getDisplayName(): String = "Erlang Header"
}

object ErlangEscriptLanguage : ErlangFamilyLanguage(
    "Erlang Escript",
    "text/erlang-escript",
    "text/x-erlang-escript",
    "application/x-erlang-escript"
) {
    override fun getDisplayName(): String = "Erlang Escript"
}

object ErlangTermsLanguage :
    ErlangFamilyLanguage(
        "Erlang Terms",
        "text/erlang-terms",
        "text/x-erlang-terms",
        "application/x-erlang-terms"
    ) {
    override fun getDisplayName(): String = "Erlang Terms"
}
