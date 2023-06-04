package com.zahra.presentation.restaurantslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahra.domain.usecase.GetRestaurantsUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RestaurantListViewModel(
    private val getRestaurantsUseCase: GetRestaurantsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<ListScreenState> = MutableStateFlow(ListScreenState())
    val state = _state.asStateFlow()

    fun loadRestaurant(postCode: String?) = viewModelScope.launch {
        _state.value = _state.value.copy(isLoading = true)
        val result = getRestaurantsUseCase.invoke(postCode)
        _state.value = _state.value.copy(restaurantList = result, isLoading = false)
    }

}