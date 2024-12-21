// The function calculateRank is your task.
// It takes a parameter, the weight of the sheep, which is an integer.
// It should return the rank of the sheep, which is also an integer.
fun calculateRank(weight: Int): Int {
    return when {
        weight < 30 -> 1
        weight in 30..<50 -> 2
        weight in 50..<70 -> 3
        else -> 4
    }
}

// The main function reads the input and calls calculateRank to rank the sheep.
fun main() {
    // Read the weight of the sheep
    val weight = readln().toInt()

    // Call calculateRank and print the result
    println(calculateRank(weight))
}