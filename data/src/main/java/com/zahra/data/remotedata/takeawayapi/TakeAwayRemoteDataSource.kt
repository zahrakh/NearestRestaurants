package com.zahra.data.remotedata.takeawayapi

import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import com.zahra.domain.data.Either


interface TakeAwayRemoteDataSource {
    suspend fun getRestaurantsByPostalCode(postCode: String?): Either<RestaurantsResponseDto, String>
    suspend fun getRestaurantsByLocation(lat:Double?,lon:Double?): Either<RestaurantsResponseDto, String>
}