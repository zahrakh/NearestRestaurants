package com.zahra.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zahra.presentation.restaurantdetails.RestaurantDetailsScreen
import com.zahra.presentation.restaurantslist.RestaurantsListScreen
import com.zahra.presentation.splash.SplashScreen


@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route,
    ) {
        composable(
            route = Screens.SplashScreen.route,
        ) {
            SplashScreen(
                navigateToFirstPage = {
                    navController.navigate(Screens.ListScreen.route) {
                        popUpTo(Screens.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }

        composable(route = Screens.ListScreen.route) {
            RestaurantsListScreen(
                navController = navController
            )
        }


        composable(route = Screens.DetailsScreen.route) {
            RestaurantDetailsScreen(

            )
        }
    }
}