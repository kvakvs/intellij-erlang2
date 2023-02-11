package se.clau.ironclad.stubs

import com.intellij.lang.ASTNode
import com.intellij.psi.PsiFile
import com.intellij.psi.StubBuilder
import com.intellij.psi.impl.source.tree.TreeUtil
import com.intellij.psi.stubs.*
import com.intellij.psi.tree.IStubFileElementType
import se.clau.ironclad.filetype.*
import se.clau.ironclad.language.FamilyParserDefinition

class ErlangFileStub(
    file: ErlangFile?,
    private val flags: ErlangFileFlags,
) : PsiFileStubImpl<ErlangFile>(file) {
    object Type : IStubFileElementType<ErlangFileStub>(ErlangLanguage) {
        // Bump this number if Stub structure changes
        private const val STUB_VERSION = 1

        override fun getStubVersion(): Int = FamilyParserDefinition.PARSER_VERSION * 1000 + STUB_VERSION

        override fun getBuilder(): StubBuilder = object : DefaultStubBuilder() {
            override fun createStubForFile(file: PsiFile): StubElement<*> {
                TreeUtil.ensureParsed(file.node) // profiler hint
                check(file is ErlangFile)
//                val flags = ErlangAttributeOwnerStub.extractFlags(file, ErlangAttributeOwnerStub.FileStubAttrFlags)
                return ErlangFileStub(file, ErlangFileFlags(isModule = false))
            }

            override fun skipChildProcessingWhenBuildingStubs(parent: ASTNode, child: ASTNode): Boolean {
                return false
            }
        }

        override fun serialize(stub: ErlangFileStub, dataStream: StubOutputStream) {
            dataStream.writeUTF(stub.flags.serializeFlags())
        }

        override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): ErlangFileStub =
            ErlangFileStub(null, ErlangFileFlags.from(dataStream))

        override fun getExternalId(): String = "Erlang.file"

    }
}

class ErlangHeaderFileStub(
    file: ErlangHeaderFile?,
    private val flags: ErlangFileFlags,
) : PsiFileStubImpl<ErlangHeaderFile>(file) {
    object Type : IStubFileElementType<ErlangHeaderFileStub>(ErlangHeaderLanguage) {
        // Bump this number if Stub structure changes
        private const val STUB_VERSION = 1

        override fun getStubVersion(): Int = FamilyParserDefinition.PARSER_VERSION * 1000 + STUB_VERSION

        override fun getBuilder(): StubBuilder = object : DefaultStubBuilder() {
            override fun createStubForFile(file: PsiFile): StubElement<*> {
                TreeUtil.ensureParsed(file.node) // profiler hint
                check(file is ErlangHeaderFile)
//                val flags = ErlangAttributeOwnerStub.extractFlags(file, ErlangAttributeOwnerStub.FileStubAttrFlags)
                return ErlangHeaderFileStub(file, ErlangFileFlags(isModule = false))
            }

            override fun skipChildProcessingWhenBuildingStubs(parent: ASTNode, child: ASTNode): Boolean {
                return false
            }
        }

        override fun serialize(stub: ErlangHeaderFileStub, dataStream: StubOutputStream) {
            dataStream.writeUTF(stub.flags.serializeFlags())
        }

        override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): ErlangHeaderFileStub =
            ErlangHeaderFileStub(null, ErlangFileFlags.from(dataStream))

        override fun getExternalId(): String = "ErlangHeader.file"

    }
}

class ErlangEscriptFileStub(
    file: ErlangEscriptFile?,
    private val flags: ErlangFileFlags,
) : PsiFileStubImpl<ErlangEscriptFile>(file) {
    object Type : IStubFileElementType<ErlangEscriptFileStub>(ErlangEscriptLanguage) {
        // Bump this number if Stub structure changes
        private const val STUB_VERSION = 1

        override fun getStubVersion(): Int = FamilyParserDefinition.PARSER_VERSION * 1000 + STUB_VERSION

        override fun getBuilder(): StubBuilder = object : DefaultStubBuilder() {
            override fun createStubForFile(file: PsiFile): StubElement<*> {
                TreeUtil.ensureParsed(file.node) // profiler hint
                check(file is ErlangEscriptFile)
//                val flags = ErlangAttributeOwnerStub.extractFlags(file, ErlangAttributeOwnerStub.FileStubAttrFlags)
                return ErlangEscriptFileStub(file, ErlangFileFlags(isModule = false))
            }

            override fun skipChildProcessingWhenBuildingStubs(parent: ASTNode, child: ASTNode): Boolean {
                return false
            }
        }

        override fun serialize(stub: ErlangEscriptFileStub, dataStream: StubOutputStream) {
            dataStream.writeUTF(stub.flags.serializeFlags())
        }

        override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): ErlangEscriptFileStub =
            ErlangEscriptFileStub(null, ErlangFileFlags.from(dataStream))

        override fun getExternalId(): String = "ErlangEscript.file"

    }
}

class ErlangTermsFileStub(
    file: ErlangTermsFile?,
    private val flags: ErlangFileFlags,
) : PsiFileStubImpl<ErlangTermsFile>(file) {
    object Type : IStubFileElementType<ErlangTermsFileStub>(ErlangTermsLanguage) {
        // Bump this number if Stub structure changes
        private const val STUB_VERSION = 1

        override fun getStubVersion(): Int = FamilyParserDefinition.PARSER_VERSION * 1000 + STUB_VERSION

        override fun getBuilder(): StubBuilder = object : DefaultStubBuilder() {
            override fun createStubForFile(file: PsiFile): StubElement<*> {
                TreeUtil.ensureParsed(file.node) // profiler hint
                check(file is ErlangTermsFile)
//                val flags = ErlangAttributeOwnerStub.extractFlags(file, ErlangAttributeOwnerStub.FileStubAttrFlags)
                return ErlangTermsFileStub(file, ErlangFileFlags(isModule = false))
            }

            override fun skipChildProcessingWhenBuildingStubs(parent: ASTNode, child: ASTNode): Boolean {
                return false
            }
        }

        override fun serialize(stub: ErlangTermsFileStub, dataStream: StubOutputStream) {
            dataStream.writeUTF(stub.flags.serializeFlags())
        }

        override fun deserialize(dataStream: StubInputStream, parentStub: StubElement<*>?): ErlangTermsFileStub =
            ErlangTermsFileStub(null, ErlangFileFlags.from(dataStream))

        override fun getExternalId(): String = "ErlangTerms.file"

    }
}
