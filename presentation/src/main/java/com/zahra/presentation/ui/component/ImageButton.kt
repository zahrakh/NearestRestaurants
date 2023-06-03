package com.zahra.presentation.ui.component

import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp


@Composable
fun ImageButton(
    icon: ImageVector,
    onClick: () -> Unit,
    iconColor: Color= Color.White
) {
    OutlinedButton(
        onClick = {
            onClick()
        },
        modifier = Modifier.size(60.dp)
            .aspectRatio(1f)
            .padding(4.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            containerColor = Color.DarkGray,
            contentColor = iconColor
        ),
        shape = CircleShape,
    ) {
        Icon(
            tint = iconColor,
            imageVector = icon,
            contentDescription = null
        )
    }
}