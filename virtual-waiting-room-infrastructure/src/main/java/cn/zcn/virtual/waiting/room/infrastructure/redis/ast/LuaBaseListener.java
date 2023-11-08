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

package cn.zcn.virtual.waiting.room.infrastructure.redis.ast;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;

/**
 * This class provides an empty implementation of {@link LuaListener},
 * which can be extended to create a listener which only needs to handle a subset
 * of the available methods.
 */
@SuppressWarnings("CheckReturnValue")
public class LuaBaseListener implements LuaListener {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFile(LuaParser.FileContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFile(LuaParser.FileContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterChunk(LuaParser.ChunkContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitChunk(LuaParser.ChunkContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBlock(LuaParser.BlockContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBlock(LuaParser.BlockContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterStat(LuaParser.StatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitStat(LuaParser.StatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPlainReturn(LuaParser.PlainReturnContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPlainReturn(LuaParser.PlainReturnContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterReturn(LuaParser.ReturnContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitReturn(LuaParser.ReturnContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBreak(LuaParser.BreakContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBreak(LuaParser.BreakContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterBlockstat(LuaParser.BlockstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitBlockstat(LuaParser.BlockstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterIfstat(LuaParser.IfstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitIfstat(LuaParser.IfstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterWhilestat(LuaParser.WhilestatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitWhilestat(LuaParser.WhilestatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterRepeatstat(LuaParser.RepeatstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitRepeatstat(LuaParser.RepeatstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFunctionstat(LuaParser.FunctionstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFunctionstat(LuaParser.FunctionstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForstat(LuaParser.ForstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForstat(LuaParser.ForstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForiterdef(LuaParser.ForiterdefContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForiterdef(LuaParser.ForiterdefContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterForbody(LuaParser.ForbodyContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitForbody(LuaParser.ForbodyContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLocalfunctionstat(LuaParser.LocalfunctionstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLocalfunctionstat(LuaParser.LocalfunctionstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterLocalstat(LuaParser.LocalstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitLocalstat(LuaParser.LocalstatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNamelist(LuaParser.NamelistContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNamelist(LuaParser.NamelistContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFunctionname(LuaParser.FunctionnameContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFunctionname(LuaParser.FunctionnameContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterDotfield(LuaParser.DotfieldContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitDotfield(LuaParser.DotfieldContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterColonfield(LuaParser.ColonfieldContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitColonfield(LuaParser.ColonfieldContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFuncbody(LuaParser.FuncbodyContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFuncbody(LuaParser.FuncbodyContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterParam(LuaParser.ParamContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitParam(LuaParser.ParamContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterAssignexpr(LuaParser.AssignexprContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitAssignexpr(LuaParser.AssignexprContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterCond(LuaParser.CondContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitCond(LuaParser.CondContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprMulDivMod(LuaParser.ExprMulDivModContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprMulDivMod(LuaParser.ExprMulDivModContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprConcat(LuaParser.ExprConcatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprConcat(LuaParser.ExprConcatContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprString(LuaParser.ExprStringContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprString(LuaParser.ExprStringContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprFalse(LuaParser.ExprFalseContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprFalse(LuaParser.ExprFalseContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprTrue(LuaParser.ExprTrueContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprTrue(LuaParser.ExprTrueContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprLogicOr(LuaParser.ExprLogicOrContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprLogicOr(LuaParser.ExprLogicOrContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprNil(LuaParser.ExprNilContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprNil(LuaParser.ExprNilContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprRelation(LuaParser.ExprRelationContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprRelation(LuaParser.ExprRelationContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprPrimary(LuaParser.ExprPrimaryContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprPrimary(LuaParser.ExprPrimaryContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprAddSub(LuaParser.ExprAddSubContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprAddSub(LuaParser.ExprAddSubContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprPow(LuaParser.ExprPowContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprPow(LuaParser.ExprPowContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprTable(LuaParser.ExprTableContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprTable(LuaParser.ExprTableContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprUnary(LuaParser.ExprUnaryContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprUnary(LuaParser.ExprUnaryContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprLogicAnd(LuaParser.ExprLogicAndContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprLogicAnd(LuaParser.ExprLogicAndContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprNumber(LuaParser.ExprNumberContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprNumber(LuaParser.ExprNumberContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprAnonymousFunction(LuaParser.ExprAnonymousFunctionContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprAnonymousFunction(LuaParser.ExprAnonymousFunctionContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprDots(LuaParser.ExprDotsContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprDots(LuaParser.ExprDotsContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterExprEquality(LuaParser.ExprEqualityContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitExprEquality(LuaParser.ExprEqualityContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPrimaryexp(LuaParser.PrimaryexpContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPrimaryexp(LuaParser.PrimaryexpContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterPrefixexp(LuaParser.PrefixexpContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitPrefixexp(LuaParser.PrefixexpContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFuncArgsNormal(LuaParser.FuncArgsNormalContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFuncArgsNormal(LuaParser.FuncArgsNormalContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFuncArgsString(LuaParser.FuncArgsStringContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFuncArgsString(LuaParser.FuncArgsStringContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFuncArgsContructor(LuaParser.FuncArgsContructorContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFuncArgsContructor(LuaParser.FuncArgsContructorContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterRecfield(LuaParser.RecfieldContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitRecfield(LuaParser.RecfieldContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterListfield(LuaParser.ListfieldContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitListfield(LuaParser.ListfieldContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterConstructor(LuaParser.ConstructorContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitConstructor(LuaParser.ConstructorContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterFieldsep(LuaParser.FieldsepContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitFieldsep(LuaParser.FieldsepContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterYindex(LuaParser.YindexContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitYindex(LuaParser.YindexContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterUnop(LuaParser.UnopContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitUnop(LuaParser.UnopContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterNumber(LuaParser.NumberContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitNumber(LuaParser.NumberContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterString(LuaParser.StringContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitString(LuaParser.StringContext ctx) {}

    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void enterEveryRule(ParserRuleContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void exitEveryRule(ParserRuleContext ctx) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitTerminal(TerminalNode node) {}
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation does nothing.</p>
     */
    @Override
    public void visitErrorNode(ErrorNode node) {}
}
