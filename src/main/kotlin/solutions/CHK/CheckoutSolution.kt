package solutions.CHK

class CheckoutSolution {

    // === Public API used by the grader (CHK_R4) ===
    fun checkout(skus: String?): Int = checkout(skus, 4)

    // === Internal API so your R1/R2/R3/R4 tests can still pick a round ===

    fun checkout(skus: String?, round: Int): Int {
        if (skus == null) return -1
        if (skus.isEmpty()) return if (round >= 2) 0 else -1

        val allowed = when (round) {
            1 -> "ABCD"
            2 -> "ABCDE"
            3 -> "ABCDEF"
            else -> ('A'..'Z').joinToString("") // R4+

        }
        if (skus.any { it !in allowed }) return -1

        val counts = skus.groupingBy { it }.eachCount()
        val countA = counts.getOrDefault('A', 0)
        val countB = counts.getOrDefault('B', 0)
        val countC = counts.getOrDefault('C', 0)
        val countD = counts.getOrDefault('D', 0)
        val countE = counts.getOrDefault('E', 0)
        val countF = counts.getOrDefault('F', 0)

        // New items for R4
        val countG = counts.getOrDefault('G', 0)
        val countH = counts.getOrDefault('H', 0)
        val countI = counts.getOrDefault('I', 0)
        val countJ = counts.getOrDefault('J', 0)
        val countK = counts.getOrDefault('K', 0)
        val countL = counts.getOrDefault('L', 0)
        val countM = counts.getOrDefault('M', 0)
        val countN = counts.getOrDefault('N', 0)
        val countO = counts.getOrDefault('O', 0)
        val countP = counts.getOrDefault('P', 0)
        val countQ = counts.getOrDefault('Q', 0)
        val countR = counts.getOrDefault('R', 0)
        val countS = counts.getOrDefault('S', 0)
        val countT = counts.getOrDefault('T', 0)
        val countU = counts.getOrDefault('U', 0)
        val countV = counts.getOrDefault('V', 0)
        val countW = counts.getOrDefault('W', 0)
        val countX = counts.getOrDefault('X', 0)
        val countY = counts.getOrDefault('Y', 0)
        val countZ = counts.getOrDefault('Z', 0)

        var total = 0

        // E -> free B (R2+)
        val freeBsFromE = if (round >= 2) countE / 2 else 0
        val effectiveB = maxOf(0, countB - freeBsFromE)

        // N -> M free (R4)
        val freeMsFromN = if (round >= 4) countN / 3 else 0
        val effectiveM = maxOf(0, countM - freeMsFromN)

        // R -> Q free (R4)
        val freeQsFromR = if (round >= 4) countR / 3 else 0
        val effectiveQ = maxOf(0, countQ - freeQsFromR)

        // U self-free (R4): "3U get one U free" => every 4 U, 1 free
        val freeUsFromU = if (round >= 4) countU / 4 else 0
        val chargedUUnits = if (round >= 4) countU - freeUsFromU else countU

        // F self-free (R3+): "2F get 1F free" => for each 3, pay 2
        val groupsOf3F = if (round >= 3) countF / 3 else 0
        val remainderF = if (round >= 3) countF % 3 else countF
        val chargedFUnits = if (round >= 3) groupsOf3F * 2 + remainderF else countF
        // (equivalently countF - groupsOf3F)

        // ---------- PRICING ----------
        // A offers
        total += if (round >= 2) {
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

        // B offers on effective (non-free) Bs
        total += (effectiveB / 2) * 45 + (effectiveB % 2) * 30

        // C & D
        total += countC * 20
        total += countD * 15

        // E (R2+) @ 40
        if (round >= 2) total += countE * 40

        // F (R3+): charge only non-free units @ 10
        if (round >= 3) total += chargedFUnits * 10

        if (round >= 4) {
            // G (20)
            total += countG * 20

            // H: 10-for-80, then 5-for-45, then singles @10 (prefer larger first)
            val tensH = countH / 10
            val rem10H = countH % 10
            val fivesH = rem10H / 5
            val singlesH = rem10H % 5
            total += tensH * 80 + fivesH * 45 + singlesH * 10

            // I (35), J (60)
            total += countI * 35
            total += countJ * 60

            // K: 2-for-150
            total += (countK / 2) * 150 + (countK % 2) * 80

            // L (90)
            total += countL * 90

            // M (15) after freebies from N
            total += effectiveM * 15

            // N (40)
            total += countN * 40

            // O (10)
            total += countO * 10

            // P: 5-for-200
            total += (countP / 5) * 200 + (countP % 5) * 50

            // Q: 3-for-80 on effective Q after R freebies
            total += (effectiveQ / 3) * 80 + (effectiveQ % 3) * 30

            // R (50)
            total += countR * 50

            // S (30), T (20)
            total += countS * 30
            total += countT * 20

            // U (40) - charge only non-free units
            total += chargedUUnits * 40

            // V: 3-for-130, then 2-for-90, then singles @50 (prefer larger first)
            val threesV = countV / 3
            val rem3V = countV % 3
            val twosV = rem3V / 2
            val singlesV = rem3V % 2
            total += threesV * 130 + twosV * 90 + singlesV * 50

            // W (20), X (90), Y (10), Z (50)
            total += countW * 20
            total += countX * 90
            total += countY * 10
            total += countZ * 50
        }

        return total
    }
}





