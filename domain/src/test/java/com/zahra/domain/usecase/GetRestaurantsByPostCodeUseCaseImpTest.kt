package com.zahra.domain.usecase


import com.google.common.truth.Truth.assertThat
import com.zahra.domain.data.Either
import com.zahra.domain.data.Restaurant
import com.zahra.domain.repository.TakeAwayRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class GetRestaurantsByPostCodeUseCaseImpTest {

    private lateinit var getRestaurantsByPostCodeUseCaseImp: GetRestaurantsByPostCodeUseCaseImp
    private lateinit var takeAwayRepository: TakeAwayRepository


    @Before
    fun setUp() {
        takeAwayRepository = Mockito.mock(TakeAwayRepository::class.java)
        getRestaurantsByPostCodeUseCaseImp = GetRestaurantsByPostCodeUseCaseImp(takeAwayRepository)
    }

    @Test
    fun test(): Unit = runBlocking {
        `when`(takeAwayRepository.getRestaurantListByPostCode("ec4m"))
            .thenReturn(
                Either.Success(
                    arrayListOf(
                        Restaurant(
                            id = 1,
                            name = "JILA",
                            logoUrl = "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/163019.gif",
                            isOpen = true,
                            rate = 2.1f,
                            cuisineTypes = null,
                        ),
                        Restaurant(
                            id = 2,
                            name = "MINA",
                            logoUrl = "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/163019.gif",
                            isOpen = true,
                            rate = 2.1f,
                            cuisineTypes = null,
                        )
                    )
                )
            )

        val result: Either<List<Restaurant>?, String> = getRestaurantsByPostCodeUseCaseImp("ec4m")
        assertThat(result).isInstanceOf(Either.Success::class.java)
        val pageData: List<Restaurant>? = (result as Either.Success).data
        assertThat(pageData).hasSize(2)
        assertThat(pageData).contains(
            Restaurant(
                id = 1,
                name = "JILA",
                logoUrl = "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/163019.gif",
                isOpen = true,
                rate = 2.1f,
                cuisineTypes = null,
            )
        )
        assertThat(pageData).contains(
            Restaurant(
                id = 2,
                name = "MINA",
                logoUrl = "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/163019.gif",
                isOpen = true,
                rate = 2.1f,
                cuisineTypes = null,
            )
        )
    }

}