fun main() {
    val nullString = null
    if (nullString?.isEmpty() == false) {
        println("yes")
    } else {
        println("no")
    }
}