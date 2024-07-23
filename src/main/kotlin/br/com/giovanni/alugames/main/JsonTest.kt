package br.com.giovanni.alugames.main

import br.com.giovanni.alugames.models.Period
import br.com.giovanni.alugames.models.SubscriptionPlan
import br.com.giovanni.alugames.services.APIUsage
import com.google.gson.GsonBuilder
import java.io.File
import java.math.BigDecimal
import java.time.LocalDate

fun main() {
    val usage = APIUsage()

    val gamerList = usage.gamerSearch()
    val gameList = usage.gameSearchJson()

    val gamerCarol = gamerList[3]

    val residentEvilGame = gameList[10]
    val spiderManGame = gameList[13]
    val theLastOfUsGame = gameList[2]
    val godOfWarGame = gameList[7]
    val dandaraGame = gameList[5]
    val assasinsCreedGame = gameList[4]
    val cyberGame = gameList[6]
    val skyrinGame = gameList[18]

    val period0 = Period(LocalDate.now(), LocalDate.now().plusDays(14))
    val period1 = Period(LocalDate.now(), LocalDate.now().plusDays(3))
    val period2 = Period(LocalDate.now(), LocalDate.now().plusDays(10))

    gamerCarol.rentGame(residentEvilGame, period0)
    gamerCarol.rentGame(spiderManGame, period1)
    gamerCarol.rentGame(theLastOfUsGame, period2)
    gamerCarol.rentGame(spiderManGame, period1)

    val gamerCamila = gamerList[5]
    gamerCamila.plan = SubscriptionPlan("SILVER", 9.90, 3, 0.15)

    gamerCamila.rentGame(spiderManGame, period0)
    gamerCamila.rentGame(theLastOfUsGame, period2)
    gamerCamila.rentGame(residentEvilGame, period1)
    gamerCamila.rentGame(godOfWarGame, period1)

    gamerCamila.recommend(7)
    gamerCamila.recommend(10)
    gamerCamila.recommend(8)
    gamerCamila.recommend(1)

    gamerCamila.rentGame(godOfWarGame, period1)

    gamerCamila.recommendGame(spiderManGame, 7)
    gamerCamila.recommendGame(theLastOfUsGame, 10)
    gamerCamila.recommendGame(assasinsCreedGame, 8)
    gamerCamila.recommendGame(cyberGame, 7)
    gamerCamila.recommendGame(dandaraGame, 8)
    gamerCamila.recommendGame(skyrinGame, 8)
    gamerCamila.recommendGame(residentEvilGame, 6)

    gamerCarol.recommendGame(godOfWarGame, 8)
    gamerCarol.recommendGame(theLastOfUsGame, 5)

    println(gamerCarol.recommendedGames)
    println(gamerCamila.recommendedGames)

    val gson = GsonBuilder().excludeFieldsWithoutExposeAnnotation().create()
    val serialize = gson.toJson(gamerCamila.recommendedGames)

    val file = File("recommendedGames-${gamerCamila.name}.json")
    file.writeText(serialize)

    println(file.absolutePath)

    val gamerGui = gamerList[2]

    gamerGui.recommendGame(spiderManGame, 10)
    gamerGui.recommendGame(theLastOfUsGame, 10)
    gamerGui.recommendGame(assasinsCreedGame, 7)
    gamerGui.recommendGame(cyberGame, 1)
    gamerGui.recommendGame(dandaraGame, 1)
    gamerGui.recommendGame(skyrinGame, 5)
    gamerGui.recommendGame(residentEvilGame, 7)

//    val gamerGuiFile = File("recommendedGames-${gamerGui.name}.json")
//    gamerGuiFile.writeText(serialize)
}