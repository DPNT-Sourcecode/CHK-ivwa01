import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.junit.jupiter.api.Assertions.assertEquals
import solutions.CHK.CheckoutSolution

class CheckoutSteps {
    private var skus: String? = null
    private var result: Int = 0
    private val checkout = CheckoutSolution()

    @Given("a basket with items {string}")
    fun basketWithItems(skus: String?){
        this.skus = skus
    }

    @When("calculate total")
    fun calculateTotal(){
        result = checkout.checkout(skus)
    }

    @Then("the total should be {int}")
    fun totalShouldBe(expected: Int){
        assertEquals(expected, result)
    }
}