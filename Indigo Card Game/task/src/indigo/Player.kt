package indigo

class Player : Players() {
    val cardsInPlayerHand = mutableListOf<Card>()
    override var score = 0
    override val collectedCards = mutableListOf<Card>()

    override fun addScore() {
        var count = 0
        for (card in collectedCards) {
            for (rank in card.valuableRanks) {
                if (card.rank == rank) count++
            }
        }
        score = count
    }


    fun putCard(cardNumber: Int) : Card {
        val card = cardsInPlayerHand[cardNumber - 1]
        cardsInPlayerHand.removeAt(cardNumber - 1)
        return card
    }

    fun showCardsInPlayersHand() {
        var cardsInHand = "Cards in hand:"
        for (n in cardsInPlayerHand.indices) {
            cardsInHand += " ${n + 1})${cardsInPlayerHand[n]}"
        }
        println(cardsInHand)
    }



}