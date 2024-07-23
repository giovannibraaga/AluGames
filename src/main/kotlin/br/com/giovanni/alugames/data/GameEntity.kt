package br.com.giovanni.alugames.data

import java.math.BigDecimal
import javax.persistence.*

@Entity
@Table(name = "games")
open class GameEntity(
    val title: String = "Game title",
    val thumb: String = "Game thumb",
    val price: Double = 0.0,
    val description: String? = null,
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int = 0
) {

}