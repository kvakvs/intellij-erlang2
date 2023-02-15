package se.clau.ironclad

interface ErlangTestCase : TestCase {
    override val testFileExtension: String get() = "erl"
}
