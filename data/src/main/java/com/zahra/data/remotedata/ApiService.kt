package com.zahra.data.remotedata

import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {

    companion object {
        const val BASE_URL = "https://uk.api.just-eat.io/"
    }

    @GET("restaurants/bypostcode/{postCode}")
    suspend fun getRestaurantsByPostCode(
        @Path("postCode") code: String?,
    ): RestaurantsResponseDto

    @GET("restaurants/bylatlong?latitude={lat}&longitude={lon}")
    suspend fun getRestaurantsByLocation(
        @Path("lat") lat: Double?,
        @Path("lon") lon: Double?,
    ): RestaurantsResponseDto

}






