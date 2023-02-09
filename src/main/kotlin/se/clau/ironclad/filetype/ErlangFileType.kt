package se.clau.ironclad.filetype

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import se.clau.ironclad.ErlangIcons
import javax.swing.Icon

object ErlangFileType : LanguageFileType(ErlangLanguage) {

    override fun getName(): String = "Erlang" // must match <filetype name=""> in plugin.xml

    override fun getIcon(): Icon = ErlangIcons.ERL_FILE

    override fun getDefaultExtension(): String = "erl"

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

    override fun getDescription(): String = "Erlang files"
}
