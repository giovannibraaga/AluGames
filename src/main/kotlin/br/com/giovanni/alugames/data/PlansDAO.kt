package br.com.giovanni.alugames.data

import br.com.giovanni.alugames.models.FreePlan
import br.com.giovanni.alugames.models.Plan
import br.com.giovanni.alugames.models.SubscriptionPlan
import br.com.giovanni.alugames.utils.toEntity
import br.com.giovanni.alugames.utils.toModel
import javax.persistence.EntityManager

class PlansDAO(manager: EntityManager) : DAO<Plan, PlanEntity>(manager, PlanEntity::class.java) {
    override fun toEntity(plan: Plan): PlanEntity {
        return plan.toEntity()
    }

    override fun toModel(entity: PlanEntity): Plan {
        return entity.toModel()!!
    }
}