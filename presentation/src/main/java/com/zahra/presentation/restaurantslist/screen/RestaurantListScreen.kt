package com.zahra.presentation.restaurantslist.screen

import androidx.compose.material.ScaffoldState
import androidx.compose.material.rememberScaffoldState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.zahra.presentation.restaurantslist.ListState
import com.zahra.presentation.ui.theme.NearestRestaurantsTheme

@Composable
fun RestaurantListScreen(
    modifier: Modifier = Modifier,
    restaurantListState: State<ListState>?=null,
    onClickToDetailScreen: (Int) -> Unit = {},
) {
    val scaffoldState: ScaffoldState = rememberScaffoldState()
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    NearestRestaurantsTheme() {
        RestaurantListScreen()
    }
}