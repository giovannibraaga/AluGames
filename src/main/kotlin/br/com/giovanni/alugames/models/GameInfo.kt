package org.example.br.com.giovanni.alugames.modelo

data class GameInfo(val info: InfoAPIShark) {
    override fun toString(): String {
        return info.toString()
    }
}