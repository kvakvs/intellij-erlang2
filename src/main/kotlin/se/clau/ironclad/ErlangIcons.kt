package se.clau.ironclad

import com.intellij.openapi.util.IconLoader
import javax.swing.Icon

object ErlangIcons {
    @JvmField
    val ERL_FILE = load("/icons/file-erlang.svg")
    @JvmField
    val TERMS_FILE = load("/icons/file-terms.svg")
    @JvmField
    val ESCRIPT_FILE = load("/icons/file-escript.svg")
    @JvmField
    val REBAR_CONFIG_FILE = load("/icons/file-rebarconfig.svg")

    private fun load(path: String): Icon = IconLoader.getIcon(path, ErlangIcons::class.java)
}
