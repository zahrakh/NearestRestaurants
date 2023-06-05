package com.zahra.presentation.ui.component

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.zahra.presentation.ui.animation.FadeInScreen

@Preview
@Composable
fun ProgressView(visible: Boolean=true) = FadeInScreen(visible) {
    CircularProgressIndicator(
        modifier = Modifier
            .padding(
                start = 24.dp,
                top = 20.dp,
                end = 20.dp,
                bottom = 4.dp)
            .width(40.dp)
            .height(40.dp)

    )
}



