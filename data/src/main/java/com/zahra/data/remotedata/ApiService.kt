package com.zahra.data.remotedata

import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val BASE_URL = "https://api.themoviedb.org/3/"
    }

    @GET("/restaurants/bypostcode/{postCode}")
    suspend fun getRestaurantsByPostCode(
        @Path("postCode") code: String? = "ec4m",
    ): RestaurantsResponseDto

}






