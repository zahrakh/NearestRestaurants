package com.zahra.presentation.restaurantslist

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zahra.domain.data.Restaurant
import com.zahra.presentation.restaurantslist.screen.RestaurantListScreen
import com.zahra.presentation.ui.theme.NearestRestaurantsTheme

@Composable
fun RestaurantsListScreen(
    modifier: Modifier = Modifier,
    viewModel: ListViewModel = hiltViewModel(),
    onClickToDetailScreen: (Restaurant) -> Unit = {},
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Surface(
        modifier = modifier.fillMaxSize(), color = MaterialTheme.colors.background
    ) {
        RestaurantListScreen(
            modifier = Modifier,
            screenState = state,
            onClickToDetailScreen = onClickToDetailScreen,
            onRetry = { viewModel.onRetry() },
        )
    }
}


@Preview(showBackground = true)
@Preview(showBackground = true, uiMode = Configuration.UI_MODE_NIGHT_YES)
@Composable
fun HomeFragmentPreview() {
    NearestRestaurantsTheme {
        RestaurantsListScreen()
    }
}


