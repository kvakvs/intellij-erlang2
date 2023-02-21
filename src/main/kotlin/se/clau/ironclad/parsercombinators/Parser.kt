package se.clau.ironclad.parsercombinators

import com.intellij.psi.tree.IElementType

/**
 * Used by Token matcher parser to check whether an InputType to a parser has same
 * IElementType as the sample provided as argument
 */
interface IParserInputItem {
    fun sameElementType(tok: IElementType): Boolean
}

interface IParserState {}

object EmptyState: IParserState {}

/**
 * Use this to provide input functions to the functional parser
 */
interface IParserInput {
    fun have(): Boolean
    fun take(): IParserInputItem?
    fun pushBack(n: Int)

    /**
     * Look ahead, cannot return null, returns a blank token if EOF reached
     */
    fun peek(offset: Int): IParserInputItem
}

data class ParserResult<ResultType>(
    val input: IParserInput,
    val result: ResultType,
    val state: IParserState
)

/**
 * All parser functions. A parser function takes input and state, and returns maybe result and maybe state
 */
typealias Parser<ResultType>
        = (input: IParserInput, state: IParserState) -> ParserResult<ResultType>

/**
 * Use this to let functional parser output the results
 */
interface IParserOutput<T> {
    fun write(lexStep: T)
}

class ParseCombinatorError(msg: String) : Exception(msg)