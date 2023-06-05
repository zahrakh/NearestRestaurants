package com.zahra.presentation.navigation

sealed class Screens(val route: String) {
    object SplashScreen : Screens("splash_screen")
    object ListScreen : Screens("list_screen")
    object DetailsScreen : Screens("details_screen")
}