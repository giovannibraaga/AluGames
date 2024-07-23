package br.com.giovanni.alugames.utils

import br.com.giovanni.alugames.data.GameEntity
import br.com.giovanni.alugames.models.GamesInfoJson
import org.example.br.com.giovanni.alugames.models.Game

fun GamesInfoJson.createGame(): Game {
    return Game(this.titulo, this.capa, this.preco, this.descricao)
}

fun Game.toEntity(): GameEntity {
    return GameEntity(this.title, this.thumb, this.price, this.description, this.id)
}

fun GameEntity.toModel(): Game {
    return Game(
        this.title,
        this.thumb,
        this.price,
        this.description,
        this.id
    )
}