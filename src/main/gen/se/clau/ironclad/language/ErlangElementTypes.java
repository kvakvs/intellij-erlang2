// This is a generated file. Not intended for manual editing.
package se.clau.ironclad.language;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import se.clau.ironclad.language.psi.impl.*;

public interface ErlangElementTypes {

  IElementType EXPR = new ErlangElementType("EXPR");
  IElementType LITERAL_EXPR = new ErlangElementType("LITERAL_EXPR");

  IElementType AND = new ErlangTokenType("and");
  IElementType ANDALSO = new ErlangTokenType("andalso");
  IElementType ATOM_NAME = new ErlangTokenType("atom_name");
  IElementType ATTRIBUTE = new ErlangTokenType("attribute");
  IElementType BANG = new ErlangTokenType("!");
  IElementType BINARY_AND = new ErlangTokenType("band");
  IElementType BINARY_NOT = new ErlangTokenType("bnot");
  IElementType BINARY_OR = new ErlangTokenType("bor");
  IElementType BINARY_SHIFT_L = new ErlangTokenType("bsl");
  IElementType BINARY_SHIFT_R = new ErlangTokenType("bsr");
  IElementType BINARY_XOR = new ErlangTokenType("bxor");
  IElementType CHAR = new ErlangTokenType("char");
  IElementType CHAR_LITERAL = new ErlangTokenType("char_literal");
  IElementType COLON = new ErlangTokenType(":");
  IElementType COLON_COLON = new ErlangTokenType("::");
  IElementType COMMA = new ErlangTokenType(",");
  IElementType DOT = new ErlangTokenType(".");
  IElementType DOUBLE_BAR = new ErlangTokenType("||");
  IElementType EQ = new ErlangTokenType("=");
  IElementType EQEQ = new ErlangTokenType("==");
  IElementType FLOAT = new ErlangTokenType("float");
  IElementType FLOAT_DIV = new ErlangTokenType("/");
  IElementType FUNCTION = new ErlangTokenType("function");
  IElementType GT = new ErlangTokenType(">");
  IElementType GTEQ = new ErlangTokenType(">=");
  IElementType HASH_SYMBOL = new ErlangTokenType("#");
  IElementType IDENTIFIER = new ErlangTokenType("identifier");
  IElementType INTEGER_DIV = new ErlangTokenType("div");
  IElementType INTEGER_LITERAL = new ErlangTokenType("integer_literal");
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
  IElementType PERIOD = new ErlangTokenType("period");
  IElementType PLUS = new ErlangTokenType("+");
  IElementType PLUS_PLUS = new ErlangTokenType("++");
  IElementType QUESTION = new ErlangTokenType("?");
  IElementType REMAINDER = new ErlangTokenType("rem");
  IElementType R_ARROW = new ErlangTokenType("->");
  IElementType R_CURLY = new ErlangTokenType("}");
  IElementType R_DOUBLE_ANGLE = new ErlangTokenType(">>");
  IElementType R_DOUBLE_ARROW = new ErlangTokenType("=>");
  IElementType R_PAREN = new ErlangTokenType(")");
  IElementType R_SQUARE = new ErlangTokenType("]");
  IElementType SEMICOLON = new ErlangTokenType(";");
  IElementType SINGLE_QUOTE = new ErlangTokenType("single_quote");
  IElementType STRING_LITERAL = new ErlangTokenType("string_literal");
  IElementType STRONG_EQ = new ErlangTokenType("=:=");
  IElementType STRONG_NEQ = new ErlangTokenType("=/=");
  IElementType VAR = new ErlangTokenType("var");
  IElementType VERTICAL_BAR = new ErlangTokenType("|");
  IElementType XOR = new ErlangTokenType("xor");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == EXPR) {
        return new ErlASTExprImpl(node);
      }
      else if (type == LITERAL_EXPR) {
        return new ErlASTLiteralExprImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
