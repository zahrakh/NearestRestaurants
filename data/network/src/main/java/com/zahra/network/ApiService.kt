package com.zahra.network

import com.zahra.network.dto.RestaurantsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

  @GET("/restaurants/bypostcode/{postCode}")
  suspend fun getRestaurantsByPostCode(
    @Path("postCode") code: String="ec4m",
  ): RestaurantsResponseDto

}






