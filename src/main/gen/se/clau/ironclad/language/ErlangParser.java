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
  // &<<isErlangSyntaxFile>> formWithPeriod *
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

  // formWithPeriod *
  private static boolean erlangRoot_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "erlangRoot_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!formWithPeriod(b, l + 1)) break;
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
  // identifier | literalExpr
  public static boolean expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = literalExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // function | attribute | !<<eofOrSpace>>
  static boolean form(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "form")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTION);
    if (!r) r = consumeToken(b, ATTRIBUTE);
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
  // !(PLUS | MINUS | L_DOUBLE_ANGLE | QUESTION 
  //     | L_SQUARE | L_CURLY | atom_name | single_quote 
  //     | BINARY_NOT | char_literal | float | integer_literal 
  //     | NOT | string_literal | var | HASH_SYMBOL | DOT)
  static boolean formRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !formRecover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // PLUS | MINUS | L_DOUBLE_ANGLE | QUESTION 
  //     | L_SQUARE | L_CURLY | atom_name | single_quote 
  //     | BINARY_NOT | char_literal | float | integer_literal 
  //     | NOT | string_literal | var | HASH_SYMBOL | DOT
  private static boolean formRecover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formRecover_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, L_DOUBLE_ANGLE);
    if (!r) r = consumeToken(b, QUESTION);
    if (!r) r = consumeToken(b, L_SQUARE);
    if (!r) r = consumeToken(b, L_CURLY);
    if (!r) r = consumeToken(b, ATOM_NAME);
    if (!r) r = consumeToken(b, SINGLE_QUOTE);
    if (!r) r = consumeToken(b, BINARY_NOT);
    if (!r) r = consumeToken(b, CHAR_LITERAL);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, INTEGER_LITERAL);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, HASH_SYMBOL);
    if (!r) r = consumeToken(b, DOT);
    return r;
  }

  /* ********************************************************** */
  // form period
  static boolean formWithPeriod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "formWithPeriod")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = form(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, PERIOD);
    exit_section_(b, l, m, r, p, ErlangParser::formRecover);
    return r || p;
  }

  /* ********************************************************** */
  // integer_literal | float | char | string_literal | char_literal | atom_name
  public static boolean literalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "literalExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeToken(b, INTEGER_LITERAL);
    if (!r) r = consumeToken(b, FLOAT);
    if (!r) r = consumeToken(b, CHAR);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, CHAR_LITERAL);
    if (!r) r = consumeToken(b, ATOM_NAME);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // literalExpr period
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
