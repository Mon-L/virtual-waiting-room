/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package cn.zcn.virtual.waiting.room.script.ast;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LuaLexer extends Lexer {
    static {
        RuntimeMetaData.checkVersion("4.11.1", RuntimeMetaData.VERSION);
    }

    protected static final DFA[] _decisionToDFA;
    protected static final PredictionContextCache _sharedContextCache = new PredictionContextCache();
    public static final int LPAREN = 1,
            RPAREN = 2,
            COLON = 3,
            COMMA = 4,
            DOT = 5,
            LBRACK = 6,
            RBRACK = 7,
            LBRACE = 8,
            RBRACE = 9,
            SEMICO = 10,
            TK_DO = 11,
            TK_END = 12,
            TK_WHILE = 13,
            TK_REPEAT = 14,
            TK_UNTIL = 15,
            TK_IF = 16,
            TK_THEN = 17,
            TK_ELSE = 18,
            TK_ELSEIF = 19,
            TK_FOR = 20,
            TK_IN = 21,
            TK_FUNCTION = 22,
            TK_LOCAL = 23,
            TK_RETURN = 24,
            TK_BREAK = 25,
            TK_NIL = 26,
            EQUAL = 27,
            TRUE = 28,
            FALSE = 29,
            OP_ADD = 30,
            OP_SUB = 31,
            OP_MUL = 32,
            OP_DIV = 33,
            OP_MOD = 34,
            OP_POW = 35,
            OP_CONCAT = 36,
            DOTS = 37,
            TK_LT = 38,
            TK_LE = 39,
            TK_GT = 40,
            TK_GE = 41,
            TK_EQ = 42,
            TK_NEQ = 43,
            TK_AND = 44,
            TK_OR = 45,
            TK_NOT = 46,
            TK_LEN = 47,
            NAME = 48,
            NORMALSTRING = 49,
            CHARSTRING = 50,
            LONGSTRING = 51,
            INT = 52,
            HEX = 53,
            FLOAT = 54,
            SHORT_COMMENT = 55,
            LONG_COMMENT = 56,
            WS = 57,
            SHEBANG = 58;
    public static String[] channelNames = {"DEFAULT_TOKEN_CHANNEL", "HIDDEN"};

    public static String[] modeNames = {"DEFAULT_MODE"};

    private static String[] makeRuleNames() {
        return new String[] {
            "LPAREN",
            "RPAREN",
            "COLON",
            "COMMA",
            "DOT",
            "LBRACK",
            "RBRACK",
            "LBRACE",
            "RBRACE",
            "SEMICO",
            "TK_DO",
            "TK_END",
            "TK_WHILE",
            "TK_REPEAT",
            "TK_UNTIL",
            "TK_IF",
            "TK_THEN",
            "TK_ELSE",
            "TK_ELSEIF",
            "TK_FOR",
            "TK_IN",
            "TK_FUNCTION",
            "TK_LOCAL",
            "TK_RETURN",
            "TK_BREAK",
            "TK_NIL",
            "EQUAL",
            "TRUE",
            "FALSE",
            "OP_ADD",
            "OP_SUB",
            "OP_MUL",
            "OP_DIV",
            "OP_MOD",
            "OP_POW",
            "OP_CONCAT",
            "DOTS",
            "TK_LT",
            "TK_LE",
            "TK_GT",
            "TK_GE",
            "TK_EQ",
            "TK_NEQ",
            "TK_AND",
            "TK_OR",
            "TK_NOT",
            "TK_LEN",
            "NAME",
            "NORMALSTRING",
            "CHARSTRING",
            "LONGSTRING",
            "NESTED_STR",
            "EscapeSequence",
            "INT",
            "HEX",
            "FLOAT",
            "ExponentPart",
            "DecimalEscape",
            "HexEscape",
            "Digit",
            "HexDigit",
            "SHORT_COMMENT",
            "LONG_COMMENT",
            "WS",
            "SHEBANG"
        };
    }

    public static final String[] ruleNames = makeRuleNames();

    private static String[] makeLiteralNames() {
        return new String[] {
            null,
            "'('",
            "')'",
            "':'",
            "','",
            "'.'",
            "'['",
            "']'",
            "'{'",
            "'}'",
            "';'",
            "'do'",
            "'end'",
            "'while'",
            "'repeat'",
            "'until'",
            "'if'",
            "'then'",
            "'else'",
            "'elseif'",
            "'for'",
            "'in'",
            "'function'",
            "'local'",
            "'return'",
            "'break'",
            "'nil'",
            "'='",
            "'true'",
            "'false'",
            "'+'",
            "'-'",
            "'*'",
            "'/'",
            "'%'",
            "'^'",
            "'..'",
            "'...'",
            "'<'",
            "'<='",
            "'>'",
            "'>='",
            "'=='",
            "'~='",
            "'and'",
            "'or'",
            "'not'",
            "'#'"
        };
    }

    private static final String[] _LITERAL_NAMES = makeLiteralNames();

    private static String[] makeSymbolicNames() {
        return new String[] {
            null,
            "LPAREN",
            "RPAREN",
            "COLON",
            "COMMA",
            "DOT",
            "LBRACK",
            "RBRACK",
            "LBRACE",
            "RBRACE",
            "SEMICO",
            "TK_DO",
            "TK_END",
            "TK_WHILE",
            "TK_REPEAT",
            "TK_UNTIL",
            "TK_IF",
            "TK_THEN",
            "TK_ELSE",
            "TK_ELSEIF",
            "TK_FOR",
            "TK_IN",
            "TK_FUNCTION",
            "TK_LOCAL",
            "TK_RETURN",
            "TK_BREAK",
            "TK_NIL",
            "EQUAL",
            "TRUE",
            "FALSE",
            "OP_ADD",
            "OP_SUB",
            "OP_MUL",
            "OP_DIV",
            "OP_MOD",
            "OP_POW",
            "OP_CONCAT",
            "DOTS",
            "TK_LT",
            "TK_LE",
            "TK_GT",
            "TK_GE",
            "TK_EQ",
            "TK_NEQ",
            "TK_AND",
            "TK_OR",
            "TK_NOT",
            "TK_LEN",
            "NAME",
            "NORMALSTRING",
            "CHARSTRING",
            "LONGSTRING",
            "INT",
            "HEX",
            "FLOAT",
            "SHORT_COMMENT",
            "LONG_COMMENT",
            "WS",
            "SHEBANG"
        };
    }

    private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
    public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

    /**
     * @deprecated Use {@link #VOCABULARY} instead.
     */
    @Deprecated
    public static final String[] tokenNames;

    static {
        tokenNames = new String[_SYMBOLIC_NAMES.length];
        for (int i = 0; i < tokenNames.length; i++) {
            tokenNames[i] = VOCABULARY.getLiteralName(i);
            if (tokenNames[i] == null) {
                tokenNames[i] = VOCABULARY.getSymbolicName(i);
            }

            if (tokenNames[i] == null) {
                tokenNames[i] = "<INVALID>";
            }
        }
    }

    @Override
    @Deprecated
    public String[] getTokenNames() {
        return tokenNames;
    }

    @Override
    public Vocabulary getVocabulary() {
        return VOCABULARY;
    }

    public static final int SHORT_COMMENT_CHANNEL = 1;
    public static final int LONG_COMMENT_CHANNEL = 2;

    public LuaLexer(CharStream input) {
        super(input);
        _interp = new LexerATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @Override
    public String getGrammarFileName() {
        return "Lua.g4";
    }

    @Override
    public String[] getRuleNames() {
        return ruleNames;
    }

    @Override
    public String getSerializedATN() {
        return _serializedATN;
    }

    @Override
    public String[] getChannelNames() {
        return channelNames;
    }

    @Override
    public String[] getModeNames() {
        return modeNames;
    }

    @Override
    public ATN getATN() {
        return _ATN;
    }

    public static final String _serializedATN =
            "\u0004\u0000:\u01d3\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"
                    + "\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"
                    + "\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"
                    + "\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"
                    + "\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"
                    + "\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002"
                    + "\u0012\u0007\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002"
                    + "\u0015\u0007\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002"
                    + "\u0018\u0007\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002"
                    + "\u001b\u0007\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002"
                    + "\u001e\u0007\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007"
                    + "!\u0002\"\u0007\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007"
                    + "&\u0002\'\u0007\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007"
                    + "+\u0002,\u0007,\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u0007"
                    + "0\u00021\u00071\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u0007"
                    + "5\u00026\u00076\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007"
                    + ":\u0002;\u0007;\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007"
                    + "?\u0002@\u0007@\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001"
                    + "\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"
                    + "\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001"
                    + "\b\u0001\b\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\u000b\u0001\u000b"
                    + "\u0001\u000b\u0001\u000b\u0001\f\u0001\f\u0001\f\u0001\f\u0001\f\u0001"
                    + "\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e"
                    + "\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000f"
                    + "\u0001\u000f\u0001\u000f\u0001\u0010\u0001\u0010\u0001\u0010\u0001\u0010"
                    + "\u0001\u0010\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011\u0001\u0011"
                    + "\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0012"
                    + "\u0001\u0012\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0013\u0001\u0014"
                    + "\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015"
                    + "\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0015\u0001\u0016"
                    + "\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0016\u0001\u0017"
                    + "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"
                    + "\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018"
                    + "\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0001\u001a"
                    + "\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001c"
                    + "\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0001\u001d"
                    + "\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f\u0001 \u0001"
                    + " \u0001!\u0001!\u0001\"\u0001\"\u0001#\u0001#\u0001#\u0001$\u0001$\u0001"
                    + "$\u0001$\u0001%\u0001%\u0001&\u0001&\u0001&\u0001\'\u0001\'\u0001(\u0001"
                    + "(\u0001(\u0001)\u0001)\u0001)\u0001*\u0001*\u0001*\u0001+\u0001+\u0001"
                    + "+\u0001+\u0001,\u0001,\u0001,\u0001-\u0001-\u0001-\u0001-\u0001.\u0001"
                    + ".\u0001/\u0001/\u0005/\u012c\b/\n/\f/\u012f\t/\u00010\u00010\u00010\u0005"
                    + "0\u0134\b0\n0\f0\u0137\t0\u00010\u00010\u00011\u00011\u00011\u00051\u013e"
                    + "\b1\n1\f1\u0141\t1\u00011\u00011\u00012\u00012\u00012\u00012\u00013\u0001"
                    + "3\u00013\u00013\u00013\u00013\u00053\u014f\b3\n3\f3\u0152\t3\u00013\u0003"
                    + "3\u0155\b3\u00014\u00014\u00014\u00014\u00034\u015b\b4\u00014\u00014\u0001"
                    + "4\u00034\u0160\b4\u00015\u00045\u0163\b5\u000b5\f5\u0164\u00016\u0001"
                    + "6\u00016\u00046\u016a\b6\u000b6\f6\u016b\u00017\u00047\u016f\b7\u000b"
                    + "7\f7\u0170\u00017\u00017\u00057\u0175\b7\n7\f7\u0178\t7\u00017\u00037"
                    + "\u017b\b7\u00017\u00017\u00047\u017f\b7\u000b7\f7\u0180\u00017\u00037"
                    + "\u0184\b7\u00017\u00047\u0187\b7\u000b7\f7\u0188\u00017\u00017\u00037"
                    + "\u018d\b7\u00018\u00018\u00038\u0191\b8\u00018\u00048\u0194\b8\u000b8"
                    + "\f8\u0195\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u00019\u0001"
                    + "9\u00019\u00019\u00039\u01a3\b9\u0001:\u0001:\u0001:\u0001:\u0001:\u0001"
                    + ";\u0001;\u0001<\u0001<\u0001=\u0001=\u0001=\u0001=\u0001=\u0005=\u01b3"
                    + "\b=\n=\f=\u01b6\t=\u0003=\u01b8\b=\u0001=\u0001=\u0001>\u0001>\u0001>"
                    + "\u0001>\u0001>\u0001>\u0001>\u0001?\u0004?\u01c4\b?\u000b?\f?\u01c5\u0001"
                    + "?\u0001?\u0001@\u0001@\u0001@\u0005@\u01cd\b@\n@\f@\u01d0\t@\u0001@\u0001"
                    + "@\u0001\u0150\u0000A\u0001\u0001\u0003\u0002\u0005\u0003\u0007\u0004\t"
                    + "\u0005\u000b\u0006\r\u0007\u000f\b\u0011\t\u0013\n\u0015\u000b\u0017\f"
                    + "\u0019\r\u001b\u000e\u001d\u000f\u001f\u0010!\u0011#\u0012%\u0013\'\u0014"
                    + ")\u0015+\u0016-\u0017/\u00181\u00193\u001a5\u001b7\u001c9\u001d;\u001e"
                    + "=\u001f? A!C\"E#G$I%K&M\'O(Q)S*U+W,Y-[.]/_0a1c2e3g\u0000i\u0000k4m5o6"
                    + "q\u0000s\u0000u\u0000w\u0000y\u0000{7}8\u007f9\u0081:\u0001\u0000\u000e"
                    + "\u0003\u0000AZ__az\u0004\u000009AZ__az\u0002\u0000\"\"\\\\\u0002\u0000"
                    + "\'\'\\\\\n\u0000\"\"\'\'\\\\abffnnrrttvvzz\u0002\u0000XXxx\u0002\u0000"
                    + "EEee\u0002\u0000++--\u0001\u000002\u0001\u000009\u0003\u000009AFaf\u0003"
                    + "\u0000\n\n\r\r[[\u0002\u0000\n\n\r\r\u0003\u0000\t\n\r\r  \u01e8\u0000"
                    + "\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001\u0000\u0000\u0000\u0000"
                    + "\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001\u0000\u0000\u0000\u0000"
                    + "\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000\u0000\u0000\u0000\r"
                    + "\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000\u0000\u0000\u0011"
                    + "\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000\u0000\u0000\u0015"
                    + "\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000\u0000\u0000\u0019"
                    + "\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000\u0000\u0000\u001d"
                    + "\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000\u0000\u0000!\u0001"
                    + "\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0000%\u0001\u0000\u0000"
                    + "\u0000\u0000\'\u0001\u0000\u0000\u0000\u0000)\u0001\u0000\u0000\u0000"
                    + "\u0000+\u0001\u0000\u0000\u0000\u0000-\u0001\u0000\u0000\u0000\u0000/"
                    + "\u0001\u0000\u0000\u0000\u00001\u0001\u0000\u0000\u0000\u00003\u0001\u0000"
                    + "\u0000\u0000\u00005\u0001\u0000\u0000\u0000\u00007\u0001\u0000\u0000\u0000"
                    + "\u00009\u0001\u0000\u0000\u0000\u0000;\u0001\u0000\u0000\u0000\u0000="
                    + "\u0001\u0000\u0000\u0000\u0000?\u0001\u0000\u0000\u0000\u0000A\u0001\u0000"
                    + "\u0000\u0000\u0000C\u0001\u0000\u0000\u0000\u0000E\u0001\u0000\u0000\u0000"
                    + "\u0000G\u0001\u0000\u0000\u0000\u0000I\u0001\u0000\u0000\u0000\u0000K"
                    + "\u0001\u0000\u0000\u0000\u0000M\u0001\u0000\u0000\u0000\u0000O\u0001\u0000"
                    + "\u0000\u0000\u0000Q\u0001\u0000\u0000\u0000\u0000S\u0001\u0000\u0000\u0000"
                    + "\u0000U\u0001\u0000\u0000\u0000\u0000W\u0001\u0000\u0000\u0000\u0000Y"
                    + "\u0001\u0000\u0000\u0000\u0000[\u0001\u0000\u0000\u0000\u0000]\u0001\u0000"
                    + "\u0000\u0000\u0000_\u0001\u0000\u0000\u0000\u0000a\u0001\u0000\u0000\u0000"
                    + "\u0000c\u0001\u0000\u0000\u0000\u0000e\u0001\u0000\u0000\u0000\u0000k"
                    + "\u0001\u0000\u0000\u0000\u0000m\u0001\u0000\u0000\u0000\u0000o\u0001\u0000"
                    + "\u0000\u0000\u0000{\u0001\u0000\u0000\u0000\u0000}\u0001\u0000\u0000\u0000"
                    + "\u0000\u007f\u0001\u0000\u0000\u0000\u0000\u0081\u0001\u0000\u0000\u0000"
                    + "\u0001\u0083\u0001\u0000\u0000\u0000\u0003\u0085\u0001\u0000\u0000\u0000"
                    + "\u0005\u0087\u0001\u0000\u0000\u0000\u0007\u0089\u0001\u0000\u0000\u0000"
                    + "\t\u008b\u0001\u0000\u0000\u0000\u000b\u008d\u0001\u0000\u0000\u0000\r"
                    + "\u008f\u0001\u0000\u0000\u0000\u000f\u0091\u0001\u0000\u0000\u0000\u0011"
                    + "\u0093\u0001\u0000\u0000\u0000\u0013\u0095\u0001\u0000\u0000\u0000\u0015"
                    + "\u0097\u0001\u0000\u0000\u0000\u0017\u009a\u0001\u0000\u0000\u0000\u0019"
                    + "\u009e\u0001\u0000\u0000\u0000\u001b\u00a4\u0001\u0000\u0000\u0000\u001d"
                    + "\u00ab\u0001\u0000\u0000\u0000\u001f\u00b1\u0001\u0000\u0000\u0000!\u00b4"
                    + "\u0001\u0000\u0000\u0000#\u00b9\u0001\u0000\u0000\u0000%\u00be\u0001\u0000"
                    + "\u0000\u0000\'\u00c5\u0001\u0000\u0000\u0000)\u00c9\u0001\u0000\u0000"
                    + "\u0000+\u00cc\u0001\u0000\u0000\u0000-\u00d5\u0001\u0000\u0000\u0000/"
                    + "\u00db\u0001\u0000\u0000\u00001\u00e2\u0001\u0000\u0000\u00003\u00e8\u0001"
                    + "\u0000\u0000\u00005\u00ec\u0001\u0000\u0000\u00007\u00ee\u0001\u0000\u0000"
                    + "\u00009\u00f3\u0001\u0000\u0000\u0000;\u00f9\u0001\u0000\u0000\u0000="
                    + "\u00fb\u0001\u0000\u0000\u0000?\u00fd\u0001\u0000\u0000\u0000A\u00ff\u0001"
                    + "\u0000\u0000\u0000C\u0101\u0001\u0000\u0000\u0000E\u0103\u0001\u0000\u0000"
                    + "\u0000G\u0105\u0001\u0000\u0000\u0000I\u0108\u0001\u0000\u0000\u0000K"
                    + "\u010c\u0001\u0000\u0000\u0000M\u010e\u0001\u0000\u0000\u0000O\u0111\u0001"
                    + "\u0000\u0000\u0000Q\u0113\u0001\u0000\u0000\u0000S\u0116\u0001\u0000\u0000"
                    + "\u0000U\u0119\u0001\u0000\u0000\u0000W\u011c\u0001\u0000\u0000\u0000Y"
                    + "\u0120\u0001\u0000\u0000\u0000[\u0123\u0001\u0000\u0000\u0000]\u0127\u0001"
                    + "\u0000\u0000\u0000_\u0129\u0001\u0000\u0000\u0000a\u0130\u0001\u0000\u0000"
                    + "\u0000c\u013a\u0001\u0000\u0000\u0000e\u0144\u0001\u0000\u0000\u0000g"
                    + "\u0154\u0001\u0000\u0000\u0000i\u015f\u0001\u0000\u0000\u0000k\u0162\u0001"
                    + "\u0000\u0000\u0000m\u0166\u0001\u0000\u0000\u0000o\u018c\u0001\u0000\u0000"
                    + "\u0000q\u018e\u0001\u0000\u0000\u0000s\u01a2\u0001\u0000\u0000\u0000u"
                    + "\u01a4\u0001\u0000\u0000\u0000w\u01a9\u0001\u0000\u0000\u0000y\u01ab\u0001"
                    + "\u0000\u0000\u0000{\u01ad\u0001\u0000\u0000\u0000}\u01bb\u0001\u0000\u0000"
                    + "\u0000\u007f\u01c3\u0001\u0000\u0000\u0000\u0081\u01c9\u0001\u0000\u0000"
                    + "\u0000\u0083\u0084\u0005(\u0000\u0000\u0084\u0002\u0001\u0000\u0000\u0000"
                    + "\u0085\u0086\u0005)\u0000\u0000\u0086\u0004\u0001\u0000\u0000\u0000\u0087"
                    + "\u0088\u0005:\u0000\u0000\u0088\u0006\u0001\u0000\u0000\u0000\u0089\u008a"
                    + "\u0005,\u0000\u0000\u008a\b\u0001\u0000\u0000\u0000\u008b\u008c\u0005"
                    + ".\u0000\u0000\u008c\n\u0001\u0000\u0000\u0000\u008d\u008e\u0005[\u0000"
                    + "\u0000\u008e\f\u0001\u0000\u0000\u0000\u008f\u0090\u0005]\u0000\u0000"
                    + "\u0090\u000e\u0001\u0000\u0000\u0000\u0091\u0092\u0005{\u0000\u0000\u0092"
                    + "\u0010\u0001\u0000\u0000\u0000\u0093\u0094\u0005}\u0000\u0000\u0094\u0012"
                    + "\u0001\u0000\u0000\u0000\u0095\u0096\u0005;\u0000\u0000\u0096\u0014\u0001"
                    + "\u0000\u0000\u0000\u0097\u0098\u0005d\u0000\u0000\u0098\u0099\u0005o\u0000"
                    + "\u0000\u0099\u0016\u0001\u0000\u0000\u0000\u009a\u009b\u0005e\u0000\u0000"
                    + "\u009b\u009c\u0005n\u0000\u0000\u009c\u009d\u0005d\u0000\u0000\u009d\u0018"
                    + "\u0001\u0000\u0000\u0000\u009e\u009f\u0005w\u0000\u0000\u009f\u00a0\u0005"
                    + "h\u0000\u0000\u00a0\u00a1\u0005i\u0000\u0000\u00a1\u00a2\u0005l\u0000"
                    + "\u0000\u00a2\u00a3\u0005e\u0000\u0000\u00a3\u001a\u0001\u0000\u0000\u0000"
                    + "\u00a4\u00a5\u0005r\u0000\u0000\u00a5\u00a6\u0005e\u0000\u0000\u00a6\u00a7"
                    + "\u0005p\u0000\u0000\u00a7\u00a8\u0005e\u0000\u0000\u00a8\u00a9\u0005a"
                    + "\u0000\u0000\u00a9\u00aa\u0005t\u0000\u0000\u00aa\u001c\u0001\u0000\u0000"
                    + "\u0000\u00ab\u00ac\u0005u\u0000\u0000\u00ac\u00ad\u0005n\u0000\u0000\u00ad"
                    + "\u00ae\u0005t\u0000\u0000\u00ae\u00af\u0005i\u0000\u0000\u00af\u00b0\u0005"
                    + "l\u0000\u0000\u00b0\u001e\u0001\u0000\u0000\u0000\u00b1\u00b2\u0005i\u0000"
                    + "\u0000\u00b2\u00b3\u0005f\u0000\u0000\u00b3 \u0001\u0000\u0000\u0000\u00b4"
                    + "\u00b5\u0005t\u0000\u0000\u00b5\u00b6\u0005h\u0000\u0000\u00b6\u00b7\u0005"
                    + "e\u0000\u0000\u00b7\u00b8\u0005n\u0000\u0000\u00b8\"\u0001\u0000\u0000"
                    + "\u0000\u00b9\u00ba\u0005e\u0000\u0000\u00ba\u00bb\u0005l\u0000\u0000\u00bb"
                    + "\u00bc\u0005s\u0000\u0000\u00bc\u00bd\u0005e\u0000\u0000\u00bd$\u0001"
                    + "\u0000\u0000\u0000\u00be\u00bf\u0005e\u0000\u0000\u00bf\u00c0\u0005l\u0000"
                    + "\u0000\u00c0\u00c1\u0005s\u0000\u0000\u00c1\u00c2\u0005e\u0000\u0000\u00c2"
                    + "\u00c3\u0005i\u0000\u0000\u00c3\u00c4\u0005f\u0000\u0000\u00c4&\u0001"
                    + "\u0000\u0000\u0000\u00c5\u00c6\u0005f\u0000\u0000\u00c6\u00c7\u0005o\u0000"
                    + "\u0000\u00c7\u00c8\u0005r\u0000\u0000\u00c8(\u0001\u0000\u0000\u0000\u00c9"
                    + "\u00ca\u0005i\u0000\u0000\u00ca\u00cb\u0005n\u0000\u0000\u00cb*\u0001"
                    + "\u0000\u0000\u0000\u00cc\u00cd\u0005f\u0000\u0000\u00cd\u00ce\u0005u\u0000"
                    + "\u0000\u00ce\u00cf\u0005n\u0000\u0000\u00cf\u00d0\u0005c\u0000\u0000\u00d0"
                    + "\u00d1\u0005t\u0000\u0000\u00d1\u00d2\u0005i\u0000\u0000\u00d2\u00d3\u0005"
                    + "o\u0000\u0000\u00d3\u00d4\u0005n\u0000\u0000\u00d4,\u0001\u0000\u0000"
                    + "\u0000\u00d5\u00d6\u0005l\u0000\u0000\u00d6\u00d7\u0005o\u0000\u0000\u00d7"
                    + "\u00d8\u0005c\u0000\u0000\u00d8\u00d9\u0005a\u0000\u0000\u00d9\u00da\u0005"
                    + "l\u0000\u0000\u00da.\u0001\u0000\u0000\u0000\u00db\u00dc\u0005r\u0000"
                    + "\u0000\u00dc\u00dd\u0005e\u0000\u0000\u00dd\u00de\u0005t\u0000\u0000\u00de"
                    + "\u00df\u0005u\u0000\u0000\u00df\u00e0\u0005r\u0000\u0000\u00e0\u00e1\u0005"
                    + "n\u0000\u0000\u00e10\u0001\u0000\u0000\u0000\u00e2\u00e3\u0005b\u0000"
                    + "\u0000\u00e3\u00e4\u0005r\u0000\u0000\u00e4\u00e5\u0005e\u0000\u0000\u00e5"
                    + "\u00e6\u0005a\u0000\u0000\u00e6\u00e7\u0005k\u0000\u0000\u00e72\u0001"
                    + "\u0000\u0000\u0000\u00e8\u00e9\u0005n\u0000\u0000\u00e9\u00ea\u0005i\u0000"
                    + "\u0000\u00ea\u00eb\u0005l\u0000\u0000\u00eb4\u0001\u0000\u0000\u0000\u00ec"
                    + "\u00ed\u0005=\u0000\u0000\u00ed6\u0001\u0000\u0000\u0000\u00ee\u00ef\u0005"
                    + "t\u0000\u0000\u00ef\u00f0\u0005r\u0000\u0000\u00f0\u00f1\u0005u\u0000"
                    + "\u0000\u00f1\u00f2\u0005e\u0000\u0000\u00f28\u0001\u0000\u0000\u0000\u00f3"
                    + "\u00f4\u0005f\u0000\u0000\u00f4\u00f5\u0005a\u0000\u0000\u00f5\u00f6\u0005"
                    + "l\u0000\u0000\u00f6\u00f7\u0005s\u0000\u0000\u00f7\u00f8\u0005e\u0000"
                    + "\u0000\u00f8:\u0001\u0000\u0000\u0000\u00f9\u00fa\u0005+\u0000\u0000\u00fa"
                    + "<\u0001\u0000\u0000\u0000\u00fb\u00fc\u0005-\u0000\u0000\u00fc>\u0001"
                    + "\u0000\u0000\u0000\u00fd\u00fe\u0005*\u0000\u0000\u00fe@\u0001\u0000\u0000"
                    + "\u0000\u00ff\u0100\u0005/\u0000\u0000\u0100B\u0001\u0000\u0000\u0000\u0101"
                    + "\u0102\u0005%\u0000\u0000\u0102D\u0001\u0000\u0000\u0000\u0103\u0104\u0005"
                    + "^\u0000\u0000\u0104F\u0001\u0000\u0000\u0000\u0105\u0106\u0005.\u0000"
                    + "\u0000\u0106\u0107\u0005.\u0000\u0000\u0107H\u0001\u0000\u0000\u0000\u0108"
                    + "\u0109\u0005.\u0000\u0000\u0109\u010a\u0005.\u0000\u0000\u010a\u010b\u0005"
                    + ".\u0000\u0000\u010bJ\u0001\u0000\u0000\u0000\u010c\u010d\u0005<\u0000"
                    + "\u0000\u010dL\u0001\u0000\u0000\u0000\u010e\u010f\u0005<\u0000\u0000\u010f"
                    + "\u0110\u0005=\u0000\u0000\u0110N\u0001\u0000\u0000\u0000\u0111\u0112\u0005"
                    + ">\u0000\u0000\u0112P\u0001\u0000\u0000\u0000\u0113\u0114\u0005>\u0000"
                    + "\u0000\u0114\u0115\u0005=\u0000\u0000\u0115R\u0001\u0000\u0000\u0000\u0116"
                    + "\u0117\u0005=\u0000\u0000\u0117\u0118\u0005=\u0000\u0000\u0118T\u0001"
                    + "\u0000\u0000\u0000\u0119\u011a\u0005~\u0000\u0000\u011a\u011b\u0005=\u0000"
                    + "\u0000\u011bV\u0001\u0000\u0000\u0000\u011c\u011d\u0005a\u0000\u0000\u011d"
                    + "\u011e\u0005n\u0000\u0000\u011e\u011f\u0005d\u0000\u0000\u011fX\u0001"
                    + "\u0000\u0000\u0000\u0120\u0121\u0005o\u0000\u0000\u0121\u0122\u0005r\u0000"
                    + "\u0000\u0122Z\u0001\u0000\u0000\u0000\u0123\u0124\u0005n\u0000\u0000\u0124"
                    + "\u0125\u0005o\u0000\u0000\u0125\u0126\u0005t\u0000\u0000\u0126\\\u0001"
                    + "\u0000\u0000\u0000\u0127\u0128\u0005#\u0000\u0000\u0128^\u0001\u0000\u0000"
                    + "\u0000\u0129\u012d\u0007\u0000\u0000\u0000\u012a\u012c\u0007\u0001\u0000"
                    + "\u0000\u012b\u012a\u0001\u0000\u0000\u0000\u012c\u012f\u0001\u0000\u0000"
                    + "\u0000\u012d\u012b\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000"
                    + "\u0000\u012e`\u0001\u0000\u0000\u0000\u012f\u012d\u0001\u0000\u0000\u0000"
                    + "\u0130\u0135\u0005\"\u0000\u0000\u0131\u0134\u0003i4\u0000\u0132\u0134"
                    + "\b\u0002\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133\u0132\u0001"
                    + "\u0000\u0000\u0000\u0134\u0137\u0001\u0000\u0000\u0000\u0135\u0133\u0001"
                    + "\u0000\u0000\u0000\u0135\u0136\u0001\u0000\u0000\u0000\u0136\u0138\u0001"
                    + "\u0000\u0000\u0000\u0137\u0135\u0001\u0000\u0000\u0000\u0138\u0139\u0005"
                    + "\"\u0000\u0000\u0139b\u0001\u0000\u0000\u0000\u013a\u013f\u0005\'\u0000"
                    + "\u0000\u013b\u013e\u0003i4\u0000\u013c\u013e\b\u0003\u0000\u0000\u013d"
                    + "\u013b\u0001\u0000\u0000\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013e"
                    + "\u0141\u0001\u0000\u0000\u0000\u013f\u013d\u0001\u0000\u0000\u0000\u013f"
                    + "\u0140\u0001\u0000\u0000\u0000\u0140\u0142\u0001\u0000\u0000\u0000\u0141"
                    + "\u013f\u0001\u0000\u0000\u0000\u0142\u0143\u0005\'\u0000\u0000\u0143d"
                    + "\u0001\u0000\u0000\u0000\u0144\u0145\u0005[\u0000\u0000\u0145\u0146\u0003"
                    + "g3\u0000\u0146\u0147\u0005]\u0000\u0000\u0147f\u0001\u0000\u0000\u0000"
                    + "\u0148\u0149\u0005=\u0000\u0000\u0149\u014a\u0003g3\u0000\u014a\u014b"
                    + "\u0005=\u0000\u0000\u014b\u0155\u0001\u0000\u0000\u0000\u014c\u0150\u0005"
                    + "[\u0000\u0000\u014d\u014f\t\u0000\u0000\u0000\u014e\u014d\u0001\u0000"
                    + "\u0000\u0000\u014f\u0152\u0001\u0000\u0000\u0000\u0150\u0151\u0001\u0000"
                    + "\u0000\u0000\u0150\u014e\u0001\u0000\u0000\u0000\u0151\u0153\u0001\u0000"
                    + "\u0000\u0000\u0152\u0150\u0001\u0000\u0000\u0000\u0153\u0155\u0005]\u0000"
                    + "\u0000\u0154\u0148\u0001\u0000\u0000\u0000\u0154\u014c\u0001\u0000\u0000"
                    + "\u0000\u0155h\u0001\u0000\u0000\u0000\u0156\u0157\u0005\\\u0000\u0000"
                    + "\u0157\u0160\u0007\u0004\u0000\u0000\u0158\u015a\u0005\\\u0000\u0000\u0159"
                    + "\u015b\u0005\r\u0000\u0000\u015a\u0159\u0001\u0000\u0000\u0000\u015a\u015b"
                    + "\u0001\u0000\u0000\u0000\u015b\u015c\u0001\u0000\u0000\u0000\u015c\u0160"
                    + "\u0005\n\u0000\u0000\u015d\u0160\u0003s9\u0000\u015e\u0160\u0003u:\u0000"
                    + "\u015f\u0156\u0001\u0000\u0000\u0000\u015f\u0158\u0001\u0000\u0000\u0000"
                    + "\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u015e\u0001\u0000\u0000\u0000"
                    + "\u0160j\u0001\u0000\u0000\u0000\u0161\u0163\u0003w;\u0000\u0162\u0161"
                    + "\u0001\u0000\u0000\u0000\u0163\u0164\u0001\u0000\u0000\u0000\u0164\u0162"
                    + "\u0001\u0000\u0000\u0000\u0164\u0165\u0001\u0000\u0000\u0000\u0165l\u0001"
                    + "\u0000\u0000\u0000\u0166\u0167\u00050\u0000\u0000\u0167\u0169\u0007\u0005"
                    + "\u0000\u0000\u0168\u016a\u0003y<\u0000\u0169\u0168\u0001\u0000\u0000\u0000"
                    + "\u016a\u016b\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000"
                    + "\u016b\u016c\u0001\u0000\u0000\u0000\u016cn\u0001\u0000\u0000\u0000\u016d"
                    + "\u016f\u0003w;\u0000\u016e\u016d\u0001\u0000\u0000\u0000\u016f\u0170\u0001"
                    + "\u0000\u0000\u0000\u0170\u016e\u0001\u0000\u0000\u0000\u0170\u0171\u0001"
                    + "\u0000\u0000\u0000\u0171\u0172\u0001\u0000\u0000\u0000\u0172\u0176\u0005"
                    + ".\u0000\u0000\u0173\u0175\u0003w;\u0000\u0174\u0173\u0001\u0000\u0000"
                    + "\u0000\u0175\u0178\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000"
                    + "\u0000\u0176\u0177\u0001\u0000\u0000\u0000\u0177\u017a\u0001\u0000\u0000"
                    + "\u0000\u0178\u0176\u0001\u0000\u0000\u0000\u0179\u017b\u0003q8\u0000\u017a"
                    + "\u0179\u0001\u0000\u0000\u0000\u017a\u017b\u0001\u0000\u0000\u0000\u017b"
                    + "\u018d\u0001\u0000\u0000\u0000\u017c\u017e\u0005.\u0000\u0000\u017d\u017f"
                    + "\u0003w;\u0000\u017e\u017d\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000"
                    + "\u0000\u0000\u0180\u017e\u0001\u0000\u0000\u0000\u0180\u0181\u0001\u0000"
                    + "\u0000\u0000\u0181\u0183\u0001\u0000\u0000\u0000\u0182\u0184\u0003q8\u0000"
                    + "\u0183\u0182\u0001\u0000\u0000\u0000\u0183\u0184\u0001\u0000\u0000\u0000"
                    + "\u0184\u018d\u0001\u0000\u0000\u0000\u0185\u0187\u0003w;\u0000\u0186\u0185"
                    + "\u0001\u0000\u0000\u0000\u0187\u0188\u0001\u0000\u0000\u0000\u0188\u0186"
                    + "\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u018a"
                    + "\u0001\u0000\u0000\u0000\u018a\u018b\u0003q8\u0000\u018b\u018d\u0001\u0000"
                    + "\u0000\u0000\u018c\u016e\u0001\u0000\u0000\u0000\u018c\u017c\u0001\u0000"
                    + "\u0000\u0000\u018c\u0186\u0001\u0000\u0000\u0000\u018dp\u0001\u0000\u0000"
                    + "\u0000\u018e\u0190\u0007\u0006\u0000\u0000\u018f\u0191\u0007\u0007\u0000"
                    + "\u0000\u0190\u018f\u0001\u0000\u0000\u0000\u0190\u0191\u0001\u0000\u0000"
                    + "\u0000\u0191\u0193\u0001\u0000\u0000\u0000\u0192\u0194\u0003w;\u0000\u0193"
                    + "\u0192\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195"
                    + "\u0193\u0001\u0000\u0000\u0000\u0195\u0196\u0001\u0000\u0000\u0000\u0196"
                    + "r\u0001\u0000\u0000\u0000\u0197\u0198\u0005\\\u0000\u0000\u0198\u01a3"
                    + "\u0003w;\u0000\u0199\u019a\u0005\\\u0000\u0000\u019a\u019b\u0003w;\u0000"
                    + "\u019b\u019c\u0003w;\u0000\u019c\u01a3\u0001\u0000\u0000\u0000\u019d\u019e"
                    + "\u0005\\\u0000\u0000\u019e\u019f\u0007\b\u0000\u0000\u019f\u01a0\u0003"
                    + "w;\u0000\u01a0\u01a1\u0003w;\u0000\u01a1\u01a3\u0001\u0000\u0000\u0000"
                    + "\u01a2\u0197\u0001\u0000\u0000\u0000\u01a2\u0199\u0001\u0000\u0000\u0000"
                    + "\u01a2\u019d\u0001\u0000\u0000\u0000\u01a3t\u0001\u0000\u0000\u0000\u01a4"
                    + "\u01a5\u0005\\\u0000\u0000\u01a5\u01a6\u0005x\u0000\u0000\u01a6\u01a7"
                    + "\u0003y<\u0000\u01a7\u01a8\u0003y<\u0000\u01a8v\u0001\u0000\u0000\u0000"
                    + "\u01a9\u01aa\u0007\t\u0000\u0000\u01aax\u0001\u0000\u0000\u0000\u01ab"
                    + "\u01ac\u0007\n\u0000\u0000\u01acz\u0001\u0000\u0000\u0000\u01ad\u01ae"
                    + "\u0005-\u0000\u0000\u01ae\u01af\u0005-\u0000\u0000\u01af\u01b7\u0001\u0000"
                    + "\u0000\u0000\u01b0\u01b4\b\u000b\u0000\u0000\u01b1\u01b3\b\f\u0000\u0000"
                    + "\u01b2\u01b1\u0001\u0000\u0000\u0000\u01b3\u01b6\u0001\u0000\u0000\u0000"
                    + "\u01b4\u01b2\u0001\u0000\u0000\u0000\u01b4\u01b5\u0001\u0000\u0000\u0000"
                    + "\u01b5\u01b8\u0001\u0000\u0000\u0000\u01b6\u01b4\u0001\u0000\u0000\u0000"
                    + "\u01b7\u01b0\u0001\u0000\u0000\u0000\u01b7\u01b8\u0001\u0000\u0000\u0000"
                    + "\u01b8\u01b9\u0001\u0000\u0000\u0000\u01b9\u01ba\u0006=\u0000\u0000\u01ba"
                    + "|\u0001\u0000\u0000\u0000\u01bb\u01bc\u0005-\u0000\u0000\u01bc\u01bd\u0005"
                    + "-\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01bf\u0003e2"
                    + "\u0000\u01bf\u01c0\u0001\u0000\u0000\u0000\u01c0\u01c1\u0006>\u0000\u0000"
                    + "\u01c1~\u0001\u0000\u0000\u0000\u01c2\u01c4\u0007\r\u0000\u0000\u01c3"
                    + "\u01c2\u0001\u0000\u0000\u0000\u01c4\u01c5\u0001\u0000\u0000\u0000\u01c5"
                    + "\u01c3\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000\u0000\u0000\u01c6"
                    + "\u01c7\u0001\u0000\u0000\u0000\u01c7\u01c8\u0006?\u0000\u0000\u01c8\u0080"
                    + "\u0001\u0000\u0000\u0000\u01c9\u01ca\u0005#\u0000\u0000\u01ca\u01ce\u0005"
                    + "!\u0000\u0000\u01cb\u01cd\b\f\u0000\u0000\u01cc\u01cb\u0001\u0000\u0000"
                    + "\u0000\u01cd\u01d0\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000"
                    + "\u0000\u01ce\u01cf\u0001\u0000\u0000\u0000\u01cf\u01d1\u0001\u0000\u0000"
                    + "\u0000\u01d0\u01ce\u0001\u0000\u0000\u0000\u01d1\u01d2\u0006@\u0000\u0000"
                    + "\u01d2\u0082\u0001\u0000\u0000\u0000\u001a\u0000\u012d\u0133\u0135\u013d"
                    + "\u013f\u0150\u0154\u015a\u015f\u0164\u016b\u0170\u0176\u017a\u0180\u0183"
                    + "\u0188\u018c\u0190\u0195\u01a2\u01b4\u01b7\u01c5\u01ce\u0001\u0000\u0001"
                    + "\u0000";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}
