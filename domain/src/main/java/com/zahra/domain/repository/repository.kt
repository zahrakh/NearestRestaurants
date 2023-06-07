package com.zahra.domain.repository

import com.zahra.domain.data.Either
import com.zahra.domain.data.Restaurant

interface TakeAwayRepository {
    suspend fun getRestaurantListByPostCode(postCode: String?): Either<List<Restaurant>?, String>
    suspend fun getRestaurantListByLocation(lat:Double?,lon:Double?): Either<List<Restaurant>?, String>
}