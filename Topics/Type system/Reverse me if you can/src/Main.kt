fun reverse(input: Int?): Int {
    return input?.toString()?.reversed()?.toIntOrNull() ?: -1
}
fun main() {
    println(reverse(readLine()!!.toInt()))
}