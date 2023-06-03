package com.zahra.presentation.ui.component

import androidx.compose.animation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import io.softpay.softpos.presentation.animation.fadeInScreen

@Preview
@OptIn(ExperimentalAnimationApi::class)
@Composable
fun ProgressView(visible: Boolean=true) = fadeInScreen(visible) {
    CircularProgressIndicator(
        modifier = Modifier
            .padding(
                start = 24.dp,
                top = 20.dp,
                end = 20.dp,
                bottom = 4.dp)
            .width(80.dp)
            .height(80.dp)

    )
}



