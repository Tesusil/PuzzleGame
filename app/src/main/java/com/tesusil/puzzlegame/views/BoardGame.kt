package com.tesusil.puzzlegame.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import kotlin.math.sqrt

@Composable
fun BoardGame(tilesList: List<Int>, onTileClick: (Int) -> Unit) {
    val boardSize = sqrt(tilesList.size.toFloat()).toInt()
    val gridItems = tilesList.chunked(boardSize)

    Column {
        gridItems.forEachIndexed { rowIndex , tilesRow ->
            Row {
                tilesRow.forEachIndexed { tileIndex, tile ->
                    val itemIndex = (rowIndex * boardSize) + tileIndex
                    TileItem(tileNumber = tile, keyIndex = itemIndex , onTileClick = {} )
                }
            }
        }
    }
}

@Preview
@Composable
fun BoardGamePreview() {
    val tileList = MutableList(size = 4*4) { it }
    BoardGame( tileList, onTileClick = {})
}