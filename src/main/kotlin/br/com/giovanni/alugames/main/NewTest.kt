package br.com.giovanni.alugames.main

import br.com.giovanni.alugames.data.Database
import br.com.giovanni.alugames.data.GamersDAO
import br.com.giovanni.alugames.data.PlansDAO
import br.com.giovanni.alugames.models.Gamer

fun main() {
    val gamer = Gamer("Monica", "monica@email.com", "15/03/1995", "moni")

    val manager = Database.getEntityManager()
    val gamerDAO = GamersDAO(manager)
    val planDAO = PlansDAO(manager)

    gamer.plan = planDAO.findByID(3)

    val dbGamerList = gamerDAO.getList()

    println(dbGamerList)

    manager.close()
}