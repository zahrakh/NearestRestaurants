package com.zahra.data.remotedata

import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    companion object {
        const val BASE_URL = "https://uk.api.just-eat.io/"
    }

    @GET("restaurants/bypostcode/{postCode}")
    suspend fun getRestaurantsByPostCode(
        @Path("postCode") postCode: String?,
    ): RestaurantsResponseDto

    @GET("restaurants/bylatlong")
    suspend fun getRestaurantsByLocation(
        @Query("latitude") lat: Double?,
        @Query("longitude") lon: Double?,
    ): RestaurantsResponseDto

}






