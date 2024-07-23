package br.com.giovanni.alugames.models

import java.math.BigDecimal

sealed class Plan(val type: String, var id: Int = 0) {
    open fun getPrice(rent: Rent): Double {
        return rent.game.price * rent.period.duration.toDouble()
    }
}