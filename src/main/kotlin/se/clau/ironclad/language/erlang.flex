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

// For 'atom names' in quotes
%state IN_QUOTES

%unicode

///////////////////////////////////////////////////////////////////////////////////////////////////
// Whitespaces
///////////////////////////////////////////////////////////////////////////////////////////////////

EOL_WS           = \n | \r | \r\n
LINE_WS          = [\ \t]
WHITE_SPACE_CHAR = {EOL_WS} | {LINE_WS}
WHITE_SPACE      = {WHITE_SPACE_CHAR}+

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
              | {BIN_LITERAL} ) {EXPONENT}?

DEC_LITERAL = [0-9] [0-9_]*
HEX_LITERAL = "0x" [a-fA-F0-9_]*
OCT_LITERAL = "0o" [0-7_]*
BIN_LITERAL = "0b" [01_]*


//CHAR_LITERAL   = ( \' ( [^\\\'\r\n] | \\[^\r\n] | "\\x" [a-fA-F0-9]+ | "\\u{" [a-fA-F0-9][a-fA-F0-9_]* "}"? )? ( \' \\ )? )
//               | ( \' [\p{xidcontinue}]* \'  )
//STRING_LITERAL = \" ( [^\\\"] | \\[^] )* ( \" \\ )?

/* Without the \\\" at the start the lexer won't find it, for unknown reasons */
ESC = "\\" ( [^] )
CHAR = {ESC} | [^\'\"\\]
STRING_BAD1 = \" ({CHAR} | \') *
STRING_LITERAL = {STRING_BAD1} \"

ALPHA_UPPERCASE = [A-Z]
ALPHA_LOWERCASE = [a-z]
ALPHA = {ALPHA_UPPERCASE} | {ALPHA_LOWERCASE}
NUM = [0-9]
OCTAL_ESCAPE = \\ [0-7]{1,3}
CONTROL_NAME = [@A-Z\[\\\]\^_] /* this is the octal range \100 - \137 */
CONTROL_ESCAPE = \\ \^ {CONTROL_NAME}

///////////////////////////////////////////////////////////////////////////////////////////////////
// Identifier: Variable and Atom
///////////////////////////////////////////////////////////////////////////////////////////////////
// Atoms and quoted atoms
ESCAPE_SEQ = \\\" | "\\b" | "\\d" | "\\e" | "\\f" | "\\n" | "\\r" | "\\s" | "\\t" | "\\v" | "\\'"
    | "\\\\" | "\\[" | "\\{" | "\\]" | "\\}" | "\\`" | "\\$" | "\\=" | "\\%" | "\\," | "\\." | "\\_"
    | {CONTROL_ESCAPE} | {OCTAL_ESCAPE}
QUOTED_CHAR = \\' | {ESCAPE_SEQ}  | [^'\\] /* [a-zA-Z0-9#_.@,;:!?/&%$+*~\^-] */
QUOTED_ATOM = {QUOTED_CHAR}+
ATOM_NAME_CHAR = {ALPHA} | {NUM} | @ | _
ATOM = ({ALPHA_LOWERCASE} {ATOM_NAME_CHAR}*)
EMPTY_ATOM = ''

// Variable
VARIABLE_NAME_CHAR = {ALPHA} | {NUM} | _
VARIABLE = ( "_" | {ALPHA_UPPERCASE} ) {VARIABLE_NAME_CHAR} *


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
  "."                             { return PERIOD; }
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

    {VARIABLE}                     { return VAR; }

    /* LITERALS */

    {ATOM} | {EMPTY_ATOM}          { return ATOM_NAME; }
    '                              { yybegin(IN_QUOTES); return SINGLE_QUOTE; }

    {INT_LITERAL}                   { return INTEGER_LITERAL; }
    {STRING_LITERAL}                { return STRING_LITERAL; }

    {WHITE_SPACE}                   { return WHITE_SPACE; }
}

<IN_QUOTES> {
    {QUOTED_ATOM}                 { return ATOM_NAME; }
    '                             { yybegin(YYINITIAL); return SINGLE_QUOTE; }
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
