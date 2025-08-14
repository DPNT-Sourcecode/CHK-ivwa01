package bdd.steps

import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions.assertEquals
import solutions.CHK.CheckoutSolution

class CheckoutSteps {
    private var skus: String? = null
    private var result: Int = 0
    private val checkout = CheckoutSolution()

    @Given("a basket with item {string}")
    fun basketWithItem(skus: String?){
            this.skus = skus
    }

    @Given("a basket with items {string}")
    fun basketWithItems(skus: String?){
        if (skus != null) {
            this.skus = skus
        }
    }

    @When("I calculate the total")
    fun calculateTotal(){
        result = when (checkout){
           is checkoutSolution -> (checkout as CheckoutSolution).checkout(skus)
            else -> throw IllegalStateException("Unknown checkout implementation $checkout")
        }
    }

    @Then("the total should be {int}")
    fun totalShouldBe(expected: Int){
        assertEquals(expected, result)
    }
}

