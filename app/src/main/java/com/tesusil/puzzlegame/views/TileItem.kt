package com.tesusil.puzzlegame.views

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun TileItem(tileNumber: Int, keyIndex: Int, onTileClick :(Int) -> Unit) {
    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(0.5.dp)
            .background(Color.Gray)
            .clickable { onTileClick(keyIndex) },
        contentAlignment = Alignment.Center,
    ) {
        Text(text = tileNumber.toString())
    }
}

@Preview
@Composable
fun TitleItemPreview() {
    TileItem(tileNumber = 1, keyIndex = 1, onTileClick = {})
}