package com.zahra.data.remotedata.takeawayapi

import com.zahra.data.remotedata.dto.CuisineTypesDto
import com.zahra.data.remotedata.dto.RestaurantsDto
import com.zahra.data.remotedata.dto.RestaurantsResponseDto
import com.zahra.domain.data.CuisineTypes
import com.zahra.domain.data.Restaurant

internal fun RestaurantsResponseDto.toRestaurantList(): List<Restaurant>? {
    return this.restaurants?.map { it.mapToRestaurant() }?.toMutableList()
}
internal fun CuisineTypesDto.toCuisineType(): CuisineTypes = CuisineTypes(
    id = this.id,
    isTopCuisine = this.isTopCuisine,
    name = this.name,
    seoName = this.seoName,
)
fun RestaurantsDto.mapToRestaurant(): Restaurant {
    var imageUrl = this.logoUrl ?: ""
    if (imageUrl.startsWith("http://")) {
        imageUrl = imageUrl.replace("http://", "https://")
    }
    return Restaurant(
        isOpen = this.isOpenNow ?: false,
        id = this.id,
        name = this.name,
        logoUrl = imageUrl,
        rate = this.ratingStars?.toFloat(),
        cuisineTypes = this.cuisineTypes?.map { it.toCuisineType() }
    )
}
