package com.zahra.data.remotedata.takeawayapi

import androidx.annotation.StringRes

interface StringProvider {

    fun getString(@StringRes id: Int): String
}