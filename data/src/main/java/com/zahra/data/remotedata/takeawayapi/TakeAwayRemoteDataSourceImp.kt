package com.zahra.data.remotedata.takeawayapi

import com.zahra.data.R
import com.zahra.data.remotedata.ApiService
import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import com.zahra.domain.data.Either
import retrofit2.HttpException
import java.io.IOException

class TakeAwayRemoteDataSourceImp(
    private val service: ApiService, private var stringProvider: StringProvider
) : TakeAwayRemoteDataSource {

    override suspend fun getRestaurantsByPostalCode(postCode: String?): Either<RestaurantsResponseDto, String> {
        return try {
            val resultDto = service.getRestaurantsByPostCode(postCode)
            Either.Success(resultDto)
        } catch (e: HttpException) {
            Either.Error(error = stringProvider.getString(R.string.error_occurred))
        } catch (e: IOException) {
            Either.Error(error = stringProvider.getString(R.string.check_internet_connection))
        } catch (e: Exception) {
            Either.Error(error = stringProvider.getString(R.string.unknown_error))
        }
    }

    override suspend fun getRestaurantsByLocation(
        lat: Double?, lon: Double?
    ): Either<RestaurantsResponseDto, String> {
        return try {
            val resultDto = service.getRestaurantsByLocation(lat, lon)
            Either.Success(resultDto)
        } catch (e: HttpException) {
            Either.Error(error = stringProvider.getString(R.string.error_occurred))
        } catch (e: IOException) {
            Either.Error(error = stringProvider.getString(R.string.check_internet_connection))
        } catch (e: Exception) {
            Either.Error(error = stringProvider.getString(R.string.unknown_error))
        }
    }
}


