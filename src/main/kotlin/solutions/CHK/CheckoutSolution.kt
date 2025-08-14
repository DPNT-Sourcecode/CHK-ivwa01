package solutions.CHK

class CheckoutSolution {
    fun checkout(skus: String?): Int {
        if(skus.isNullOrEmpty() || skus.any { it !in "ABCD"})
        return -1

        var total = 0
        val counts = skus.groupingBy { it }.eachCount()

        val countA = counts.getOrDefault('A',0)
        total += (countA / 3) * 130 + (countA % 3) * 50

        val countB = counts.getOrDefault('B',0)
        total += (countB / 2) * 45 + (countB % 2) * 30

        return total
    }
}



