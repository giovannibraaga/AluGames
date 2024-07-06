package br.com.giovanni.alugames.models

import org.example.br.com.giovanni.alugames.modelo.Game
import java.util.Scanner
import kotlin.random.Random

data class Gamer(var name: String, var email: String) {
    var birthDate: String? = null
    var user: String? = null
        set(value) {
            field = value
            if (internId.isNullOrBlank()) {
                generateInternId()
            }
        }
    var internId: String? = null
        private set

    val gamesSearched = mutableListOf<Game?>()

    constructor(name: String, email: String, birthDate: String, user: String) : this(name, email) {
        this.birthDate = birthDate
        this.user = user
        generateInternId()
    }

    override fun toString(): String {
        return "Gamer(name='$name', email='$email', birthDate=$birthDate, user=$user, internId=$internId)"
    }

    fun generateInternId() {
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

