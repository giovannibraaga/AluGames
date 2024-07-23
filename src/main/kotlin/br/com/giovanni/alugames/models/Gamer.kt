package br.com.giovanni.alugames.models

import org.example.br.com.giovanni.alugames.models.Game
import java.text.DecimalFormat
import java.util.*
import kotlin.random.Random

data class Gamer(var name: String, var email: String) : Recommendation {
    var birthDate: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (internId.isNullOrBlank()) {
                generateInternId()
            }
        }
    var id = 0
    var internId: String? = null
        private set
    val gamesSearched = mutableListOf<Game?>()
    val rentedGames = mutableListOf<Rent>()
    var plan: Plan = FreePlan("BRONZE")
    private val ratingList = mutableListOf<Int>()
    val recommendedGames = mutableListOf<Game>()
    private val decimalFormat = DecimalFormat("#.00")

    override val average: Double
        get() = ratingList.average()

    override fun recommend(rating: Int) {
        if (rating in 1..10) {
            ratingList.add(rating)
        } else {
            println("Rating must be between 1 and 10")
        }
    }

    fun recommendGame(game: Game, rating: Int) {
        game.recommend(rating)
        recommendedGames.add(game)
    }

    constructor(name: String, email: String, birthDate: String?, user: String?, id: Int = 0) : this(name, email) {
        this.birthDate = birthDate
        this.user = user
        this.id = id
        generateInternId()
    }

    override fun toString(): String {
        return "Gamer:\n" +
                "name: '$name'\n" +
                "email: '$email'\n" +
                "birthDate: $birthDate\n" +
                "user: $user\n" +
                "internId: $internId\n" +
                "Reputation: ${decimalFormat.format(average)}\n" +
                "ID: $id\n" +
                "Plan: ${plan.type}"
    }

    private fun generateInternId() {
        val number = Random.nextInt(10000)
        val tag = String.format("%04d", number)

        internId = "${user}#$tag"
    }

    private fun validateEmail(): String {
        val regex = Regex("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")

        if (regex.matches(email)) {
            return email
        } else
            throw IllegalArgumentException("Invalid email")
    }

    fun rentGame(game: Game, period: Period): Rent {
        val rent = Rent(this, game, period)
        rentedGames.add(rent)

        return rent
    }

    fun rentedGamesFilter(month: Int): List<Game> {
        return rentedGames.filter { rent: Rent -> rent.period.initialDate.monthValue == month }
            .map { rent: Rent -> rent.game }
    }

    companion object {
        fun createGamer(scanner: Scanner): Gamer {
            println("Welcome to AluGames! Let's get started. What's your name?")
            val name = scanner.nextLine()
            println("What's your email?")
            val email = scanner.nextLine()
            println("Would you like to complete your registration with an username and a birthdate? (y/n)")
            val option = scanner.nextLine()

            if (option.equals("y", true)) {
                println("What's your username?")
                val user = scanner.nextLine()
                println("What's your birthdate?")
                val birthDate = scanner.nextLine()

                return Gamer(name, email, birthDate, user)
            } else {
                return Gamer(name, email)
            }
        }
    }

    init {
        if (name.isBlank()) {
            throw IllegalArgumentException("Name cannot be blank")
        }
        this.email = validateEmail()
    }
}

