package com.zahra.presentation.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun Button(
    number: Int,
    onClick: (digit: Int) -> Unit,
) {
    OutlinedButton(
        onClick = { onClick(number) },
        modifier = Modifier
            .size(60.dp)
            .aspectRatio(1f)
            .padding(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = DarkGray,
            contentColor = White
        ),
        shape = CircleShape,
    ) {
        Text(
            text = number.toString(),
            fontSize = 22.sp,
            color = White
        )
    }
}