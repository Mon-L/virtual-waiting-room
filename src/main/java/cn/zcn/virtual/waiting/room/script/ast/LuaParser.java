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

import java.util.List;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class LuaParser extends Parser {
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
    public static final int RULE_file = 0,
            RULE_chunk = 1,
            RULE_block = 2,
            RULE_stat = 3,
            RULE_laststat = 4,
            RULE_blockstat = 5,
            RULE_ifstat = 6,
            RULE_whilestat = 7,
            RULE_repeatstat = 8,
            RULE_functionstat = 9,
            RULE_forstat = 10,
            RULE_foriterdef = 11,
            RULE_forbody = 12,
            RULE_localfunctionstat = 13,
            RULE_localstat = 14,
            RULE_namelist = 15,
            RULE_functionname = 16,
            RULE_dotfield = 17,
            RULE_colonfield = 18,
            RULE_funcbody = 19,
            RULE_param = 20,
            RULE_assignexpr = 21,
            RULE_cond = 22,
            RULE_expr = 23,
            RULE_primaryexp = 24,
            RULE_prefixexp = 25,
            RULE_funcargs = 26,
            RULE_recfield = 27,
            RULE_listfield = 28,
            RULE_constructor = 29,
            RULE_fieldsep = 30,
            RULE_yindex = 31,
            RULE_unop = 32,
            RULE_number = 33,
            RULE_string = 34;

    private static String[] makeRuleNames() {
        return new String[] {
            "file",
            "chunk",
            "block",
            "stat",
            "laststat",
            "blockstat",
            "ifstat",
            "whilestat",
            "repeatstat",
            "functionstat",
            "forstat",
            "foriterdef",
            "forbody",
            "localfunctionstat",
            "localstat",
            "namelist",
            "functionname",
            "dotfield",
            "colonfield",
            "funcbody",
            "param",
            "assignexpr",
            "cond",
            "expr",
            "primaryexp",
            "prefixexp",
            "funcargs",
            "recfield",
            "listfield",
            "constructor",
            "fieldsep",
            "yindex",
            "unop",
            "number",
            "string"
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

    @Override
    public String getGrammarFileName() {
        return "java-escape";
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
    public ATN getATN() {
        return _ATN;
    }

    public LuaParser(TokenStream input) {
        super(input);
        _interp = new ParserATNSimulator(this, _ATN, _decisionToDFA, _sharedContextCache);
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FileContext extends ParserRuleContext {
        public ChunkContext chunk() {
            return getRuleContext(ChunkContext.class, 0);
        }

        public TerminalNode EOF() {
            return getToken(LuaParser.EOF, 0);
        }

        public TerminalNode SHEBANG() {
            return getToken(LuaParser.SHEBANG, 0);
        }

        public FileContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_file;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterFile(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitFile(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitFile(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FileContext file() throws RecognitionException {
        FileContext _localctx = new FileContext(_ctx, getState());
        enterRule(_localctx, 0, RULE_file);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(71);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == SHEBANG) {
                    {
                        setState(70);
                        match(SHEBANG);
                    }
                }

                setState(73);
                chunk();
                setState(74);
                match(EOF);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ChunkContext extends ParserRuleContext {
        public List<StatContext> stat() {
            return getRuleContexts(StatContext.class);
        }

        public StatContext stat(int i) {
            return getRuleContext(StatContext.class, i);
        }

        public LaststatContext laststat() {
            return getRuleContext(LaststatContext.class, 0);
        }

        public List<TerminalNode> SEMICO() {
            return getTokens(LuaParser.SEMICO);
        }

        public TerminalNode SEMICO(int i) {
            return getToken(LuaParser.SEMICO, i);
        }

        public ChunkContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_chunk;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterChunk(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitChunk(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitChunk(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ChunkContext chunk() throws RecognitionException {
        ChunkContext _localctx = new ChunkContext(_ctx, getState());
        enterRule(_localctx, 2, RULE_chunk);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(82);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (((_la) & ~0x3f) == 0 && ((1L << _la) & 35958568747362562L) != 0) {
                    {
                        {
                            setState(76);
                            stat();
                            setState(78);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                            if (_la == SEMICO) {
                                {
                                    setState(77);
                                    match(SEMICO);
                                }
                            }
                        }
                    }
                    setState(84);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(89);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == TK_RETURN || _la == TK_BREAK) {
                    {
                        setState(85);
                        laststat();
                        setState(87);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == SEMICO) {
                            {
                                setState(86);
                                match(SEMICO);
                            }
                        }
                    }
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BlockContext extends ParserRuleContext {
        public ChunkContext chunk() {
            return getRuleContext(ChunkContext.class, 0);
        }

        public BlockContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_block;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterBlock(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitBlock(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitBlock(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BlockContext block() throws RecognitionException {
        BlockContext _localctx = new BlockContext(_ctx, getState());
        enterRule(_localctx, 4, RULE_block);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(91);
                chunk();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StatContext extends ParserRuleContext {
        public IfstatContext ifstat() {
            return getRuleContext(IfstatContext.class, 0);
        }

        public WhilestatContext whilestat() {
            return getRuleContext(WhilestatContext.class, 0);
        }

        public BlockstatContext blockstat() {
            return getRuleContext(BlockstatContext.class, 0);
        }

        public FunctionstatContext functionstat() {
            return getRuleContext(FunctionstatContext.class, 0);
        }

        public ForstatContext forstat() {
            return getRuleContext(ForstatContext.class, 0);
        }

        public RepeatstatContext repeatstat() {
            return getRuleContext(RepeatstatContext.class, 0);
        }

        public LocalfunctionstatContext localfunctionstat() {
            return getRuleContext(LocalfunctionstatContext.class, 0);
        }

        public LocalstatContext localstat() {
            return getRuleContext(LocalstatContext.class, 0);
        }

        public PrimaryexpContext primaryexp() {
            return getRuleContext(PrimaryexpContext.class, 0);
        }

        public AssignexprContext assignexpr() {
            return getRuleContext(AssignexprContext.class, 0);
        }

        public StatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_stat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterStat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitStat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitStat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StatContext stat() throws RecognitionException {
        StatContext _localctx = new StatContext(_ctx, getState());
        enterRule(_localctx, 6, RULE_stat);
        try {
            setState(103);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 5, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(93);
                        ifstat();
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(94);
                        whilestat();
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(95);
                        blockstat();
                    }
                    break;
                case 4:
                    enterOuterAlt(_localctx, 4);
                    {
                        setState(96);
                        functionstat();
                    }
                    break;
                case 5:
                    enterOuterAlt(_localctx, 5);
                    {
                        setState(97);
                        forstat();
                    }
                    break;
                case 6:
                    enterOuterAlt(_localctx, 6);
                    {
                        setState(98);
                        repeatstat();
                    }
                    break;
                case 7:
                    enterOuterAlt(_localctx, 7);
                    {
                        setState(99);
                        localfunctionstat();
                    }
                    break;
                case 8:
                    enterOuterAlt(_localctx, 8);
                    {
                        setState(100);
                        localstat();
                    }
                    break;
                case 9:
                    enterOuterAlt(_localctx, 9);
                    {
                        setState(101);
                        primaryexp();
                    }
                    break;
                case 10:
                    enterOuterAlt(_localctx, 10);
                    {
                        setState(102);
                        assignexpr();
                    }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LaststatContext extends ParserRuleContext {
        public LaststatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_laststat;
        }

        public LaststatContext() {}

        public void copyFrom(LaststatContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ReturnContext extends LaststatContext {
        public TerminalNode TK_RETURN() {
            return getToken(LuaParser.TK_RETURN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(LuaParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(LuaParser.COMMA, i);
        }

        public ReturnContext(LaststatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterReturn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitReturn(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitReturn(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PlainReturnContext extends LaststatContext {
        public TerminalNode TK_RETURN() {
            return getToken(LuaParser.TK_RETURN, 0);
        }

        public PlainReturnContext(LaststatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterPlainReturn(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitPlainReturn(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitPlainReturn(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BreakContext extends LaststatContext {
        public TerminalNode TK_BREAK() {
            return getToken(LuaParser.TK_BREAK, 0);
        }

        public BreakContext(LaststatContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterBreak(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitBreak(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitBreak(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LaststatContext laststat() throws RecognitionException {
        LaststatContext _localctx = new LaststatContext(_ctx, getState());
        enterRule(_localctx, 8, RULE_laststat);
        int _la;
        try {
            setState(116);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 7, _ctx)) {
                case 1:
                    _localctx = new PlainReturnContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(105);
                        match(TK_RETURN);
                    }
                    break;
                case 2:
                    _localctx = new ReturnContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(106);
                        match(TK_RETURN);
                        setState(107);
                        expr(0);
                        setState(112);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(108);
                                    match(COMMA);
                                    setState(109);
                                    expr(0);
                                }
                            }
                            setState(114);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                    break;
                case 3:
                    _localctx = new BreakContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(115);
                        match(TK_BREAK);
                    }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class BlockstatContext extends ParserRuleContext {
        public TerminalNode TK_DO() {
            return getToken(LuaParser.TK_DO, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public TerminalNode TK_END() {
            return getToken(LuaParser.TK_END, 0);
        }

        public BlockstatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_blockstat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterBlockstat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitBlockstat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitBlockstat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final BlockstatContext blockstat() throws RecognitionException {
        BlockstatContext _localctx = new BlockstatContext(_ctx, getState());
        enterRule(_localctx, 10, RULE_blockstat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(118);
                match(TK_DO);
                setState(119);
                block();
                setState(120);
                match(TK_END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class IfstatContext extends ParserRuleContext {
        public TerminalNode TK_IF() {
            return getToken(LuaParser.TK_IF, 0);
        }

        public List<CondContext> cond() {
            return getRuleContexts(CondContext.class);
        }

        public CondContext cond(int i) {
            return getRuleContext(CondContext.class, i);
        }

        public List<TerminalNode> TK_THEN() {
            return getTokens(LuaParser.TK_THEN);
        }

        public TerminalNode TK_THEN(int i) {
            return getToken(LuaParser.TK_THEN, i);
        }

        public List<BlockContext> block() {
            return getRuleContexts(BlockContext.class);
        }

        public BlockContext block(int i) {
            return getRuleContext(BlockContext.class, i);
        }

        public TerminalNode TK_END() {
            return getToken(LuaParser.TK_END, 0);
        }

        public List<TerminalNode> TK_ELSEIF() {
            return getTokens(LuaParser.TK_ELSEIF);
        }

        public TerminalNode TK_ELSEIF(int i) {
            return getToken(LuaParser.TK_ELSEIF, i);
        }

        public TerminalNode TK_ELSE() {
            return getToken(LuaParser.TK_ELSE, 0);
        }

        public IfstatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_ifstat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterIfstat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitIfstat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitIfstat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final IfstatContext ifstat() throws RecognitionException {
        IfstatContext _localctx = new IfstatContext(_ctx, getState());
        enterRule(_localctx, 12, RULE_ifstat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(122);
                match(TK_IF);
                setState(123);
                cond();
                setState(124);
                match(TK_THEN);
                setState(125);
                block();
                setState(133);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == TK_ELSEIF) {
                    {
                        {
                            setState(126);
                            match(TK_ELSEIF);
                            setState(127);
                            cond();
                            setState(128);
                            match(TK_THEN);
                            setState(129);
                            block();
                        }
                    }
                    setState(135);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(138);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == TK_ELSE) {
                    {
                        setState(136);
                        match(TK_ELSE);
                        setState(137);
                        block();
                    }
                }

                setState(140);
                match(TK_END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class WhilestatContext extends ParserRuleContext {
        public TerminalNode TK_WHILE() {
            return getToken(LuaParser.TK_WHILE, 0);
        }

        public CondContext cond() {
            return getRuleContext(CondContext.class, 0);
        }

        public TerminalNode TK_DO() {
            return getToken(LuaParser.TK_DO, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public TerminalNode TK_END() {
            return getToken(LuaParser.TK_END, 0);
        }

        public WhilestatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_whilestat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterWhilestat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitWhilestat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitWhilestat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final WhilestatContext whilestat() throws RecognitionException {
        WhilestatContext _localctx = new WhilestatContext(_ctx, getState());
        enterRule(_localctx, 14, RULE_whilestat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(142);
                match(TK_WHILE);
                setState(143);
                cond();
                setState(144);
                match(TK_DO);
                setState(145);
                block();
                setState(146);
                match(TK_END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RepeatstatContext extends ParserRuleContext {
        public TerminalNode TK_REPEAT() {
            return getToken(LuaParser.TK_REPEAT, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public TerminalNode TK_UNTIL() {
            return getToken(LuaParser.TK_UNTIL, 0);
        }

        public CondContext cond() {
            return getRuleContext(CondContext.class, 0);
        }

        public RepeatstatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_repeatstat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterRepeatstat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitRepeatstat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitRepeatstat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final RepeatstatContext repeatstat() throws RecognitionException {
        RepeatstatContext _localctx = new RepeatstatContext(_ctx, getState());
        enterRule(_localctx, 16, RULE_repeatstat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(148);
                match(TK_REPEAT);
                setState(149);
                block();
                setState(150);
                match(TK_UNTIL);
                setState(151);
                cond();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionstatContext extends ParserRuleContext {
        public TerminalNode TK_FUNCTION() {
            return getToken(LuaParser.TK_FUNCTION, 0);
        }

        public FunctionnameContext functionname() {
            return getRuleContext(FunctionnameContext.class, 0);
        }

        public FuncbodyContext funcbody() {
            return getRuleContext(FuncbodyContext.class, 0);
        }

        public FunctionstatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionstat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterFunctionstat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitFunctionstat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitFunctionstat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FunctionstatContext functionstat() throws RecognitionException {
        FunctionstatContext _localctx = new FunctionstatContext(_ctx, getState());
        enterRule(_localctx, 18, RULE_functionstat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(153);
                match(TK_FUNCTION);
                setState(154);
                functionname();
                setState(155);
                funcbody();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ForstatContext extends ParserRuleContext {
        public TerminalNode TK_FOR() {
            return getToken(LuaParser.TK_FOR, 0);
        }

        public ForiterdefContext foriterdef() {
            return getRuleContext(ForiterdefContext.class, 0);
        }

        public ForbodyContext forbody() {
            return getRuleContext(ForbodyContext.class, 0);
        }

        public TerminalNode TK_END() {
            return getToken(LuaParser.TK_END, 0);
        }

        public ForstatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forstat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterForstat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitForstat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitForstat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ForstatContext forstat() throws RecognitionException {
        ForstatContext _localctx = new ForstatContext(_ctx, getState());
        enterRule(_localctx, 20, RULE_forstat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(157);
                match(TK_FOR);
                setState(158);
                foriterdef();
                setState(159);
                forbody();
                setState(160);
                match(TK_END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ForiterdefContext extends ParserRuleContext {
        public List<TerminalNode> NAME() {
            return getTokens(LuaParser.NAME);
        }

        public TerminalNode NAME(int i) {
            return getToken(LuaParser.NAME, i);
        }

        public TerminalNode EQUAL() {
            return getToken(LuaParser.EQUAL, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(LuaParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(LuaParser.COMMA, i);
        }

        public TerminalNode TK_IN() {
            return getToken(LuaParser.TK_IN, 0);
        }

        public ForiterdefContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_foriterdef;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterForiterdef(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitForiterdef(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitForiterdef(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ForiterdefContext foriterdef() throws RecognitionException {
        ForiterdefContext _localctx = new ForiterdefContext(_ctx, getState());
        enterRule(_localctx, 22, RULE_foriterdef);
        int _la;
        try {
            setState(189);
            _errHandler.sync(this);
            switch (getInterpreter().adaptivePredict(_input, 13, _ctx)) {
                case 1:
                    enterOuterAlt(_localctx, 1);
                    {
                    }
                    break;
                case 2:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(163);
                        match(NAME);
                        setState(164);
                        match(EQUAL);
                        setState(165);
                        expr(0);
                        setState(166);
                        match(COMMA);
                        setState(167);
                        expr(0);
                        setState(170);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == COMMA) {
                            {
                                setState(168);
                                match(COMMA);
                                setState(169);
                                expr(0);
                            }
                        }
                    }
                    break;
                case 3:
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(172);
                        match(NAME);
                        setState(177);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(173);
                                    match(COMMA);
                                    setState(174);
                                    match(NAME);
                                }
                            }
                            setState(179);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                        setState(180);
                        match(TK_IN);
                        setState(181);
                        expr(0);
                        setState(186);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(182);
                                    match(COMMA);
                                    setState(183);
                                    expr(0);
                                }
                            }
                            setState(188);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                    break;
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ForbodyContext extends ParserRuleContext {
        public TerminalNode TK_DO() {
            return getToken(LuaParser.TK_DO, 0);
        }

        public BlockContext block() {
            return getRuleContext(BlockContext.class, 0);
        }

        public ForbodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_forbody;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterForbody(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitForbody(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitForbody(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ForbodyContext forbody() throws RecognitionException {
        ForbodyContext _localctx = new ForbodyContext(_ctx, getState());
        enterRule(_localctx, 24, RULE_forbody);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(191);
                match(TK_DO);
                setState(192);
                block();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LocalfunctionstatContext extends ParserRuleContext {
        public TerminalNode TK_LOCAL() {
            return getToken(LuaParser.TK_LOCAL, 0);
        }

        public TerminalNode TK_FUNCTION() {
            return getToken(LuaParser.TK_FUNCTION, 0);
        }

        public TerminalNode NAME() {
            return getToken(LuaParser.NAME, 0);
        }

        public FuncbodyContext funcbody() {
            return getRuleContext(FuncbodyContext.class, 0);
        }

        public LocalfunctionstatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_localfunctionstat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterLocalfunctionstat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitLocalfunctionstat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitLocalfunctionstat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LocalfunctionstatContext localfunctionstat() throws RecognitionException {
        LocalfunctionstatContext _localctx = new LocalfunctionstatContext(_ctx, getState());
        enterRule(_localctx, 26, RULE_localfunctionstat);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(194);
                match(TK_LOCAL);
                setState(195);
                match(TK_FUNCTION);
                setState(196);
                match(NAME);
                setState(197);
                funcbody();
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class LocalstatContext extends ParserRuleContext {
        public TerminalNode TK_LOCAL() {
            return getToken(LuaParser.TK_LOCAL, 0);
        }

        public NamelistContext namelist() {
            return getRuleContext(NamelistContext.class, 0);
        }

        public TerminalNode EQUAL() {
            return getToken(LuaParser.EQUAL, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(LuaParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(LuaParser.COMMA, i);
        }

        public LocalstatContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_localstat;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterLocalstat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitLocalstat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitLocalstat(this);
            else return visitor.visitChildren(this);
        }
    }

    public final LocalstatContext localstat() throws RecognitionException {
        LocalstatContext _localctx = new LocalstatContext(_ctx, getState());
        enterRule(_localctx, 28, RULE_localstat);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(199);
                match(TK_LOCAL);
                setState(200);
                namelist();
                setState(210);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == EQUAL) {
                    {
                        setState(201);
                        match(EQUAL);
                        setState(202);
                        expr(0);
                        setState(207);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(203);
                                    match(COMMA);
                                    setState(204);
                                    expr(0);
                                }
                            }
                            setState(209);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NamelistContext extends ParserRuleContext {
        public List<TerminalNode> NAME() {
            return getTokens(LuaParser.NAME);
        }

        public TerminalNode NAME(int i) {
            return getToken(LuaParser.NAME, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(LuaParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(LuaParser.COMMA, i);
        }

        public NamelistContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_namelist;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterNamelist(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitNamelist(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitNamelist(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NamelistContext namelist() throws RecognitionException {
        NamelistContext _localctx = new NamelistContext(_ctx, getState());
        enterRule(_localctx, 30, RULE_namelist);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(212);
                match(NAME);
                setState(217);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(213);
                            match(COMMA);
                            setState(214);
                            match(NAME);
                        }
                    }
                    setState(219);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FunctionnameContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(LuaParser.NAME, 0);
        }

        public List<DotfieldContext> dotfield() {
            return getRuleContexts(DotfieldContext.class);
        }

        public DotfieldContext dotfield(int i) {
            return getRuleContext(DotfieldContext.class, i);
        }

        public ColonfieldContext colonfield() {
            return getRuleContext(ColonfieldContext.class, 0);
        }

        public FunctionnameContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_functionname;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterFunctionname(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitFunctionname(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitFunctionname(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FunctionnameContext functionname() throws RecognitionException {
        FunctionnameContext _localctx = new FunctionnameContext(_ctx, getState());
        enterRule(_localctx, 32, RULE_functionname);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(220);
                match(NAME);
                setState(224);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == DOT) {
                    {
                        {
                            setState(221);
                            dotfield();
                        }
                    }
                    setState(226);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(228);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == COLON) {
                    {
                        setState(227);
                        colonfield();
                    }
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class DotfieldContext extends ParserRuleContext {
        public TerminalNode DOT() {
            return getToken(LuaParser.DOT, 0);
        }

        public TerminalNode NAME() {
            return getToken(LuaParser.NAME, 0);
        }

        public DotfieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_dotfield;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterDotfield(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitDotfield(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitDotfield(this);
            else return visitor.visitChildren(this);
        }
    }

    public final DotfieldContext dotfield() throws RecognitionException {
        DotfieldContext _localctx = new DotfieldContext(_ctx, getState());
        enterRule(_localctx, 34, RULE_dotfield);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(230);
                match(DOT);
                setState(231);
                match(NAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ColonfieldContext extends ParserRuleContext {
        public TerminalNode COLON() {
            return getToken(LuaParser.COLON, 0);
        }

        public TerminalNode NAME() {
            return getToken(LuaParser.NAME, 0);
        }

        public ColonfieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_colonfield;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterColonfield(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitColonfield(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitColonfield(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ColonfieldContext colonfield() throws RecognitionException {
        ColonfieldContext _localctx = new ColonfieldContext(_ctx, getState());
        enterRule(_localctx, 36, RULE_colonfield);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(233);
                match(COLON);
                setState(234);
                match(NAME);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncbodyContext extends ParserRuleContext {
        public TerminalNode LPAREN() {
            return getToken(LuaParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(LuaParser.RPAREN, 0);
        }

        public ChunkContext chunk() {
            return getRuleContext(ChunkContext.class, 0);
        }

        public TerminalNode TK_END() {
            return getToken(LuaParser.TK_END, 0);
        }

        public List<ParamContext> param() {
            return getRuleContexts(ParamContext.class);
        }

        public ParamContext param(int i) {
            return getRuleContext(ParamContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(LuaParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(LuaParser.COMMA, i);
        }

        public FuncbodyContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcbody;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterFuncbody(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitFuncbody(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitFuncbody(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FuncbodyContext funcbody() throws RecognitionException {
        FuncbodyContext _localctx = new FuncbodyContext(_ctx, getState());
        enterRule(_localctx, 38, RULE_funcbody);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(236);
                match(LPAREN);
                setState(245);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (_la == DOTS || _la == NAME) {
                    {
                        setState(237);
                        param();
                        setState(242);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        while (_la == COMMA) {
                            {
                                {
                                    setState(238);
                                    match(COMMA);
                                    setState(239);
                                    param();
                                }
                            }
                            setState(244);
                            _errHandler.sync(this);
                            _la = _input.LA(1);
                        }
                    }
                }

                setState(247);
                match(RPAREN);
                setState(248);
                chunk();
                setState(249);
                match(TK_END);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ParamContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(LuaParser.NAME, 0);
        }

        public TerminalNode DOTS() {
            return getToken(LuaParser.DOTS, 0);
        }

        public ParamContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_param;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterParam(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitParam(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitParam(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ParamContext param() throws RecognitionException {
        ParamContext _localctx = new ParamContext(_ctx, getState());
        enterRule(_localctx, 40, RULE_param);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(251);
                _la = _input.LA(1);
                if (!(_la == DOTS || _la == NAME)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class AssignexprContext extends ParserRuleContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode EQUAL() {
            return getToken(LuaParser.EQUAL, 0);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(LuaParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(LuaParser.COMMA, i);
        }

        public List<PrimaryexpContext> primaryexp() {
            return getRuleContexts(PrimaryexpContext.class);
        }

        public PrimaryexpContext primaryexp(int i) {
            return getRuleContext(PrimaryexpContext.class, i);
        }

        public AssignexprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_assignexpr;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterAssignexpr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitAssignexpr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitAssignexpr(this);
            else return visitor.visitChildren(this);
        }
    }

    public final AssignexprContext assignexpr() throws RecognitionException {
        AssignexprContext _localctx = new AssignexprContext(_ctx, getState());
        enterRule(_localctx, 42, RULE_assignexpr);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(253);
                expr(0);
                setState(258);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(254);
                            match(COMMA);
                            setState(255);
                            primaryexp();
                        }
                    }
                    setState(260);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
                setState(261);
                match(EQUAL);
                setState(262);
                expr(0);
                setState(267);
                _errHandler.sync(this);
                _la = _input.LA(1);
                while (_la == COMMA) {
                    {
                        {
                            setState(263);
                            match(COMMA);
                            setState(264);
                            expr(0);
                        }
                    }
                    setState(269);
                    _errHandler.sync(this);
                    _la = _input.LA(1);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class CondContext extends ParserRuleContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public CondContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_cond;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterCond(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitCond(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitCond(this);
            else return visitor.visitChildren(this);
        }
    }

    public final CondContext cond() throws RecognitionException {
        CondContext _localctx = new CondContext(_ctx, getState());
        enterRule(_localctx, 44, RULE_cond);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(270);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprContext extends ParserRuleContext {
        public ExprContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_expr;
        }

        public ExprContext() {}

        public void copyFrom(ExprContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprMulDivModContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode OP_MUL() {
            return getToken(LuaParser.OP_MUL, 0);
        }

        public TerminalNode OP_DIV() {
            return getToken(LuaParser.OP_DIV, 0);
        }

        public TerminalNode OP_MOD() {
            return getToken(LuaParser.OP_MOD, 0);
        }

        public ExprMulDivModContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprMulDivMod(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprMulDivMod(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprMulDivMod(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprConcatContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode OP_CONCAT() {
            return getToken(LuaParser.OP_CONCAT, 0);
        }

        public ExprConcatContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprConcat(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprConcat(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprConcat(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprStringContext extends ExprContext {
        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public ExprStringContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprString(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprFalseContext extends ExprContext {
        public TerminalNode FALSE() {
            return getToken(LuaParser.FALSE, 0);
        }

        public ExprFalseContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprFalse(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprFalse(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprFalse(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprTrueContext extends ExprContext {
        public TerminalNode TRUE() {
            return getToken(LuaParser.TRUE, 0);
        }

        public ExprTrueContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprTrue(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprTrue(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprTrue(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprLogicOrContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode TK_OR() {
            return getToken(LuaParser.TK_OR, 0);
        }

        public ExprLogicOrContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprLogicOr(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprLogicOr(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprLogicOr(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprNilContext extends ExprContext {
        public TerminalNode TK_NIL() {
            return getToken(LuaParser.TK_NIL, 0);
        }

        public ExprNilContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprNil(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprNil(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprNil(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprRelationContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode TK_LT() {
            return getToken(LuaParser.TK_LT, 0);
        }

        public TerminalNode TK_LE() {
            return getToken(LuaParser.TK_LE, 0);
        }

        public TerminalNode TK_GT() {
            return getToken(LuaParser.TK_GT, 0);
        }

        public TerminalNode TK_GE() {
            return getToken(LuaParser.TK_GE, 0);
        }

        public ExprRelationContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprRelation(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprRelation(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprRelation(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprPrimaryContext extends ExprContext {
        public PrimaryexpContext primaryexp() {
            return getRuleContext(PrimaryexpContext.class, 0);
        }

        public ExprPrimaryContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprPrimary(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprPrimary(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprPrimary(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprAddSubContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode OP_ADD() {
            return getToken(LuaParser.OP_ADD, 0);
        }

        public TerminalNode OP_SUB() {
            return getToken(LuaParser.OP_SUB, 0);
        }

        public ExprAddSubContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprAddSub(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprAddSub(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprAddSub(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprPowContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode OP_POW() {
            return getToken(LuaParser.OP_POW, 0);
        }

        public ExprPowContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprPow(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprPow(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprPow(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprTableContext extends ExprContext {
        public ConstructorContext constructor() {
            return getRuleContext(ConstructorContext.class, 0);
        }

        public ExprTableContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprTable(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprTable(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprTable(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprUnaryContext extends ExprContext {
        public UnopContext unop() {
            return getRuleContext(UnopContext.class, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public ExprUnaryContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprUnary(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprUnary(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprUnary(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprLogicAndContext extends ExprContext {
        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode TK_AND() {
            return getToken(LuaParser.TK_AND, 0);
        }

        public ExprLogicAndContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprLogicAnd(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprLogicAnd(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprLogicAnd(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprNumberContext extends ExprContext {
        public NumberContext number() {
            return getRuleContext(NumberContext.class, 0);
        }

        public ExprNumberContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprNumber(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprAnonymousFunctionContext extends ExprContext {
        public TerminalNode TK_FUNCTION() {
            return getToken(LuaParser.TK_FUNCTION, 0);
        }

        public FuncbodyContext funcbody() {
            return getRuleContext(FuncbodyContext.class, 0);
        }

        public ExprAnonymousFunctionContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprAnonymousFunction(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprAnonymousFunction(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor)
                return ((LuaVisitor<? extends T>) visitor).visitExprAnonymousFunction(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprDotsContext extends ExprContext {
        public TerminalNode DOTS() {
            return getToken(LuaParser.DOTS, 0);
        }

        public ExprDotsContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprDots(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprDots(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprDots(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ExprEqualityContext extends ExprContext {
        public Token op;

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public TerminalNode TK_EQ() {
            return getToken(LuaParser.TK_EQ, 0);
        }

        public TerminalNode TK_NEQ() {
            return getToken(LuaParser.TK_NEQ, 0);
        }

        public ExprEqualityContext(ExprContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterExprEquality(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitExprEquality(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitExprEquality(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ExprContext expr() throws RecognitionException {
        return expr(0);
    }

    private ExprContext expr(int _p) throws RecognitionException {
        ParserRuleContext _parentctx = _ctx;
        int _parentState = getState();
        ExprContext _localctx = new ExprContext(_ctx, _parentState);
        ExprContext _prevctx = _localctx;
        int _startState = 46;
        enterRecursionRule(_localctx, 46, RULE_expr, _p);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(286);
                _errHandler.sync(this);
                switch (_input.LA(1)) {
                    case INT:
                    case HEX:
                    case FLOAT:
                        {
                            _localctx = new ExprNumberContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;

                            setState(273);
                            number();
                        }
                        break;
                    case NORMALSTRING:
                    case CHARSTRING:
                    case LONGSTRING:
                        {
                            _localctx = new ExprStringContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;
                            setState(274);
                            string();
                        }
                        break;
                    case TK_NIL:
                        {
                            _localctx = new ExprNilContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;
                            setState(275);
                            match(TK_NIL);
                        }
                        break;
                    case FALSE:
                        {
                            _localctx = new ExprFalseContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;
                            setState(276);
                            match(FALSE);
                        }
                        break;
                    case TRUE:
                        {
                            _localctx = new ExprTrueContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;
                            setState(277);
                            match(TRUE);
                        }
                        break;
                    case DOTS:
                        {
                            _localctx = new ExprDotsContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;
                            setState(278);
                            match(DOTS);
                        }
                        break;
                    case LBRACE:
                        {
                            _localctx = new ExprTableContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;
                            setState(279);
                            constructor();
                        }
                        break;
                    case TK_FUNCTION:
                        {
                            _localctx = new ExprAnonymousFunctionContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;
                            setState(280);
                            match(TK_FUNCTION);
                            setState(281);
                            funcbody();
                        }
                        break;
                    case LPAREN:
                    case NAME:
                        {
                            _localctx = new ExprPrimaryContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;
                            setState(282);
                            primaryexp();
                        }
                        break;
                    case OP_SUB:
                    case TK_NOT:
                    case TK_LEN:
                        {
                            _localctx = new ExprUnaryContext(_localctx);
                            _ctx = _localctx;
                            _prevctx = _localctx;
                            setState(283);
                            unop();
                            setState(284);
                            expr(7);
                        }
                        break;
                    default:
                        throw new NoViableAltException(this);
                }
                _ctx.stop = _input.LT(-1);
                setState(314);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 25, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        if (_parseListeners != null) triggerExitRuleEvent();
                        _prevctx = _localctx;
                        {
                            setState(312);
                            _errHandler.sync(this);
                            switch (getInterpreter().adaptivePredict(_input, 24, _ctx)) {
                                case 1:
                                    {
                                        _localctx = new ExprPowContext(new ExprContext(_parentctx, _parentState));
                                        pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                        setState(288);
                                        if (!(precpred(_ctx, 9)))
                                            throw new FailedPredicateException(this, "precpred(_ctx, 9)");
                                        setState(289);
                                        match(OP_POW);
                                        setState(290);
                                        expr(9);
                                    }
                                    break;
                                case 2:
                                    {
                                        _localctx = new ExprConcatContext(new ExprContext(_parentctx, _parentState));
                                        pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                        setState(291);
                                        if (!(precpred(_ctx, 8)))
                                            throw new FailedPredicateException(this, "precpred(_ctx, 8)");
                                        setState(292);
                                        match(OP_CONCAT);
                                        setState(293);
                                        expr(8);
                                    }
                                    break;
                                case 3:
                                    {
                                        _localctx = new ExprMulDivModContext(new ExprContext(_parentctx, _parentState));
                                        pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                        setState(294);
                                        if (!(precpred(_ctx, 6)))
                                            throw new FailedPredicateException(this, "precpred(_ctx, 6)");
                                        setState(295);
                                        ((ExprMulDivModContext) _localctx).op = _input.LT(1);
                                        _la = _input.LA(1);
                                        if (!(((_la) & ~0x3f) == 0 && ((1L << _la) & 30064771072L) != 0)) {
                                            ((ExprMulDivModContext) _localctx).op =
                                                    (Token) _errHandler.recoverInline(this);
                                        } else {
                                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                            _errHandler.reportMatch(this);
                                            consume();
                                        }
                                        setState(296);
                                        expr(7);
                                    }
                                    break;
                                case 4:
                                    {
                                        _localctx = new ExprAddSubContext(new ExprContext(_parentctx, _parentState));
                                        pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                        setState(297);
                                        if (!(precpred(_ctx, 5)))
                                            throw new FailedPredicateException(this, "precpred(_ctx, 5)");
                                        setState(298);
                                        ((ExprAddSubContext) _localctx).op = _input.LT(1);
                                        _la = _input.LA(1);
                                        if (!(_la == OP_ADD || _la == OP_SUB)) {
                                            ((ExprAddSubContext) _localctx).op =
                                                    (Token) _errHandler.recoverInline(this);
                                        } else {
                                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                            _errHandler.reportMatch(this);
                                            consume();
                                        }
                                        setState(299);
                                        expr(6);
                                    }
                                    break;
                                case 5:
                                    {
                                        _localctx = new ExprRelationContext(new ExprContext(_parentctx, _parentState));
                                        pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                        setState(300);
                                        if (!(precpred(_ctx, 4)))
                                            throw new FailedPredicateException(this, "precpred(_ctx, 4)");
                                        setState(301);
                                        ((ExprRelationContext) _localctx).op = _input.LT(1);
                                        _la = _input.LA(1);
                                        if (!(((_la) & ~0x3f) == 0 && ((1L << _la) & 4123168604160L) != 0)) {
                                            ((ExprRelationContext) _localctx).op =
                                                    (Token) _errHandler.recoverInline(this);
                                        } else {
                                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                            _errHandler.reportMatch(this);
                                            consume();
                                        }
                                        setState(302);
                                        expr(5);
                                    }
                                    break;
                                case 6:
                                    {
                                        _localctx = new ExprEqualityContext(new ExprContext(_parentctx, _parentState));
                                        pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                        setState(303);
                                        if (!(precpred(_ctx, 3)))
                                            throw new FailedPredicateException(this, "precpred(_ctx, 3)");
                                        setState(304);
                                        ((ExprEqualityContext) _localctx).op = _input.LT(1);
                                        _la = _input.LA(1);
                                        if (!(_la == TK_EQ || _la == TK_NEQ)) {
                                            ((ExprEqualityContext) _localctx).op =
                                                    (Token) _errHandler.recoverInline(this);
                                        } else {
                                            if (_input.LA(1) == Token.EOF) matchedEOF = true;
                                            _errHandler.reportMatch(this);
                                            consume();
                                        }
                                        setState(305);
                                        expr(4);
                                    }
                                    break;
                                case 7:
                                    {
                                        _localctx = new ExprLogicAndContext(new ExprContext(_parentctx, _parentState));
                                        pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                        setState(306);
                                        if (!(precpred(_ctx, 2)))
                                            throw new FailedPredicateException(this, "precpred(_ctx, 2)");
                                        setState(307);
                                        match(TK_AND);
                                        setState(308);
                                        expr(3);
                                    }
                                    break;
                                case 8:
                                    {
                                        _localctx = new ExprLogicOrContext(new ExprContext(_parentctx, _parentState));
                                        pushNewRecursionContext(_localctx, _startState, RULE_expr);
                                        setState(309);
                                        if (!(precpred(_ctx, 1)))
                                            throw new FailedPredicateException(this, "precpred(_ctx, 1)");
                                        setState(310);
                                        match(TK_OR);
                                        setState(311);
                                        expr(2);
                                    }
                                    break;
                            }
                        }
                    }
                    setState(316);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 25, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            unrollRecursionContexts(_parentctx);
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrimaryexpContext extends ParserRuleContext {
        public PrefixexpContext prefixexp() {
            return getRuleContext(PrefixexpContext.class, 0);
        }

        public List<DotfieldContext> dotfield() {
            return getRuleContexts(DotfieldContext.class);
        }

        public DotfieldContext dotfield(int i) {
            return getRuleContext(DotfieldContext.class, i);
        }

        public List<YindexContext> yindex() {
            return getRuleContexts(YindexContext.class);
        }

        public YindexContext yindex(int i) {
            return getRuleContext(YindexContext.class, i);
        }

        public List<TerminalNode> COLON() {
            return getTokens(LuaParser.COLON);
        }

        public TerminalNode COLON(int i) {
            return getToken(LuaParser.COLON, i);
        }

        public List<TerminalNode> NAME() {
            return getTokens(LuaParser.NAME);
        }

        public TerminalNode NAME(int i) {
            return getToken(LuaParser.NAME, i);
        }

        public List<FuncargsContext> funcargs() {
            return getRuleContexts(FuncargsContext.class);
        }

        public FuncargsContext funcargs(int i) {
            return getRuleContext(FuncargsContext.class, i);
        }

        public PrimaryexpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_primaryexp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterPrimaryexp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitPrimaryexp(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitPrimaryexp(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PrimaryexpContext primaryexp() throws RecognitionException {
        PrimaryexpContext _localctx = new PrimaryexpContext(_ctx, getState());
        enterRule(_localctx, 48, RULE_primaryexp);
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(317);
                prefixexp();
                setState(326);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 27, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            setState(324);
                            _errHandler.sync(this);
                            switch (_input.LA(1)) {
                                case DOT:
                                    {
                                        setState(318);
                                        dotfield();
                                    }
                                    break;
                                case LBRACK:
                                    {
                                        setState(319);
                                        yindex();
                                    }
                                    break;
                                case COLON:
                                    {
                                        setState(320);
                                        match(COLON);
                                        setState(321);
                                        match(NAME);
                                        setState(322);
                                        funcargs();
                                    }
                                    break;
                                case LPAREN:
                                case LBRACE:
                                case NORMALSTRING:
                                case CHARSTRING:
                                case LONGSTRING:
                                    {
                                        setState(323);
                                        funcargs();
                                    }
                                    break;
                                default:
                                    throw new NoViableAltException(this);
                            }
                        }
                    }
                    setState(328);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 27, _ctx);
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class PrefixexpContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(LuaParser.NAME, 0);
        }

        public TerminalNode LPAREN() {
            return getToken(LuaParser.LPAREN, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(LuaParser.RPAREN, 0);
        }

        public PrefixexpContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_prefixexp;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterPrefixexp(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitPrefixexp(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitPrefixexp(this);
            else return visitor.visitChildren(this);
        }
    }

    public final PrefixexpContext prefixexp() throws RecognitionException {
        PrefixexpContext _localctx = new PrefixexpContext(_ctx, getState());
        enterRule(_localctx, 50, RULE_prefixexp);
        try {
            setState(334);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NAME:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(329);
                        match(NAME);
                    }
                    break;
                case LPAREN:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(330);
                        match(LPAREN);
                        setState(331);
                        expr(0);
                        setState(332);
                        match(RPAREN);
                    }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncargsContext extends ParserRuleContext {
        public FuncargsContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_funcargs;
        }

        public FuncargsContext() {}

        public void copyFrom(FuncargsContext ctx) {
            super.copyFrom(ctx);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArgsNormalContext extends FuncargsContext {
        public TerminalNode LPAREN() {
            return getToken(LuaParser.LPAREN, 0);
        }

        public TerminalNode RPAREN() {
            return getToken(LuaParser.RPAREN, 0);
        }

        public List<ExprContext> expr() {
            return getRuleContexts(ExprContext.class);
        }

        public ExprContext expr(int i) {
            return getRuleContext(ExprContext.class, i);
        }

        public List<TerminalNode> COMMA() {
            return getTokens(LuaParser.COMMA);
        }

        public TerminalNode COMMA(int i) {
            return getToken(LuaParser.COMMA, i);
        }

        public FuncArgsNormalContext(FuncargsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterFuncArgsNormal(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitFuncArgsNormal(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitFuncArgsNormal(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArgsContructorContext extends FuncargsContext {
        public ConstructorContext constructor() {
            return getRuleContext(ConstructorContext.class, 0);
        }

        public FuncArgsContructorContext(FuncargsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterFuncArgsContructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitFuncArgsContructor(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitFuncArgsContructor(this);
            else return visitor.visitChildren(this);
        }
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FuncArgsStringContext extends FuncargsContext {
        public StringContext string() {
            return getRuleContext(StringContext.class, 0);
        }

        public FuncArgsStringContext(FuncargsContext ctx) {
            copyFrom(ctx);
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterFuncArgsString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitFuncArgsString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitFuncArgsString(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FuncargsContext funcargs() throws RecognitionException {
        FuncargsContext _localctx = new FuncargsContext(_ctx, getState());
        enterRule(_localctx, 52, RULE_funcargs);
        int _la;
        try {
            setState(350);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case LPAREN:
                    _localctx = new FuncArgsNormalContext(_localctx);
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(336);
                        match(LPAREN);
                        setState(345);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (((_la) & ~0x3f) == 0 && ((1L << _la) & 35958568737833218L) != 0) {
                            {
                                setState(337);
                                expr(0);
                                setState(342);
                                _errHandler.sync(this);
                                _la = _input.LA(1);
                                while (_la == COMMA) {
                                    {
                                        {
                                            setState(338);
                                            match(COMMA);
                                            setState(339);
                                            expr(0);
                                        }
                                    }
                                    setState(344);
                                    _errHandler.sync(this);
                                    _la = _input.LA(1);
                                }
                            }
                        }

                        setState(347);
                        match(RPAREN);
                    }
                    break;
                case NORMALSTRING:
                case CHARSTRING:
                case LONGSTRING:
                    _localctx = new FuncArgsStringContext(_localctx);
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(348);
                        string();
                    }
                    break;
                case LBRACE:
                    _localctx = new FuncArgsContructorContext(_localctx);
                    enterOuterAlt(_localctx, 3);
                    {
                        setState(349);
                        constructor();
                    }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class RecfieldContext extends ParserRuleContext {
        public TerminalNode NAME() {
            return getToken(LuaParser.NAME, 0);
        }

        public TerminalNode EQUAL() {
            return getToken(LuaParser.EQUAL, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public YindexContext yindex() {
            return getRuleContext(YindexContext.class, 0);
        }

        public RecfieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_recfield;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterRecfield(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitRecfield(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitRecfield(this);
            else return visitor.visitChildren(this);
        }
    }

    public final RecfieldContext recfield() throws RecognitionException {
        RecfieldContext _localctx = new RecfieldContext(_ctx, getState());
        enterRule(_localctx, 54, RULE_recfield);
        try {
            setState(359);
            _errHandler.sync(this);
            switch (_input.LA(1)) {
                case NAME:
                    enterOuterAlt(_localctx, 1);
                    {
                        setState(352);
                        match(NAME);
                        setState(353);
                        match(EQUAL);
                        setState(354);
                        expr(0);
                    }
                    break;
                case LBRACK:
                    enterOuterAlt(_localctx, 2);
                    {
                        setState(355);
                        yindex();
                        setState(356);
                        match(EQUAL);
                        setState(357);
                        expr(0);
                    }
                    break;
                default:
                    throw new NoViableAltException(this);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ListfieldContext extends ParserRuleContext {
        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public ListfieldContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_listfield;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterListfield(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitListfield(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitListfield(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ListfieldContext listfield() throws RecognitionException {
        ListfieldContext _localctx = new ListfieldContext(_ctx, getState());
        enterRule(_localctx, 56, RULE_listfield);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(361);
                expr(0);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class ConstructorContext extends ParserRuleContext {
        public TerminalNode LBRACE() {
            return getToken(LuaParser.LBRACE, 0);
        }

        public TerminalNode RBRACE() {
            return getToken(LuaParser.RBRACE, 0);
        }

        public List<FieldsepContext> fieldsep() {
            return getRuleContexts(FieldsepContext.class);
        }

        public FieldsepContext fieldsep(int i) {
            return getRuleContext(FieldsepContext.class, i);
        }

        public List<RecfieldContext> recfield() {
            return getRuleContexts(RecfieldContext.class);
        }

        public RecfieldContext recfield(int i) {
            return getRuleContext(RecfieldContext.class, i);
        }

        public List<ListfieldContext> listfield() {
            return getRuleContexts(ListfieldContext.class);
        }

        public ListfieldContext listfield(int i) {
            return getRuleContext(ListfieldContext.class, i);
        }

        public ConstructorContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_constructor;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterConstructor(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitConstructor(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitConstructor(this);
            else return visitor.visitChildren(this);
        }
    }

    public final ConstructorContext constructor() throws RecognitionException {
        ConstructorContext _localctx = new ConstructorContext(_ctx, getState());
        enterRule(_localctx, 58, RULE_constructor);
        int _la;
        try {
            int _alt;
            enterOuterAlt(_localctx, 1);
            {
                setState(363);
                match(LBRACE);
                setState(372);
                _errHandler.sync(this);
                _alt = getInterpreter().adaptivePredict(_input, 34, _ctx);
                while (_alt != 2 && _alt != org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER) {
                    if (_alt == 1) {
                        {
                            {
                                setState(366);
                                _errHandler.sync(this);
                                switch (getInterpreter().adaptivePredict(_input, 33, _ctx)) {
                                    case 1:
                                        {
                                            setState(364);
                                            recfield();
                                        }
                                        break;
                                    case 2:
                                        {
                                            setState(365);
                                            listfield();
                                        }
                                        break;
                                }
                                setState(368);
                                fieldsep();
                            }
                        }
                    }
                    setState(374);
                    _errHandler.sync(this);
                    _alt = getInterpreter().adaptivePredict(_input, 34, _ctx);
                }
                setState(382);
                _errHandler.sync(this);
                _la = _input.LA(1);
                if (((_la) & ~0x3f) == 0 && ((1L << _la) & 35958568737833282L) != 0) {
                    {
                        setState(377);
                        _errHandler.sync(this);
                        switch (getInterpreter().adaptivePredict(_input, 35, _ctx)) {
                            case 1:
                                {
                                    setState(375);
                                    recfield();
                                }
                                break;
                            case 2:
                                {
                                    setState(376);
                                    listfield();
                                }
                                break;
                        }
                        setState(380);
                        _errHandler.sync(this);
                        _la = _input.LA(1);
                        if (_la == COMMA || _la == SEMICO) {
                            {
                                setState(379);
                                fieldsep();
                            }
                        }
                    }
                }

                setState(384);
                match(RBRACE);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class FieldsepContext extends ParserRuleContext {
        public TerminalNode COMMA() {
            return getToken(LuaParser.COMMA, 0);
        }

        public TerminalNode SEMICO() {
            return getToken(LuaParser.SEMICO, 0);
        }

        public FieldsepContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_fieldsep;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterFieldsep(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitFieldsep(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitFieldsep(this);
            else return visitor.visitChildren(this);
        }
    }

    public final FieldsepContext fieldsep() throws RecognitionException {
        FieldsepContext _localctx = new FieldsepContext(_ctx, getState());
        enterRule(_localctx, 60, RULE_fieldsep);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(386);
                _la = _input.LA(1);
                if (!(_la == COMMA || _la == SEMICO)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class YindexContext extends ParserRuleContext {
        public TerminalNode LBRACK() {
            return getToken(LuaParser.LBRACK, 0);
        }

        public ExprContext expr() {
            return getRuleContext(ExprContext.class, 0);
        }

        public TerminalNode RBRACK() {
            return getToken(LuaParser.RBRACK, 0);
        }

        public YindexContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_yindex;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterYindex(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitYindex(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitYindex(this);
            else return visitor.visitChildren(this);
        }
    }

    public final YindexContext yindex() throws RecognitionException {
        YindexContext _localctx = new YindexContext(_ctx, getState());
        enterRule(_localctx, 62, RULE_yindex);
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(388);
                match(LBRACK);
                setState(389);
                expr(0);
                setState(390);
                match(RBRACK);
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class UnopContext extends ParserRuleContext {
        public TerminalNode TK_NOT() {
            return getToken(LuaParser.TK_NOT, 0);
        }

        public TerminalNode TK_LEN() {
            return getToken(LuaParser.TK_LEN, 0);
        }

        public TerminalNode OP_SUB() {
            return getToken(LuaParser.OP_SUB, 0);
        }

        public UnopContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_unop;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterUnop(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitUnop(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitUnop(this);
            else return visitor.visitChildren(this);
        }
    }

    public final UnopContext unop() throws RecognitionException {
        UnopContext _localctx = new UnopContext(_ctx, getState());
        enterRule(_localctx, 64, RULE_unop);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(392);
                _la = _input.LA(1);
                if (!(((_la) & ~0x3f) == 0 && ((1L << _la) & 211108380016640L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class NumberContext extends ParserRuleContext {
        public TerminalNode INT() {
            return getToken(LuaParser.INT, 0);
        }

        public TerminalNode HEX() {
            return getToken(LuaParser.HEX, 0);
        }

        public TerminalNode FLOAT() {
            return getToken(LuaParser.FLOAT, 0);
        }

        public NumberContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_number;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterNumber(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitNumber(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitNumber(this);
            else return visitor.visitChildren(this);
        }
    }

    public final NumberContext number() throws RecognitionException {
        NumberContext _localctx = new NumberContext(_ctx, getState());
        enterRule(_localctx, 66, RULE_number);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(394);
                _la = _input.LA(1);
                if (!(((_la) & ~0x3f) == 0 && ((1L << _la) & 31525197391593472L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    @SuppressWarnings("CheckReturnValue")
    public static class StringContext extends ParserRuleContext {
        public TerminalNode NORMALSTRING() {
            return getToken(LuaParser.NORMALSTRING, 0);
        }

        public TerminalNode CHARSTRING() {
            return getToken(LuaParser.CHARSTRING, 0);
        }

        public TerminalNode LONGSTRING() {
            return getToken(LuaParser.LONGSTRING, 0);
        }

        public StringContext(ParserRuleContext parent, int invokingState) {
            super(parent, invokingState);
        }

        @Override
        public int getRuleIndex() {
            return RULE_string;
        }

        @Override
        public void enterRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).enterString(this);
        }

        @Override
        public void exitRule(ParseTreeListener listener) {
            if (listener instanceof LuaListener) ((LuaListener) listener).exitString(this);
        }

        @Override
        public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
            if (visitor instanceof LuaVisitor) return ((LuaVisitor<? extends T>) visitor).visitString(this);
            else return visitor.visitChildren(this);
        }
    }

    public final StringContext string() throws RecognitionException {
        StringContext _localctx = new StringContext(_ctx, getState());
        enterRule(_localctx, 68, RULE_string);
        int _la;
        try {
            enterOuterAlt(_localctx, 1);
            {
                setState(396);
                _la = _input.LA(1);
                if (!(((_la) & ~0x3f) == 0 && ((1L << _la) & 3940649673949184L) != 0)) {
                    _errHandler.recoverInline(this);
                } else {
                    if (_input.LA(1) == Token.EOF) matchedEOF = true;
                    _errHandler.reportMatch(this);
                    consume();
                }
            }
        } catch (RecognitionException re) {
            _localctx.exception = re;
            _errHandler.reportError(this, re);
            _errHandler.recover(this, re);
        } finally {
            exitRule();
        }
        return _localctx;
    }

    public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
        switch (ruleIndex) {
            case 23:
                return expr_sempred((ExprContext) _localctx, predIndex);
        }
        return true;
    }

    private boolean expr_sempred(ExprContext _localctx, int predIndex) {
        switch (predIndex) {
            case 0:
                return precpred(_ctx, 9);
            case 1:
                return precpred(_ctx, 8);
            case 2:
                return precpred(_ctx, 6);
            case 3:
                return precpred(_ctx, 5);
            case 4:
                return precpred(_ctx, 4);
            case 5:
                return precpred(_ctx, 3);
            case 6:
                return precpred(_ctx, 2);
            case 7:
                return precpred(_ctx, 1);
        }
        return true;
    }

    public static final String _serializedATN =
            "\u0004\u0001:\u018f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"
                    + "\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"
                    + "\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"
                    + "\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0002"
                    + "\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007\u000f"
                    + "\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007\u0012"
                    + "\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007\u0015"
                    + "\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007\u0018"
                    + "\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007\u001b"
                    + "\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007\u001e"
                    + "\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007\"\u0001"
                    + "\u0000\u0003\u0000H\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0001"
                    + "\u0001\u0001\u0001\u0003\u0001O\b\u0001\u0005\u0001Q\b\u0001\n\u0001\f"
                    + "\u0001T\t\u0001\u0001\u0001\u0001\u0001\u0003\u0001X\b\u0001\u0003\u0001"
                    + "Z\b\u0001\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0003"
                    + "\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003"
                    + "\u0001\u0003\u0003\u0003h\b\u0003\u0001\u0004\u0001\u0004\u0001\u0004"
                    + "\u0001\u0004\u0001\u0004\u0005\u0004o\b\u0004\n\u0004\f\u0004r\t\u0004"
                    + "\u0001\u0004\u0003\u0004u\b\u0004\u0001\u0005\u0001\u0005\u0001\u0005"
                    + "\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006"
                    + "\u0001\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005\u0006\u0084\b\u0006"
                    + "\n\u0006\f\u0006\u0087\t\u0006\u0001\u0006\u0001\u0006\u0003\u0006\u008b"
                    + "\b\u0006\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\u0007\u0001"
                    + "\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0001\b\u0001\b\u0001\b"
                    + "\u0001\t\u0001\t\u0001\t\u0001\t\u0001\n\u0001\n\u0001\n\u0001\n\u0001"
                    + "\n\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0001\u000b"
                    + "\u0001\u000b\u0001\u000b\u0003\u000b\u00ab\b\u000b\u0001\u000b\u0001\u000b"
                    + "\u0001\u000b\u0005\u000b\u00b0\b\u000b\n\u000b\f\u000b\u00b3\t\u000b\u0001"
                    + "\u000b\u0001\u000b\u0001\u000b\u0001\u000b\u0005\u000b\u00b9\b\u000b\n"
                    + "\u000b\f\u000b\u00bc\t\u000b\u0003\u000b\u00be\b\u000b\u0001\f\u0001\f"
                    + "\u0001\f\u0001\r\u0001\r\u0001\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e"
                    + "\u0001\u000e\u0001\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u00ce\b\u000e"
                    + "\n\u000e\f\u000e\u00d1\t\u000e\u0003\u000e\u00d3\b\u000e\u0001\u000f\u0001"
                    + "\u000f\u0001\u000f\u0005\u000f\u00d8\b\u000f\n\u000f\f\u000f\u00db\t\u000f"
                    + "\u0001\u0010\u0001\u0010\u0005\u0010\u00df\b\u0010\n\u0010\f\u0010\u00e2"
                    + "\t\u0010\u0001\u0010\u0003\u0010\u00e5\b\u0010\u0001\u0011\u0001\u0011"
                    + "\u0001\u0011\u0001\u0012\u0001\u0012\u0001\u0012\u0001\u0013\u0001\u0013"
                    + "\u0001\u0013\u0001\u0013\u0005\u0013\u00f1\b\u0013\n\u0013\f\u0013\u00f4"
                    + "\t\u0013\u0003\u0013\u00f6\b\u0013\u0001\u0013\u0001\u0013\u0001\u0013"
                    + "\u0001\u0013\u0001\u0014\u0001\u0014\u0001\u0015\u0001\u0015\u0001\u0015"
                    + "\u0005\u0015\u0101\b\u0015\n\u0015\f\u0015\u0104\t\u0015\u0001\u0015\u0001"
                    + "\u0015\u0001\u0015\u0001\u0015\u0005\u0015\u010a\b\u0015\n\u0015\f\u0015"
                    + "\u010d\t\u0015\u0001\u0016\u0001\u0016\u0001\u0017\u0001\u0017\u0001\u0017"
                    + "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"
                    + "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0003\u0017"
                    + "\u011f\b\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"
                    + "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"
                    + "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"
                    + "\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017\u0001\u0017"
                    + "\u0001\u0017\u0005\u0017\u0139\b\u0017\n\u0017\f\u0017\u013c\t\u0017\u0001"
                    + "\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001\u0018\u0001"
                    + "\u0018\u0005\u0018\u0145\b\u0018\n\u0018\f\u0018\u0148\t\u0018\u0001\u0019"
                    + "\u0001\u0019\u0001\u0019\u0001\u0019\u0001\u0019\u0003\u0019\u014f\b\u0019"
                    + "\u0001\u001a\u0001\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u0155\b\u001a"
                    + "\n\u001a\f\u001a\u0158\t\u001a\u0003\u001a\u015a\b\u001a\u0001\u001a\u0001"
                    + "\u001a\u0001\u001a\u0003\u001a\u015f\b\u001a\u0001\u001b\u0001\u001b\u0001"
                    + "\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0001\u001b\u0003\u001b\u0168"
                    + "\b\u001b\u0001\u001c\u0001\u001c\u0001\u001d\u0001\u001d\u0001\u001d\u0003"
                    + "\u001d\u016f\b\u001d\u0001\u001d\u0001\u001d\u0005\u001d\u0173\b\u001d"
                    + "\n\u001d\f\u001d\u0176\t\u001d\u0001\u001d\u0001\u001d\u0003\u001d\u017a"
                    + "\b\u001d\u0001\u001d\u0003\u001d\u017d\b\u001d\u0003\u001d\u017f\b\u001d"
                    + "\u0001\u001d\u0001\u001d\u0001\u001e\u0001\u001e\u0001\u001f\u0001\u001f"
                    + "\u0001\u001f\u0001\u001f\u0001 \u0001 \u0001!\u0001!\u0001\"\u0001\"\u0001"
                    + "\"\u0000\u0001.#\u0000\u0002\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014"
                    + "\u0016\u0018\u001a\u001c\u001e \"$&(*,.02468:<>@BD\u0000\t\u0002\u0000"
                    + "%%00\u0001\u0000 \"\u0001\u0000\u001e\u001f\u0001\u0000&)\u0001\u0000"
                    + "*+\u0002\u0000\u0004\u0004\n\n\u0002\u0000\u001f\u001f./\u0001\u00004"
                    + "6\u0001\u000013\u01ac\u0000G\u0001\u0000\u0000\u0000\u0002R\u0001\u0000"
                    + "\u0000\u0000\u0004[\u0001\u0000\u0000\u0000\u0006g\u0001\u0000\u0000\u0000"
                    + "\bt\u0001\u0000\u0000\u0000\nv\u0001\u0000\u0000\u0000\fz\u0001\u0000"
                    + "\u0000\u0000\u000e\u008e\u0001\u0000\u0000\u0000\u0010\u0094\u0001\u0000"
                    + "\u0000\u0000\u0012\u0099\u0001\u0000\u0000\u0000\u0014\u009d\u0001\u0000"
                    + "\u0000\u0000\u0016\u00bd\u0001\u0000\u0000\u0000\u0018\u00bf\u0001\u0000"
                    + "\u0000\u0000\u001a\u00c2\u0001\u0000\u0000\u0000\u001c\u00c7\u0001\u0000"
                    + "\u0000\u0000\u001e\u00d4\u0001\u0000\u0000\u0000 \u00dc\u0001\u0000\u0000"
                    + "\u0000\"\u00e6\u0001\u0000\u0000\u0000$\u00e9\u0001\u0000\u0000\u0000"
                    + "&\u00ec\u0001\u0000\u0000\u0000(\u00fb\u0001\u0000\u0000\u0000*\u00fd"
                    + "\u0001\u0000\u0000\u0000,\u010e\u0001\u0000\u0000\u0000.\u011e\u0001\u0000"
                    + "\u0000\u00000\u013d\u0001\u0000\u0000\u00002\u014e\u0001\u0000\u0000\u0000"
                    + "4\u015e\u0001\u0000\u0000\u00006\u0167\u0001\u0000\u0000\u00008\u0169"
                    + "\u0001\u0000\u0000\u0000:\u016b\u0001\u0000\u0000\u0000<\u0182\u0001\u0000"
                    + "\u0000\u0000>\u0184\u0001\u0000\u0000\u0000@\u0188\u0001\u0000\u0000\u0000"
                    + "B\u018a\u0001\u0000\u0000\u0000D\u018c\u0001\u0000\u0000\u0000FH\u0005"
                    + ":\u0000\u0000GF\u0001\u0000\u0000\u0000GH\u0001\u0000\u0000\u0000HI\u0001"
                    + "\u0000\u0000\u0000IJ\u0003\u0002\u0001\u0000JK\u0005\u0000\u0000\u0001"
                    + "K\u0001\u0001\u0000\u0000\u0000LN\u0003\u0006\u0003\u0000MO\u0005\n\u0000"
                    + "\u0000NM\u0001\u0000\u0000\u0000NO\u0001\u0000\u0000\u0000OQ\u0001\u0000"
                    + "\u0000\u0000PL\u0001\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001"
                    + "\u0000\u0000\u0000RS\u0001\u0000\u0000\u0000SY\u0001\u0000\u0000\u0000"
                    + "TR\u0001\u0000\u0000\u0000UW\u0003\b\u0004\u0000VX\u0005\n\u0000\u0000"
                    + "WV\u0001\u0000\u0000\u0000WX\u0001\u0000\u0000\u0000XZ\u0001\u0000\u0000"
                    + "\u0000YU\u0001\u0000\u0000\u0000YZ\u0001\u0000\u0000\u0000Z\u0003\u0001"
                    + "\u0000\u0000\u0000[\\\u0003\u0002\u0001\u0000\\\u0005\u0001\u0000\u0000"
                    + "\u0000]h\u0003\f\u0006\u0000^h\u0003\u000e\u0007\u0000_h\u0003\n\u0005"
                    + "\u0000`h\u0003\u0012\t\u0000ah\u0003\u0014\n\u0000bh\u0003\u0010\b\u0000"
                    + "ch\u0003\u001a\r\u0000dh\u0003\u001c\u000e\u0000eh\u00030\u0018\u0000"
                    + "fh\u0003*\u0015\u0000g]\u0001\u0000\u0000\u0000g^\u0001\u0000\u0000\u0000"
                    + "g_\u0001\u0000\u0000\u0000g`\u0001\u0000\u0000\u0000ga\u0001\u0000\u0000"
                    + "\u0000gb\u0001\u0000\u0000\u0000gc\u0001\u0000\u0000\u0000gd\u0001\u0000"
                    + "\u0000\u0000ge\u0001\u0000\u0000\u0000gf\u0001\u0000\u0000\u0000h\u0007"
                    + "\u0001\u0000\u0000\u0000iu\u0005\u0018\u0000\u0000jk\u0005\u0018\u0000"
                    + "\u0000kp\u0003.\u0017\u0000lm\u0005\u0004\u0000\u0000mo\u0003.\u0017\u0000"
                    + "nl\u0001\u0000\u0000\u0000or\u0001\u0000\u0000\u0000pn\u0001\u0000\u0000"
                    + "\u0000pq\u0001\u0000\u0000\u0000qu\u0001\u0000\u0000\u0000rp\u0001\u0000"
                    + "\u0000\u0000su\u0005\u0019\u0000\u0000ti\u0001\u0000\u0000\u0000tj\u0001"
                    + "\u0000\u0000\u0000ts\u0001\u0000\u0000\u0000u\t\u0001\u0000\u0000\u0000"
                    + "vw\u0005\u000b\u0000\u0000wx\u0003\u0004\u0002\u0000xy\u0005\f\u0000\u0000"
                    + "y\u000b\u0001\u0000\u0000\u0000z{\u0005\u0010\u0000\u0000{|\u0003,\u0016"
                    + "\u0000|}\u0005\u0011\u0000\u0000}\u0085\u0003\u0004\u0002\u0000~\u007f"
                    + "\u0005\u0013\u0000\u0000\u007f\u0080\u0003,\u0016\u0000\u0080\u0081\u0005"
                    + "\u0011\u0000\u0000\u0081\u0082\u0003\u0004\u0002\u0000\u0082\u0084\u0001"
                    + "\u0000\u0000\u0000\u0083~\u0001\u0000\u0000\u0000\u0084\u0087\u0001\u0000"
                    + "\u0000\u0000\u0085\u0083\u0001\u0000\u0000\u0000\u0085\u0086\u0001\u0000"
                    + "\u0000\u0000\u0086\u008a\u0001\u0000\u0000\u0000\u0087\u0085\u0001\u0000"
                    + "\u0000\u0000\u0088\u0089\u0005\u0012\u0000\u0000\u0089\u008b\u0003\u0004"
                    + "\u0002\u0000\u008a\u0088\u0001\u0000\u0000\u0000\u008a\u008b\u0001\u0000"
                    + "\u0000\u0000\u008b\u008c\u0001\u0000\u0000\u0000\u008c\u008d\u0005\f\u0000"
                    + "\u0000\u008d\r\u0001\u0000\u0000\u0000\u008e\u008f\u0005\r\u0000\u0000"
                    + "\u008f\u0090\u0003,\u0016\u0000\u0090\u0091\u0005\u000b\u0000\u0000\u0091"
                    + "\u0092\u0003\u0004\u0002\u0000\u0092\u0093\u0005\f\u0000\u0000\u0093\u000f"
                    + "\u0001\u0000\u0000\u0000\u0094\u0095\u0005\u000e\u0000\u0000\u0095\u0096"
                    + "\u0003\u0004\u0002\u0000\u0096\u0097\u0005\u000f\u0000\u0000\u0097\u0098"
                    + "\u0003,\u0016\u0000\u0098\u0011\u0001\u0000\u0000\u0000\u0099\u009a\u0005"
                    + "\u0016\u0000\u0000\u009a\u009b\u0003 \u0010\u0000\u009b\u009c\u0003&\u0013"
                    + "\u0000\u009c\u0013\u0001\u0000\u0000\u0000\u009d\u009e\u0005\u0014\u0000"
                    + "\u0000\u009e\u009f\u0003\u0016\u000b\u0000\u009f\u00a0\u0003\u0018\f\u0000"
                    + "\u00a0\u00a1\u0005\f\u0000\u0000\u00a1\u0015\u0001\u0000\u0000\u0000\u00a2"
                    + "\u00be\u0001\u0000\u0000\u0000\u00a3\u00a4\u00050\u0000\u0000\u00a4\u00a5"
                    + "\u0005\u001b\u0000\u0000\u00a5\u00a6\u0003.\u0017\u0000\u00a6\u00a7\u0005"
                    + "\u0004\u0000\u0000\u00a7\u00aa\u0003.\u0017\u0000\u00a8\u00a9\u0005\u0004"
                    + "\u0000\u0000\u00a9\u00ab\u0003.\u0017\u0000\u00aa\u00a8\u0001\u0000\u0000"
                    + "\u0000\u00aa\u00ab\u0001\u0000\u0000\u0000\u00ab\u00be\u0001\u0000\u0000"
                    + "\u0000\u00ac\u00b1\u00050\u0000\u0000\u00ad\u00ae\u0005\u0004\u0000\u0000"
                    + "\u00ae\u00b0\u00050\u0000\u0000\u00af\u00ad\u0001\u0000\u0000\u0000\u00b0"
                    + "\u00b3\u0001\u0000\u0000\u0000\u00b1\u00af\u0001\u0000\u0000\u0000\u00b1"
                    + "\u00b2\u0001\u0000\u0000\u0000\u00b2\u00b4\u0001\u0000\u0000\u0000\u00b3"
                    + "\u00b1\u0001\u0000\u0000\u0000\u00b4\u00b5\u0005\u0015\u0000\u0000\u00b5"
                    + "\u00ba\u0003.\u0017\u0000\u00b6\u00b7\u0005\u0004\u0000\u0000\u00b7\u00b9"
                    + "\u0003.\u0017\u0000\u00b8\u00b6\u0001\u0000\u0000\u0000\u00b9\u00bc\u0001"
                    + "\u0000\u0000\u0000\u00ba\u00b8\u0001\u0000\u0000\u0000\u00ba\u00bb\u0001"
                    + "\u0000\u0000\u0000\u00bb\u00be\u0001\u0000\u0000\u0000\u00bc\u00ba\u0001"
                    + "\u0000\u0000\u0000\u00bd\u00a2\u0001\u0000\u0000\u0000\u00bd\u00a3\u0001"
                    + "\u0000\u0000\u0000\u00bd\u00ac\u0001\u0000\u0000\u0000\u00be\u0017\u0001"
                    + "\u0000\u0000\u0000\u00bf\u00c0\u0005\u000b\u0000\u0000\u00c0\u00c1\u0003"
                    + "\u0004\u0002\u0000\u00c1\u0019\u0001\u0000\u0000\u0000\u00c2\u00c3\u0005"
                    + "\u0017\u0000\u0000\u00c3\u00c4\u0005\u0016\u0000\u0000\u00c4\u00c5\u0005"
                    + "0\u0000\u0000\u00c5\u00c6\u0003&\u0013\u0000\u00c6\u001b\u0001\u0000\u0000"
                    + "\u0000\u00c7\u00c8\u0005\u0017\u0000\u0000\u00c8\u00d2\u0003\u001e\u000f"
                    + "\u0000\u00c9\u00ca\u0005\u001b\u0000\u0000\u00ca\u00cf\u0003.\u0017\u0000"
                    + "\u00cb\u00cc\u0005\u0004\u0000\u0000\u00cc\u00ce\u0003.\u0017\u0000\u00cd"
                    + "\u00cb\u0001\u0000\u0000\u0000\u00ce\u00d1\u0001\u0000\u0000\u0000\u00cf"
                    + "\u00cd\u0001\u0000\u0000\u0000\u00cf\u00d0\u0001\u0000\u0000\u0000\u00d0"
                    + "\u00d3\u0001\u0000\u0000\u0000\u00d1\u00cf\u0001\u0000\u0000\u0000\u00d2"
                    + "\u00c9\u0001\u0000\u0000\u0000\u00d2\u00d3\u0001\u0000\u0000\u0000\u00d3"
                    + "\u001d\u0001\u0000\u0000\u0000\u00d4\u00d9\u00050\u0000\u0000\u00d5\u00d6"
                    + "\u0005\u0004\u0000\u0000\u00d6\u00d8\u00050\u0000\u0000\u00d7\u00d5\u0001"
                    + "\u0000\u0000\u0000\u00d8\u00db\u0001\u0000\u0000\u0000\u00d9\u00d7\u0001"
                    + "\u0000\u0000\u0000\u00d9\u00da\u0001\u0000\u0000\u0000\u00da\u001f\u0001"
                    + "\u0000\u0000\u0000\u00db\u00d9\u0001\u0000\u0000\u0000\u00dc\u00e0\u0005"
                    + "0\u0000\u0000\u00dd\u00df\u0003\"\u0011\u0000\u00de\u00dd\u0001\u0000"
                    + "\u0000\u0000\u00df\u00e2\u0001\u0000\u0000\u0000\u00e0\u00de\u0001\u0000"
                    + "\u0000\u0000\u00e0\u00e1\u0001\u0000\u0000\u0000\u00e1\u00e4\u0001\u0000"
                    + "\u0000\u0000\u00e2\u00e0\u0001\u0000\u0000\u0000\u00e3\u00e5\u0003$\u0012"
                    + "\u0000\u00e4\u00e3\u0001\u0000\u0000\u0000\u00e4\u00e5\u0001\u0000\u0000"
                    + "\u0000\u00e5!\u0001\u0000\u0000\u0000\u00e6\u00e7\u0005\u0005\u0000\u0000"
                    + "\u00e7\u00e8\u00050\u0000\u0000\u00e8#\u0001\u0000\u0000\u0000\u00e9\u00ea"
                    + "\u0005\u0003\u0000\u0000\u00ea\u00eb\u00050\u0000\u0000\u00eb%\u0001\u0000"
                    + "\u0000\u0000\u00ec\u00f5\u0005\u0001\u0000\u0000\u00ed\u00f2\u0003(\u0014"
                    + "\u0000\u00ee\u00ef\u0005\u0004\u0000\u0000\u00ef\u00f1\u0003(\u0014\u0000"
                    + "\u00f0\u00ee\u0001\u0000\u0000\u0000\u00f1\u00f4\u0001\u0000\u0000\u0000"
                    + "\u00f2\u00f0\u0001\u0000\u0000\u0000\u00f2\u00f3\u0001\u0000\u0000\u0000"
                    + "\u00f3\u00f6\u0001\u0000\u0000\u0000\u00f4\u00f2\u0001\u0000\u0000\u0000"
                    + "\u00f5\u00ed\u0001\u0000\u0000\u0000\u00f5\u00f6\u0001\u0000\u0000\u0000"
                    + "\u00f6\u00f7\u0001\u0000\u0000\u0000\u00f7\u00f8\u0005\u0002\u0000\u0000"
                    + "\u00f8\u00f9\u0003\u0002\u0001\u0000\u00f9\u00fa\u0005\f\u0000\u0000\u00fa"
                    + "\'\u0001\u0000\u0000\u0000\u00fb\u00fc\u0007\u0000\u0000\u0000\u00fc)"
                    + "\u0001\u0000\u0000\u0000\u00fd\u0102\u0003.\u0017\u0000\u00fe\u00ff\u0005"
                    + "\u0004\u0000\u0000\u00ff\u0101\u00030\u0018\u0000\u0100\u00fe\u0001\u0000"
                    + "\u0000\u0000\u0101\u0104\u0001\u0000\u0000\u0000\u0102\u0100\u0001\u0000"
                    + "\u0000\u0000\u0102\u0103\u0001\u0000\u0000\u0000\u0103\u0105\u0001\u0000"
                    + "\u0000\u0000\u0104\u0102\u0001\u0000\u0000\u0000\u0105\u0106\u0005\u001b"
                    + "\u0000\u0000\u0106\u010b\u0003.\u0017\u0000\u0107\u0108\u0005\u0004\u0000"
                    + "\u0000\u0108\u010a\u0003.\u0017\u0000\u0109\u0107\u0001\u0000\u0000\u0000"
                    + "\u010a\u010d\u0001\u0000\u0000\u0000\u010b\u0109\u0001\u0000\u0000\u0000"
                    + "\u010b\u010c\u0001\u0000\u0000\u0000\u010c+\u0001\u0000\u0000\u0000\u010d"
                    + "\u010b\u0001\u0000\u0000\u0000\u010e\u010f\u0003.\u0017\u0000\u010f-\u0001"
                    + "\u0000\u0000\u0000\u0110\u0111\u0006\u0017\uffff\uffff\u0000\u0111\u011f"
                    + "\u0003B!\u0000\u0112\u011f\u0003D\"\u0000\u0113\u011f\u0005\u001a\u0000"
                    + "\u0000\u0114\u011f\u0005\u001d\u0000\u0000\u0115\u011f\u0005\u001c\u0000"
                    + "\u0000\u0116\u011f\u0005%\u0000\u0000\u0117\u011f\u0003:\u001d\u0000\u0118"
                    + "\u0119\u0005\u0016\u0000\u0000\u0119\u011f\u0003&\u0013\u0000\u011a\u011f"
                    + "\u00030\u0018\u0000\u011b\u011c\u0003@ \u0000\u011c\u011d\u0003.\u0017"
                    + "\u0007\u011d\u011f\u0001\u0000\u0000\u0000\u011e\u0110\u0001\u0000\u0000"
                    + "\u0000\u011e\u0112\u0001\u0000\u0000\u0000\u011e\u0113\u0001\u0000\u0000"
                    + "\u0000\u011e\u0114\u0001\u0000\u0000\u0000\u011e\u0115\u0001\u0000\u0000"
                    + "\u0000\u011e\u0116\u0001\u0000\u0000\u0000\u011e\u0117\u0001\u0000\u0000"
                    + "\u0000\u011e\u0118\u0001\u0000\u0000\u0000\u011e\u011a\u0001\u0000\u0000"
                    + "\u0000\u011e\u011b\u0001\u0000\u0000\u0000\u011f\u013a\u0001\u0000\u0000"
                    + "\u0000\u0120\u0121\n\t\u0000\u0000\u0121\u0122\u0005#\u0000\u0000\u0122"
                    + "\u0139\u0003.\u0017\t\u0123\u0124\n\b\u0000\u0000\u0124\u0125\u0005$\u0000"
                    + "\u0000\u0125\u0139\u0003.\u0017\b\u0126\u0127\n\u0006\u0000\u0000\u0127"
                    + "\u0128\u0007\u0001\u0000\u0000\u0128\u0139\u0003.\u0017\u0007\u0129\u012a"
                    + "\n\u0005\u0000\u0000\u012a\u012b\u0007\u0002\u0000\u0000\u012b\u0139\u0003"
                    + ".\u0017\u0006\u012c\u012d\n\u0004\u0000\u0000\u012d\u012e\u0007\u0003"
                    + "\u0000\u0000\u012e\u0139\u0003.\u0017\u0005\u012f\u0130\n\u0003\u0000"
                    + "\u0000\u0130\u0131\u0007\u0004\u0000\u0000\u0131\u0139\u0003.\u0017\u0004"
                    + "\u0132\u0133\n\u0002\u0000\u0000\u0133\u0134\u0005,\u0000\u0000\u0134"
                    + "\u0139\u0003.\u0017\u0003\u0135\u0136\n\u0001\u0000\u0000\u0136\u0137"
                    + "\u0005-\u0000\u0000\u0137\u0139\u0003.\u0017\u0002\u0138\u0120\u0001\u0000"
                    + "\u0000\u0000\u0138\u0123\u0001\u0000\u0000\u0000\u0138\u0126\u0001\u0000"
                    + "\u0000\u0000\u0138\u0129\u0001\u0000\u0000\u0000\u0138\u012c\u0001\u0000"
                    + "\u0000\u0000\u0138\u012f\u0001\u0000\u0000\u0000\u0138\u0132\u0001\u0000"
                    + "\u0000\u0000\u0138\u0135\u0001\u0000\u0000\u0000\u0139\u013c\u0001\u0000"
                    + "\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a\u013b\u0001\u0000"
                    + "\u0000\u0000\u013b/\u0001\u0000\u0000\u0000\u013c\u013a\u0001\u0000\u0000"
                    + "\u0000\u013d\u0146\u00032\u0019\u0000\u013e\u0145\u0003\"\u0011\u0000"
                    + "\u013f\u0145\u0003>\u001f\u0000\u0140\u0141\u0005\u0003\u0000\u0000\u0141"
                    + "\u0142\u00050\u0000\u0000\u0142\u0145\u00034\u001a\u0000\u0143\u0145\u0003"
                    + "4\u001a\u0000\u0144\u013e\u0001\u0000\u0000\u0000\u0144\u013f\u0001\u0000"
                    + "\u0000\u0000\u0144\u0140\u0001\u0000\u0000\u0000\u0144\u0143\u0001\u0000"
                    + "\u0000\u0000\u0145\u0148\u0001\u0000\u0000\u0000\u0146\u0144\u0001\u0000"
                    + "\u0000\u0000\u0146\u0147\u0001\u0000\u0000\u0000\u01471\u0001\u0000\u0000"
                    + "\u0000\u0148\u0146\u0001\u0000\u0000\u0000\u0149\u014f\u00050\u0000\u0000"
                    + "\u014a\u014b\u0005\u0001\u0000\u0000\u014b\u014c\u0003.\u0017\u0000\u014c"
                    + "\u014d\u0005\u0002\u0000\u0000\u014d\u014f\u0001\u0000\u0000\u0000\u014e"
                    + "\u0149\u0001\u0000\u0000\u0000\u014e\u014a\u0001\u0000\u0000\u0000\u014f"
                    + "3\u0001\u0000\u0000\u0000\u0150\u0159\u0005\u0001\u0000\u0000\u0151\u0156"
                    + "\u0003.\u0017\u0000\u0152\u0153\u0005\u0004\u0000\u0000\u0153\u0155\u0003"
                    + ".\u0017\u0000\u0154\u0152\u0001\u0000\u0000\u0000\u0155\u0158\u0001\u0000"
                    + "\u0000\u0000\u0156\u0154\u0001\u0000\u0000\u0000\u0156\u0157\u0001\u0000"
                    + "\u0000\u0000\u0157\u015a\u0001\u0000\u0000\u0000\u0158\u0156\u0001\u0000"
                    + "\u0000\u0000\u0159\u0151\u0001\u0000\u0000\u0000\u0159\u015a\u0001\u0000"
                    + "\u0000\u0000\u015a\u015b\u0001\u0000\u0000\u0000\u015b\u015f\u0005\u0002"
                    + "\u0000\u0000\u015c\u015f\u0003D\"\u0000\u015d\u015f\u0003:\u001d\u0000"
                    + "\u015e\u0150\u0001\u0000\u0000\u0000\u015e\u015c\u0001\u0000\u0000\u0000"
                    + "\u015e\u015d\u0001\u0000\u0000\u0000\u015f5\u0001\u0000\u0000\u0000\u0160"
                    + "\u0161\u00050\u0000\u0000\u0161\u0162\u0005\u001b\u0000\u0000\u0162\u0168"
                    + "\u0003.\u0017\u0000\u0163\u0164\u0003>\u001f\u0000\u0164\u0165\u0005\u001b"
                    + "\u0000\u0000\u0165\u0166\u0003.\u0017\u0000\u0166\u0168\u0001\u0000\u0000"
                    + "\u0000\u0167\u0160\u0001\u0000\u0000\u0000\u0167\u0163\u0001\u0000\u0000"
                    + "\u0000\u01687\u0001\u0000\u0000\u0000\u0169\u016a\u0003.\u0017\u0000\u016a"
                    + "9\u0001\u0000\u0000\u0000\u016b\u0174\u0005\b\u0000\u0000\u016c\u016f"
                    + "\u00036\u001b\u0000\u016d\u016f\u00038\u001c\u0000\u016e\u016c\u0001\u0000"
                    + "\u0000\u0000\u016e\u016d\u0001\u0000\u0000\u0000\u016f\u0170\u0001\u0000"
                    + "\u0000\u0000\u0170\u0171\u0003<\u001e\u0000\u0171\u0173\u0001\u0000\u0000"
                    + "\u0000\u0172\u016e\u0001\u0000\u0000\u0000\u0173\u0176\u0001\u0000\u0000"
                    + "\u0000\u0174\u0172\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000"
                    + "\u0000\u0175\u017e\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000"
                    + "\u0000\u0177\u017a\u00036\u001b\u0000\u0178\u017a\u00038\u001c\u0000\u0179"
                    + "\u0177\u0001\u0000\u0000\u0000\u0179\u0178\u0001\u0000\u0000\u0000\u017a"
                    + "\u017c\u0001\u0000\u0000\u0000\u017b\u017d\u0003<\u001e\u0000\u017c\u017b"
                    + "\u0001\u0000\u0000\u0000\u017c\u017d\u0001\u0000\u0000\u0000\u017d\u017f"
                    + "\u0001\u0000\u0000\u0000\u017e\u0179\u0001\u0000\u0000\u0000\u017e\u017f"
                    + "\u0001\u0000\u0000\u0000\u017f\u0180\u0001\u0000\u0000\u0000\u0180\u0181"
                    + "\u0005\t\u0000\u0000\u0181;\u0001\u0000\u0000\u0000\u0182\u0183\u0007"
                    + "\u0005\u0000\u0000\u0183=\u0001\u0000\u0000\u0000\u0184\u0185\u0005\u0006"
                    + "\u0000\u0000\u0185\u0186\u0003.\u0017\u0000\u0186\u0187\u0005\u0007\u0000"
                    + "\u0000\u0187?\u0001\u0000\u0000\u0000\u0188\u0189\u0007\u0006\u0000\u0000"
                    + "\u0189A\u0001\u0000\u0000\u0000\u018a\u018b\u0007\u0007\u0000\u0000\u018b"
                    + "C\u0001\u0000\u0000\u0000\u018c\u018d\u0007\b\u0000\u0000\u018dE\u0001"
                    + "\u0000\u0000\u0000&GNRWYgpt\u0085\u008a\u00aa\u00b1\u00ba\u00bd\u00cf"
                    + "\u00d2\u00d9\u00e0\u00e4\u00f2\u00f5\u0102\u010b\u011e\u0138\u013a\u0144"
                    + "\u0146\u014e\u0156\u0159\u015e\u0167\u016e\u0174\u0179\u017c\u017e";
    public static final ATN _ATN = new ATNDeserializer().deserialize(_serializedATN.toCharArray());

    static {
        _decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
        for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
            _decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
        }
    }
}
