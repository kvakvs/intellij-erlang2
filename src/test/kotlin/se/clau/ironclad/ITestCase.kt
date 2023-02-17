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

package se.clau.ironclad

import java.nio.file.Path
import java.nio.file.Paths

interface ITestCase {
    val testFileExtension: String
    fun getTestDataPath(): String
    fun getTestName(lowercaseFirstLetter: Boolean): String

    companion object {
        const val testResourcesPath = "src/test/resources"

        @JvmStatic
        fun camelOrWordsToSnake(name: String): String {
            if (' ' in name) return name.trim().replace(" ", "_")

            return name.split("(?=[A-Z])".toRegex()).joinToString("_", transform = String::lowercase)
        }
    }
}

fun ITestCase.pathToSourceTestFile(): Path =
    Paths.get("${ITestCase.testResourcesPath}/${getTestDataPath()}/${getTestName(true)}.$testFileExtension")

fun ITestCase.pathToGoldTestFile(): Path =
    Paths.get("${ITestCase.testResourcesPath}/${getTestDataPath()}/${getTestName(true)}.txt")
