/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.data.model

import android.os.Parcelable
import com.netmera.netmerafintech.R
import kotlinx.parcelize.Parcelize

@Parcelize
data class Transaction (
    var category: String? = "",
    var icon: Int = R.drawable.shopping_bag,
    var iconContainerColor: Int = R.color.blue,
    var name: String? = "",
    var numberOfPayments: String? = "",
    var price: String? = "",
    var priceColor: Int = R.color.black,
    var totalAmount: String? = "",
    var transactionId: Int? = null,
    var transactionNumber: String? = "",
    var type: String? = "",
    ) : Parcelable