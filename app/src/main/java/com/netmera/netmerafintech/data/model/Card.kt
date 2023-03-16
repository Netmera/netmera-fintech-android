/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.data.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Card(
    var cardId: Int = 0,
): Parcelable