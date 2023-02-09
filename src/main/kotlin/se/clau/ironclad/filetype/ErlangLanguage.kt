package se.clau.ironclad.filetype

import com.intellij.lang.Language

/// The language definition for Erlang source files *.erl
object ErlangLanguage : Language("Erlang", "text/erlang", "text/x-erlang", "application/x-erlang") {
    override fun isCaseSensitive() = true

    override fun getDisplayName() = "Erlang"
}
