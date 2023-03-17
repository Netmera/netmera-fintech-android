/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.Netmera.Events

import com.google.gson.annotations.SerializedName
import com.netmera.NetmeraEvent


class ManageEvent : NetmeraEvent() {
    @SerializedName("ea")
    private var account: String? = null
    override fun eventCode(): String {
        return EVENT_CODE
    }

    fun setAccount(account: String?) {
        this.account = account
    }

    companion object {
        private const val EVENT_CODE = "xmiwr"
    }
}