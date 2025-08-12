package solutions.HLO

class HelloSolution {
    fun hello(friendName: String): String {
        val name = if (friendName.isBlank()) "Hello World" else friendName
        return "Hello, $friendName"

    }
}



