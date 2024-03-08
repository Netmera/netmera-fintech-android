/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.Netmera.Events

import com.google.gson.annotations.SerializedName

import com.netmera.NetmeraEvent


class FreezeCardEvent : NetmeraEvent() {
    @SerializedName("ea")
    private var cardId: String? = null
    override fun eventCode(): String {
        return EVENT_CODE
    }

    fun setCardId(cardId: String?) {
        this.cardId = cardId
    }

    companion object {
        private const val EVENT_CODE = "zxwqx"
    }
}