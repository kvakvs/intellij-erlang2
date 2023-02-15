// This is a generated file. Not intended for manual editing.
package se.clau.ironclad.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static se.clau.ironclad.language.ErlangElementTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import se.clau.ironclad.language.psi.*;

public class ErlPsiPreprocessorDefineImpl extends ASTWrapperPsiElement implements ErlPsiPreprocessorDefine {

  public ErlPsiPreprocessorDefineImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ErlPsiVisitor visitor) {
    visitor.visitPreprocessorDefine(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ErlPsiVisitor) accept((ErlPsiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public ErlPsiPreprocessorDefineArgs getPreprocessorDefineArgs() {
    return findChildByClass(ErlPsiPreprocessorDefineArgs.class);
  }

  @Override
  @Nullable
  public ErlPsiPreprocessorDirectiveEnd getPreprocessorDirectiveEnd() {
    return findChildByClass(ErlPsiPreprocessorDirectiveEnd.class);
  }

}
