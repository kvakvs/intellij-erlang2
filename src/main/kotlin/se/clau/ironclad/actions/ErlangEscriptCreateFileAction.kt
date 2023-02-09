package se.clau.ironclad.actions

import com.intellij.ide.actions.CreateFileFromTemplateAction
import com.intellij.ide.actions.CreateFileFromTemplateDialog
import com.intellij.openapi.actionSystem.DataContext
import com.intellij.openapi.project.DumbAware
import com.intellij.openapi.project.Project
import com.intellij.psi.PsiDirectory
import se.clau.ironclad.ErlangIcons

class ErlangEscriptCreateFileAction :
    CreateFileFromTemplateAction(CAPTION, "", ErlangIcons.ERL_FILE),
    DumbAware {

    override fun getActionName(directory: PsiDirectory?, newName: String, templateName: String?): String = CAPTION

    override fun isAvailable(dataContext: DataContext): Boolean {
        return true
        // Old code: Check that the file is under project root directory
    }

    override fun buildDialog(project: Project, directory: PsiDirectory, builder: CreateFileFromTemplateDialog.Builder) {
        builder.setTitle(CAPTION)
            .addKind("Empty file", ErlangIcons.ESCRIPT_FILE, "Erlang Escript")
    }

    private companion object {
        private const val CAPTION = "Erlang Escript"
    }
}
