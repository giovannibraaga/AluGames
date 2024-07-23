package br.com.giovanni.alugames.models

interface Recommendation {
    val average: Double

    fun recommend(rating: Int)
}