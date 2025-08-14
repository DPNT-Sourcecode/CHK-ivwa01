package solutions.CHK

class CheckoutSolution {

    fun checkout(skus: String?, round: Int = 2): Int {
        // Null => illegal
        if (skus == null) return -1

        // Empty => R1 returns -1, R2/R3 return 0
        if (skus.isEmpty()) return if (round >= 2) 0 else -1

        // Allowed SKUs per round
        val allowed = when (round) {
            1 -> "ABCD"
            2 -> "ABCDE"
            else -> "ABCDEF" // R3+
        }

        // Validate input contains only allowed SKUs
        if (skus.any { it !in allowed }) return -1

        var total = 0
        val counts = skus.groupingBy { it }.eachCount()

        val countA = counts.getOrDefault('A', 0)
        val countB = counts.getOrDefault('B', 0)
        val countC = counts.getOrDefault('C', 0)
        val countD = counts.getOrDefault('D', 0)
        val countE = counts.getOrDefault('E', 0)
        val countF = counts.getOrDefault('F', 0)

        // Free B from E (R2/R3): for every 2 E's, 1 B is free
        val freeBsFromE = if (round >= 2) countE / 2 else 0
        val effectiveCountB = maxOf(0, countB - freeBsFromE)

        // A offers: R1 (3A for 130), R2/R3 (5A for 200; 3A for 130)
        total += if (round >= 2) {
            // Favor customer: apply 5A first, then 3A, then singles
            val fives = countA / 5
            val remAfter5 = countA % 5
            val threes = remAfter5 / 3
            val singles = remAfter5 % 3
            fives * 200 + threes * 130 + singles * 50
        } else {
            val threes = countA / 3
            val singles = countA % 3
            threes * 130 + singles * 50
        }

        // B offers: 2B for 45 on the effective (non-free) Bs
        total += (effectiveCountB / 2) * 45 + (effectiveCountB % 2) * 30

        // C & D (no offers)
        total += countC * 20
        total += countD * 15

        // E price (R2/R3)
        if (round >= 2) {
            total += countE * 40
        }

        // F price + offer (R3): "buy 2F get 1F free" => for each 3, pay 2
        if (round >= 3) {
            val groupsOf3 = countF / 3
            val remainder = countF % 3
            total += groupsOf3 * 20 + remainder * 10
        }

        return total
    }
}

