package se.clau.ironclad

interface IErlangTestCase : ITestCase {
    override val testFileExtension: String get() = "erl"
}
