package br.com.giovanni.alugames.utils

import br.com.giovanni.alugames.data.FreePlanEntity
import br.com.giovanni.alugames.data.PlanEntity
import br.com.giovanni.alugames.data.SubscriptionPlanEntity
import br.com.giovanni.alugames.models.FreePlan
import br.com.giovanni.alugames.models.Plan
import br.com.giovanni.alugames.models.SubscriptionPlan

fun Plan.toEntity(): PlanEntity {
    return if (this is SubscriptionPlan) {
        SubscriptionPlanEntity(this.type, this.monthlyPayment, this.gamesIncluded, this.discountPercentage, this.id)
    } else {
        FreePlanEntity(this.type, this.id)
    }
}

fun PlanEntity?.toModel(): Plan? {
    return if (this == null) {
        null
    } else if (this is SubscriptionPlanEntity) {
        SubscriptionPlan(this.type, this.monthlyPayment, this.gamesIncluded, this.discountPercentage, this.id)
    } else {
        FreePlan(this.type, this.id)
    }
}