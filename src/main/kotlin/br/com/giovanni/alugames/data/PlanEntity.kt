package br.com.giovanni.alugames.data

import javax.persistence.*

@Entity
@Table(name = "plans")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "plan_type", discriminatorType = DiscriminatorType.STRING)
sealed class PlanEntity(
    var type: String = "",
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Int = 0
) {
    constructor() : this("", 0) {

    }
}

@Entity
@DiscriminatorValue("Free")
open class FreePlanEntity(type: String = "Free Plan", id: Int = 0) : PlanEntity(type, id)

@Entity
@DiscriminatorValue("Subscription")
open class SubscriptionPlanEntity(
    type: String = "Subscription Plan",
    var monthlyPayment: Double = 0.0,
    var gamesIncluded: Int = 0,
    var discountPercentage: Double = 0.0,
    id: Int = 0
) : PlanEntity(type, id)
