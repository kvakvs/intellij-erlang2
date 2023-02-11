// This is a generated file. Not intended for manual editing.
package se.clau.ironclad.language;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static se.clau.ironclad.language.ErlangElementTypes.*;
import static se.clau.ironclad.language.ErlangParserUtil.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class ErlangParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return erlangFile(b, l + 1);
  }

  /* ********************************************************** */
  // ATOM_NAME | (SINGLE_QUOTE ATOM_NAME SINGLE_QUOTE)
  public static boolean atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom")) return false;
    if (!nextTokenIs(b, "<atom>", ATOM_NAME, SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = consumeToken(b, ATOM_NAME);
    if (!r) r = atom_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SINGLE_QUOTE ATOM_NAME SINGLE_QUOTE
  private static boolean atom_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atom_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, SINGLE_QUOTE, ATOM_NAME, SINGLE_QUOTE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // erlangRoot | escriptRoot | termsRoot
  static boolean erlangFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "erlangFile")) return false;
    boolean r;
    r = erlangRoot(b, l + 1);
    if (!r) r = escriptRoot(b, l + 1);
    if (!r) r = termsRoot(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // &<<isErlangSyntaxFile>> form *
  static boolean erlangRoot(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "erlangRoot")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = erlangRoot_0(b, l + 1);
    r = r && erlangRoot_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<isErlangSyntaxFile>>
  private static boolean erlangRoot_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "erlangRoot_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isErlangSyntaxFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // form *
  private static boolean erlangRoot_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "erlangRoot_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!form(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "erlangRoot_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // &<<isEscriptSyntaxFile>>
  static boolean escriptRoot(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "escriptRoot")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isEscriptSyntaxFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VAR | literalExpr
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = consumeToken(b, VAR);
    if (!r) r = literalExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // functionDef | moduleAttr | !<<eofOrSpace>>
  static boolean form(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "form")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionDef(b, l + 1);
    if (!r) r = moduleAttr(b, l + 1);
    if (!r) r = form_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eofOrSpace>>
  private static boolean form_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "form_2")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eofOrSpace(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // atom L_PAREN functionDefArgs R_PAREN R_ARROW functionDefBody PERIOD
  public static boolean functionDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef")) return false;
    if (!nextTokenIs(b, "<function def>", ATOM_NAME, SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEF, "<function def>");
    r = atom(b, l + 1);
    r = r && consumeToken(b, L_PAREN);
    r = r && functionDefArgs(b, l + 1);
    r = r && consumeTokens(b, 0, R_PAREN, R_ARROW);
    r = r && functionDefBody(b, l + 1);
    r = r && consumeToken(b, PERIOD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VAR | atom
  public static boolean functionDefArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefArg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEF_ARG, "<function def arg>");
    r = consumeToken(b, VAR);
    if (!r) r = atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // functionDefArg ( COMMA functionDefArg )*
  static boolean functionDefArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefArgs")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionDefArg(b, l + 1);
    r = r && functionDefArgs_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA functionDefArg )*
  private static boolean functionDefArgs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefArgs_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionDefArgs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionDefArgs_1", c)) break;
    }
    return true;
  }

  // COMMA functionDefArg
  private static boolean functionDefArgs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefArgs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && functionDefArg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // expr ( COMMA expr )*
  static boolean functionDefBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefBody")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = expr(b, l + 1);
    r = r && functionDefBody_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA expr )*
  private static boolean functionDefBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefBody_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionDefBody_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionDefBody_1", c)) break;
    }
    return true;
  }

  // COMMA expr
  private static boolean functionDefBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDefBody_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // INTEGER_LITERAL | float | char | STRING_LITERAL | CHAR_LITERAL | atom
  public static boolean literalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeToken(b, INTEGER_LITERAL);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, CHAR_LITERAL);
    if (!r) r = atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // literalExpr PERIOD
  static boolean literalExprWithPeriod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExprWithPeriod")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = literalExpr(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, PERIOD);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MINUS atom ( L_PAREN moduleAttrContents R_PAREN )? PERIOD
  public static boolean moduleAttr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleAttr")) return false;
    if (!nextTokenIs(b, MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE_ATTR, null);
    r = consumeToken(b, MINUS);
    r = r && atom(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, moduleAttr_2(b, l + 1));
    r = p && consumeToken(b, PERIOD) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( L_PAREN moduleAttrContents R_PAREN )?
  private static boolean moduleAttr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleAttr_2")) return false;
    moduleAttr_2_0(b, l + 1);
    return true;
  }

  // L_PAREN moduleAttrContents R_PAREN
  private static boolean moduleAttr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleAttr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && moduleAttrContents(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // literalExpr? ( COMMA literalExpr )*
  static boolean moduleAttrContents(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleAttrContents")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = moduleAttrContents_0(b, l + 1);
    r = r && moduleAttrContents_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // literalExpr?
  private static boolean moduleAttrContents_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleAttrContents_0")) return false;
    literalExpr(b, l + 1);
    return true;
  }

  // ( COMMA literalExpr )*
  private static boolean moduleAttrContents_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleAttrContents_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!moduleAttrContents_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "moduleAttrContents_1", c)) break;
    }
    return true;
  }

  // COMMA literalExpr
  private static boolean moduleAttrContents_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "moduleAttrContents_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && literalExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // &<<isTermsSyntaxFile>> literalExprWithPeriod *
  static boolean termsRoot(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "termsRoot")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = termsRoot_0(b, l + 1);
    r = r && termsRoot_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<isTermsSyntaxFile>>
  private static boolean termsRoot_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "termsRoot_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isTermsSyntaxFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // literalExprWithPeriod *
  private static boolean termsRoot_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "termsRoot_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!literalExprWithPeriod(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "termsRoot_1", c)) break;
    }
    return true;
  }

}
