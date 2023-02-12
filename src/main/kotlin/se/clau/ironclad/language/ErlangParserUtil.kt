package se.clau.ironclad.language

import com.intellij.lang.PsiBuilder
import com.intellij.lang.parser.GeneratedParserUtilBase
import com.intellij.psi.TokenType
import com.intellij.psi.impl.source.resolve.FileContextUtil
import se.clau.ironclad.filetype.ErlangEscriptFileType
import se.clau.ironclad.filetype.ErlangFileType
import se.clau.ironclad.filetype.ErlangHeaderFileType
import se.clau.ironclad.filetype.ErlangTermsFileType

@Suppress("UNUSED_PARAMETER")
class ErlangParserUtil : ErlangParserUtilBase() {
    companion object {
        @JvmStatic
        fun isTermsSyntaxFile(builder: PsiBuilder, level: Int): Boolean {
            val file = builder.getUserData(FileContextUtil.CONTAINING_FILE_KEY)!!
            return file.fileType === ErlangTermsFileType
        }

        @JvmStatic
        fun isErlangSyntaxFile(builder: PsiBuilder, level: Int): Boolean {
            val file = builder.getUserData(FileContextUtil.CONTAINING_FILE_KEY)!!
            return file.fileType === ErlangFileType || file.fileType == ErlangHeaderFileType
        }

        @JvmStatic
        fun isEscriptSyntaxFile(builder: PsiBuilder, level: Int): Boolean {
            val file = builder.getUserData(FileContextUtil.CONTAINING_FILE_KEY)!!
            return file.fileType === ErlangEscriptFileType
        }

        @JvmStatic
        fun eofOrSpace(builder: PsiBuilder, level: Int): Boolean {
            if (builder.eof()) return true

            val one = builder.rawLookup(1)
            val two = builder.rawLookup(2)

            if (one === TokenType.WHITE_SPACE
                && (two === ErlangElementTypes.PERIOD || two == null)
                || one == null && builder.tokenType === ErlangElementTypes.PERIOD
            ) {
                builder.remapCurrentToken(TokenType.ERROR_ELEMENT)
                return true
            }
            return false
        }

        /**
         * Matches any token other than ")" "." pair
         */
        @JvmStatic
        fun macroBodyAnyToken(b: PsiBuilder, level: Int): Boolean {
            val tokenType = b.tokenType
            return if (tokenType == ErlangElementTypes.R_PAREN && b.lookAhead(1) == ErlangElementTypes.PERIOD) {
                false
            } else {
                consumeToken(b, tokenType)
                true
            }
        }
    }
}