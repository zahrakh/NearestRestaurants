package com.zahra.presentation.ui.navigation

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash_screen")
    object RestaurantListScreen : Screens("list_screen")
    object RestaurantDetailsScreen : Screens("details_screen")
}