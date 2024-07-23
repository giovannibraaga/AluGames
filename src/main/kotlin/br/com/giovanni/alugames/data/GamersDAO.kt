package br.com.giovanni.alugames.data

import br.com.giovanni.alugames.models.Gamer
import br.com.giovanni.alugames.utils.toEntity
import br.com.giovanni.alugames.utils.toModel
import javax.persistence.EntityManager

class GamersDAO(manager: EntityManager) : DAO<Gamer, GamerEntity>(manager, GamerEntity::class.java) {
    override fun toEntity(objeto: Gamer): GamerEntity {
        return objeto.toEntity()
    }

    override fun toModel(entity: GamerEntity): Gamer {
        return entity.toModel().apply { plan = entity.plan.toModel()!! }
    }

}