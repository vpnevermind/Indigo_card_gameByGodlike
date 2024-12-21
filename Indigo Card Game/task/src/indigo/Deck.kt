package indigo

data class Card(val rank: String,val suit: String) {
    val valuableRanks = listOf("A", "K", "Q", "J", "10")
    override fun toString(): String {
        return "$rank$suit"
    }
}

open class Deck() {
    val ranks = listOf("A", "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K")
    val suits = listOf("♣", "♦", "♥", "♠")
    val deck = mutableListOf<Card>()

    fun resetDeck() {
        deck.clear()
        for (s in suits) {
            for (r in ranks) {
                deck.add(Card(r, s))
            }
        }
        shuffleDeck()
    }

    fun shuffleDeck() {
        deck.shuffle()
    }

    fun getCard(): Card {
        val output = deck.last()
        deck.removeLast()
        return output
    }
}
