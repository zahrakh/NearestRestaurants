package com.zahra.presentation.ui.component

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.AsyncImage
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import com.zahra.presentation.R

@Composable
fun GifImageView(
    url: String,
    modifier: Modifier = Modifier
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current)
        .components {
            if (SDK_INT >= 28) {
                add(ImageDecoderDecoder.Factory())
            } else {
                add(GifDecoder.Factory())
            }
        }
        .crossfade(true)
        .build()

    AsyncImage(
        modifier = Modifier
            .clip(shape = CircleShape)
            .size(56.dp),
        model = url,
        placeholder = painterResource(R.drawable.ic_place_holder),
        error = painterResource(R.drawable.ic_place_holder),
        imageLoader = imageLoader,
        contentDescription = stringResource(R.string.desc_logo),
    )
}