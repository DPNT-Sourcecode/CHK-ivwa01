package solutions.HLO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HelloSolutionTest {
    @Test
    fun dumpHello() {
        val instance = HelloSolutionR2()
        println("Using class: ${instance.javaClass.canonicalName}")
        val result = instance.hello("Alice")
        println("Result: $result")
        Assertions.assertEquals("Hello, Alice!", result)
    }
}