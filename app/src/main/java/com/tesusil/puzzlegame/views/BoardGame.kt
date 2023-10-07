package com.tesusil.puzzlegame.views

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import com.tesusil.puzzlegame.game.ShiftDirection
import com.tesusil.puzzlegame.game.Tile
import kotlin.math.sqrt

@Composable
fun BoardGame(tilesList: List<Tile>, onTileClick: (Int, ShiftDirection) -> Unit) {
    val boardSize = sqrt(tilesList.size.toFloat()).toInt()
    val gridItems = tilesList.chunked(boardSize)

    Column {
        gridItems.forEachIndexed { rowIndex, tilesRow ->
            Row {
                tilesRow.forEachIndexed { tileIndex, tile ->
                    val itemIndex = (rowIndex * boardSize) + tileIndex
                    TileItem(
                        tileNumber = tile.number,
                        keyIndex = itemIndex,
                        backgroundColor = tile.backgroundColor,
                        onTileClick = { index, direction ->
                            onTileClick(index, direction)
                        })
                }
            }
        }
    }
}

@Preview
@Composable
fun BoardGamePreview() {
    val tileList = MutableList(size = 4 * 4) { Tile(it, Color.Blue) }
    BoardGame(tileList, onTileClick = { _, _ -> })
}