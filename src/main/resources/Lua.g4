/*
BSD License

Copyright (c) 2016, CaiDa
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions
are met:

1. Redistributions of source code must retain the above copyright
   notice, this list of conditions and the following disclaimer.
2. Redistributions in binary form must reproduce the above copyright
   notice, this list of conditions and the following disclaimer in the
   documentation and/or other materials provided with the distribution.
3. The name of its author may be used to endorse or promote products
   derived from this software without specific prior written permission.


THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS
"AS IS" AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT
LIMITED TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR
A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL THE COPYRIGHT
HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE
OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.

This grammar file derived from:
    Lua 5.1 Source Code
    https://www.lua.org/versions.html#5.1

    Lua 5.3 grammar written by Kazunori Sakamoto and Alexander Alexeev
    https://github.com/antlr/grammars-v4/blob/master/lua/Lua.g4
*/


grammar Lua;

@header{
package cn.zcn.virtual.waiting.room.script.ast;
}

@lexer::members {
    public static final int SHORT_COMMENT_CHANNEL = 1;
    public static final int LONG_COMMENT_CHANNEL = 2;
}

// Program
file: SHEBANG? chunk EOF;

chunk
    : (stat (SEMICO)?)* (laststat (SEMICO)?)?
    ;

block
    : chunk
    ;

stat
    : ifstat
    | whilestat
    | blockstat
    | functionstat
    | forstat
    | repeatstat
    | localfunctionstat
    | localstat
    | primaryexp
    | assignexpr
    ;

laststat
    : TK_RETURN # PlainReturn
    | TK_RETURN expr (COMMA expr)* # Return
    | TK_BREAK  # Break
    ;

blockstat
    : TK_DO block TK_END
    ;

ifstat
    : TK_IF cond TK_THEN block (TK_ELSEIF cond TK_THEN block)* (TK_ELSE block)? TK_END
    ;

whilestat
    : TK_WHILE cond TK_DO block TK_END
    ;

repeatstat
    : TK_REPEAT block TK_UNTIL cond
    ;

// Function
functionstat
    : TK_FUNCTION functionname funcbody
    ;

// For
forstat
    : TK_FOR foriterdef forbody TK_END
    ;

foriterdef
    :
    | NAME EQUAL expr COMMA expr (COMMA expr)?
    | NAME (COMMA NAME)* TK_IN  expr (COMMA expr)*
    ;

forbody
    : TK_DO block
    ;

// Local
localfunctionstat
    : TK_LOCAL TK_FUNCTION NAME funcbody
    ;

localstat
    : TK_LOCAL namelist (EQUAL expr (COMMA expr)* )?
    ;

namelist
    : NAME (COMMA NAME)*
    ;

functionname
    : NAME (dotfield)* colonfield?
    ;

dotfield
    : DOT NAME
    ;

colonfield
    : COLON NAME
    ;

funcbody
    : LPAREN (param (COMMA param)* )? RPAREN chunk TK_END
    ;

param
    : NAME
    | DOTS
    ;

assignexpr
    : expr (COMMA primaryexp)* EQUAL expr (COMMA expr)*
    ;

// Expression
cond
    : expr
    ;

expr
    : number # ExprNumber
    | string # ExprString
    | TK_NIL # ExprNil
    | FALSE  # ExprFalse
    | TRUE   # ExprTrue
    | DOTS   # ExprDots
    | constructor # ExprTable
    | TK_FUNCTION funcbody # ExprAnonymousFunction
    | primaryexp # ExprPrimary
    | <assoc=right> expr OP_POW expr # ExprPow
    | <assoc=right> expr OP_CONCAT expr # ExprConcat
    | unop expr # ExprUnary
    | expr op=(OP_MUL | OP_DIV | OP_MOD) expr # ExprMulDivMod
    | expr op=(OP_ADD | OP_SUB ) expr # ExprAddSub
    | expr op=(TK_LT | TK_LE |TK_GT | TK_GE) expr # ExprRelation
    | expr op=(TK_EQ | TK_NEQ) expr # ExprEquality
    | expr TK_AND expr  # ExprLogicAnd
    | expr TK_OR expr   # ExprLogicOr
    ;

primaryexp
    : prefixexp (dotfield|yindex|COLON NAME funcargs|funcargs)*
    ;

prefixexp
    : NAME
    | LPAREN expr RPAREN
    ;

funcargs
    : LPAREN (expr (COMMA expr)*)? RPAREN # FuncArgsNormal
    | string  # FuncArgsString
    | constructor # FuncArgsContructor
    ;
// ConsControl
recfield
    : NAME EQUAL expr
    | yindex EQUAL expr
    ;

listfield
    : expr
    ;

constructor
    : LBRACE ((recfield|listfield) fieldsep)* ((recfield|listfield) fieldsep?)? RBRACE
    ;

fieldsep
    : COMMA
    | SEMICO
    ;

// Other Field
yindex
    : LBRACK expr RBRACK
    ;

unop
    : TK_NOT
    | TK_LEN
    | OP_SUB
    ;

number
    : INT | HEX | FLOAT // HEX_FLOAT // TODO lua5.2
    ;

string
    : NORMALSTRING | CHARSTRING | LONGSTRING
    ;

////////////// LEXER ////////////////////////
LPAREN : '(' ;
RPAREN : ')' ;
COLON  : ':' ;
COMMA  : ',' ;
DOT    : '.' ;
LBRACK : '[' ;
RBRACK : ']' ;
LBRACE : '{' ;
RBRACE : '}' ;
SEMICO : ';' ;
// KEYWORD
TK_DO     : 'do' ;
TK_END    : 'end' ;
TK_WHILE  : 'while' ;
TK_REPEAT : 'repeat' ;
TK_UNTIL  : 'until' ;
TK_IF     : 'if' ;
TK_THEN   : 'then' ;
TK_ELSE   : 'else' ;
TK_ELSEIF : 'elseif' ;
TK_FOR    : 'for' ;
TK_IN     : 'in';
TK_FUNCTION : 'function' ;
TK_LOCAL  : 'local' ;
TK_RETURN : 'return' ;
TK_BREAK  : 'break' ;
TK_NIL    : 'nil' ;
EQUAL  : '=' ;
TRUE   : 'true' ;
FALSE  : 'false' ;
// BINOP
OP_ADD : '+' ;
OP_SUB : '-' ;
OP_MUL : '*' ;
OP_DIV : '/' ;
//   IDIV: '//' ;     // TODO lua5.3
OP_MOD : '%' ;
OP_POW : '^' ;
OP_CONCAT : '..' ;
DOTS   : '...' ;
TK_LT : '<' ;
TK_LE : '<=' ;
TK_GT : '>' ;
TK_GE : '>=' ;
TK_EQ : '==' ;
TK_NEQ : '~=' ;
TK_AND : 'and' ;
TK_OR  : 'or' ;
TK_NOT  : 'not' ;
TK_LEN  : '#'   ;

NAME
    : [a-zA-Z_][a-zA-Z_0-9]*
    ;

NORMALSTRING
    : '"' ( EscapeSequence | ~('\\'|'"') )* '"'
    ;

CHARSTRING
    : '\'' ( EscapeSequence | ~('\''|'\\') )* '\''
    ;

LONGSTRING
    : '[' NESTED_STR ']'
    ;

fragment
NESTED_STR
    : '=' NESTED_STR '='
    | '[' .*? ']'
    ;

fragment
EscapeSequence
    : '\\' [abfnrtvz"'\\]
    | '\\' '\r'? '\n'
    | DecimalEscape
    | HexEscape
    ;
//    | UtfEscape  // TODO lua5.3

INT
    : Digit+
    ;

HEX
    : '0' [xX] HexDigit+
    ;

FLOAT
    : Digit+ '.' Digit* ExponentPart?
    | '.' Digit+ ExponentPart?
    | Digit+ ExponentPart
    ;

// TODO lua5.2
//HEX_FLOAT
//    : '0' [xX] HexDigit+ '.' HexDigit* HexExponentPart?
//    | '0' [xX] '.' HexDigit+ HexExponentPart?
//    | '0' [xX] HexDigit+ HexExponentPart
//    ;

fragment
ExponentPart
    : [eE] [+-]? Digit+
    ;

// TODO lua5.2
// HexExponentPart
//fragment
//HexExponentPart
//    : [pP] [+-]? Digit+
//    ;


fragment
DecimalEscape
    : '\\' Digit
    | '\\' Digit Digit
    | '\\' [0-2] Digit Digit
    ;

fragment
HexEscape
    : '\\' 'x' HexDigit HexDigit
    ;

// TODO lua5.3
//fragment
//UtfEscape
//    : '\\' 'u{' HexDigit+ '}'
//    ;

fragment
Digit
    : [0-9]
    ;

fragment
HexDigit
    : [0-9a-fA-F]
    ;

SHORT_COMMENT
    : '--' (~('\r'|'\n'|'[') ~('\r'|'\n')*)? -> channel(HIDDEN)
    ;

LONG_COMMENT
    : '--' LONGSTRING  -> channel(HIDDEN)
    ;

WS
    : [ \t\r\n]+ -> channel(HIDDEN)
    ;

SHEBANG
    : '#' '!' ~('\n'|'\r')* -> channel(HIDDEN)
    ;