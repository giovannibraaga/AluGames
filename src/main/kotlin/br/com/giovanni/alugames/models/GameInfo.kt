package org.example.br.com.giovanni.alugames.modelo

data class GameInfo(val info: APIInfoShark) {
    override fun toString(): String {
        return info.toString()
    }
}