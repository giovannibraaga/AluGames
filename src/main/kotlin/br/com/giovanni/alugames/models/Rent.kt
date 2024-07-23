package br.com.giovanni.alugames.models

import org.example.br.com.giovanni.alugames.models.Game

data class Rent(val gamer: Gamer, val game: Game, val period: Period) {
    val rentPrice = gamer.plan.getPrice(this)
    var id = 0

    override fun toString(): String {
        return "${gamer.name} rented the game: ${game.title} for $$rentPrice"
    }


}

