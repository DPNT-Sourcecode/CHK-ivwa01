package bdd.steps

import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions.assertEquals
import solutions.HLO.HelloSolutionR1
import solutions.HLO.HelloSolutionR2
import java.lang.IllegalStateException

class HelloSteps {
    private lateinit var name: String
    private lateinit var msg: String
    private var hello: Any? = null

    @Before("@r1")
    fun setUpR1(){
        hello = HelloSolutionR1()
    }

    @Before("not @r1")
    fun setUpR2(){
        hello = HelloSolutionR2()
    }

    @Given("^a friend named \"(.*)\"$")
    fun aFriendName(n: String) {
        name = n
    }

    @When("I say hello")
    fun iSayHello() {
        msg = when (hello) {
            is HelloSolutionR1 -> (hello as HelloSolutionR1).hello(name)
            is HelloSolutionR2 -> (hello as HelloSolutionR2).hello(name)
            else -> throw IllegalStateException("Unknown hello implementation $hello")
        }
    }

    @Then("the message should be {string}")
    fun theMessageShouldBe(expected: String) {
        assertEquals(expected, msg, "Expected vs Actual mismatch")
    }
}
