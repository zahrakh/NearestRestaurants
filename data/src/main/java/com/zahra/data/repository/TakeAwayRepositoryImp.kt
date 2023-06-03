package com.zahra.data.repository

import com.zahra.data.remote.takeawayapi.TakeAwayRemoteDataSource
import com.zahra.domain.data.Restaurant
import com.zahra.domain.repository.TakeAwayRepository

class TakeAwayRepositoryImp(
    private val takeAwayRemoteDataSource: TakeAwayRemoteDataSource
) : TakeAwayRepository {
    override suspend fun getRestaurantListByPostCode(postCode: String?): List<Restaurant> =
        takeAwayRemoteDataSource.getRestaurantsByPostalCode(postCode)
}