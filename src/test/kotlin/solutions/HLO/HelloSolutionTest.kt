package solutions.HLO
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class HelloSolutionTest {
    @Test
    fun dumpHello() {
        val result = HelloSolution().hello("Alice")
        Assertions.assertEquals("<<force-fail>>", result)
    }
}