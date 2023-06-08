package com.zahra.data.repository


import com.google.common.truth.Truth.assertThat
import com.zahra.data.remotedata.dto.RestaurantsDto
import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import com.zahra.data.remotedata.takeawayapi.TakeAwayRemoteDataSource
import com.zahra.domain.data.Either
import com.zahra.domain.data.Restaurant
import com.zahra.domain.repository.TakeAwayRepository
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class TakeAwayRepositoryImpTest {

    private lateinit var takeAwayRemoteDataSource: TakeAwayRemoteDataSource
    private lateinit var repository: TakeAwayRepository

    @Before
    fun setUp() {
        takeAwayRemoteDataSource = Mockito.mock(TakeAwayRemoteDataSource::class.java)
        repository = TakeAwayRepositoryImp(takeAwayRemoteDataSource)
    }

    @Test
    fun `test get restaurants by postCode success and convert http with https`(): Unit = runBlocking {
        `when`(takeAwayRemoteDataSource.getRestaurantsByPostalCode("ec4m"))
            .thenReturn(
                Either.Success(
                    RestaurantsResponseDto(
                        area = null,
                        metaData = null,
                        restaurants = getRestaurantsList(),
                        shortResultText = null,
                        deliveryFees = null,
                        promotedPlacement = null,
                        restaurantSets = null,
                        cuisineSets = null,
                        views = null,
                        dishes = null,
                    )
                )
            )

        val result = repository.getRestaurantListByPostCode(postCode = "ec4m")
        assertThat(result).isInstanceOf(Either.Success::class.java)
        val success: Either.Success<List<Restaurant>?, String> = result as Either.Success
        val data: List<Restaurant>? = success.data
        assertThat(success.data).hasSize(1)
        val restaurant = Restaurant(
            id = 1,
            name = "JILA",
            logoUrl = "https://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/163019.gif",
            isOpen = true,
            rate = 2.1f,
            cuisineTypes = null,
        )

        assertThat(data?.get(0)).isEqualTo(restaurant)
    }

    private fun getRestaurantsList(): List<RestaurantsDto> {
        return listOf(
            RestaurantsDto(
                id = 1,
                name = "JILA",
                logoUrl = "http://d30v2pzvrfyzpo.cloudfront.net/uk/images/restaurants/163019.gif",
                isOpenNow = true,
                ratingStars = 2.1,
                cuisineTypes = null,
            )
        )
    }
}

