package solutions.CHK

class CheckoutSolution {
    fun checkout(skus: String?, isR2: Boolean = true): Int {

        if (skus == null || skus.isEmpty()) return -1

        if (skus.any { it !in if (isR2) "ABCDE" else "ABCD" }) return -1

        var total = 0
        val counts = skus.groupingBy { it }.eachCount()

        val countA = counts.getOrDefault('A',0)
        val countB = counts.getOrDefault('B',0)
        val countC = counts.getOrDefault('C',0)
        val countD = counts.getOrDefault('D',0)
        val countE = counts.getOrDefault('E',0)

        val freeBSFromE = if (isR2) countE / 2 else 0
        val effectiveCountB = maxOf(0, countB - freeBSFromE)

        total += if (isR2) {
            (countA / 5) * 200 + ((countA % 5) / 3) * 130 + ((countA % 5) % 3) * 50
        } else {
            (countA / 3) * 130 + (countA % 3) * 50
        }

        total += (effectiveCountB / 2) * 45 + (effectiveCountB % 2) * 30
        total += countC * 20
        total += countD * 15

        if (isR2) total += countE * 40

        return total
    }
}
