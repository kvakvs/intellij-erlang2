package se.clau.ironclad.language

import com.intellij.lang.PsiBuilder
import com.intellij.lang.PsiBuilderUtil
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
        fun isEofOrSpace(builder: PsiBuilder, level: Int): Boolean {
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
        fun macroBodyAnyToken(builder: PsiBuilder, level: Int): Boolean {
            val tokenType = builder.tokenType
            return if (tokenType == ErlangElementTypes.R_PAREN && builder.lookAhead(1) == ErlangElementTypes.PERIOD) {
                false
            } else {
                consumeToken(builder, tokenType)
                true
            }
        }

        /**
         * Modified from intellij-Rust
         * `FLOAT_LITERAL` is never produced during lexing. We construct it during parsing from one or
         * several `INT_LITERAL` tokens.
         *
         * Here we collapse these sequences of tokes:
         * 1. `INT_LITERAL`, `PERIOD`, `INT_LITERAL`. Like `0.0`
         * 2. `INT_LITERAL`, `PERIOD` (but **not** `INT_LITERAL`, `PERIOD`, `IDENTIFIER`). Like `0.`
         */
        @JvmStatic
        fun parseFloatLiteral(builder: PsiBuilder, level: Int): Boolean {
            return when (builder.tokenType) {
                ErlangElementTypes.INTEGER_LITERAL -> {
                    // Works with `0.0`, `0.`, but not `0.foo` (identifier is not accepted after `.`)
                    if (builder.rawLookup(1) == ErlangElementTypes.PERIOD) {
                        val (collapse, size) = when (builder.rawLookup(2)) {
                            ErlangElementTypes.INTEGER_LITERAL, ErlangElementTypes.FLOAT_LITERAL -> true to 3
                            //ErlangElementTypes.IDENTIFIER -> false to 0
                            else -> true to 2
                        }
                        if (collapse) {
                            val marker = builder.mark()
                            PsiBuilderUtil.advance(builder, size)
                            marker.collapse(ErlangElementTypes.FLOAT_LITERAL)
                            return true
                        }
                    }
                    // Works with floats without `.` like `1f32`, `1e3`, `3e-4`
                    val text = builder.tokenText
                    val isFloat = text != null &&
                            (text.contains("f") || text.contains("e", ignoreCase = true) && !text.endsWith("e"))
                            && !text.startsWith("0x")
                    if (isFloat) {
                        builder.remapCurrentToken(ErlangElementTypes.FLOAT_LITERAL)
                        builder.advanceLexer()
                    }
                    isFloat
                }
                // Can be already remapped
                ErlangElementTypes.FLOAT_LITERAL -> {
                    builder.advanceLexer()
                    true
                }

                else -> false
            }
        }

//        /**
//         * Parse the given rule which is preprocessor define rule, executes the effect and then collapses it
//         * into a whitespace
//         */
//        @JvmStatic
//        fun handlePreprocessorDefine(builder: PsiBuilder, level: Int, preprocessorDefineParser: Parser): Boolean {
//            val preprocDirective = enter_section_(builder)
//
//            if (preprocessorDefineParser.parse(builder, level)) {
//                // Parse successful - execute -define() effect and collapse into a whitespace
//                preprocDirective.collapse(TokenType.WHITE_SPACE)
//                return true
//            }
//
//            // Parse not successful
//            exit_section_(builder, preprocDirective, ErlangElementTypes.PP_DEFINE, false)
//            return false
//        }

    } // end companion
}