package com.zahra.presentation.restaurantslist

import com.zahra.domain.data.Restaurant
import com.zahra.presentation.utils.DEFAULT_POST_CODE

data class ListState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val restaurantList: List<Restaurant>? = null,
    val currentPostCode: String = DEFAULT_POST_CODE,
    val showDialogLocation:Boolean=false
)