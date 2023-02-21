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
        separatorParser: Parser<Unit>
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
                output.add(first.result)

                while (input.have()) {
                    try {
                        val separator = separatorParser(first.input, EmptyState)
                        val next = elementParser(separator.input, state1)
                        output.add(next.result)
                        state1 = next.state
                    } catch (_: ParseCombinatorError) {
                        // error means no more could be consumed
                    }
                }
            } catch (_: ParseCombinatorError) {
                // error means first element was not consumed so we have zero elements
            }

            return ParserResult(input, output, state1)
        }
    }
}
