/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package se.clau.ironclad.language;

import static se.clau.ironclad.language.ErlangElementTypes.*;
import static se.clau.ironclad.language.ErlangParserDefinition.*;
import com.intellij.lexer.FlexLexer;
import static com.intellij.psi.TokenType.*;
import com.intellij.psi.tree.IElementType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>erlang.flex</tt>
 */
public class GeneratedErlangLexer implements FlexLexer {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int IN_SHEBANG_STATE = 2;
  public static final int IN_QUOTED_ATOM_STATE = 4;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\2\1\1\2\16\1\1\22\0\1\2\1\46\1\14\1\10\1\15\1\43\1\0\1\13\1\54\1\55"+
    "\1\64\1\4\1\44\1\47\1\45\1\60\4\7\4\21\2\6\1\56\1\57\1\63\1\42\1\62\1\24\1"+
    "\22\4\20\1\17\25\20\1\35\1\12\1\37\1\23\1\5\1\41\1\70\1\25\1\53\1\26\1\3\1"+
    "\27\2\11\1\50\2\11\1\52\1\65\1\30\1\66\2\11\1\31\1\32\1\33\1\51\1\34\1\11"+
    "\1\67\2\11\1\36\1\61\1\40\7\0\1\16\242\0\2\16\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\1\1\1\2\1\3\1\4\1\5\2\6\1\7"+
    "\1\10\2\1\1\11\4\3\1\12\1\13\1\14\1\15"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\24\1\25"+
    "\1\26\1\27\1\30\1\31\1\32\1\33\1\34\3\3"+
    "\1\35\1\36\1\3\1\1\1\37\1\0\1\6\2\0"+
    "\1\3\2\0\1\40\2\41\1\42\10\3\1\43\1\44"+
    "\1\17\1\45\4\0\1\46\1\47\1\50\1\51\1\52"+
    "\1\53\1\54\1\55\1\56\2\3\3\0\2\6\1\57"+
    "\1\3\1\60\1\61\1\62\2\3\1\63\1\64\1\65"+
    "\1\45\1\66\3\0\1\67\2\0\1\3\1\70\1\71"+
    "\1\6\1\72\1\73\1\74\10\0\2\3\1\0\1\75"+
    "\1\76\5\0\2\3\1\77\1\0\1\100\2\0\1\101"+
    "\1\102\1\3\1\103\1\104\1\0\1\105\1\106\3\0"+
    "\1\107";

  private static int [] zzUnpackAction() {
    int [] result = new int[151];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\71\0\162\0\253\0\344\0\u011d\0\253\0\u0156"+
    "\0\u018f\0\u01c8\0\u0201\0\u023a\0\u0273\0\u02ac\0\u02e5\0\u031e"+
    "\0\u0357\0\u0390\0\u03c9\0\253\0\253\0\253\0\253\0\u0402"+
    "\0\u043b\0\253\0\253\0\253\0\u0474\0\253\0\253\0\u04ad"+
    "\0\253\0\u04e6\0\u051f\0\u0558\0\u0591\0\253\0\u05ca\0\u0603"+
    "\0\u063c\0\253\0\253\0\u0675\0\u06ae\0\253\0\u06e7\0\u0720"+
    "\0\u0759\0\u0792\0\253\0\u0273\0\u07cb\0\253\0\253\0\u0804"+
    "\0\u083d\0\u0876\0\u08af\0\u08e8\0\u0921\0\u095a\0\u0993\0\u09cc"+
    "\0\u0a05\0\253\0\253\0\u0a3e\0\u0a77\0\u0ab0\0\u0ae9\0\u0b22"+
    "\0\u0b5b\0\253\0\253\0\253\0\253\0\253\0\253\0\253"+
    "\0\253\0\u0b94\0\u0bcd\0\u0c06\0\u06ae\0\u0c3f\0\u0c78\0\u0c78"+
    "\0\u0cb1\0\253\0\u0cea\0\u011d\0\u011d\0\u011d\0\u0d23\0\u0d5c"+
    "\0\u011d\0\u011d\0\u011d\0\u0d95\0\u0dce\0\u0e07\0\u0e40\0\u0e79"+
    "\0\u0eb2\0\u0eeb\0\u0f24\0\u0f5d\0\u011d\0\u0f96\0\u0fcf\0\u011d"+
    "\0\u011d\0\u011d\0\u1008\0\u1041\0\u107a\0\u10b3\0\u10ec\0\u1125"+
    "\0\u115e\0\u1197\0\u11d0\0\u1209\0\u1242\0\253\0\253\0\u127b"+
    "\0\u12b4\0\u12ed\0\u1326\0\u135f\0\u1398\0\u13d1\0\253\0\u140a"+
    "\0\253\0\u1443\0\u147c\0\253\0\u011d\0\u14b5\0\253\0\253"+
    "\0\u14ee\0\u011d\0\u1527\0\u1560\0\u1599\0\u15d2\0\253";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[151];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\4\2\5\1\6\1\7\1\10\1\11\1\12\1\13"+
    "\1\6\1\4\1\14\1\15\1\16\1\4\2\10\1\11"+
    "\2\4\1\17\1\20\1\21\1\6\1\22\1\23\3\6"+
    "\1\24\1\25\1\26\1\27\1\4\1\30\1\31\1\32"+
    "\1\33\1\34\1\35\4\6\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\6\1\47\1\50"+
    "\1\51\1\52\1\53\67\52\12\54\1\55\1\56\55\54"+
    "\72\0\2\5\71\0\1\6\1\0\3\6\1\0\1\6"+
    "\5\0\4\6\2\0\10\6\13\0\4\6\11\0\4\6"+
    "\3\0\1\10\1\0\3\10\1\0\1\10\5\0\3\10"+
    "\3\0\10\10\13\0\4\10\11\0\4\10\3\0\1\57"+
    "\1\0\3\60\1\61\6\0\1\57\1\0\1\60\52\0"+
    "\1\57\1\0\1\60\2\11\1\61\6\0\1\57\1\0"+
    "\1\11\115\0\1\62\35\0\1\63\55\0\12\64\1\65"+
    "\1\64\1\66\54\64\12\67\1\70\56\67\3\0\1\71"+
    "\1\0\1\71\3\0\1\71\5\0\2\71\4\0\10\71"+
    "\13\0\4\71\11\0\4\71\3\0\1\6\1\0\3\6"+
    "\1\0\1\6\5\0\4\6\2\0\3\6\1\72\1\6"+
    "\1\73\2\6\13\0\4\6\11\0\1\6\1\74\1\75"+
    "\1\76\3\0\1\6\1\0\3\6\1\0\1\6\5\0"+
    "\4\6\2\0\10\6\13\0\1\77\3\6\11\0\4\6"+
    "\3\0\1\6\1\0\3\6\1\0\1\6\5\0\4\6"+
    "\2\0\10\6\13\0\4\6\11\0\1\6\1\100\2\6"+
    "\3\0\1\101\1\0\3\6\1\0\1\6\5\0\4\6"+
    "\2\0\10\6\13\0\4\6\11\0\4\6\42\0\1\102"+
    "\17\0\1\103\6\0\1\104\1\0\14\104\1\0\24\104"+
    "\1\105\25\104\3\0\1\106\22\0\1\107\21\0\1\110"+
    "\1\111\10\0\1\112\64\0\1\113\54\0\1\114\107\0"+
    "\1\115\71\0\1\116\50\0\1\117\4\0\1\120\13\0"+
    "\1\121\10\0\1\6\1\0\3\6\1\0\1\6\5\0"+
    "\4\6\2\0\4\6\1\122\3\6\13\0\4\6\11\0"+
    "\4\6\3\0\1\6\1\0\3\6\1\0\1\6\5\0"+
    "\4\6\2\0\10\6\13\0\4\6\11\0\1\6\1\123"+
    "\2\6\3\0\1\6\1\0\3\6\1\0\1\6\5\0"+
    "\4\6\2\0\3\6\1\124\4\6\13\0\4\6\11\0"+
    "\4\6\12\54\1\125\1\0\55\54\3\0\1\54\1\0"+
    "\1\54\1\0\1\54\2\0\4\54\3\0\1\54\1\0"+
    "\1\126\1\0\21\54\27\0\1\127\3\130\11\0\1\130"+
    "\25\0\1\127\24\0\1\57\1\0\3\60\7\0\1\57"+
    "\1\0\1\60\52\0\1\131\2\0\2\131\1\0\1\131"+
    "\5\0\3\131\3\0\10\131\13\0\4\131\11\0\4\131"+
    "\35\132\1\0\33\132\71\64\1\67\1\0\14\67\1\0"+
    "\52\67\3\0\1\71\1\0\3\71\1\0\1\71\5\0"+
    "\3\71\3\0\10\71\13\0\4\71\11\0\4\71\3\0"+
    "\1\6\1\0\3\6\1\0\1\6\5\0\4\6\2\0"+
    "\10\6\13\0\4\6\11\0\1\6\1\133\2\6\3\0"+
    "\1\6\1\0\3\6\1\0\1\6\5\0\4\6\2\0"+
    "\4\6\1\134\3\6\13\0\2\6\1\135\1\6\11\0"+
    "\4\6\3\0\1\6\1\0\3\6\1\0\1\6\5\0"+
    "\4\6\2\0\4\6\1\136\3\6\13\0\4\6\11\0"+
    "\4\6\3\0\1\6\1\0\3\6\1\0\1\6\5\0"+
    "\4\6\2\0\10\6\13\0\4\6\11\0\1\6\1\137"+
    "\2\6\3\0\1\6\1\0\3\6\1\0\1\6\5\0"+
    "\4\6\2\0\3\6\1\140\4\6\13\0\4\6\11\0"+
    "\4\6\3\0\1\6\1\0\3\6\1\0\1\6\5\0"+
    "\4\6\2\0\7\6\1\141\13\0\4\6\11\0\4\6"+
    "\3\0\1\6\1\0\3\6\1\0\1\6\5\0\4\6"+
    "\2\0\6\6\1\142\1\6\13\0\4\6\11\0\4\6"+
    "\3\0\1\6\1\0\3\6\1\0\1\6\5\0\4\6"+
    "\2\0\10\6\13\0\4\6\11\0\1\143\3\6\1\104"+
    "\1\0\14\104\1\0\52\104\1\144\1\0\14\144\1\0"+
    "\24\144\1\145\25\144\30\0\1\146\21\0\1\147\21\0"+
    "\1\150\114\0\1\151\1\152\70\0\1\153\43\0\1\154"+
    "\1\0\3\6\1\0\1\6\5\0\4\6\2\0\10\6"+
    "\13\0\4\6\11\0\4\6\3\0\1\6\1\0\3\6"+
    "\1\0\1\6\5\0\4\6\2\0\4\6\1\155\3\6"+
    "\13\0\4\6\11\0\4\6\3\0\1\6\1\0\3\6"+
    "\1\0\1\6\5\0\4\6\2\0\1\6\1\156\6\6"+
    "\13\0\4\6\11\0\4\6\5\0\1\54\4\0\1\54"+
    "\4\0\2\54\1\0\2\54\11\0\1\54\1\0\1\54"+
    "\36\0\3\130\11\0\1\130\52\0\1\157\1\0\3\131"+
    "\1\0\1\131\5\0\1\157\2\131\3\0\10\131\13\0"+
    "\4\131\11\0\4\131\3\0\1\6\1\0\3\6\1\0"+
    "\1\6\5\0\4\6\2\0\6\6\1\160\1\6\13\0"+
    "\4\6\11\0\4\6\3\0\1\6\1\0\3\6\1\0"+
    "\1\6\5\0\4\6\2\0\4\6\1\161\3\6\13\0"+
    "\4\6\11\0\4\6\3\0\1\6\1\0\3\6\1\0"+
    "\1\6\5\0\4\6\2\0\1\6\1\162\6\6\13\0"+
    "\4\6\11\0\4\6\1\144\1\0\14\144\1\0\52\144"+
    "\1\145\1\0\14\145\1\0\52\145\26\0\1\163\74\0"+
    "\1\164\15\0\1\165\47\0\1\166\67\0\1\167\1\0"+
    "\1\170\113\0\1\171\43\0\1\172\45\0\1\6\1\0"+
    "\3\6\1\0\1\6\5\0\4\6\2\0\10\6\13\0"+
    "\2\6\1\173\1\6\11\0\4\6\3\0\1\6\1\0"+
    "\3\6\1\0\1\6\5\0\4\6\2\0\10\6\13\0"+
    "\4\6\11\0\3\6\1\174\3\0\1\157\1\127\3\131"+
    "\1\0\1\131\5\0\1\157\2\131\3\0\10\131\12\0"+
    "\1\127\4\131\11\0\4\131\50\0\1\175\23\0\1\176"+
    "\114\0\1\177\111\0\1\200\23\0\1\201\113\0\1\202"+
    "\114\0\1\203\21\0\1\204\70\0\1\6\1\0\3\6"+
    "\1\0\1\6\5\0\4\6\2\0\5\6\1\205\2\6"+
    "\13\0\4\6\11\0\4\6\3\0\1\6\1\0\3\6"+
    "\1\0\1\6\5\0\4\6\2\0\10\6\13\0\2\6"+
    "\1\206\1\6\11\0\4\6\27\0\1\207\71\0\1\210"+
    "\67\0\1\211\44\0\1\212\136\0\1\213\46\0\1\214"+
    "\44\0\1\215\1\0\3\6\1\0\1\6\5\0\4\6"+
    "\2\0\10\6\13\0\4\6\11\0\4\6\3\0\1\6"+
    "\1\0\3\6\1\0\1\6\5\0\4\6\2\0\5\6"+
    "\1\216\2\6\13\0\4\6\11\0\4\6\3\0\1\217"+
    "\114\0\1\220\67\0\1\221\45\0\1\6\1\0\3\6"+
    "\1\0\1\6\5\0\4\6\2\0\10\6\13\0\4\6"+
    "\11\0\1\6\1\222\2\6\3\0\1\223\72\0\1\224"+
    "\135\0\1\225\66\0\1\226\45\0\1\227\43\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[5643];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\11\2\1\1\11\14\1\4\11\2\1\3\11"+
    "\1\1\2\11\1\1\1\11\4\1\1\11\3\1\2\11"+
    "\2\1\1\11\1\0\1\1\2\0\1\11\2\0\2\11"+
    "\12\1\2\11\2\1\4\0\10\11\3\1\3\0\2\1"+
    "\1\11\13\1\3\0\1\1\2\0\7\1\10\0\2\1"+
    "\1\0\2\11\5\0\2\1\1\11\1\0\1\11\2\0"+
    "\1\11\2\1\2\11\1\0\2\1\3\0\1\11";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[151];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  public GeneratedErlangLexer() {
    this((java.io.Reader)null);
  }
    /**
    * Dedicated storage for starting position of some previously successful
    * match
    */
    private int zzSavedStartRead = -1;

    /**
    * Dedicated nested-comment level counter
    */
    private int zzNestedCommentLevel = 0;

    IElementType imbueCharacterLiteral() {
        zzStartRead += 1;
        return CHAR_LITERAL;
    }
    IElementType imbueShebang() {
        zzStartRead = zzSavedStartRead + 2; // skip #!
        zzSavedStartRead = -1;
        return SHEBANG_LINE;
    }


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public GeneratedErlangLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
   * matched text.
   *
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch.
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
   *
   * In a wellformed scanner (no or only correct usage of
   * yypushback(int) and a match-all fallback rule) this method
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  }


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        switch (zzLexicalState) {
            case IN_SHEBANG_STATE: {
              yybegin(YYINITIAL); return SHEBANG_LINE;
            }  // fall though
            case 152: break;
            default:
        return null;
        }
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return BAD_CHARACTER;
            } 
            // fall through
          case 72: break;
          case 2: 
            { return WHITE_SPACE;
            } 
            // fall through
          case 73: break;
          case 3: 
            { return ATOM_NAME;
            } 
            // fall through
          case 74: break;
          case 4: 
            { return PLUS;
            } 
            // fall through
          case 75: break;
          case 5: 
            { return VAR;
            } 
            // fall through
          case 76: break;
          case 6: 
            { return INTEGER_LITERAL;
            } 
            // fall through
          case 77: break;
          case 7: 
            { return HASH_SYMBOL;
            } 
            // fall through
          case 78: break;
          case 8: 
            { yybegin(IN_QUOTED_ATOM_STATE); return SINGLE_QUOTE;
            } 
            // fall through
          case 79: break;
          case 9: 
            { return QUESTION;
            } 
            // fall through
          case 80: break;
          case 10: 
            { return L_SQUARE;
            } 
            // fall through
          case 81: break;
          case 11: 
            { return L_CURLY;
            } 
            // fall through
          case 82: break;
          case 12: 
            { return R_SQUARE;
            } 
            // fall through
          case 83: break;
          case 13: 
            { return R_CURLY;
            } 
            // fall through
          case 84: break;
          case 14: 
            { return EQ;
            } 
            // fall through
          case 85: break;
          case 15: 
            { return COMMENT;
            } 
            // fall through
          case 86: break;
          case 16: 
            { return COMMA;
            } 
            // fall through
          case 87: break;
          case 17: 
            { return PERIOD;
            } 
            // fall through
          case 88: break;
          case 18: 
            { return BANG;
            } 
            // fall through
          case 89: break;
          case 19: 
            { return MINUS;
            } 
            // fall through
          case 90: break;
          case 20: 
            { return L_PAREN;
            } 
            // fall through
          case 91: break;
          case 21: 
            { return R_PAREN;
            } 
            // fall through
          case 92: break;
          case 22: 
            { return COLON;
            } 
            // fall through
          case 93: break;
          case 23: 
            { return SEMICOLON;
            } 
            // fall through
          case 94: break;
          case 24: 
            { return FLOAT_DIV;
            } 
            // fall through
          case 95: break;
          case 25: 
            { return VERTICAL_BAR;
            } 
            // fall through
          case 96: break;
          case 26: 
            { return GT;
            } 
            // fall through
          case 97: break;
          case 27: 
            { return LT;
            } 
            // fall through
          case 98: break;
          case 28: 
            { return MULTIPLY;
            } 
            // fall through
          case 99: break;
          case 29: 
            { 
            } 
            // fall through
          case 100: break;
          case 30: 
            { yypushback(1); yybegin(YYINITIAL); return imbueShebang();
            } 
            // fall through
          case 101: break;
          case 31: 
            { yybegin(YYINITIAL); return SINGLE_QUOTE;
            } 
            // fall through
          case 102: break;
          case 32: 
            { return STRING_LITERAL;
            } 
            // fall through
          case 103: break;
          case 33: 
            { return imbueCharacterLiteral();
            } 
            // fall through
          case 104: break;
          case 34: 
            { return PP_PASTE;
            } 
            // fall through
          case 105: break;
          case 35: 
            { return EQEQ;
            } 
            // fall through
          case 106: break;
          case 36: 
            { return R_DOUBLE_ARROW;
            } 
            // fall through
          case 107: break;
          case 37: 
            { return FUNCTION_DOC_COMMENT;
            } 
            // fall through
          case 108: break;
          case 38: 
            { return R_ARROW;
            } 
            // fall through
          case 109: break;
          case 39: 
            { return COLON_COLON;
            } 
            // fall through
          case 110: break;
          case 40: 
            { return NEQ;
            } 
            // fall through
          case 111: break;
          case 41: 
            { return DOUBLE_BAR;
            } 
            // fall through
          case 112: break;
          case 42: 
            { return R_DOUBLE_ANGLE;
            } 
            // fall through
          case 113: break;
          case 43: 
            { return L_DOUBLE_ARROW;
            } 
            // fall through
          case 114: break;
          case 44: 
            { return L_ARROW;
            } 
            // fall through
          case 115: break;
          case 45: 
            { return L_DOUBLE_ANGLE;
            } 
            // fall through
          case 116: break;
          case 46: 
            { return OR;
            } 
            // fall through
          case 117: break;
          case 47: 
            // lookahead expression with fixed base length
            zzMarkedPos = Character.offsetByCodePoints
                (zzBufferL/*, zzStartRead, zzEndRead - zzStartRead*/, zzStartRead, 1);
            { if (getTokenStart() == 0) {
            zzSavedStartRead = zzStartRead;
            yybegin(IN_SHEBANG_STATE);
        } else return HASH_SYMBOL;
            } 
            // fall through
          case 118: break;
          case 48: 
            { return BINARY_SHIFT_R;
            } 
            // fall through
          case 119: break;
          case 49: 
            { return BINARY_SHIFT_L;
            } 
            // fall through
          case 120: break;
          case 50: 
            { return BINARY_OR;
            } 
            // fall through
          case 121: break;
          case 51: 
            { return INTEGER_DIV;
            } 
            // fall through
          case 122: break;
          case 52: 
            { return NOT;
            } 
            // fall through
          case 123: break;
          case 53: 
            { return REMAINDER;
            } 
            // fall through
          case 124: break;
          case 54: 
            { return MODULE_DOC_COMMENT;
            } 
            // fall through
          case 125: break;
          case 55: 
            { return PP_IF;
            } 
            // fall through
          case 126: break;
          case 56: 
            { return XOR;
            } 
            // fall through
          case 127: break;
          case 57: 
            { return AND;
            } 
            // fall through
          case 128: break;
          case 58: 
            { return BINARY_NOT;
            } 
            // fall through
          case 129: break;
          case 59: 
            { return BINARY_XOR;
            } 
            // fall through
          case 130: break;
          case 60: 
            { return BINARY_AND;
            } 
            // fall through
          case 131: break;
          case 61: 
            { return PP_ELSE;
            } 
            // fall through
          case 132: break;
          case 62: 
            { return PP_ELIF;
            } 
            // fall through
          case 133: break;
          case 63: 
            { return PP_ENDIF;
            } 
            // fall through
          case 134: break;
          case 64: 
            { return PP_IFDEF;
            } 
            // fall through
          case 135: break;
          case 65: 
            { return PP_UNDEF;
            } 
            // fall through
          case 136: break;
          case 66: 
            { return ORELSE;
            } 
            // fall through
          case 137: break;
          case 67: 
            { return PP_DEFINE;
            } 
            // fall through
          case 138: break;
          case 68: 
            { return PP_IFNDEF;
            } 
            // fall through
          case 139: break;
          case 69: 
            { return ANDALSO;
            } 
            // fall through
          case 140: break;
          case 70: 
            { return PP_INCLUDE;
            } 
            // fall through
          case 141: break;
          case 71: 
            { return PP_INCLUDELIB;
            } 
            // fall through
          case 142: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
