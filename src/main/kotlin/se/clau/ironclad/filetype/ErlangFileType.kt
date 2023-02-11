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

object ErlangHeaderFileType : LanguageFileType(ErlangHeaderLanguage) {

    override fun getName(): String = "Erlang Include Header" // must match <filetype name=""> in plugin.xml

    override fun getIcon(): Icon = ErlangIcons.HRL_FILE

    override fun getDefaultExtension(): String = "hrl"

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

    override fun getDescription(): String = "Erlang include header files"
}

object ErlangEscriptFileType : LanguageFileType(ErlangEscriptLanguage) {

    override fun getName(): String = "Erlang Escript" // must match <filetype name=""> in plugin.xml

    override fun getIcon(): Icon = ErlangIcons.ESCRIPT_FILE

    override fun getDefaultExtension(): String = "escript"

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

    override fun getDescription(): String = "Erlang Escript executable script files"
}

object ErlangTermsFileType : LanguageFileType(ErlangTermsLanguage) {
    override fun getName(): String = "Erlang Terms/Config" // must match <filetype name=""> in plugin.xml

    override fun getIcon(): Icon = ErlangIcons.TERMS_FILE

    override fun getDefaultExtension(): String = "config"

    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"

    override fun getDescription(): String = "Configuration or data files containing Erlang terms"

}


//import com.intellij.openapi.fileTypes.LanguageFileType
//import com.intellij.openapi.vfs.VirtualFile
//import se.clau.ironclad.ErlangIcons
//import javax.swing.Icon
//
//object ErlangRebarConfigFileType : LanguageFileType(ErlangLanguage) {
//
//    override fun getName(): String = "Erlang Rebar Config" // must match <filetype name=""> in plugin.xml
//
//    override fun getIcon(): Icon = ErlangIcons.REBAR_CONFIG_FILE
//
//    override fun getDefaultExtension(): String = "rebar.config"
//
//    override fun getCharset(file: VirtualFile, content: ByteArray): String = "UTF-8"
//
//    override fun getDescription(): String = "Erlang Rebar configuration files"
//}
