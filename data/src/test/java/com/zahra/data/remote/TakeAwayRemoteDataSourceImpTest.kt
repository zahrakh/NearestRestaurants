package com.zahra.data.remote

import com.zahra.data.remotedata.ApiService
import com.google.common.truth.Truth.assertThat
import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import com.zahra.data.remotedata.takeawayapi.StringProvider
import com.zahra.data.remotedata.takeawayapi.TakeAwayRemoteDataSource
import com.zahra.data.remotedata.takeawayapi.TakeAwayRemoteDataSourceImp
import com.zahra.domain.data.Either
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.Mockito
import retrofit2.HttpException
import com.zahra.data.R

class TakeAwayRemoteDataSourceImpTest {

    private lateinit var apiService: ApiService
    private lateinit var takeAwayRemoteDataSource: TakeAwayRemoteDataSource
    private lateinit var stringProvider: StringProvider

    @Before
    fun setUp() {
        apiService = Mockito.mock(ApiService::class.java)
        stringProvider = Mockito.mock(StringProvider::class.java)
        takeAwayRemoteDataSource = TakeAwayRemoteDataSourceImp(apiService, stringProvider)
    }

    @Test
    fun `test http exception in get restaurants by postcode`(): Unit = runBlocking {
        val exception = Mockito.mock(HttpException::class.java)
        Mockito.`when`(exception.message).thenReturn("Http test message")
        Mockito.`when`(apiService.getRestaurantsByPostCode(postCode = "ec4m"))
            .thenThrow(exception)

        val result: Either<RestaurantsResponseDto, String> =
            takeAwayRemoteDataSource.getRestaurantsByPostalCode(postCode = "ec4m")
        assertThat(result).isInstanceOf(Either.Error::class.java)
        val error = result as Either.Error
        assertThat(error.error).isEqualTo("Http test message")
    }


    @Test
    fun `test exception in get restaurants by location when http message is null`(): Unit = runBlocking {
        val exception = Mockito.mock(HttpException::class.java)
        Mockito.`when`(exception.message).thenReturn(null)
        Mockito.`when`(apiService.getRestaurantsByLocation(lat = 0.0,lon=0.0))
            .thenThrow(exception)

        Mockito.`when`(stringProvider.getString(R.string.error_occurred))
            .thenReturn("Unfortunately, an error has occurred")
        val result: Either<RestaurantsResponseDto, String> =
            takeAwayRemoteDataSource.getRestaurantsByLocation(lat = 0.0,lon=0.0)
        assertThat(result).isInstanceOf(Either.Error::class.java)
        val error = result as Either.Error
        assertThat(error.error).isEqualTo("Unfortunately, an error has occurred")
    }

}

