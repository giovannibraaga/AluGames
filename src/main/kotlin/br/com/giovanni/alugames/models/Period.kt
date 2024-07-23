package br.com.giovanni.alugames.models

import java.time.LocalDate
import java.time.Period

data class Period(val initialDate: LocalDate, val finalDate: LocalDate) {
    val duration = Period.between(initialDate, finalDate).days
}

