package com.zahra.presentation.restaurantslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahra.domain.usecase.GetRestaurantsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class RestaurantListViewModel @Inject constructor(
    private val getRestaurantsUseCase: GetRestaurantsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<ListScreenState> = MutableStateFlow(ListScreenState())
    val state = _state.asStateFlow()

    fun loadRestaurant(postCode:String?=null) = viewModelScope.launch {
        _state.value = _state.value.copy(isLoading = true)
        val result = getRestaurantsUseCase.invoke(postCode)
        _state.value = _state.value.copy(restaurantList = result, isLoading = false)
    }

}