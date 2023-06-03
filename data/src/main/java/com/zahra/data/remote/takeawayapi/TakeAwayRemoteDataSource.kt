package com.zahra.data.remote.takeaway

import com.zahra.domain.data.Restaurant

interface TakeAwayRemoteDataSource {
    suspend fun getRestaurantsByPostalCode(postCode: String?): List<com.zahra.domain.data.Restaurant>
}