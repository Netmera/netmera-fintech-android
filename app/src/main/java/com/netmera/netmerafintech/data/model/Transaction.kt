package com.netmera.netmerafintech.data.model

import com.netmera.netmerafintech.R

data class Transaction (
    var transactionId: Int? = null,
    var name: String? = "",
    val price: String? = "",
    var icon: Int = R.drawable.shopping_bag,
    var iconContainerColor: Int = R.color.blue,
    var type: String? = "",
    var priceColor: Int? = R.color.black,
    )