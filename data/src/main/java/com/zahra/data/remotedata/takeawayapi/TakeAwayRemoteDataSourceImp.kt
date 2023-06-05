package com.zahra.data.remotedata.takeawayapi

import com.zahra.data.remotedata.ApiService
import com.zahra.domain.data.Restaurant
import javax.inject.Inject

class TakeAwayRemoteDataSourceImp @Inject constructor(
    private val service: ApiService
) : TakeAwayRemoteDataSource {
    override suspend fun getRestaurantsByPostalCode(postCode: String?): List<Restaurant> = service
        .getRestaurantsByPostCode(postCode)
        .toRestaurantList()
}


