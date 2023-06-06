package com.zahra.domain.data

data class Restaurant(
    val id: Int?,
    val name: String?,
    val logoUrl: String?,
    val foodTypesName: String?,
    val isOpen: Boolean = true,
    val rate: Float = 2.5f
)
