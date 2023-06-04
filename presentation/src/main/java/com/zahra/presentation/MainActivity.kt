package com.zahra.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zahra.presentation.ui.navigation.Navigation
import com.zahra.presentation.ui.theme.NearestRestaurantsTheme


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            NearestRestaurantsTheme {
                // A surface container using the 'background' color from the theme
                Navigation()
            }
        }
    }
}





