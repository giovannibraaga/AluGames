package br.com.giovanni.alugames.utils

import br.com.giovanni.alugames.data.GamerEntity
import br.com.giovanni.alugames.models.Gamer
import br.com.giovanni.alugames.models.GamerInfoJson

fun GamerInfoJson.createGamer(): Gamer {
    return Gamer(
        this.nome,
        this.email,
        this.dataNascimento,
        this.usuario
    )
}

fun Gamer.toEntity(): GamerEntity {
    return GamerEntity(
        this.name,
        this.email,
        this.birthDate,
        this.user,
        this.id,
        this.plan.toEntity()
    )
}

fun GamerEntity.toModel(): Gamer {
    return Gamer(
        this.name,
        this.email,
        this.birthDate,
        this.user,
        this.id
    )
}