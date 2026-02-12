package com.synder.ui.components

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@Composable
fun <T> SwipeableCardStack(
    items: List<T>,
    onSwipeLeft: (T) -> Unit,
    onSwipeRight: (T) -> Unit,
    cardContent: @Composable BoxScope.(item: T, isTop: Boolean) -> Unit
) {
    if (items.isEmpty()) return

    val top = items.first()
    val next = items.getOrNull(1)

    var offsetX by remember(top) { mutableStateOf(0f) }
    val threshold = with(LocalDensity.current) { 120.dp.toPx() }
    val animatedOffsetX by animateFloatAsState(offsetX, label = "cardOffset")

    Box(modifier = Modifier.fillMaxSize()) {
        if (next != null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .offset { IntOffset(0, 20) }
                    .background(Color.White.copy(alpha = 0.07f), RoundedCornerShape(28.dp))
            ) {
                cardContent(next, false)
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .offset { IntOffset(animatedOffsetX.roundToInt(), 0) }
                .pointerInput(top) {
                    detectDragGestures(
                        onDrag = { change, dragAmount ->
                            change.consume()
                            offsetX += dragAmount.x
                        },
                        onDragEnd = {
                            when {
                                offsetX > threshold -> onSwipeRight(top)
                                offsetX < -threshold -> onSwipeLeft(top)
                            }
                            offsetX = 0f
                        }
                    )
                }
                .background(Color.White.copy(alpha = 0.09f), RoundedCornerShape(28.dp))
        ) {
            cardContent(top, true)
        }
    }
}
