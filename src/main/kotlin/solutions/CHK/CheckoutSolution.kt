package solutions.CHK

class CheckoutSolution {
    fun checkout(skus: String?, isR2: Boolean = true): Int {
        // Return -1 for null input; for empty string, return 0 for CHK_R2, -1 for CHK_R1
        if (skus == null) return -1
        if (skus.isEmpty()) return if (isR2) 0 else -1

        // Validate SKUs: ABCD for CHK_R1, ABCDE for CHK_R2
        if (skus.any { it !in if (isR2) "ABCDE" else "ABCD" }) return -1

        var total = 0
        val counts = skus.groupingBy { it }.eachCount()

        val countA = counts.getOrDefault('A', 0)
        val countB = counts.getOrDefault('B', 0)
        val countC = counts.getOrDefault('C', 0)
        val countD = counts.getOrDefault('D', 0)
        val countE = counts.getOrDefault('E', 0)

        // Apply free B offer for CHK_R2 (2E get one B free)
        val freeBSFromE = if (isR2) countE / 2 else 0
        val effectiveCountB = maxOf(0, countB - freeBSFromE)

        // Apply A offers: CHK_R1 (3A for 130), CHK_R2 (5A for 200, 3A for 130)
        total += if (isR2) {
            (countA / 5) * 200 + ((countA % 5) / 3) * 130 + ((countA % 5) % 3) * 50
        } else {
            (countA / 3) * 130 + (countA % 3) * 50
        }

        // Apply B offer: 2B for 45
        total += (effectiveCountB / 2) * 45 + (effectiveCountB % 2) * 30

        // Add C and D (no offers)
        total += countC * 20
        total += countD * 15

        // Add E for CHK_R2 (40 each)
        if (isR2) total += countE * 40

        return total
    }
}