package com.tesusil.puzzlegame.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.tesusil.puzzlegame.game.PuzzleGame
import com.tesusil.puzzlegame.game.ShiftDirection

@Composable
fun MainScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        val puzzleGame = remember { PuzzleGame() }
        
        BoardGame(puzzleGame.board.value,
            onTileClick = {
                puzzleGame.moveTile(it, ShiftDirection.UP)
            }
        )
        Spacer(modifier = Modifier.height(20.dp))
        Button(onClick = { puzzleGame.startGame() }) {
            Text(text = "Start Game")
        }
    }
}