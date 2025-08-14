package solutions.HLO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HelloSolutionTest {
    @Test
    fun dumpHello() {
        val result = HelloSolutionR1().hello("Alice")
        Assertions.assertEquals("Hello, Alice!", result)
    }
}