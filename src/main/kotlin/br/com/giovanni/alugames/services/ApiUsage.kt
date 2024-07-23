package br.com.giovanni.alugames.services

import br.com.giovanni.alugames.models.Gamer
import br.com.giovanni.alugames.models.GamerInfoJson
import br.com.giovanni.alugames.models.GamesInfoJson
import br.com.giovanni.alugames.utils.createGame
import br.com.giovanni.alugames.utils.createGamer
import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import com.google.gson.reflect.TypeToken
import org.example.br.com.giovanni.alugames.models.Game
import org.example.br.com.giovanni.alugames.modelo.GameInfo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class APIUsage {

    private fun dataUsage(url: String): String {
        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        return response.body()
    }

    fun gameSearch(id: String): GameInfo? {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val json = dataUsage(url)

        val gson = Gson()
        val myGameInfo = try {
            gson.fromJson(json, GameInfo::class.java)
        } catch (e: JsonSyntaxException) {
            null
        }
        return myGameInfo
    }

    fun gamerSearch(): List<Gamer> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/gamers.json"

        val json = dataUsage(url)

        val gson = Gson()
        val myGamerType = object : TypeToken<List<GamerInfoJson>>() {}.type
        val gamerList: List<GamerInfoJson> = gson.fromJson(json, myGamerType)

        val gamerConversionList = gamerList.map { gamerInfoJson ->
            gamerInfoJson.createGamer()
        }

        return gamerConversionList
    }

    fun gameSearchJson(): List<Game> {
        val url = "https://raw.githubusercontent.com/jeniblodev/arquivosJson/main/jogos.json"
        val json = dataUsage(url)

        val gson = Gson()
        val myGameType = object : TypeToken<List<GamesInfoJson>>() {}.type
        val gameList: List<GamesInfoJson> = gson.fromJson(json, myGameType)

        val gameConversionList = gameList.map { gamesInfoJson -> gamesInfoJson.createGame() }

        return gameConversionList
    }
}