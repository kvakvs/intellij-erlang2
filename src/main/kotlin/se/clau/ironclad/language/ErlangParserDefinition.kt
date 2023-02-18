package se.clau.ironclad.language

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.TokenType
import com.intellij.psi.tree.IElementType
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet
import se.clau.ironclad.filetype.ErlangEscriptFile
import se.clau.ironclad.filetype.ErlangFile
import se.clau.ironclad.filetype.ErlangHeaderFile
import se.clau.ironclad.filetype.ErlangTermsFile
import se.clau.ironclad.language.ErlangElementTypes.PREPROCESSOR_DEFINE_ARGS
import se.clau.ironclad.language.ErlangElementTypes.STRING_LITERAL
import se.clau.ironclad.stubs.ErlangEscriptFileStub
import se.clau.ironclad.stubs.ErlangFileStub
import se.clau.ironclad.stubs.ErlangHeaderFileStub
import se.clau.ironclad.stubs.ErlangTermsFileStub

abstract class FamilyParserDefinition(private val constructFile: (FileViewProvider) -> PsiFileBase) : ParserDefinition {
    companion object {
        // Should be increased after any change of lexer rules
        private const val LEXER_VERSION: Int = 1

        // Should be increased after any change of parser rules
        const val PARSER_VERSION: Int = LEXER_VERSION * 1000 + 1

        @JvmField
        val WS = TokenSet.create(TokenType.WHITE_SPACE)

        @JvmField
        val SHEBANG_LINE: IElementType = ErlangTokenType("#!")

        @JvmField
        val COMMENT: IElementType = ErlangTokenType("COMMENT")

        @JvmField
        val FUNCTION_DOC_COMMENT: IElementType = ErlangTokenType("FUNCTION_DOC_COMMENT")

        @JvmField
        val MODULE_DOC_COMMENT: IElementType = ErlangTokenType("MODULE_DOC_COMMENT")

        val ALL_COMMENT_TOKENS = tokenSetOf(COMMENT, FUNCTION_DOC_COMMENT, MODULE_DOC_COMMENT)
        val ALL_STRING_LITERALS = tokenSetOf(STRING_LITERAL)
    }

    override fun createLexer(project: Project?): Lexer = ErlangLexer()

    override fun createParser(project: Project?): PsiParser = ErlangParser()

    override fun getCommentTokens(): TokenSet = ALL_COMMENT_TOKENS

    override fun getStringLiteralElements(): TokenSet = ALL_STRING_LITERALS

    override fun createElement(node: ASTNode?): PsiElement {
        return ErlangElementTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        val createDefault = { constructFile(viewProvider) }
//        val project = viewProvider.manager.project
        return createDefault()
    }
}

class ErlangParserDefinition : FamilyParserDefinition(ErlangFile::construct) {
    override fun getFileNodeType(): IFileElementType = ErlangFileStub.Type
}

class ErlangHeaderParserDefinition : FamilyParserDefinition(ErlangHeaderFile::construct) {
    override fun getFileNodeType(): IFileElementType = ErlangHeaderFileStub.Type
}

class ErlangEscriptParserDefinition : FamilyParserDefinition(ErlangEscriptFile::construct) {
    override fun getFileNodeType(): IFileElementType = ErlangEscriptFileStub.Type
}

class ErlangTermsParserDefinition : FamilyParserDefinition(ErlangTermsFile::construct) {
    override fun getFileNodeType(): IFileElementType = ErlangTermsFileStub.Type
}
