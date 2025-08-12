package bdd.steps

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions
import solutions.HLO.HelloSolution

class HelloSteps {
    private lateinit var name: String
    private lateinit var msg: String
    private val hello = HelloSolution()

    @Given("a friend named {string}")
    fun aFriendName(n: String) { name = n }

    @When("I say hello")
    fun iSayHello() { msg = hello.hello(name) }

    @Then("the message should be {string}")
    fun theMessageShouldBe(expected: String) {
        Assertions.assertEquals(expected, msg)
    }
}

