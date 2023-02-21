package se.clau.ironclad.language.preprocessor

import se.clau.ironclad.parsercombinators.IParserInput

interface IPreprocessorDirective {
    fun execute(
        input: IParserInput,
        output: MutableList<CachedLexerStep>,
        scope: PreprocessorScope
    )
}
