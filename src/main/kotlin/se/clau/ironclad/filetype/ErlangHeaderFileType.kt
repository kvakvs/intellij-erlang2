package se.clau.ironclad.filetype

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import se.clau.ironclad.ErlangIcons
import javax.swing.Icon

object ErlangHeaderFileType : LanguageFileType(ErlangLanguage) {

    override fun getName(): String = "Erlang Include Header" // must match <filetype name=""> in plugin.xml

    override fun getIcon(): Icon = ErlangIcons.HRL_FILE

    override fun getDefaultExtension(): String = "hrl"

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

    override fun getDescription(): String = "Erlang include header files"
}
