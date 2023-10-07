package com.tesusil.puzzlegame.game

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf

class PuzzleGame(private val boardSize: Int = DEFAULT_BOARD_SIZE) {

    private val _board = mutableStateOf(List(size = boardSize * boardSize) { it })
    val board: State<List<Int>> = _board

    companion object {
        const val DEFAULT_BOARD_SIZE = 4
    }
    fun startGame() {
        shuffleBoard()
    }
    private fun shuffleBoard() {
        val currentList = _board.value.toMutableList()
        currentList.shuffle()
        _board.value = currentList
    }

    fun moveTile(tileIndex: Int, direction: ShiftDirection): Boolean {
        val newIndex = when(direction) {
            ShiftDirection.UP -> tileIndex - boardSize
            ShiftDirection.DOWN -> tileIndex + boardSize
            ShiftDirection.LEFT -> tileIndex - 1
            ShiftDirection.RIGHT -> tileIndex + 1
        }
        if(newIndex in 0.._board.value.lastIndex) {
            val list = _board.value.toMutableList()
            val tempItem = _board.value[newIndex]
            list[newIndex] = list[tileIndex]
            list[tileIndex] = tempItem
            _board.value = list
        }
        return false
    }
}