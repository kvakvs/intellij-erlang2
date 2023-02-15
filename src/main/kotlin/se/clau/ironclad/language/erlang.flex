package se.clau.ironclad.language;

import static se.clau.ironclad.language.ErlangElementTypes.*;
import static se.clau.ironclad.language.ErlangParserDefinition.*;
import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.*;
import com.intellij.psi.tree.IElementType;

%%

%{
  public GeneratedErlangLexer() {
    this((java.io.Reader)null);
  }
%}

%{}
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
%class GeneratedErlangLexer
%implements FlexLexer
%function advance
%type IElementType

%s IN_SHEBANG_STATE

// For 'atom names' in quotes
%s IN_QUOTED_ATOM_STATE

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
// See `ErlangParserUtil.parseFloatLiteral` where `INT_LITERAL` turns into `FLOAT_LITERAL` during parsing.
INT_LITERAL = ( {DEC_LITERAL} | {BASED_LITERAL} ) {EXPONENT}?
DEC_LITERAL = [0-9] [0-9_]*
// Integer literals with radix (base) specified, like 16#0ffff or 36#a123z, radix is 2..36
BASED_LITERAL = [0-3]? [0-9] "#" [0-9a-zA-Z] [0-9a-zA-Z_]*

// Without the \\\" at the start the lexer won't find it, for unknown reasons
ESC = "\\" ( [^] )
STRING_CHAR = {ESC} | [^\'\"\\]
STRING_BAD1 = \" ({STRING_CHAR} | \') *
STRING_LITERAL = {STRING_BAD1} \"

DOLLAR_ESCAPED_CHAR = \\ .
DOLLAR_CHAR = "$" ( {DOLLAR_ESCAPED_CHAR} | . )

ALPHA_UPPERCASE = [A-Z]
ALPHA_LOWERCASE = [a-z]
ALPHA = {ALPHA_UPPERCASE} | {ALPHA_LOWERCASE}
NUM = [0-9]
OCTAL_ESCAPE = \\ [0-7]{1,3}
CONTROL_NAME = [@A-Z\[\\\]\^_] /* this is the octal range \100 - \137 */
CONTROL_ESCAPE = \\ \^ {CONTROL_NAME}

// A pasted ?MACRO
PREPROCESSOR_PASTE = "?" [A-Za-z_] [A-Za-z_0-9]*

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
    "#" / "!"[^\[]                 { if (getTokenStart() == 0) yybegin(IN_SHEBANG_STATE); else return HASH_SYMBOL; }
    {PREPROCESSOR_PASTE}           { return PP_PASTE; }

    // Preprocessor
    // These do not return a token, resolve in place
    "-define"           { return PP_DEFINE; }
    "-undef"            { return PP_UNDEF; }
    "-ifdef"            { return PP_IFDEF; }
    "-if"               { return PP_IF; }
    "-elif"             { return PP_ELIF; }
    "-ifndef"           { return PP_IFNDEF; }
    "-else"             { return PP_ELSE; }
    "-endif"            { return PP_ENDIF; }
    "-include"          { return PP_INCLUDE; }
    "-include_lib"      { return PP_INCLUDELIB; }
    // Preprocessor end

    "{"                            { return L_CURLY; }
    "}"                            { return R_CURLY; }
    "["                            { return L_SQUARE; }
    "]"                            { return R_SQUARE; }
    "("                            { return L_PAREN; }
    ")"                            { return R_PAREN; }
    "::"                           { return COLON_COLON; }
    ":"                            { return COLON; }
    ";"                            { return SEMICOLON; }
    ","                            { return COMMA; }
    "."                            { return PERIOD; }
    "/="                           { return NEQ; }
    "=="                           { return EQEQ; }
    "="                            { return EQ; }
    "!"                            { return BANG; }
    "#"                            { return HASH_SYMBOL; }
    "||"                           { return DOUBLE_BAR; }
    "|"                            { return VERTICAL_BAR; }
    "->"                           { return R_ARROW; }
    "<-"                           { return L_ARROW; }
    "=>"                           { return R_DOUBLE_ARROW; }
    "<="                           { return L_DOUBLE_ARROW; }
    "*"                            { return MULTIPLY; }
    "/"                            { return FLOAT_DIV; }
    "+"                            { return PLUS; }
    "-"                            { return MINUS; }
    "<<"                           { return L_DOUBLE_ANGLE; }
    "<"                            { return LT; }
    ">>"                           { return R_DOUBLE_ANGLE; }
    ">"                            { return GT; }
    "?"                            { return QUESTION; }

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
    {DOLLAR_CHAR}                  { return DOLLAR_CHAR; }

    /* LITERALS */

    {ATOM} | {EMPTY_ATOM}          { return ATOM_NAME; }
    '                              { yybegin(IN_QUOTED_ATOM_STATE); return SINGLE_QUOTE; }

    {INT_LITERAL}                   { return INTEGER_LITERAL; }
    {STRING_LITERAL}                { return STRING_LITERAL; }

    {WHITE_SPACE}                   { return WHITE_SPACE; }
}

<IN_QUOTED_ATOM_STATE> {
    {QUOTED_ATOM}                 { return ATOM_NAME; }
    '                             { yybegin(YYINITIAL); return SINGLE_QUOTE; }
}

<IN_SHEBANG_STATE> {
    [\r\n]  { yypushback(1); yybegin(YYINITIAL); return SHEBANG_LINE;}
    [^]     {}
    <<EOF>> { yybegin(YYINITIAL); return SHEBANG_LINE;}
}

///////////////////////////////////////////////////////////////////////////////////////////////////
// Catch All
///////////////////////////////////////////////////////////////////////////////////////////////////

[^] { return BAD_CHARACTER; }
