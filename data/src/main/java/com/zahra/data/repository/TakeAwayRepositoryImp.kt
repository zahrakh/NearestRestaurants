package com.zahra.data.repository

import com.zahra.data.remotedata.takeawayapi.TakeAwayRemoteDataSource
import com.zahra.domain.data.Restaurant
import com.zahra.domain.repository.TakeAwayRepository
import javax.inject.Inject

class TakeAwayRepositoryImp @Inject constructor(
    private val takeAwayRemoteDataSource: TakeAwayRemoteDataSource
) : TakeAwayRepository {
    override suspend fun getRestaurantListByPostCode(postCode: String?): List<Restaurant> =
        takeAwayRemoteDataSource.getRestaurantsByPostalCode(postCode)
}