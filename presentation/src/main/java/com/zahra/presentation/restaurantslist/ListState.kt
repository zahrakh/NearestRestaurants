package com.zahra.presentation.restaurantslist

import com.zahra.domain.data.Restaurant

data class ListState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val restaurantList: List<Restaurant> = arrayListOf()
)