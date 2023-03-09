package com.netmera.netmerafintech.data.model

import android.graphics.Color
import com.netmera.netmerafintech.R

data class Transaction (
    var transactionId: Int? = null,
    var name: String? = "",
    val price: String? = "",
    var icon: Int = R.drawable.shopping_bag,
    var iconContainerColor: Int = Color.rgb(0, 120, 255),
    var type: String? = "",
    var priceColor: Int? = Color.BLACK,
    )