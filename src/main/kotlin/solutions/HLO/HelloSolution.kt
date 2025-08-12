package solutions.HLO

class HelloSolution {
    fun hello(friendName: String): String {
        if (friendName.length == 0 || friendName == "\"\"") {
            return "Hello, World!"
        }
        return "Hello, " + friendName + "!"
    }
}
