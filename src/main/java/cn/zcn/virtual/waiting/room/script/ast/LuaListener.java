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

import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link LuaParser}.
 */
public interface LuaListener extends ParseTreeListener {
    /**
     * Enter a parse tree produced by {@link LuaParser#file}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterFile(LuaParser.FileContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#file}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitFile(LuaParser.FileContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#chunk}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterChunk(LuaParser.ChunkContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#chunk}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitChunk(LuaParser.ChunkContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#block}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterBlock(LuaParser.BlockContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#block}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitBlock(LuaParser.BlockContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#stat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterStat(LuaParser.StatContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#stat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitStat(LuaParser.StatContext ctx);
    /**
     * Enter a parse tree produced by the {@code PlainReturn} labeled
     * alternative in {@link LuaParser#laststat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterPlainReturn(LuaParser.PlainReturnContext ctx);
    /**
     * Exit a parse tree produced by the {@code PlainReturn} labeled alternative
     * in {@link LuaParser#laststat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitPlainReturn(LuaParser.PlainReturnContext ctx);
    /**
     * Enter a parse tree produced by the {@code Return} labeled alternative in
     * {@link LuaParser#laststat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterReturn(LuaParser.ReturnContext ctx);
    /**
     * Exit a parse tree produced by the {@code Return} labeled alternative in
     * {@link LuaParser#laststat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitReturn(LuaParser.ReturnContext ctx);
    /**
     * Enter a parse tree produced by the {@code Break} labeled alternative in
     * {@link LuaParser#laststat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterBreak(LuaParser.BreakContext ctx);
    /**
     * Exit a parse tree produced by the {@code Break} labeled alternative in
     * {@link LuaParser#laststat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitBreak(LuaParser.BreakContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#blockstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterBlockstat(LuaParser.BlockstatContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#blockstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitBlockstat(LuaParser.BlockstatContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#ifstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterIfstat(LuaParser.IfstatContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#ifstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitIfstat(LuaParser.IfstatContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#whilestat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterWhilestat(LuaParser.WhilestatContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#whilestat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitWhilestat(LuaParser.WhilestatContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#repeatstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterRepeatstat(LuaParser.RepeatstatContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#repeatstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitRepeatstat(LuaParser.RepeatstatContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#functionstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterFunctionstat(LuaParser.FunctionstatContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#functionstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitFunctionstat(LuaParser.FunctionstatContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#forstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterForstat(LuaParser.ForstatContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#forstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitForstat(LuaParser.ForstatContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#foriterdef}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterForiterdef(LuaParser.ForiterdefContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#foriterdef}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitForiterdef(LuaParser.ForiterdefContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#forbody}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterForbody(LuaParser.ForbodyContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#forbody}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitForbody(LuaParser.ForbodyContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#localfunctionstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterLocalfunctionstat(LuaParser.LocalfunctionstatContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#localfunctionstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitLocalfunctionstat(LuaParser.LocalfunctionstatContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#localstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterLocalstat(LuaParser.LocalstatContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#localstat}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitLocalstat(LuaParser.LocalstatContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#namelist}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterNamelist(LuaParser.NamelistContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#namelist}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitNamelist(LuaParser.NamelistContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#functionname}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterFunctionname(LuaParser.FunctionnameContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#functionname}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitFunctionname(LuaParser.FunctionnameContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#dotfield}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterDotfield(LuaParser.DotfieldContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#dotfield}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitDotfield(LuaParser.DotfieldContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#colonfield}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterColonfield(LuaParser.ColonfieldContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#colonfield}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitColonfield(LuaParser.ColonfieldContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#funcbody}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterFuncbody(LuaParser.FuncbodyContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#funcbody}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitFuncbody(LuaParser.FuncbodyContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#param}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterParam(LuaParser.ParamContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#param}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitParam(LuaParser.ParamContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#assignexpr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterAssignexpr(LuaParser.AssignexprContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#assignexpr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitAssignexpr(LuaParser.AssignexprContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#cond}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterCond(LuaParser.CondContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#cond}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitCond(LuaParser.CondContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprMulDivMod} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprMulDivMod(LuaParser.ExprMulDivModContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprMulDivMod} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprMulDivMod(LuaParser.ExprMulDivModContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprConcat} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprConcat(LuaParser.ExprConcatContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprConcat} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprConcat(LuaParser.ExprConcatContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprString} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprString(LuaParser.ExprStringContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprString} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprString(LuaParser.ExprStringContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprFalse} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprFalse(LuaParser.ExprFalseContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprFalse} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprFalse(LuaParser.ExprFalseContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprTrue} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprTrue(LuaParser.ExprTrueContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprTrue} labeled alternative in
     * {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprTrue(LuaParser.ExprTrueContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprLogicOr} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprLogicOr(LuaParser.ExprLogicOrContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprLogicOr} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprLogicOr(LuaParser.ExprLogicOrContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprNil} labeled alternative in
     * {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprNil(LuaParser.ExprNilContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprNil} labeled alternative in
     * {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprNil(LuaParser.ExprNilContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprRelation} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprRelation(LuaParser.ExprRelationContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprRelation} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprRelation(LuaParser.ExprRelationContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprPrimary} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprPrimary(LuaParser.ExprPrimaryContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprPrimary} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprPrimary(LuaParser.ExprPrimaryContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprAddSub} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprAddSub(LuaParser.ExprAddSubContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprAddSub} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprAddSub(LuaParser.ExprAddSubContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprPow} labeled alternative in
     * {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprPow(LuaParser.ExprPowContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprPow} labeled alternative in
     * {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprPow(LuaParser.ExprPowContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprTable} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprTable(LuaParser.ExprTableContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprTable} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprTable(LuaParser.ExprTableContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprUnary} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprUnary(LuaParser.ExprUnaryContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprUnary} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprUnary(LuaParser.ExprUnaryContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprLogicAnd} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprLogicAnd(LuaParser.ExprLogicAndContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprLogicAnd} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprLogicAnd(LuaParser.ExprLogicAndContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprNumber} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprNumber(LuaParser.ExprNumberContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprNumber} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprNumber(LuaParser.ExprNumberContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprAnonymousFunction} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprAnonymousFunction(LuaParser.ExprAnonymousFunctionContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprAnonymousFunction} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprAnonymousFunction(LuaParser.ExprAnonymousFunctionContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprDots} labeled alternative
     * in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprDots(LuaParser.ExprDotsContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprDots} labeled alternative in
     * {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprDots(LuaParser.ExprDotsContext ctx);
    /**
     * Enter a parse tree produced by the {@code ExprEquality} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterExprEquality(LuaParser.ExprEqualityContext ctx);
    /**
     * Exit a parse tree produced by the {@code ExprEquality} labeled
     * alternative in {@link LuaParser#expr}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitExprEquality(LuaParser.ExprEqualityContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#primaryexp}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterPrimaryexp(LuaParser.PrimaryexpContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#primaryexp}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitPrimaryexp(LuaParser.PrimaryexpContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#prefixexp}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterPrefixexp(LuaParser.PrefixexpContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#prefixexp}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitPrefixexp(LuaParser.PrefixexpContext ctx);
    /**
     * Enter a parse tree produced by the {@code FuncArgsNormal} labeled
     * alternative in {@link LuaParser#funcargs}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterFuncArgsNormal(LuaParser.FuncArgsNormalContext ctx);
    /**
     * Exit a parse tree produced by the {@code FuncArgsNormal} labeled
     * alternative in {@link LuaParser#funcargs}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitFuncArgsNormal(LuaParser.FuncArgsNormalContext ctx);
    /**
     * Enter a parse tree produced by the {@code FuncArgsString} labeled
     * alternative in {@link LuaParser#funcargs}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterFuncArgsString(LuaParser.FuncArgsStringContext ctx);
    /**
     * Exit a parse tree produced by the {@code FuncArgsString} labeled
     * alternative in {@link LuaParser#funcargs}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitFuncArgsString(LuaParser.FuncArgsStringContext ctx);
    /**
     * Enter a parse tree produced by the {@code FuncArgsContructor} labeled
     * alternative in {@link LuaParser#funcargs}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterFuncArgsContructor(LuaParser.FuncArgsContructorContext ctx);
    /**
     * Exit a parse tree produced by the {@code FuncArgsContructor} labeled
     * alternative in {@link LuaParser#funcargs}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitFuncArgsContructor(LuaParser.FuncArgsContructorContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#recfield}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterRecfield(LuaParser.RecfieldContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#recfield}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitRecfield(LuaParser.RecfieldContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#listfield}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterListfield(LuaParser.ListfieldContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#listfield}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitListfield(LuaParser.ListfieldContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#constructor}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterConstructor(LuaParser.ConstructorContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#constructor}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitConstructor(LuaParser.ConstructorContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#fieldsep}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterFieldsep(LuaParser.FieldsepContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#fieldsep}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitFieldsep(LuaParser.FieldsepContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#yindex}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterYindex(LuaParser.YindexContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#yindex}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitYindex(LuaParser.YindexContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#unop}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterUnop(LuaParser.UnopContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#unop}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitUnop(LuaParser.UnopContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#number}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterNumber(LuaParser.NumberContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#number}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitNumber(LuaParser.NumberContext ctx);
    /**
     * Enter a parse tree produced by {@link LuaParser#string}.
     *
     * @param ctx
     *            the parse tree
     */
    void enterString(LuaParser.StringContext ctx);
    /**
     * Exit a parse tree produced by {@link LuaParser#string}.
     *
     * @param ctx
     *            the parse tree
     */
    void exitString(LuaParser.StringContext ctx);
}
