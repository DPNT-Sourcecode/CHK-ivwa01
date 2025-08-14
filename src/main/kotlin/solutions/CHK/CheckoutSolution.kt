package solutions.CHK

class CheckoutSolution {
    fun checkout(skus: String?): Int {
        if(skus.isNullOrEmpty() || skus.any { it !in "ABCD"})
        return -1

        var total = 0
        var countA = 130

        return total = countA
    }
}
