package com.zahra.presentation.ui.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideOutHorizontally
import androidx.compose.runtime.Composable
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.composable
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.zahra.presentation.splash.SplashScreen


@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navController = rememberAnimatedNavController()
    AnimatedNavHost(
        navController = navController,
        startDestination = Screens.SplashScreen.route,
    ) {
        composable(
            route = Screens.SplashScreen.route,
            exitTransition = { _, _ ->
                slideOutHorizontally(
                    targetOffsetX = { -300 },
                    animationSpec = tween(300, easing = FastOutSlowInEasing)
                ) +
                        fadeOut(animationSpec = tween(400))
            },
            popEnterTransition = { _, _ ->
                fadeIn(animationSpec = tween(400))
            }
        ) {
            SplashScreen(
                navigateToFirstPage = {
                    navController.navigate(Screens.RestaurantListScreen.route) {
                        popUpTo(Screens.SplashScreen.route) {
                            inclusive = true
                        }
                    }
                }
            )
        }


    }


}