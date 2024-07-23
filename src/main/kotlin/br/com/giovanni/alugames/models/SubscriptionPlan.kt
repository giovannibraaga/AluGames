package br.com.giovanni.alugames.models

class SubscriptionPlan(
    type: String,
    val monthlyPayment: Double,
    val gamesIncluded: Int,
    val discountPercentage: Double,
    id: Int = 0
) : Plan(type, id) {
    override fun getPrice(rent: Rent): Double {
        val totalGamesMontlhy = rent.gamer.rentedGamesFilter(rent.period.initialDate.monthValue).size + 1

        return if (totalGamesMontlhy <= gamesIncluded) {
            0.0
        } else {
            var ogPrice = super.getPrice(rent)

            if (rent.gamer.average > 8) {
                ogPrice -= ogPrice * discountPercentage
            }
            ogPrice
        }
    }
}
