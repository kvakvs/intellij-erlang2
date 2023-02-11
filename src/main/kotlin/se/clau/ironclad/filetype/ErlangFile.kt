package se.clau.ironclad.filetype

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class ErlangFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, ErlangLanguage) {
    companion object {
        fun construct(fileViewProvider: FileViewProvider): PsiFileBase = ErlangFile(fileViewProvider)
    }

    override fun getFileType(): FileType = ErlangFileType
}

class ErlangHeaderFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, ErlangHeaderLanguage) {
    companion object {
        fun construct(fileViewProvider: FileViewProvider): PsiFileBase = ErlangHeaderFile(fileViewProvider)
    }

    override fun getFileType(): FileType = ErlangHeaderFileType
}

class ErlangEscriptFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, ErlangEscriptLanguage) {
    companion object {
        fun construct(fileViewProvider: FileViewProvider): PsiFileBase = ErlangEscriptFile(fileViewProvider)
    }

    override fun getFileType(): FileType = ErlangEscriptFileType
}

class ErlangTermsFile(fileViewProvider: FileViewProvider) : PsiFileBase(fileViewProvider, ErlangTermsLanguage) {
    companion object {
        fun construct(fileViewProvider: FileViewProvider): PsiFileBase = ErlangTermsFile(fileViewProvider)
    }

    override fun getFileType(): FileType = ErlangTermsFileType
}
