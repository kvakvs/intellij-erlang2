package se.clau.ironclad.parsercombinators

object Combinator {
    /**
     * Returns a new `ParserFn<>`, which will succeed if left parser succeeds, and right parser succeeds.
     * The result of this new function will be what the `outputParser` returned.
     */
    fun <ResultType> delimited(
        leftParser: Parser<Unit>,
        outputParser: Parser<ResultType>,
        rightParser: Parser<Unit>
    ): Parser<ResultType> {
        return fun(
            input: IParserInput,
            state: IParserState?
        ): ParserResult<ResultType> {
            val left = leftParser(input, EmptyState) // throws if match failed
            val result = outputParser(left.input, left.state)
            val right = rightParser(result.input, EmptyState) // throws if match failed

            // Reform the `result` and set its input to the right parser input, so that we get
            // the correct tail
            return ParserResult(right.input, result.result, result.state)
        }
    }

    /**
     * Succeeds if either of the parsers succeed. Parsers must share the same return type.
     */
    fun <ResultType> either(
        vararg parsers: Parser<ResultType>,
    ): Parser<ResultType> {
        return fun(input: IParserInput, state: IParserState): ParserResult<ResultType> {
            for (p in parsers) {
                try {
                    return p(input, state)
                } catch (_: ParseCombinatorError) {
                    // no error
                }
            }
            throw ParseCombinatorError("None of the provided parsers matched")
        }
    }
}