package solutions.CHK

class CheckoutSolution {
    fun checkout(skus: String?): Int {
        if(skus.isNullOrEmpty() || skus.any { it !in "ABCD"})
        return -1

        var total = 0
        val counts = skus.groupingBy { it }.eachCount()

        var countA = counts.getOrDefault('A',0)
        total += (countA / 3) * 130 + (countA / 3)

        return total
    }
}

