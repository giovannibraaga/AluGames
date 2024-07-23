package br.com.giovanni.alugames.data

import javax.persistence.*

@Entity
@Table(name = "gamers")
open class GamerEntity(
    val name: String = "Gamer name",
    val email: String = "gamer@email.com",
    val birthDate: String? = null,
    val user: String? = null,

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0,

    @ManyToOne
    val plan: PlanEntity = FreePlanEntity()
)