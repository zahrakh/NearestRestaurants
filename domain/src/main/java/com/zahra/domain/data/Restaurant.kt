package com.zahra.domain.data

data class Restaurant(
    val id: Int?,
    val name: String?,
    val logoUrl: String?,
    val isOpen: Boolean = true,
    val rate: Float? = null,
    val cuisineTypes: List<CuisineTypes>? = null,
) {
    fun cuisineTypesDescription(): String {
        var cousinType = ""
        cuisineTypes?.forEach {
            cousinType = cousinType.plus(" • ").plus(it.name).plus("\n")
        }
        return cousinType
    }
}

data class CuisineTypes(
    val id: Int? = null,
    val isTopCuisine: Boolean? = null,
    val name: String? = null,
    val seoName: String? = null
)
