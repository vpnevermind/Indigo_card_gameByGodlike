// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val height = readln().toInt()
    val length = readln().toInt()
    val length2 = readln().toInt()
    val width = readln().toInt()
    val box = Box(height, length, width)

    println(box)
    println(box.copy(length = length2))
}