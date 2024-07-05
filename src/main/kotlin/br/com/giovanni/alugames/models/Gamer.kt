package br.com.giovanni.alugames.models

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

    init {
        if(name.isBlank()) {
            throw IllegalArgumentException("Name cannot be blank")
        }
        this.email = validateEmail()
    }
}

