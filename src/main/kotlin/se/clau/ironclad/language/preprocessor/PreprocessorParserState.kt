package se.clau.ironclad.language.preprocessor

import se.clau.ironclad.parsercombinators.IParserState

data class PreprocessorParserState(val scope: PreprocessorScope): IParserState