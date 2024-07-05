package org.example.br.com.giovanni.alugames.principal

import br.com.giovanni.alugames.services.APIUsage
import org.example.br.com.giovanni.alugames.modelo.Game
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)

    println("Search for the game code: ")
    val search = scanner.nextLine()

    val apiSearch = APIUsage()
    val gameInformation = apiSearch.gameSearch(search)

    var myGame: Game? = null

    val result = runCatching {
        if (gameInformation != null) {
            myGame = Game(
                gameInformation.info.title,
                gameInformation.info.thumb
            )
        }
    }

    if (gameInformation == null) {
        result.isFailure.run {
            println("Game not found, try another game index")
        }
    } else {
        result.onSuccess {
            println("Would you like to give a custom description? (y/n)")
            val answer = scanner.nextLine()

            if (answer.equals("y", true)) {
                println("Type your description: ")
                val description = scanner.nextLine()
                myGame?.description = description
            } else {
                myGame?.description = myGame?.title
            }
            println(myGame)
        }
    }
}