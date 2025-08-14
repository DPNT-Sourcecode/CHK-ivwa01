package bdd.steps

import io.cucumber.java.Before
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions.assertEquals
import solutions.CHK.CheckoutSolution

class CheckoutSteps {
    private var skus: String? = null
    private var result: Int = 0
    private var checkout: CheckoutSolution? = null
    private var round: Int = 1

    @Before("@r1")
    fun setUpR1() {
        checkout = CheckoutSolution()
        round = 1
    }

    @Before("@r2")
    fun setUpR2() {
        checkout = CheckoutSolution()
        round = 2
    }

    @Before("@r3")
    fun setUpR3() {
        checkout = CheckoutSolution()
        round = 3
    }

    @Given("a basket with item {string}")
    fun basketWithItem(skus: String?) {
        this.skus = skus
    }

    @Given("a basket with items {string}")
    fun basketWithItems(skus: String?) {
        if (skus != null) {
            this.skus = skus
        }
    }

    @When("I calculate the total")
    fun calculateTotal() {
        result = when (checkout) {
            is CheckoutSolution -> (checkout as CheckoutSolution).checkout(skus, round)
            else -> throw IllegalStateException("Unknown checkout implementation $checkout")
        }
    }

    @Then("the total should be {int}")
    fun totalShouldBe(expected: Int) {
        assertEquals(expected, result)
    }

    @Before("@r4")
    fun setUpR4() {
        checkout = CheckoutSolution()
        round = 4
    }

    @Before("@r5")
    fun setUpR5() {
        checkout = CheckoutSolution()
        round = 5
    }
}

