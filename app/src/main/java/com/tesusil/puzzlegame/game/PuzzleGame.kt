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
        return false;
    }
}