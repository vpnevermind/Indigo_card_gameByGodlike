package indigo

class Computer : Players(){
    val cardsInComputerHand = mutableListOf<Card>()
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

    fun computerChooseCard(): Card {
        val card = mainStrategy()
        cardsInComputerHand.remove(card)
        return card
    }

    fun mainStrategy():Card {
      return when {
           cardsInComputerHand.size == 1 -> cardsInComputerHand.first()
           tableCards.isEmpty() -> noCandidateCard()
           else -> candidateCardStrategy()
       }
    }

    fun candidateCardStrategy(): Card {
        val topCard = tableCards.last()
        var candidateCards = mutableListOf<Card>()
        for (card in cardsInComputerHand) {
            if (card.suit == topCard.suit || card.rank == topCard.rank) candidateCards.add(card)
        }
        if (candidateCards.isEmpty()) {
            return noCandidateCard()
        }
        if (candidateCards.size == 1) {
            return candidateCards.first()
        }
        if (candidateCards.size > 1) {
            val cardsWithCandidateSuit = mutableListOf<Card>()
            val cardsWithCandidateRank = mutableListOf<Card>()
            for (card in candidateCards) {
                if (card.suit == topCard.suit) cardsWithCandidateSuit.add(card)
            }
            for (card in candidateCards) {
                if (card.rank == topCard.rank) cardsWithCandidateRank.add(card)
            }
            return if (cardsWithCandidateRank.size > cardsWithCandidateSuit.size) {
                cardsWithCandidateRank.random()
            } else {
                cardsWithCandidateSuit.random()
            }
        }
        return cardsInComputerHand.random()
    }

    fun noCandidateCard(): Card {
        for (i in 0..<cardsInComputerHand.size - 1) {
            for (j in i + 1..<cardsInComputerHand.size) {
                if (cardsInComputerHand[i].suit == cardsInComputerHand[j].suit) {
                    return cardsInComputerHand[i]
                }
            }
        }
        for (i in 0..<cardsInComputerHand.size - 1) {
            for (j in i + 1..<cardsInComputerHand.size) {
                if (cardsInComputerHand[i].rank == cardsInComputerHand[j].rank) {
                    return cardsInComputerHand[i]
                }
            }
        }
        return cardsInComputerHand.random()
    }


}