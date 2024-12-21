fun main() {
    val elvis = readLine()
    println("Elvis says: ${elvis ?: throw IllegalStateException()}")
}