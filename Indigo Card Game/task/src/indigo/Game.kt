package indigo

import java.util.Objects
val tableCards = mutableListOf<Card>()

class Game() {
    private val deck = Deck()
    private val player = Player()
    private val computer = Computer()

    private var currentPlayer: Players = player
    private var lastWinner: Players = player
    private var firstPlayer: Players = player

    fun startGame() {
        println("Indigo Card Game")
        deck.resetDeck()
        chooseWhoPlayFirst()
        initializeTable()
        game()
        giveRemainingTableCards()
        rewardForMoreCards()
        checkScore()
        exitGame()
    }

    private fun chooseWhoPlayFirst() {
        println("Play first?")
        when (readln()) {
            "yes" -> {currentPlayer = player; firstPlayer = player}
            "no" -> {currentPlayer = computer; firstPlayer = computer}
            "exit" -> exitGame()
            else -> chooseWhoPlayFirst()
        }
    }

    private fun initializeTable() {
        addCard(4, tableCards)
        println("Initial cards on the table: ${tableCards.joinToString(" ")}")
        checkTable()
    }

    private fun addCard(amount: Int, hand: MutableList<Card>) {
        repeat(amount) {
            hand.add(deck.getCard())
        }
    }

    private fun checkTable() {
        println()
        if (tableCards.isNotEmpty()) {
            println("${tableCards.size} cards on the table, and the top card is ${tableCards.last()}")
        } else {
            println("No cards on the table")
        }
    }

    private fun game() {
        while(deck.deck.isNotEmpty()) {
            giveCards()
            while (player.cardsInPlayerHand.isNotEmpty() || computer.cardsInComputerHand.isNotEmpty()) {
                testWinCondition(isCardMatchesWithTopCardOnTable(chooseCard()))
            }
        }
    }

    private fun giveCards() {
        addCard(6, player.cardsInPlayerHand)
        addCard(6, computer.cardsInComputerHand)
    }

    private fun testWinCondition(isCardMatches: Boolean) {
        if (isCardMatches) {
            giveCardsToWinner()
            if (currentPlayer == player) {
                lastWinner = player
                println("Player wins cards")
            } else {
                lastWinner = computer
                println("Computer wins cards")
            }
            checkScore()
            checkTable()
        } else {
            checkTable()
        }
        currentPlayer = if (currentPlayer == player) computer else player
    }

    private fun isCardMatchesWithTopCardOnTable(chosenCard: Card): Boolean {
        return if (tableCards.isNotEmpty() && (chosenCard.rank == tableCards.last().rank || chosenCard.suit == tableCards.last().suit)){
            tableCards.add(chosenCard)
            true
        } else {
            tableCards.add(chosenCard)
            false
        }
    }

    private fun giveCardsToWinner() {
        repeat(tableCards.size) {
            currentPlayer.collectedCards.add(tableCards.last())
            tableCards.removeLast()
        }
        currentPlayer.addScore()
    }

    private fun checkScore() {
        println("Score: Player ${player.score} - Computer ${computer.score}")
        println("Cards: Player ${player.collectedCards.size} - Computer ${computer.collectedCards.size}")
    }

    private fun chooseCard(): Card {
        if (currentPlayer == player) {
            player.showCardsInPlayersHand()
            while (true) {
                println("Choose a card to play (1-${player.cardsInPlayerHand.size}):")
                val choosenCard = readln()
                when (choosenCard) {
                    "exit" -> exitGame()
                    in "1".."${player.cardsInPlayerHand.size}" -> {
                        return player.putCard(choosenCard.toInt())
                    }
                }
            }
        } else {
            println("${computer.cardsInComputerHand.joinToString(" ")}")
            val card = computer.computerChooseCard()
            println("Computer plays $card")
            return card
        }
    }

    private fun giveRemainingTableCards() {
        repeat(tableCards.size) {
            lastWinner.collectedCards.add(tableCards.last())
            tableCards.removeLast()
        }
        lastWinner.addScore()
    }

    private fun rewardForMoreCards() {
        if (player.collectedCards.size > computer.collectedCards.size) {
            player.score += 3
        } else if (player.collectedCards.size < computer.collectedCards.size) {
            computer.score += 3
        } else {
            firstPlayer.score += 3
        }
    }
        private fun exitGame() {
            println("Game Over")
            System.exit(0)
        }
}