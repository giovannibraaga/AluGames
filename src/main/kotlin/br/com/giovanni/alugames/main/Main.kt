package org.example.br.com.giovanni.alugames.principal

import br.com.giovanni.alugames.models.Gamer
import br.com.giovanni.alugames.services.APIUsage
import br.com.giovanni.alugames.utils.transformInAge
import org.example.br.com.giovanni.alugames.models.Game
import java.util.*


fun main() {
    val scanner = Scanner(System.`in`)
    val gamer = Gamer.createGamer(scanner)
    println("Registration completed with success! Gamer Status:\n$gamer")
    println("The gamer ${gamer.user} is: ${gamer.birthDate?.transformInAge()}")

    do {
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
                gamer.gamesSearched.add(myGame)
            }
        }

        println("Would you like to search another game? (y/n)")
        val answer2 = scanner.nextLine()

    } while (answer2.equals("y", true))


    println("Games oredered by title: ")
    gamer.gamesSearched.sortBy {
        it?.title
    }

    gamer.gamesSearched.forEach {
        println("Title: ${it?.title}")
    }

    val gamesFiltered = gamer.gamesSearched.filter {
        it?.title?.contains("batman", true) ?: false
    }

    gamesFiltered.forEach {
        println("Title: ${it?.title}")
    }

    println("Search ended, thanks for using our service")

    println("Would you like to delete any item? (y/n)")
    val answerDel = scanner.nextLine()

    if (answerDel.equals("y", true)) {
        println("Type the index of the item you want to delete: ")
        val index = scanner.nextInt()
        gamer.gamesSearched.removeAt(index)
    }
    println("Updated list of games: ")
    gamer.gamesSearched.forEach {
        println("Title: ${it?.title}")
    }
}

