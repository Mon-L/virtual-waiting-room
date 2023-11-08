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

import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link LuaParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface LuaVisitor<T> extends ParseTreeVisitor<T> {
    /**
     * Visit a parse tree produced by {@link LuaParser#file}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFile(LuaParser.FileContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#chunk}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitChunk(LuaParser.ChunkContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#block}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlock(LuaParser.BlockContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#stat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitStat(LuaParser.StatContext ctx);
    /**
     * Visit a parse tree produced by the {@code PlainReturn}
     * labeled alternative in {@link LuaParser#laststat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPlainReturn(LuaParser.PlainReturnContext ctx);
    /**
     * Visit a parse tree produced by the {@code Return}
     * labeled alternative in {@link LuaParser#laststat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitReturn(LuaParser.ReturnContext ctx);
    /**
     * Visit a parse tree produced by the {@code Break}
     * labeled alternative in {@link LuaParser#laststat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBreak(LuaParser.BreakContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#blockstat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitBlockstat(LuaParser.BlockstatContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#ifstat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitIfstat(LuaParser.IfstatContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#whilestat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitWhilestat(LuaParser.WhilestatContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#repeatstat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRepeatstat(LuaParser.RepeatstatContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#functionstat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionstat(LuaParser.FunctionstatContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#forstat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForstat(LuaParser.ForstatContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#foriterdef}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForiterdef(LuaParser.ForiterdefContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#forbody}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitForbody(LuaParser.ForbodyContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#localfunctionstat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLocalfunctionstat(LuaParser.LocalfunctionstatContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#localstat}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitLocalstat(LuaParser.LocalstatContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#namelist}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNamelist(LuaParser.NamelistContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#functionname}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFunctionname(LuaParser.FunctionnameContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#dotfield}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitDotfield(LuaParser.DotfieldContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#colonfield}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitColonfield(LuaParser.ColonfieldContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#funcbody}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFuncbody(LuaParser.FuncbodyContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#param}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitParam(LuaParser.ParamContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#assignexpr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitAssignexpr(LuaParser.AssignexprContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#cond}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitCond(LuaParser.CondContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprMulDivMod}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprMulDivMod(LuaParser.ExprMulDivModContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprConcat}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprConcat(LuaParser.ExprConcatContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprString}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprString(LuaParser.ExprStringContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprFalse}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprFalse(LuaParser.ExprFalseContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprTrue}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprTrue(LuaParser.ExprTrueContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprLogicOr}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprLogicOr(LuaParser.ExprLogicOrContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprNil}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprNil(LuaParser.ExprNilContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprRelation}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprRelation(LuaParser.ExprRelationContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprPrimary}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprPrimary(LuaParser.ExprPrimaryContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprAddSub}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprAddSub(LuaParser.ExprAddSubContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprPow}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprPow(LuaParser.ExprPowContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprTable}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprTable(LuaParser.ExprTableContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprUnary}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprUnary(LuaParser.ExprUnaryContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprLogicAnd}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprLogicAnd(LuaParser.ExprLogicAndContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprNumber}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprNumber(LuaParser.ExprNumberContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprAnonymousFunction}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprAnonymousFunction(LuaParser.ExprAnonymousFunctionContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprDots}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprDots(LuaParser.ExprDotsContext ctx);
    /**
     * Visit a parse tree produced by the {@code ExprEquality}
     * labeled alternative in {@link LuaParser#expr}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitExprEquality(LuaParser.ExprEqualityContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#primaryexp}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPrimaryexp(LuaParser.PrimaryexpContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#prefixexp}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitPrefixexp(LuaParser.PrefixexpContext ctx);
    /**
     * Visit a parse tree produced by the {@code FuncArgsNormal}
     * labeled alternative in {@link LuaParser#funcargs}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFuncArgsNormal(LuaParser.FuncArgsNormalContext ctx);
    /**
     * Visit a parse tree produced by the {@code FuncArgsString}
     * labeled alternative in {@link LuaParser#funcargs}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFuncArgsString(LuaParser.FuncArgsStringContext ctx);
    /**
     * Visit a parse tree produced by the {@code FuncArgsContructor}
     * labeled alternative in {@link LuaParser#funcargs}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFuncArgsContructor(LuaParser.FuncArgsContructorContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#recfield}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitRecfield(LuaParser.RecfieldContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#listfield}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitListfield(LuaParser.ListfieldContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#constructor}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitConstructor(LuaParser.ConstructorContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#fieldsep}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitFieldsep(LuaParser.FieldsepContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#yindex}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitYindex(LuaParser.YindexContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#unop}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitUnop(LuaParser.UnopContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#number}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitNumber(LuaParser.NumberContext ctx);
    /**
     * Visit a parse tree produced by {@link LuaParser#string}.
     * @param ctx the parse tree
     * @return the visitor result
     */
    T visitString(LuaParser.StringContext ctx);
}
