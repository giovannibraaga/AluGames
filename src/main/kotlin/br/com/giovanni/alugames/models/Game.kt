package org.example.br.com.giovanni.alugames.modelo

data class Game(val title: String, val thumb: String) {
    var description: String? = null

    override fun toString(): String {
        return "My Game ->\n" +
                "Title='$title', \n" +
                "Thumbnail='$thumb', \n" +
                "description='$description'"
    }


}