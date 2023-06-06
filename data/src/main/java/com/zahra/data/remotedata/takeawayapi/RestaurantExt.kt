package com.zahra.data.remotedata.takeawayapi

import com.zahra.data.remotedata.dto.RestaurantsDto
import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import com.zahra.domain.data.Restaurant

internal fun RestaurantsResponseDto.toRestaurantList(): List<Restaurant> {
    return this.Restaurants.map { it.mapToRestaurant() }.toMutableList()
}

fun RestaurantsDto.mapToRestaurant(): Restaurant {
    var imageUrl = this.LogoUrl ?: ""
    if (imageUrl.startsWith("http://")) {
        imageUrl = imageUrl.replace("http://", "https://")
    }
    return Restaurant(
        id = this.Id,
        name = this.Name,
        logoUrl = imageUrl,
        foodTypesName = "Ghorme sabzi" //todo change it
    )
}