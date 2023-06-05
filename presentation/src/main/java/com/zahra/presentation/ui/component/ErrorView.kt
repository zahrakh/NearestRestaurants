package com.zahra.presentation.ui.component

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zahra.presentation.ui.animation.FadeInScreen
import com.zahra.presentation.R


@Composable
fun ErrorView(
    errorMessage: String,
    ocClick: () -> Unit,
    visible: Boolean,
) {
    FadeInScreen(visible = visible) {
        Column(
            modifier = Modifier.padding(5.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Row {
                Text(
                    color = White,
                    textAlign = TextAlign.Center,
                    text = errorMessage
                )
                Spacer(modifier = Modifier.height(18.dp))
            }
        }
        Row {
            Spacer(modifier = Modifier.height(24.dp))
            Button(text = stringResource(id = R.string.retry), onClick = ocClick)
        }

    }
}
