package se.clau.ironclad.filetype

import com.intellij.openapi.fileTypes.LanguageFileType
import com.intellij.openapi.vfs.VirtualFile
import se.clau.ironclad.ErlangIcons
import javax.swing.Icon

object ErlangTermsFileType : LanguageFileType(ErlangLanguage) {
    override fun getName(): String = "Erlang Terms/Config" // must match <filetype name=""> in plugin.xml

    override fun getIcon(): Icon = ErlangIcons.TERMS_FILE

    override fun getDefaultExtension(): String = "config"

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

    override fun getDescription(): String = "Configuration or data files containing Erlang terms"
}
