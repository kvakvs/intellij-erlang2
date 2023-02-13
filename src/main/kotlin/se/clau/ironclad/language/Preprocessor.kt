package se.clau.ironclad.language

import com.intellij.lang.ASTNode

/**
 * Stores preprocessor visible scope, and is populated by parsing -define/-undef directives.
 * Lives inside `ErlangParser`, via being defined in `ErlangParserUtilBase`
 */
class Preprocessor {
    data class Identifier(val name: String, val params: List<String>)

    val definitions = mutableMapOf<Identifier, List<ASTNode>>()
}