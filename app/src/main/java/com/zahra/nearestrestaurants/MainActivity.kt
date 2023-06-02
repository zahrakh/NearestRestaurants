package com.zahra.nearestrestaurants

import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.lifecycleScope
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import com.zahra.nearestrestaurants.ui.theme.NearestRestaurantsTheme
import com.zahra.network.ApiService
import kotlinx.coroutines.launch
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import java.io.IOException
import java.io.OutputStreamWriter


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        lifecycleScope.launch {
            main(baseContext)
        }
        setContent {
            NearestRestaurantsTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")



                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NearestRestaurantsTheme {
        Greeting("Android")
    }
}


suspend fun main(context: Context) {
    Log.i("LogX","start")
    val json = Json { ignoreUnknownKeys = true }
    val retrofit = Retrofit.Builder().baseUrl("https://uk.api.just-eat.io/")
        .addConverterFactory(
            json.asConverterFactory(
                MediaType.get("application/json"),
            ),
        )
        .build()
    val service = retrofit.create(ApiService::class.java)
    val data = service.getRestaurantsByPostCode()
    Log.i("LogX", "end${data.promotedPlacement?.PromotedRestaurantsMap}")
}

