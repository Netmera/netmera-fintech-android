package com.netmera.netmerafintech.data.model

import android.graphics.Color

data class Contact (
    var contactId: Int? = null,
    var containerColor: Int = Color.rgb(0, 120, 255),
    var name: String? = "",
)