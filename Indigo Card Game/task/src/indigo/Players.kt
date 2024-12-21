package indigo

abstract class Players {
    abstract var score: Int
    abstract val collectedCards: MutableList<Card>
    abstract fun addScore()
}