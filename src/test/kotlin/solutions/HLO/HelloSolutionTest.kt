package solutions.HLO
import org.junit.jupiter.api.Test
import java.sql.DriverManager.println

class HelloSolutionTest {
    @Test
    fun testHello() {
        val hello = HelloSolution()
        val result = hello.hello("Alice")
        println(">>> HelloSolution says: '$result'")
    }
}