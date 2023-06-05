package com.zahra.data.remotedata.takeawayapi

import com.zahra.data.remotedata.dto.RestaurantsDto
import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import com.zahra.domain.data.Restaurant

internal fun RestaurantsResponseDto.toRestaurantList(): List<com.zahra.domain.data.Restaurant> {
    return this.Restaurants.map { it.mapToRestaurant() }.toMutableList()
}

fun RestaurantsDto.mapToRestaurant(): Restaurant =
    Restaurant(
        id = this.Id,
        name = this.Name,
        logoUrl = this.LogoUrl,
        foodTypesName = "Ghorme sabzi" //todo change it
    )
