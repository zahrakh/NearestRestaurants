package com.zahra.presentation.ui.component

import android.os.Build.VERSION.SDK_INT
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil.ImageLoader
import coil.compose.rememberAsyncImagePainter
import coil.decode.GifDecoder
import coil.decode.ImageDecoderDecoder
import coil.request.ImageRequest
import com.zahra.presentation.R

@Composable
fun GifImageView(
    url: String,
) {
    val imageLoader = ImageLoader.Builder(LocalContext.current).components {
        if (SDK_INT >= 28) {
            add(ImageDecoderDecoder.Factory())
        } else {
            add(GifDecoder.Factory())
        }
    }.crossfade(true)
        .placeholder(R.drawable.ic_place_holder)
        .error(R.drawable.ic_place_holder)
        .build()


    Image(
        painter = rememberAsyncImagePainter(
            ImageRequest.Builder(LocalContext.current).data(url).build(), imageLoader = imageLoader
        ),
        contentDescription = stringResource(id = R.string.desc_logo),
        modifier = Modifier
            .clip(shape = CircleShape)
            .size(56.dp),
    )


}