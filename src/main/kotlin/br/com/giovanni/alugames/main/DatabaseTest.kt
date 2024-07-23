package br.com.giovanni.alugames.main

import br.com.giovanni.alugames.data.Database
import br.com.giovanni.alugames.data.GamersDAO
import br.com.giovanni.alugames.data.GamesDAO
import br.com.giovanni.alugames.models.Gamer
import org.example.br.com.giovanni.alugames.models.Game

fun main() {
    val newGame = Game(
        "The Last of Us Part I",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/1888930/header.jpg?t=1686864554",
        5.99,
        "Uma aventura pós-apocalíptica de sobrevivência em um mundo infestado por zumbis e facções em conflito."
    )
    val game2 = Game(
        "Dandara",
        "https://cdn.cloudflare.steamstatic.com/steam/apps/612390/header.jpg?t=1674055293",
        9.99,
        "Um jogo de plataforma e ação com elementos de metroidvania, onde você controla a heroína Dandara em sua luta para libertar um mundo repleto de opressão e tirania."
    )

    val manager = Database.getEntityManager()

    val gameDAO = GamesDAO(manager)

//    gameDAO.add(newGame)
    val gameList: List<Game> = gameDAO.getList()
    println(gameList)

    val newGamer = Gamer("Giovanni", "giovanni@a.com", "01/01/1999", "giovanni")

    val gamerDAO = GamersDAO(manager)

//    gamerDAO.addGamer(newGamer)

    val gamersList: List<Gamer> = gamerDAO.getList()
    println(gamersList)


    manager.close()
}