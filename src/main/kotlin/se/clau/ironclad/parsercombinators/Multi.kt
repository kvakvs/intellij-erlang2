package se.clau.ironclad.parsercombinators

/**
 * Matcher functions for complex sequences
 */
object Multi {
    /**
     * Create a parser function which attempts to match multiple elements parsed by
     * `elementParser` and separated by `separatorParser`
     */
    fun <ResultType> separated0(
        elementParser: Parser<ResultType>,
        separatorParser: Parser<*>
    ): Parser<List<ResultType>> {
        return fun(
            input: IParserInput,
            state: IParserState
        ): ParserResult<List<ResultType>> {
            val output = mutableListOf<ResultType>()
            var state1 = state

            try {
                val first = elementParser(input, state)
                state1 = first.state
                output.add(first.value)

                while (input.have()) {
                    try {
                        val separator = separatorParser(first.input.clone(), EmptyState)
                        val next = elementParser(separator.input.clone(), state1)
                        output.add(next.value)
                        state1 = next.state
                    } catch (_: ParserCombinatorError) {
                        // error means no more could be consumed
                    }
                }
            } catch (_: ParserCombinatorError) {
                // error means first element was not consumed so we have zero elements
            }

            return ParserResult(input.clone(), output, state1)
        }
    }
}
