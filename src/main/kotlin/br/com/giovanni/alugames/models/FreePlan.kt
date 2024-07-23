package br.com.giovanni.alugames.models

import java.math.BigDecimal
import java.math.RoundingMode

class FreePlan(type: String, id: Int = 0) : Plan(type, id) {
    override fun getPrice(rent: Rent): Double {
        var ogPrice = super.getPrice(rent)

        if (rent.gamer.average > 8) {
            ogPrice -= ogPrice * 0.1
        }
        return ogPrice
    }
}
