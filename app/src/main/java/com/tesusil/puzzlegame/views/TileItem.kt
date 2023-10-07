package com.tesusil.puzzlegame.views

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.tesusil.puzzlegame.game.ShiftDirection
import kotlin.math.abs

@Composable
fun TileItem(tileNumber: Int, keyIndex: Int, backgroundColor: Color, onTileClick: (Int, ShiftDirection) -> Unit) {
    var offsetX by remember { mutableStateOf(0f) }
    var offsetY by remember { mutableStateOf(0f) }

    Box(
        modifier = Modifier
            .size(100.dp)
            .padding(0.5.dp)
            .background(backgroundColor)
            .pointerInput(Unit) {
                detectDragGestures(onDragEnd = {
                    Log.d("Felek", "drag end : offset x : $offsetX , offset y : $offsetY")
                    val absX = abs(offsetX)
                    val absY = abs(offsetY)
                    val direction = if (absX > absY) {
                        if (offsetX < 0) ShiftDirection.LEFT else ShiftDirection.RIGHT
                    } else {
                        if (offsetY < 0) ShiftDirection.UP else ShiftDirection.DOWN
                    }
                    onTileClick(keyIndex, direction)
                    offsetX = 0f
                    offsetY = 0f
                }) { change, dragAmount ->
                    val (x, y) = dragAmount
                    if (x < 0 && x < offsetX || x > 0 && x > offsetX) {
                        offsetX = x
                    }
                    if (y < 0 && y < offsetY || y > 0 && y > offsetY) {
                        offsetY = y
                    }
                }
            },
        contentAlignment = Alignment.Center,
    ) {
        Text(text = tileNumber.toString(), color = Color.White)
    }
}

@Preview
@Composable
fun TitleItemPreview() {
    TileItem(tileNumber = 1, keyIndex = 1, Color.Blue, onTileClick = { _, _ ->

    })
}