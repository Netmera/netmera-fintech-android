package com.netmera.netmerafintech.data.model

import com.google.gson.annotations.SerializedName
import com.netmera.NetmeraUser
import com.netmera.internal.Optional


class NMImpactFintechUser : NetmeraUser() {
    @SerializedName("bk")
    private var type: Optional<String>? = null
    fun setType(type: String?) {
        this.type = Optional.fromNullable(type)
    }
}