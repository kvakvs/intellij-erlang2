package se.clau.ironclad.parsercombinators

object Combinator {
    /**
     * Returns a new `ParserFn<>`, which will succeed if left parser succeeds, and right parser succeeds.
     * The result of this new function will be what the `outputParser` returned.
     */
    fun <ResultType> delimited(
        leftParser: Parser<*>,
        outputParser: Parser<ResultType>,
        rightParser: Parser<*>
    ): Parser<ResultType> {
        return fun(
            input: IParserInput,
            state: IParserState?
        ): ParserResult<ResultType> {
            val left = leftParser(input.clone(), EmptyState) // throws if match failed
            val result = outputParser(left.input.clone(), left.state)
            val right = rightParser(result.input.clone(), EmptyState) // throws if match failed

            // Reform the `result` and set its input to the right parser input, so that we get
            // the correct tail
            return ParserResult(right.input.clone(), result.value, result.state)
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
                    return p(input.clone(), state)
                } catch (_: ParserCombinatorError) {
                    // no error
                }
            }
            throw ParserCombinatorError("None of the provided parsers matched")
        }
    }

    /**
     * Attempt to apply the `parser`, and convert its result to optional ResultType.
     * If parse fails, will return the default.
     */
    fun <ResultType> opt(parser: Parser<ResultType>, defaultResult: () -> ResultType): Parser<ResultType> {
        return fun(input: IParserInput, state: IParserState): ParserResult<ResultType> {
            try {
                val parseResult = parser(input.clone(), state)
                return parseResult
            } catch (e: ParserCombinatorError) {
                return ParserResult(input.clone(), defaultResult(), state)
            }
        }
    }

    /**
     * Wraps another parser.
     * Catches ParserCombinatorError, then rethrows it with added context data
     */
    fun <ResultType> context(ctx: String, parser: Parser<ResultType>): Parser<ResultType> {
        return fun(input:IParserInput, state: IParserState): ParserResult<ResultType> {
            try {
                return parser(input.clone(), state)
            } catch (e: ParserCombinatorError) {
                throw e.addContext(ctx)
            }
        }
    }
}