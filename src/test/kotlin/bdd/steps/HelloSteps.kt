package bdd.steps

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions.assertEquals
import solutions.HLO.HelloSolutionR1
import solutions.HLO.HelloSolutionR2

class HelloSteps {
    private lateinit var name: String
    private lateinit var msg: String
    private var hello: Any? = null

    fun setUpR1(){
        hello = HelloSolutionR1()
    }

    fun setUpR2(){
        hello = HelloSolutionR1()
    }



    @Given("^a friend named \"(.*)\"$")
    fun aFriendName(n: String) { name = n }

    @When("I say hello")
    fun iSayHello() {
        msg = when (hello) {
            is HelloSolutionR1 -> (hello as HelloSolutionR1).hello(name)
            else -> (hello as HelloSolutionR2).hello(name)
        }
    }

    @Then("the message should be {string}")
    fun theMessageShouldBe(expected: String) {
        assertEquals(expected, msg, "Expected vs Actual mismatch")
    }
}

