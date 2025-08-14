package solutions.CHK

class CheckoutSolution {
    fun checkout(skus: String?): Int {

        if (skus == null) return -1

        if(skus.isEmpty()) return 0

        if(skus.any { it !in "ABCDE"}) return -1

        var total = 0
        val counts = skus.groupingBy { it }.eachCount()

        val countA = counts.getOrDefault('A',0)
        val countB = counts.getOrDefault('B',0)
        val countC = counts.getOrDefault('C',0)
        val countD = counts.getOrDefault('D',0)
        val countE = counts.getOrDefault('E',0)

        val freeBSFromE = countE / 2
        val effectiveCountB = maxOf(0, countB - freeBSFromE)

        total += (countA / 5) * 200 + ((countA % 5) / 3) * 130 + ((countA % 5) % 3) * 50

        total += (effectiveCountB / 2) * 45 + (effectiveCountB % 2) * 30

        total += countC * 20
        total += countD * 15
        total += countE * 40

        return total
    }
}
