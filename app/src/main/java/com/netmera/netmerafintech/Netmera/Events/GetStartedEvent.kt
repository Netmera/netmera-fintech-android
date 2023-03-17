/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.Netmera.Events

import com.google.gson.annotations.SerializedName
import com.netmera.NetmeraEvent

class GetStartedEvent : NetmeraEvent() {
    @SerializedName("fg")
    private var getStarted: Boolean? = null
    override fun eventCode(): String {
        return EVENT_CODE
    }

    fun setGetStarted(getStarted: Boolean?) {
        this.getStarted = getStarted
    }

    companion object {
        private const val EVENT_CODE = "radgk"
    }
}