package se.clau.ironclad.language;

import com.intellij.lexer.*;
import com.intellij.psi.tree.IElementType;

import static se.clau.ironclad.language.ErlangElementTypes.*;
import static se.clau.ironclad.language.ErlangParserDefinition.*;
import static com.intellij.psi.TokenType.*;

%%

%{
  public _ErlangLexer() {
    this((java.io.Reader)null);
  }
%}

%{}
  /**
    * '#+' stride demarking start/end of raw string/byte literal
    */
  //private int zzShaStride = -1;

  /**
    * Dedicated storage for starting position of some previously successful
    * match
    */
  private int zzPostponedMarkedPos = -1;

  /**
    * Dedicated nested-comment level counter
    */
  private int zzNestedCommentLevel = 0;
%}

%public
%class _ErlangLexer
%implements FlexLexer
%function advance
%type IElementType

%s IN_SHEBANG

//%s IN_BLOCK_COMMENT
//%s IN_OUTER_EOL_COMMENT

%s IN_LIFETIME_OR_CHAR

%s IN_RAW_LITERAL
%s IN_RAW_LITERAL_SUFFIX

%unicode

///////////////////////////////////////////////////////////////////////////////////////////////////
// Whitespaces
///////////////////////////////////////////////////////////////////////////////////////////////////

EOL_WS           = \n | \r | \r\n
LINE_WS          = [\ \t]
WHITE_SPACE_CHAR = {EOL_WS} | {LINE_WS}
WHITE_SPACE      = {WHITE_SPACE_CHAR}+

///////////////////////////////////////////////////////////////////////////////////////////////////
// Identifier
///////////////////////////////////////////////////////////////////////////////////////////////////

IDENTIFIER = ("r#")?[_\p{xidstart}][\p{xidcontinue}]*
SUFFIX     = {IDENTIFIER}

///////////////////////////////////////////////////////////////////////////////////////////////////
// Literals
///////////////////////////////////////////////////////////////////////////////////////////////////

EXPONENT      = [eE] [-+]? [0-9_]+

// Note: this rule also consumes *float* literals in scientific form like `1e3`, `3e-4`.
// `FLOAT_LITERAL` is never produced by the lexer.
// See `RustParserUtil.parseFloatLiteral` where `INTEGER_LITERAL` turns into `FLOAT_LITERAL` during parsing.
INT_LITERAL = ( {DEC_LITERAL}
              | {HEX_LITERAL}
              | {OCT_LITERAL}
              | {BIN_LITERAL} ) {EXPONENT}? {SUFFIX}?

DEC_LITERAL = [0-9] [0-9_]*
HEX_LITERAL = "0x" [a-fA-F0-9_]*
OCT_LITERAL = "0o" [0-7_]*
BIN_LITERAL = "0b" [01_]*


CHAR_LITERAL   = ( \' ( [^\\\'\r\n] | \\[^\r\n] | "\\x" [a-fA-F0-9]+ | "\\u{" [a-fA-F0-9][a-fA-F0-9_]* "}"? )? ( \' {SUFFIX}? | \\ )? )
               | ( \' [\p{xidcontinue}]* \' {SUFFIX}? )
STRING_LITERAL = \" ( [^\\\"] | \\[^] )* ( \" {SUFFIX}? | \\ )?

//INNER_EOL_DOC = ({LINE_WS}*"//!".*{EOL_WS})*({LINE_WS}*"//!".*)
// !(!a|b) is a (set) difference between a and b.
//EOL_DOC_LINE  = {LINE_WS}*!(!("///".*)|("////".*))


%%
<YYINITIAL> {
  "#" / "!"[^\[]                  { if (getTokenStart() == 0) yybegin(IN_SHEBANG); else return HASH_SYMBOL; }

//  \'                              { yybegin(IN_LIFETIME_OR_CHAR); yypushback(1); }

  "{"                             { return L_CURLY; }
  "}"                             { return R_CURLY; }
  "["                             { return L_SQUARE; }
  "]"                             { return R_SQUARE; }
  "("                             { return L_PAREN; }
  ")"                             { return R_PAREN; }
  "::"                            { return COLON_COLON; }
  ":"                             { return COLON; }
  ";"                             { return SEMICOLON; }
  ","                             { return COMMA; }
  "."                             { return DOT; }
  "="                             { return EQ; }
  "/="                            { return NEQ; }
  "=="                            { return EQEQ; }
  "!"                             { return BANG; }
  "+"                             { return PLUS; }
  "-"                             { return MINUS; }
  "#"                             { return HASH_SYMBOL; }
  "|"                             { return VERTICAL_BAR; }
  "||"                            { return DOUBLE_BAR; }
  "->"                            { return R_ARROW; }
  "<-"                            { return L_ARROW; }
  "=>"                            { return R_DOUBLE_ARROW; }
  "<="                            { return L_DOUBLE_ARROW; }
  "<"                             { return LT; }
  "*"                             { return MULTIPLY; }
  "/"                             { return FLOAT_DIV; }
  ">"                             { return GT; }
  "?"                             { return QUESTION; }

    "div"                          { return INTEGER_DIV; }
    "rem"                          { return REMAINDER; }
    "or"                           { return OR; }
    "xor"                          { return XOR; }
    "bor"                          { return BINARY_OR; }
    "bxor"                         { return BINARY_XOR; }
    "bsl"                          { return BINARY_SHIFT_L; }
    "bsr"                          { return BINARY_SHIFT_R; }
    "and"                          { return AND; }
    "band"                         { return BINARY_AND; }
    "not"                          { return NOT; }
    "bnot"                         { return BINARY_NOT; }
    "andalso"                      { return ANDALSO; }
    "orelse"                       { return ORELSE; }

    "%%%" .*                       { return MODULE_DOC_COMMENT; }
    "%%" .*                        { return FUNCTION_DOC_COMMENT; }
    "%" .*                         { return COMMENT; }

    {IDENTIFIER}                   { return IDENTIFIER; }

  /* LITERALS */

  {INT_LITERAL}                   { return INTEGER_LITERAL; }
  {STRING_LITERAL}                { return STRING_LITERAL; }

  {WHITE_SPACE}                   { return WHITE_SPACE; }
}

<IN_SHEBANG> {
    [\r\n]  { yypushback(1); yybegin(YYINITIAL); return SHEBANG_LINE;}
    [^]     {}
    <<EOF>> { yybegin(YYINITIAL); return SHEBANG_LINE;}
}

///////////////////////////////////////////////////////////////////////////////////////////////////
// Catch All
///////////////////////////////////////////////////////////////////////////////////////////////////

[^] { return BAD_CHARACTER; }
