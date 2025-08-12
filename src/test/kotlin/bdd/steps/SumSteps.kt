package bdd.steps
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions.assertEquals
import solutions.SUM.SumSolution

class SumSteps {
    private var a = 0
    private var b = 0
    private var result = 0
    private val solver = SumSolution()

    @Given("two integers {int} and {int}")
    fun twoIntegers(x: Int, y: Int) { a = x; b = y }

    @When("I sum the numbers")
    fun sumNumbers() { result = solver.sum(a, b) }

    @Then("the result should be {int}")
    fun theResultShouldBe(expected: Int) { assertEquals(expected, result) }
}