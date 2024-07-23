package br.com.giovanni.alugames.main

import br.com.giovanni.alugames.data.Database
import br.com.giovanni.alugames.data.PlansDAO
import br.com.giovanni.alugames.models.FreePlan
import br.com.giovanni.alugames.models.SubscriptionPlan

fun main() {
    val avulso = FreePlan("BRONZE")
    val prata = SubscriptionPlan("PRATA", 9.90, 3, 0.15)
    val ouro = SubscriptionPlan("OURO", 19.90, 5, 0.20)
    val platina = SubscriptionPlan("PLATINA", 29.90, 10, 0.30)
    val diamante = SubscriptionPlan("DIAMANTE", 49.90, 20, 0.50)

    val manager = Database.getEntityManager()
    val plansDAO = PlansDAO(manager)

    plansDAO.add(avulso)
    plansDAO.add(prata)
    plansDAO.add(ouro)
    plansDAO.add(platina)
    plansDAO.add(diamante)

    val plansList = plansDAO.getList()
    println(plansList)

    manager.close()
}
