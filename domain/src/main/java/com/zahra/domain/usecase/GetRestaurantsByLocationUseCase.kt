package com.zahra.domain.usecase

import com.zahra.domain.data.Either
import com.zahra.domain.data.Restaurant
import com.zahra.domain.repository.TakeAwayRepository
import javax.inject.Inject

interface GetRestaurantsByLocationUseCase {
    suspend operator fun invoke(lat: Double?, lon: Double?): Either<List<Restaurant>?, String>

}

class GetRestaurantsByLocationUseCaseImp @Inject constructor(
    private val repository: TakeAwayRepository
) : GetRestaurantsByLocationUseCase {
    override suspend fun invoke(lat: Double?, lon: Double?): Either<List<Restaurant>?, String> =
        repository.getRestaurantListByLocation(lat, lon)
}