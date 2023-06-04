package com.zahra.domain.usecase

import com.zahra.domain.data.Restaurant
import com.zahra.domain.repository.TakeAwayRepository

interface GetRestaurantsUseCase {
    suspend operator fun invoke(postCode: String?): List<Restaurant>
}

class GetRestaurantsUseCaseImp(
    private val repository: TakeAwayRepository
) : GetRestaurantsUseCase {
    override suspend fun invoke(postCode: String?): List<Restaurant> = repository
        .getRestaurantListByPostCode(postCode)
}