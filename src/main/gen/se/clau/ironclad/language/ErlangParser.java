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
    return ErlangFile(b, l + 1);
  }

  /* ********************************************************** */
  // ATOM_NAME | (SINGLE_QUOTE ATOM_NAME SINGLE_QUOTE)
  public static boolean Atom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Atom")) return false;
    if (!nextTokenIs(b, "<atom>", ATOM_NAME, SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOM, "<atom>");
    r = consumeToken(b, ATOM_NAME);
    if (!r) r = Atom_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // SINGLE_QUOTE ATOM_NAME SINGLE_QUOTE
  private static boolean Atom_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Atom_1")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = consumeTokens(b, 1, SINGLE_QUOTE, ATOM_NAME, SINGLE_QUOTE);
    p = r; // pin = 1
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // ErlangFileBody | EscriptFileBody | TermsFileBody
  static boolean ErlangFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ErlangFile")) return false;
    boolean r;
    r = ErlangFileBody(b, l + 1);
    if (!r) r = EscriptFileBody(b, l + 1);
    if (!r) r = TermsFileBody(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // &<<isErlangSyntaxFile>> Form *
  static boolean ErlangFileBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ErlangFileBody")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ErlangFileBody_0(b, l + 1);
    r = r && ErlangFileBody_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<isErlangSyntaxFile>>
  private static boolean ErlangFileBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ErlangFileBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isErlangSyntaxFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // Form *
  private static boolean ErlangFileBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ErlangFileBody_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!Form(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ErlangFileBody_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // &<<isEscriptSyntaxFile>> Expr ( COMMA Expr ) * PERIOD
  static boolean EscriptFileBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EscriptFileBody")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = EscriptFileBody_0(b, l + 1);
    r = r && Expr(b, l + 1);
    r = r && EscriptFileBody_2(b, l + 1);
    r = r && consumeToken(b, PERIOD);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<isEscriptSyntaxFile>>
  private static boolean EscriptFileBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EscriptFileBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isEscriptSyntaxFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( COMMA Expr ) *
  private static boolean EscriptFileBody_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EscriptFileBody_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!EscriptFileBody_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "EscriptFileBody_2", c)) break;
    }
    return true;
  }

  // COMMA Expr
  private static boolean EscriptFileBody_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "EscriptFileBody_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // VAR | LiteralExpr
  public static boolean Expr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Expr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR, "<expr>");
    r = consumeToken(b, VAR);
    if (!r) r = LiteralExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // Atom L_PAREN FnDefArgs R_PAREN R_ARROW FnDefBody PERIOD
  public static boolean FnDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnDef")) return false;
    if (!nextTokenIs(b, "<fn def>", ATOM_NAME, SINGLE_QUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FN_DEF, "<fn def>");
    r = Atom(b, l + 1);
    r = r && consumeToken(b, L_PAREN);
    r = r && FnDefArgs(b, l + 1);
    r = r && consumeTokens(b, 0, R_PAREN, R_ARROW);
    r = r && FnDefBody(b, l + 1);
    r = r && consumeToken(b, PERIOD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // VAR | Atom
  public static boolean FnDefArg(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnDefArg")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FN_DEF_ARG, "<fn def arg>");
    r = consumeToken(b, VAR);
    if (!r) r = Atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FnDefArg ( COMMA FnDefArg )*
  static boolean FnDefArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnDefArgs")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FnDefArg(b, l + 1);
    r = r && FnDefArgs_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA FnDefArg )*
  private static boolean FnDefArgs_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnDefArgs_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FnDefArgs_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FnDefArgs_1", c)) break;
    }
    return true;
  }

  // COMMA FnDefArg
  private static boolean FnDefArgs_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnDefArgs_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && FnDefArg(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // Expr ( COMMA Expr )*
  static boolean FnDefBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnDefBody")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = Expr(b, l + 1);
    r = r && FnDefBody_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ( COMMA Expr )*
  private static boolean FnDefBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnDefBody_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!FnDefBody_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "FnDefBody_1", c)) break;
    }
    return true;
  }

  // COMMA Expr
  private static boolean FnDefBody_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "FnDefBody_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && Expr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FnDef
  //     | PreprocessorDefine
  //     | ModuleAttr
  //     | !<<isEofOrSpace>>
  static boolean Form(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Form")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = FnDef(b, l + 1);
    if (!r) r = PreprocessorDefine(b, l + 1);
    if (!r) r = ModuleAttr(b, l + 1);
    if (!r) r = Form_3(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<isEofOrSpace>>
  private static boolean Form_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "Form_3")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !isEofOrSpace(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FLOAT_LITERAL | <<parseFloatLiteral>> | INTEGER_LITERAL
  //     | DOLLAR_CHAR | STRING_LITERAL | CHAR_LITERAL
  //     | Atom
  public static boolean LiteralExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LITERAL_EXPR, "<literal expr>");
    r = consumeToken(b, FLOAT_LITERAL);
    if (!r) r = parseFloatLiteral(b, l + 1);
    if (!r) r = consumeToken(b, INTEGER_LITERAL);
    if (!r) r = consumeToken(b, DOLLAR_CHAR);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, CHAR_LITERAL);
    if (!r) r = Atom(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // LiteralExpr PERIOD
  static boolean LiteralExprWithPeriod(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "LiteralExprWithPeriod")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = LiteralExpr(b, l + 1);
    p = r; // pin = 1
    r = r && consumeToken(b, PERIOD);
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  /* ********************************************************** */
  // MINUS Atom ( L_PAREN ModuleAttrContents R_PAREN )? PERIOD
  public static boolean ModuleAttr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleAttr")) return false;
    if (!nextTokenIs(b, MINUS)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, MODULE_ATTR, null);
    r = consumeToken(b, MINUS);
    r = r && Atom(b, l + 1);
    p = r; // pin = 2
    r = r && report_error_(b, ModuleAttr_2(b, l + 1));
    r = p && consumeToken(b, PERIOD) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // ( L_PAREN ModuleAttrContents R_PAREN )?
  private static boolean ModuleAttr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleAttr_2")) return false;
    ModuleAttr_2_0(b, l + 1);
    return true;
  }

  // L_PAREN ModuleAttrContents R_PAREN
  private static boolean ModuleAttr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleAttr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, L_PAREN);
    r = r && ModuleAttrContents(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LiteralExpr? ( COMMA LiteralExpr )*
  static boolean ModuleAttrContents(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleAttrContents")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = ModuleAttrContents_0(b, l + 1);
    r = r && ModuleAttrContents_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LiteralExpr?
  private static boolean ModuleAttrContents_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleAttrContents_0")) return false;
    LiteralExpr(b, l + 1);
    return true;
  }

  // ( COMMA LiteralExpr )*
  private static boolean ModuleAttrContents_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleAttrContents_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!ModuleAttrContents_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "ModuleAttrContents_1", c)) break;
    }
    return true;
  }

  // COMMA LiteralExpr
  private static boolean ModuleAttrContents_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ModuleAttrContents_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && LiteralExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // PP_DEFINE L_PAREN preprocessorMacroIdent
  //     PreprocessorDefineArgs? COMMA
  //     PreprocessorMacroBodyToken*
  //     PreprocessorDirectiveEnd
  public static boolean PreprocessorDefine(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreprocessorDefine")) return false;
    if (!nextTokenIs(b, PP_DEFINE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, PREPROCESSOR_DEFINE, null);
    r = consumeTokens(b, 0, PP_DEFINE, L_PAREN);
    r = r && preprocessorMacroIdent(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, PreprocessorDefine_3(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COMMA)) && r;
    r = p && report_error_(b, PreprocessorDefine_5(b, l + 1)) && r;
    r = p && PreprocessorDirectiveEnd(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // PreprocessorDefineArgs?
  private static boolean PreprocessorDefine_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreprocessorDefine_3")) return false;
    PreprocessorDefineArgs(b, l + 1);
    return true;
  }

  // PreprocessorMacroBodyToken*
  private static boolean PreprocessorDefine_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreprocessorDefine_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PreprocessorMacroBodyToken(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PreprocessorDefine_5", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // L_PAREN VAR ( COMMA VAR )* R_PAREN
  public static boolean PreprocessorDefineArgs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreprocessorDefineArgs")) return false;
    if (!nextTokenIs(b, L_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, L_PAREN, VAR);
    r = r && PreprocessorDefineArgs_2(b, l + 1);
    r = r && consumeToken(b, R_PAREN);
    exit_section_(b, m, PREPROCESSOR_DEFINE_ARGS, r);
    return r;
  }

  // ( COMMA VAR )*
  private static boolean PreprocessorDefineArgs_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreprocessorDefineArgs_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!PreprocessorDefineArgs_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "PreprocessorDefineArgs_2", c)) break;
    }
    return true;
  }

  // COMMA VAR
  private static boolean PreprocessorDefineArgs_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreprocessorDefineArgs_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, VAR);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // R_PAREN PERIOD
  public static boolean PreprocessorDirectiveEnd(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreprocessorDirectiveEnd")) return false;
    if (!nextTokenIs(b, R_PAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, R_PAREN, PERIOD);
    exit_section_(b, m, PREPROCESSOR_DIRECTIVE_END, r);
    return r;
  }

  /* ********************************************************** */
  // !PreprocessorDirectiveEnd
  static boolean PreprocessorDirectiveRecover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreprocessorDirectiveRecover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !PreprocessorDirectiveEnd(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // <<macroBodyAnyToken>>
  static boolean PreprocessorMacroBodyToken(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "PreprocessorMacroBodyToken")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = macroBodyAnyToken(b, l + 1);
    exit_section_(b, l, m, r, false, ErlangParser::PreprocessorDirectiveRecover);
    return r;
  }

  /* ********************************************************** */
  // &<<isTermsSyntaxFile>> LiteralExprWithPeriod *
  static boolean TermsFileBody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TermsFileBody")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = TermsFileBody_0(b, l + 1);
    r = r && TermsFileBody_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // &<<isTermsSyntaxFile>>
  private static boolean TermsFileBody_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TermsFileBody_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _AND_);
    r = isTermsSyntaxFile(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LiteralExprWithPeriod *
  private static boolean TermsFileBody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "TermsFileBody_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!LiteralExprWithPeriod(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "TermsFileBody_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // VAR | ATOM_NAME
  static boolean preprocessorMacroIdent(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "preprocessorMacroIdent")) return false;
    if (!nextTokenIs(b, "", ATOM_NAME, VAR)) return false;
    boolean r;
    r = consumeToken(b, VAR);
    if (!r) r = consumeToken(b, ATOM_NAME);
    return r;
  }

}
