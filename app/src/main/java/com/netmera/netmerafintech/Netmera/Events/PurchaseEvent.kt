/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.Netmera.Events

import com.google.gson.annotations.SerializedName

import com.netmera.NetmeraEvent


class PurchaseEvent : NetmeraEvent() {
    @SerializedName("ea")
    private var amount: String? = null

    @SerializedName("eb")
    private var message: String? = null
    override fun eventCode(): String {
        return EVENT_CODE
    }

    fun setAmount(amount: String?) {
        this.amount = amount
    }

    fun setMessage(message: String?) {
        this.message = message
    }

    companion object {
        private const val EVENT_CODE = "lephe"
    }
}