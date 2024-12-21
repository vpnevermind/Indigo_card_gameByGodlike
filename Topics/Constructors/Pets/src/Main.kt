class Vehicle(val name: String, val color: String) {

    init {
        println("Vehicle created: $name is in color $color")
    }
}

fun main() {
    val car = Vehicle("Car", "Red")
}