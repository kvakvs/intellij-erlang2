package se.clau.ironclad.language

import com.intellij.psi.tree.IElementType

/**
 * Stores preprocessor visible scope, and is populated by parsing -define/-undef directives.
 * Lives and is populated inside `ErlangLexer`
 */
class Preprocessor {
    data class MacroArity(val name: String, val arity: Int)
    data class MacroDefinition(val vars: List<String>, val tokens: Collection<IElementType>)

    val macros = mutableMapOf<MacroArity, MacroDefinition>()

    fun define(name: String, vars: List<String>, tokens: Collection<IElementType>) {
        macros[MacroArity(name, vars.size)] = MacroDefinition(vars, tokens)
    }

    fun findMacro(id: MacroArity): MacroDefinition? = if (macros.containsKey(id)) macros[id] else null

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
}