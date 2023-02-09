package se.clau.ironclad.filetype

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import se.clau.ironclad.ErlangIcons
import javax.swing.Icon

object ErlangEscriptFileType : LanguageFileType(ErlangLanguage) {

    override fun getName(): String = "Erlang Escript" // must match <filetype name=""> in plugin.xml

    override fun getIcon(): Icon = ErlangIcons.ESCRIPT_FILE

    override fun getDefaultExtension(): String = "escript"

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

    override fun getDescription(): String = "Erlang Escript executable script files"
}
