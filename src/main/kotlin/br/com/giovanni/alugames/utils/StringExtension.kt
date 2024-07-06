package br.com.giovanni.alugames.utils

import java.time.LocalDate
import java.time.Period
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException

fun String.transformInAge(): Int {
    val formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy")
    return runCatching {
        val birthDate = LocalDate.parse(this, formatter)
        val today = LocalDate.now()
        Period.between(birthDate, today).years
    }.onFailure {
        if (it is DateTimeParseException) {
            println("Invalid birth date.")
        } else {
            println("An error occurred while calculating the age.")
        }
    }.getOrDefault(0)
}