package com.zahra.presentation.restaurantslist.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.zahra.domain.data.Restaurant
import com.zahra.presentation.ui.component.EmptyView
import com.zahra.presentation.ui.component.GifImageView
import com.zahra.presentation.ui.component.RatingView
import com.zahra.presentation.ui.theme.NearestRestaurantsTheme

@Composable
fun RestaurantListScreen(
    modifier: Modifier = Modifier,
    restaurantList: List<Restaurant>? = null,
    onClickToDetailScreen: (Restaurant) -> Unit = {},
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        if (!restaurantList.isNullOrEmpty()) {
            RestaurantList(restaurantList = restaurantList) { restaurantId ->
                onClickToDetailScreen(restaurantId)
            }
        }
        EmptyView(visible = restaurantList.isNullOrEmpty())
    }
}


@Composable
fun RestaurantList(
    restaurantList: List<Restaurant> = arrayListOf(),
    onItemClicked: (item: Restaurant) -> Unit = { },
) {
    LazyColumn(
        contentPadding = PaddingValues(bottom = 16.dp)
    ) {
        items(restaurantList) { item ->
            RestaurantItemRow(item = item, onItemClicked = onItemClicked)
        }
    }
}

@Composable
fun RestaurantItemRow(
    item: Restaurant,
    onItemClicked: (clickedItem: Restaurant) -> Unit = { },
) {
    Card(shape = RoundedCornerShape(8.dp),
        backgroundColor = MaterialTheme.colors.surface,
        elevation = 2.dp,
        modifier = Modifier
            .fillMaxWidth()
            .padding(start = 16.dp, end = 16.dp, top = 8.dp)
            .clickable { onItemClicked(item) }) {
        Box() {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp),
                verticalAlignment = Alignment.CenterVertically
            ) {
                // restaurant logo
                GifImageView(
                    url = item.logoUrl ?: "",
                )
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(start = 12.dp)
                ) {

                    // Text that shows the name
                    Text(
                        text = item.name ?: "",
                        maxLines = 1,
                        overflow = TextOverflow.Clip,
                        style = TextStyle(
                            fontSize = 16.sp, color = Color.Black
                        )
                    )
                    Spacer(modifier = Modifier.height(8.dp))

                    // Rating view
                    RatingView(
                        modifier = Modifier
                            .wrapContentSize()
                            .height(15.dp),
                        rating = item.rate ?: 0.0f
                    )

                    Spacer(modifier = Modifier.height(16.dp))

                    // Text that shows the food type as description
                    Text(
                        modifier = Modifier.padding(top = 2.dp),
                        text = item.cuisineTypesDescription(),
                        maxLines = 5,
                        overflow = TextOverflow.Ellipsis,
                        style = TextStyle(
                            fontSize = 14.sp, color = Color.Gray
                        )
                    )

                }
            }
        }
    }

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    NearestRestaurantsTheme() {
        RestaurantListScreen()
    }
}



