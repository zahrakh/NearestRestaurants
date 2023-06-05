package com.zahra.domain.usecase

import com.zahra.domain.data.Either
import com.zahra.domain.data.Restaurant
import com.zahra.domain.repository.TakeAwayRepository
import javax.inject.Inject

interface GetRestaurantsUseCase {
    suspend operator fun invoke(postCode: String?): Either<List<Restaurant>, String>
}

class GetRestaurantsUseCaseImp @Inject constructor(
    private val repository: TakeAwayRepository
) : GetRestaurantsUseCase {
    override suspend fun invoke(postCode: String?): Either<List<Restaurant>, String> = repository
        .getRestaurantListByPostCode(postCode)
}