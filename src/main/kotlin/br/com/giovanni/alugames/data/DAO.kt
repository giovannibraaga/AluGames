package br.com.giovanni.alugames.data

import javax.persistence.EntityManager

abstract class DAO<TModel, TEntity>(
    protected val manager: EntityManager,
    protected val entityType: Class<TEntity>
) {
    abstract fun toEntity(objeto: TModel): TEntity
    abstract fun toModel(entity: TEntity): TModel

    open fun getList(): List<TModel> {
        val query = manager.createQuery("from ${entityType.simpleName}", entityType)
        return query.resultList.map { entity -> toModel(entity) }
    }

    open fun add(objeto: TModel) {
        val entity = toEntity(objeto)
        manager.transaction.begin()
        manager.persist(entity)
        manager.transaction.commit()
    }

    open fun findByID(id: Int): TModel {
        val query = manager.createQuery("from ${entityType.simpleName} e where e.id = :id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult

        return toModel(entity)
    }

    open fun delete(id: Int) {
        val query = manager.createQuery("from ${entityType.simpleName} e where e.id = :id", entityType)
        query.setParameter("id", id)
        val entity = query.singleResult

        manager.transaction.begin()
        manager.remove(entity)
        manager.transaction.commit()
    }
}