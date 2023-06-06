package com.zahra.presentation.ui.component

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahra.presentation.ui.shape.TextFieldBackground


@Composable
fun Button(
    text: String,
    onClick: () -> Unit,
) {
    OutlinedButton(
        onClick = { onClick() },
        modifier = Modifier
            .padding(8.dp)
            .border(
                width = 1.dp, brush = TextFieldBackground, shape = RoundedCornerShape(4.dp)
            ),
        shape = CircleShape,
    ) {
        Text(
            text = text, fontSize = 16.sp, color = White
        )
    }
}