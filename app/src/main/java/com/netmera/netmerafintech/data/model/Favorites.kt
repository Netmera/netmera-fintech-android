/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Favorites (
    var favoriteId: Int? = null,
    var icon: Int?,
    var lastFourDigit: String? = "",
    var lastName: String? = "",
    var name: String = "",
): Parcelable