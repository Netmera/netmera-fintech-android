package com.netmera.netmerafintech.Netmera.Events

import com.google.gson.annotations.SerializedName

import com.netmera.NetmeraEvent


class PaymentDetailEvent : NetmeraEvent() {
    @SerializedName("ec")
    private var transactionId: Int? = null
    override fun eventCode(): String {
        return EVENT_CODE
    }

    fun setTransactionId(transactionId: Int?) {
        this.transactionId = transactionId
    }

    companion object {
        private const val EVENT_CODE = "ctxsb"
    }
}