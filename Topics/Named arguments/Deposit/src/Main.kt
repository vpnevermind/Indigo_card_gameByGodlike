import kotlin.math.pow

fun main() {
    val parameter = readln()
    val value = readln().toInt()
    when (parameter) {
        "amount" -> println(deposit(amount = value))
        "percent" -> println(deposit(percent = value))
        "years" -> println(deposit(years = value))
    }
}

fun deposit(amount: Int = 1000, percent:Int = 5, years: Int = 10): Int {
    val result = amount * (1 + (percent.toDouble() / 100)).pow(years)
    return result.toInt()
}