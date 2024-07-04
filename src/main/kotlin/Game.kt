package org.example

data class Game(val title: String, val thumb: String) {
    val description = ""

    override fun toString(): String {
        return "My Game ->\n" +
                "Title='$title', \n" +
                "Thumbnail='$thumb', \n" +
                "description='$description'"
    }


}