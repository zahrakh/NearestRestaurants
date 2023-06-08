package com.zahra.presentation.restaurantslist

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.location.Location
import androidx.core.app.ActivityCompat
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.android.gms.location.FusedLocationProviderClient
import com.google.android.gms.location.LocationServices
import com.zahra.domain.data.Either
import com.zahra.domain.usecase.GetRestaurantsByLocationUseCase
import com.zahra.domain.usecase.GetRestaurantsByPostCodeUseCase
import com.zahra.presentation.R
import com.zahra.presentation.utils.DEFAULT_POST_CODE
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val getByPostCodeUseCase: GetRestaurantsByPostCodeUseCase,
    private val getByLocationUseCase: GetRestaurantsByLocationUseCase,
) : ViewModel() {

    private val _state: MutableStateFlow<ListState> = MutableStateFlow(ListState())
    val state = _state.asStateFlow()

    var lastSearchState: LastSearchState = LastSearchState.POSTCODE

    var job: Job? = null

    init {
        getRestaurantByPostCode()
    }

    fun getRestaurantByPostCode(postCode: String? = DEFAULT_POST_CODE) {
        lastSearchState = LastSearchState.POSTCODE

        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            _state.value = _state.value.copy(currentPostCode = postCode ?: DEFAULT_POST_CODE)
            _state.value = _state.value.copy(isLoading = true, errorMessage = null)
            when (val result = getByPostCodeUseCase.invoke(postCode)) {
                is Either.Success -> {
                    _state.value =
                        _state.value.copy(restaurantList = result.data, isLoading = false)
                }

                is Either.Error -> {
                    _state.value = _state.value.copy(
                        isLoading = false,
                        errorMessage = result.error,
                        restaurantList = null
                    )
                }
            }
        }
    }

    private fun getRestaurantByLocation(lat: Double? = 0.0, lon: Double? = 0.0) {
        lastSearchState = LastSearchState.GPS

        job?.cancel()
        job = viewModelScope.launch(Dispatchers.IO) {
            _state.value = _state.value.copy(isLoading = true, errorMessage = null)
            when (val result = getByLocationUseCase.invoke(lat, lon)) {
                is Either.Success -> {
                    _state.value = _state.value.copy(
                        restaurantList = result.data, isLoading = false
                    )
                }

                is Either.Error -> {
                    _state.value = _state.value.copy(
                        restaurantList = null, isLoading = false, errorMessage = result.error
                    )
                }
            }
        }
    }

    fun onRetry() {
        if (lastSearchState == LastSearchState.GPS) {
            getRestaurantByLocation()
        } else {
            getRestaurantByPostCode()
        }
    }

    fun showGoneDialogLocation(show: Boolean = false) {
        _state.value = _state.value.copy(showDialogLocation = show)
    }

    fun searchByGPS(context: Context) {
        val locationProviderClient: FusedLocationProviderClient =
            LocationServices.getFusedLocationProviderClient(context)

        if (ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_FINE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(
                context, Manifest.permission.ACCESS_COARSE_LOCATION
            ) != PackageManager.PERMISSION_GRANTED
        ) {
            _state.value = _state.value.copy(
                errorMessage = context.getString(R.string.no_restaurants_around)
            )
            return
        }
        locationProviderClient.lastLocation.addOnSuccessListener { location: Location? ->
            if (location != null) {
                getRestaurantByLocation(location.latitude, location.longitude)
            } else {
                _state.value = _state.value.copy(
                    errorMessage = context.getString(R.string.insert_post_code_manually)
                )
            }
        }
    }

    fun requestForPermission(showLocationRequest:Boolean) {
        _state.value=_state.value.copy(showLocationRequest=showLocationRequest)
    }

}



