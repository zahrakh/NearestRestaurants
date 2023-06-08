package com.zahra.domain.usecase


import com.zahra.domain.repository.TakeAwayRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.kotlin.times
import org.mockito.kotlin.verify

class GetRestaurantsByLocationUseCaseImpTest {

    private lateinit var getRestaurantsByLocationUseCase: GetRestaurantsByLocationUseCase
    private lateinit var takeAwayRepository: TakeAwayRepository

    @Before
    fun setUp() {
        takeAwayRepository = Mockito.mock(TakeAwayRepository::class.java)
        getRestaurantsByLocationUseCase = GetRestaurantsByLocationUseCaseImp(takeAwayRepository)
    }

    @Test
    fun `test useCase must call takeaway repository`(): Unit = runBlocking {
        getRestaurantsByLocationUseCase.invoke(0.0,0.0)
        verify(takeAwayRepository, times(1)).getRestaurantListByLocation(0.0,0.0)
    }

}