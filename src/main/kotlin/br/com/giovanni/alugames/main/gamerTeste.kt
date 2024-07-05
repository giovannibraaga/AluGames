package br.com.giovanni.alugames.main

import br.com.giovanni.alugames.models.Gamer

fun main() {
    val giovanni = Gamer("Giovanni", "giovanni@a.com", "01/01/1999", "giovanni")
    println(giovanni)

    val lara = Gamer("Lara", "lara@gmail.com")
    lara.let {
        it.birthDate = "07/03/2009"
        it.user = "laralinda"
    }.also {
        println(lara)
    }

    val carlos = Gamer("Carlos", "carlos+alugames@gmail.com")
    carlos.let{
        it.birthDate = "12/10/1970"
        it.user = "carlosrausch"
    }
    println(carlos)
}