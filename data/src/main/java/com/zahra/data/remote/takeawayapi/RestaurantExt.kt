package com.zahra.data.remote.takeawayapi

import com.zahra.data.remote.dto.RestaurantsDto
import com.zahra.data.remote.dto.RestaurantsResponseDto

internal fun RestaurantsResponseDto.toRestaurantList(): List<com.zahra.domain.data.Restaurant> {
    return this.Restaurants.map { it.mapToRestaurant() }.toMutableList()
}

fun RestaurantsDto.mapToRestaurant(): com.zahra.domain.data.Restaurant =
    com.zahra.domain.data.Restaurant(
        id = this.Id,
        name = this.Name,
        logoUrl = this.LogoUrl
    )
