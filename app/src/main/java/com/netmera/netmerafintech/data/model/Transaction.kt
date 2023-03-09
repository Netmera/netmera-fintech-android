package com.netmera.netmerafintech.data.model

import com.netmera.netmerafintech.R

data class Transaction (
    var icon: Int = R.drawable.shopping_bag,
    var iconContainerColor: Int = R.color.blue,
    var name: String? = "",
    val price: String? = "",
    var priceColor: Int = R.color.black,
    var transactionId: Int? = null,
    var type: String? = "",
    )