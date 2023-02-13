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

public class ErlPsiFnDefImpl extends ASTWrapperPsiElement implements ErlPsiFnDef {

  public ErlPsiFnDefImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull ErlPsiVisitor visitor) {
    visitor.visitFnDef(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof ErlPsiVisitor) accept((ErlPsiVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public ErlPsiAtom getAtom() {
    return findNotNullChildByClass(ErlPsiAtom.class);
  }

  @Override
  @NotNull
  public List<ErlPsiExpr> getExprList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlPsiExpr.class);
  }

  @Override
  @NotNull
  public List<ErlPsiFnDefArg> getFnDefArgList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, ErlPsiFnDefArg.class);
  }

}
