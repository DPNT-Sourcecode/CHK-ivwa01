package solutions.HLO

class HelloSolution {
    fun hello(friendName: String): String {
        val name = if (friendName.isBlank()) "World!" else friendName
        return "Hello, $friendName"
    }
}
