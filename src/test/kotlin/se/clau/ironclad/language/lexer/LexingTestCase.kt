/*
 * From: intellij-rust
 * License: The MIT License (MIT)
 *
 * Copyright (c) 2015 Aleksey Kladov, Evgeny Kurbatsky, Alexey Kudinkin and contributors
 * Copyright (c) 2016 JetBrains
 *
 * Use of this source code is governed by the MIT license that can be
 * found in the LICENSE file.
 */

package se.clau.ironclad.language.lexer

import com.intellij.lexer.Lexer
import se.clau.ironclad.language.ErlangLexer

class LexingTestCase : LexingTestCaseBase() {
    override fun getTestDataPath(): String = "se/clau/ironclad/language/lexer/fixtures"

    override fun createLexer(): Lexer = ErlangLexer()

    fun `test comments`() = doTest()
    fun `test shebang`() = doTest()
    fun `test shebang 1`() = doTest()
    fun `test shebang 2`() = doTest()
    fun `test shebang 3`() = doTest()
    fun `test shebang 4`() = doTest()
    fun `test numbers`() = doTest()
    fun `test identifiers`() = doTest()
    fun `test char literals`() = doTest()
    fun `test string literals`() = doTest()
    fun `test byte literals`() = doTest()
    fun `test invalid escape`() = doTest()
    fun `test doc comment merging`() = doTest()
    fun `test keywords`() = doTest()
}
