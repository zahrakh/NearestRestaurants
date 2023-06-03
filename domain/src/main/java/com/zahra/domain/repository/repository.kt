package com.zahra.domain.repository

import com.zahra.domain.data.Restaurant

interface TakeAwayRepository {
    suspend fun getRestaurantListByPostCode(postCode: String?):List<Restaurant>
}