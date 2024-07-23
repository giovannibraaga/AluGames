package org.example.br.com.giovanni.alugames.models

import br.com.giovanni.alugames.models.Recommendation
import com.google.gson.annotations.Expose
import java.text.DecimalFormat

data class Game(
    @Expose val title: String,
    @Expose val thumb: String
) : Recommendation {
    var description: String? = null
    var price: Double = 0.0

    var id = 0

    private val ratingList = mutableListOf<Int>()
    private val decimalFormat = DecimalFormat("#.##")
    override val average: Double
        get() = ratingList.average()

    constructor(title: String, thumb: String, price: Double, description: String?, id: Int = 0) : this(title, thumb) {
        this.price = price
        this.description = description
        this.id = id
    }

    override fun toString(): String {
        return "Game:\n" +
                "Title: $title\n" +
                "Thumbnail: $thumb\n" +
                "Price: ${decimalFormat.format(price)}\n" +
                "description: $description\n" +
                "Rating: ${decimalFormat.format(ratingList.average())}\n" +
                "ID: $id\n"
    }

    override fun recommend(rating: Int) {
        if (rating in 1..10) {
            ratingList.add(rating)
        } else {
            println("Rating must be between 1 and 10")
        }
    }
}