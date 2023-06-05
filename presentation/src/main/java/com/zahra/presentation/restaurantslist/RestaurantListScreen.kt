package com.zahra.presentation.restaurantslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun RestaurantsListScreen(
    navController: NavController
) {
    val viewModel = hiltViewModel<RestaurantListViewModel>()
    viewModel.loadRestaurant("ec4m")
    BackgroundCard(navController)
}


@Composable
fun BackgroundCard(navController: NavController) {
    Surface(color = Color.Gray, modifier = Modifier.fillMaxSize()) {

        Column(
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Button(
                modifier = Modifier
                    .width(200.dp)
                    .height(54.dp),
                onClick = {

                },
                enabled = true,
                shape = RoundedCornerShape(23.dp),

                ) {
                Text(text = "Start", color = Color.White)

            }
            Spacer(modifier = Modifier.padding(25.dp))

        }


    }
}
