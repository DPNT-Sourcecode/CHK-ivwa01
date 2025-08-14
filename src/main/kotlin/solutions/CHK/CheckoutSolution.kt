package solutions.CHK

class CheckoutSolution {
    fun checkout(skus: String?): Int {
        if(skus == null) return -1
        if(skus.isEmpty()) return 0
        if(skus.any { it !in "ABCD"}) return -1

        var total = 0
        val counts = skus.groupingBy { it }.eachCount()

        val countA = counts.getOrDefault('A',0)
        val countB = counts.getOrDefault('B',0)
        val countC = counts.getOrDefault('C',0)
        val countD = counts.getOrDefault('D',0)
        val countE = counts.getOrDefault('E',0)


        val countA = counts.getOrDefault('A',0)
        total += (countA / 3) * 130 + (countA % 3) * 50

        val countB = counts.getOrDefault('B',0)
        total += (countB / 2) * 45 + (countB % 2) * 30

        val countC = counts.getOrDefault('C',0)
        total += countC * 20

        val countD = counts.getOrDefault('D',0)
        total += countD * 15

        return total
    }
}
