package se.clau.ironclad.language.preprocessor

import se.clau.ironclad.common.NameArity
import se.clau.ironclad.parsercombinators.IParserState

// Predefined symbols
// FILE = filename: string
// FUNCTION_NAME
// FUNCTION_ARITY
// LINE: integer
// MODULE, MODULE_STRING
// BASE_MODULE, BASE_MODULE_STRING
// MACHINE = Machine:atom
// Machine = true
// OTP_RELEASE (from erlang:system_info)

class PreprocessorScope: IParserState {
    data class PreprocessorDefinition(val vars: Collection<String>, val tokens: Collection<TokenWithLexerState>)

    private val definitions = mutableMapOf<NameArity, PreprocessorDefinition>()

    fun addDefinition(name: String, vars: Collection<String>, tokens: Collection<TokenWithLexerState>) {
        val key = NameArity(name, vars.size)
        definitions[key] = PreprocessorDefinition(vars, tokens)
    }
}
