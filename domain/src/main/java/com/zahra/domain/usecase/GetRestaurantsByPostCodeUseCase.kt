package com.zahra.domain.usecase

import com.zahra.domain.data.Either
import com.zahra.domain.data.Restaurant
import com.zahra.domain.repository.TakeAwayRepository
import javax.inject.Inject

interface GetRestaurantsByPostCodeUseCase {
    suspend operator fun invoke(postCode: String?): Either<List<Restaurant>?, String>
}

class GetRestaurantsByPostCodeUseCaseImp @Inject constructor(
    private val repository: TakeAwayRepository
) : GetRestaurantsByPostCodeUseCase {
    override suspend fun invoke(postCode: String?): Either<List<Restaurant>?, String> = repository
        .getRestaurantListByPostCode(postCode)
}