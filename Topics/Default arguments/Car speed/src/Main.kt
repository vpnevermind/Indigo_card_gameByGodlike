fun checkSpeed(speed: Int, limit: Int = 60) {
    if (speed > limit) {
        println("Exceeds the limit by ${speed - limit} kilometers per hour")
    } else {
        println("Within the limit")
    }
}