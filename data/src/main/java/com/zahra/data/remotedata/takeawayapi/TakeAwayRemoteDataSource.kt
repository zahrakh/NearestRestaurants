package com.zahra.data.remotedata.takeawayapi

import com.zahra.domain.data.Restaurant


interface TakeAwayRemoteDataSource {
    suspend fun getRestaurantsByPostalCode(postCode: String?): List<Restaurant>
}