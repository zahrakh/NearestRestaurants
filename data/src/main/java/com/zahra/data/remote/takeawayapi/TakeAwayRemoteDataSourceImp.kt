package com.zahra.data.remote.takeaway

import com.zahra.domain.data.Restaurant
import com.zahra.network.ApiService

class TakeAwayRemoteDataSourceImp(
    private val service: ApiService
) : TakeAwayRemoteDataSource {
    override suspend fun getRestaurantsByPostalCode(postCode:String?): List<com.zahra.domain.data.Restaurant> = service
        .getRestaurantsByPostCode(postCode)
        .toRestaurantList()
}


