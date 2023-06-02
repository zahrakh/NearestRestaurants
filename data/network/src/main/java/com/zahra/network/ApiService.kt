package com.zahra.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.coroutines.GlobalScope
import kotlinx.serialization.json.Json
import okhttp3.MediaType
import retrofit2.Retrofit
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {


  @GET("/restaurants/bypostcode/{postCode}")
  suspend fun getRestaurantsByPostCode(
    @Path("postCode") code: String="ec4m",
  ): RestaurantsResponse

}






