package com.zahra.data.remote.takeawayapi

import com.zahra.data.remote.ApiService
import com.zahra.domain.data.Restaurant

class TakeAwayRemoteDataSourceImp(
    private val service: ApiService
) : TakeAwayRemoteDataSource {
    override suspend fun getRestaurantsByPostalCode(postCode: String?): List<Restaurant> = service
        .getRestaurantsByPostCode(postCode)
        .toRestaurantList()
}


