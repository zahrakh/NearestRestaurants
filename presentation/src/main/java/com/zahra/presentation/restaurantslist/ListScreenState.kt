package com.zahra.presentation.restaurantslist

import com.zahra.domain.data.Restaurant

data class ListScreenState(
    val isLoading: Boolean = false,
    val restaurantList: List<Restaurant> = arrayListOf()
)