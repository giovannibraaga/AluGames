package br.com.giovanni.alugames.data

import br.com.giovanni.alugames.utils.toEntity
import br.com.giovanni.alugames.utils.toModel
import org.example.br.com.giovanni.alugames.models.Game
import javax.persistence.EntityManager

class GamesDAO(manager: EntityManager) : DAO<Game, GameEntity>(manager, GameEntity::class.java) {

    override fun toEntity(objeto: Game): GameEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GameEntity): Game {
        return entity.toModel()
    }
}