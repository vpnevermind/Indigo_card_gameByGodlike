import java.util.Scanner   // Required for reading user input.

fun main(args: Array<String>) {
    // Create a scanner object for reading user input.
    val scanner = Scanner(System.`in`)

    // Read a line of input from the user.
    val inputString = scanner.nextLine()

    println(inputString.reversed())
}