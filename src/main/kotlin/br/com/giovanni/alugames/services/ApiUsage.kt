package br.com.giovanni.alugames.services

import com.google.gson.Gson
import com.google.gson.JsonSyntaxException
import org.example.br.com.giovanni.alugames.modelo.GameInfo
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse.BodyHandlers

class APIUsage {
    fun gameSearch(id: String): GameInfo? {
        val url = "https://www.cheapshark.com/api/1.0/games?id=$id"

        val client: HttpClient = HttpClient.newHttpClient()
        val request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .build()

        val response = client
            .send(request, BodyHandlers.ofString())

        val json = response.body()

        val gson = Gson()
        val myGameInfo = try {
            gson.fromJson(json, GameInfo::class.java)
        } catch (e: JsonSyntaxException) {
            null
        }
        return myGameInfo
    }
}