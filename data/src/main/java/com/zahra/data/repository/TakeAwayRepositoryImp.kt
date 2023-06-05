package com.zahra.data.repository

import com.zahra.data.remotedata.takeawayapi.TakeAwayRemoteDataSource
import com.zahra.data.remotedata.takeawayapi.toRestaurantList
import com.zahra.domain.data.Either
import com.zahra.domain.data.Restaurant
import com.zahra.domain.repository.TakeAwayRepository
import javax.inject.Inject

class TakeAwayRepositoryImp @Inject constructor(
    private val takeAwayRemoteDataSource: TakeAwayRemoteDataSource
) : TakeAwayRepository {
    override suspend fun getRestaurantListByPostCode(postCode: String?): Either<List<Restaurant>, String> {
        return when (val result = takeAwayRemoteDataSource.getRestaurantsByPostalCode(postCode)) {
            is Either.Success -> {
                Either.Success(result.data.toRestaurantList())
            }

            is Either.Error -> {
                Either.Error(result.error)
            }
        }
    }
}