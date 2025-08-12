package solutions.HLO
import org.junit.jupiter.api.Test
import java.sql.DriverManager.println

class HelloSolutionTest {
    @Test
    fun testHello() {
        val result = HelloSolution().hello("Alice")
        println("Output from HelloSolution: $result")
    }
}