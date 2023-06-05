package com.zahra.presentation.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.zahra.presentation.R
import com.zahra.presentation.ui.animation.FadeInScreen
import com.zahra.presentation.ui.theme.OrangeColor


@Composable
fun ErrorView(
    errorMessage: String,
    ocClick: () -> Unit,
    visible: Boolean,
) {
    FadeInScreen(visible = visible) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row {
                Text(
                    color = OrangeColor,
                    textAlign = TextAlign.Center,
                    text = errorMessage
                )
                Spacer(modifier = Modifier.height(18.dp))
            }
            Row {
                Button(text = stringResource(id = R.string.retry), onClick = ocClick)
            }
        }
    }
}
