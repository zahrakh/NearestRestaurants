package com.zahra.presentation.restaurantslist

import android.content.res.Configuration
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.zahra.presentation.restaurantslist.screen.RestaurantListScreen
import com.zahra.presentation.ui.theme.NearestRestaurantsTheme

@Composable
fun RestaurantsListScreen(
    modifier: Modifier = Modifier,
    viewModel: ListViewModel = hiltViewModel(),
    onClickToDetailScreen: (Int) -> Unit = {},
) {
    Surface(
        modifier = modifier.fillMaxSize(),
        color = MaterialTheme.colors.background
    ) {
        RestaurantListScreen(
            modifier = Modifier
                .padding(
                    horizontal = 16.dp
                ),
            restaurantListState = viewModel.state.collectAsStateWithLifecycle(),
            onClickToDetailScreen = onClickToDetailScreen,
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


