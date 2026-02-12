package com.synder.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun GlassTopBar(
    title: String,
    subtitle: String
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .blur(14.dp)
            .background(Color.White.copy(alpha = 0.14f), RoundedCornerShape(24.dp))
            .padding(20.dp)
    ) {
        Text(text = title, color = Color.White, fontWeight = FontWeight.Bold, fontSize = 24.sp)
        Text(text = subtitle, color = Color.White.copy(alpha = 0.8f), fontSize = 14.sp)
    }
}
