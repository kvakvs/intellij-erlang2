// This is a generated file. Not intended for manual editing.
package se.clau.ironclad.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import se.clau.ironclad.language.psi.impl.*;

public interface ErlangElementTypes {

  IElementType ATOM = new ErlangElementType("ATOM");
  IElementType EXPR = new ErlangElementType("EXPR");
  IElementType FUNCTION_DEF = new ErlangElementType("FUNCTION_DEF");
  IElementType FUNCTION_DEF_ARG = new ErlangElementType("FUNCTION_DEF_ARG");
  IElementType LITERAL_EXPR = new ErlangElementType("LITERAL_EXPR");
  IElementType MODULE_ATTR = new ErlangElementType("MODULE_ATTR");
  IElementType PREPROCESSOR_DEFINE = new ErlangElementType("PREPROCESSOR_DEFINE");
  IElementType PREPROCESSOR_DEFINE_ARGS = new ErlangElementType("PREPROCESSOR_DEFINE_ARGS");

  IElementType AND = new ErlangTokenType("and");
  IElementType ANDALSO = new ErlangTokenType("andalso");
  IElementType ATOM_NAME = new ErlangTokenType("ATOM_NAME");
  IElementType BANG = new ErlangTokenType("!");
  IElementType BINARY_AND = new ErlangTokenType("band");
  IElementType BINARY_NOT = new ErlangTokenType("bnot");
  IElementType BINARY_OR = new ErlangTokenType("bor");
  IElementType BINARY_SHIFT_L = new ErlangTokenType("bsl");
  IElementType BINARY_SHIFT_R = new ErlangTokenType("bsr");
  IElementType BINARY_XOR = new ErlangTokenType("bxor");
  IElementType CHAR = new ErlangTokenType("char");
  IElementType CHAR_LITERAL = new ErlangTokenType("CHAR_LITERAL");
  IElementType COLON = new ErlangTokenType(":");
  IElementType COLON_COLON = new ErlangTokenType("::");
  IElementType COMMA = new ErlangTokenType(",");
  IElementType DOUBLE_BAR = new ErlangTokenType("||");
  IElementType EQ = new ErlangTokenType("=");
  IElementType EQEQ = new ErlangTokenType("==");
  IElementType FLOAT = new ErlangTokenType("float");
  IElementType FLOAT_DIV = new ErlangTokenType("/");
  IElementType GT = new ErlangTokenType(">");
  IElementType GTEQ = new ErlangTokenType(">=");
  IElementType HASH_SYMBOL = new ErlangTokenType("#");
  IElementType INTEGER_DIV = new ErlangTokenType("div");
  IElementType INTEGER_LITERAL = new ErlangTokenType("INTEGER_LITERAL");
  IElementType LT = new ErlangTokenType("<");
  IElementType LTEQ = new ErlangTokenType("=<");
  IElementType L_ARROW = new ErlangTokenType("<-");
  IElementType L_CURLY = new ErlangTokenType("{");
  IElementType L_DOUBLE_ANGLE = new ErlangTokenType("<<");
  IElementType L_DOUBLE_ARROW = new ErlangTokenType("<=");
  IElementType L_PAREN = new ErlangTokenType("(");
  IElementType L_SQUARE = new ErlangTokenType("[");
  IElementType MATCH = new ErlangTokenType(":=");
  IElementType MAYBE_EQ = new ErlangTokenType("?=");
  IElementType MINUS = new ErlangTokenType("-");
  IElementType MINUS_MINUS = new ErlangTokenType("--");
  IElementType MULTIPLY = new ErlangTokenType("*");
  IElementType NEQ = new ErlangTokenType("/=");
  IElementType NOT = new ErlangTokenType("not");
  IElementType OR = new ErlangTokenType("or");
  IElementType ORELSE = new ErlangTokenType("orelse");
  IElementType PERIOD = new ErlangTokenType(".");
  IElementType PLUS = new ErlangTokenType("+");
  IElementType PLUS_PLUS = new ErlangTokenType("++");
  IElementType PP_DEFINE = new ErlangTokenType("preprocessor -define");
  IElementType PP_ELIF = new ErlangTokenType("preprocessor -elif");
  IElementType PP_ELSE = new ErlangTokenType("preprocessor -else");
  IElementType PP_ENDIF = new ErlangTokenType("preprocessor -endif");
  IElementType PP_IF = new ErlangTokenType("preprocessor -if");
  IElementType PP_IFDEF = new ErlangTokenType("preprocessor -ifdef");
  IElementType PP_IFNDEF = new ErlangTokenType("preprocessor -ifndef");
  IElementType PP_INCLUDE = new ErlangTokenType("preprocessor -include");
  IElementType PP_INCLUDELIB = new ErlangTokenType("preprocessor -include_lib");
  IElementType PP_UNDEF = new ErlangTokenType("preprocessor -undef");
  IElementType QUESTION = new ErlangTokenType("?");
  IElementType REMAINDER = new ErlangTokenType("rem");
  IElementType R_ARROW = new ErlangTokenType("->");
  IElementType R_CURLY = new ErlangTokenType("}");
  IElementType R_DOUBLE_ANGLE = new ErlangTokenType(">>");
  IElementType R_DOUBLE_ARROW = new ErlangTokenType("=>");
  IElementType R_PAREN = new ErlangTokenType(")");
  IElementType R_SQUARE = new ErlangTokenType("]");
  IElementType SEMICOLON = new ErlangTokenType(";");
  IElementType SINGLE_QUOTE = new ErlangTokenType("'");
  IElementType STRING_LITERAL = new ErlangTokenType("STRING_LITERAL");
  IElementType STRONG_EQ = new ErlangTokenType("=:=");
  IElementType STRONG_NEQ = new ErlangTokenType("=/=");
  IElementType VAR = new ErlangTokenType("VAR");
  IElementType VERTICAL_BAR = new ErlangTokenType("|");
  IElementType XOR = new ErlangTokenType("xor");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ATOM) {
        return new ErlPsiAtomImpl(node);
      }
      else if (type == EXPR) {
        return new ErlPsiExprImpl(node);
      }
      else if (type == FUNCTION_DEF) {
        return new ErlPsiFunctionDefImpl(node);
      }
      else if (type == FUNCTION_DEF_ARG) {
        return new ErlPsiFunctionDefArgImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new ErlPsiLiteralExprImpl(node);
      }
      else if (type == MODULE_ATTR) {
        return new ErlPsiModuleAttrImpl(node);
      }
      else if (type == PREPROCESSOR_DEFINE) {
        return new ErlPsiPreprocessorDefineImpl(node);
      }
      else if (type == PREPROCESSOR_DEFINE_ARGS) {
        return new ErlPsiPreprocessorDefineArgsImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
