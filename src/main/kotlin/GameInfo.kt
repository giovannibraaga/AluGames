package org.example

data class GameInfo(val info: InfoAPIShark) {
    override fun toString(): String {
        return info.toString()
    }
}