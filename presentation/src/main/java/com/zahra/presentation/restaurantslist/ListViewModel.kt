package com.zahra.presentation.restaurantslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.zahra.domain.data.Either
import com.zahra.domain.usecase.GetRestaurantsUseCase
import com.zahra.presentation.utils.DEFAULT_POST_CODE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getRestaurantsUseCase: GetRestaurantsUseCase
) : ViewModel() {

    private val _state: MutableStateFlow<ListState> = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    init {
        viewModelScope.launch { getRestaurantByPostCode() }
    }

    private suspend fun getRestaurantByPostCode(postCode: String? = DEFAULT_POST_CODE) {
        _state.value = _state.value.copy(isLoading = true, errorMessage = null)
        when (val result = getRestaurantsUseCase.invoke(postCode)) {
            is Either.Success -> {
                _state.value = _state.value.copy(restaurantList = result.data, isLoading = false)
            }

            is Either.Error -> {
                _state.value = _state.value.copy(isLoading = false, errorMessage = result.error)
            }
        }


    }

}