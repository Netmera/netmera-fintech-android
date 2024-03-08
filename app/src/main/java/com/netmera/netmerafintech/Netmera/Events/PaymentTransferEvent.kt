/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.Netmera.Events

import com.google.gson.annotations.SerializedName

import com.netmera.NetmeraEvent


class PaymentTransferEvent : NetmeraEvent() {
    @SerializedName("ea")
    private var who: String? = null
    override fun eventCode(): String {
        return EVENT_CODE
    }

    fun setWho(who: String?) {
        this.who = who
    }

    companion object {
        private const val EVENT_CODE = "wwsvp"
    }
}