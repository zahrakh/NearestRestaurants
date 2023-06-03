package com.zahra.presentation.restaurantslist

import androidx.lifecycle.ViewModel
import com.zahra.domain.usecase.GetRestaurantsUseCase

class RestaurantListViewModel(
    private val getRestaurantsUseCase: GetRestaurantsUseCase
) : ViewModel() {
}