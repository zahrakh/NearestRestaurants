package com.zahra.data.remotedata.takeawayapi

import com.zahra.data.remotedata.dto.RestaurantsDto
import com.zahra.data.remotedata.dto.RestaurantsResponseDto

internal fun RestaurantsResponseDto.toRestaurantList(): List<com.zahra.domain.data.Restaurant> {
    return this.Restaurants.map { it.mapToRestaurant() }.toMutableList()
}

fun RestaurantsDto.mapToRestaurant(): com.zahra.domain.data.Restaurant =
    com.zahra.domain.data.Restaurant(
        id = this.Id,
        name = this.Name,
        logoUrl = this.LogoUrl
    )
