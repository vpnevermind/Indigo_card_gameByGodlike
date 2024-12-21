import kotlin.math.abs
import kotlin.math.hypot

fun perimeter(x1: Double, y1: Double, x2: Double, y2: Double, x3: Double, y3: Double, x4: Double = x3, y4: Double = y3): Double {
    val s1x = abs(x1 - x2)
    val s1y = abs(y1 - y2)
    val s1 = hypot(s1x, s1y)

    val s2x = abs(x2 - x3)
    val s2y = abs(y2 - y3)
    val s2 = hypot(s2x, s2y)

    val s3x = abs(x3 - x4)
    val s3y = abs(y3 - y4)
    val s3 = hypot(s3x, s3y)

    val s4x = abs(x4 - x1)
    val s4y = abs(y4 - y1)
    val s4 = hypot(s4x, s4y)

    return s1 + s2 + s3 + s4
}
fun main() {
    println(perimeter(0.0, 0.0, 12.0, 0.0, 0.0, 5.0))
}
