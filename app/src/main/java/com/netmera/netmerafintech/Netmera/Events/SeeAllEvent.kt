/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.Netmera.Events

import com.netmera.NetmeraEvent


class SeeAllEvent : NetmeraEvent() {
    override fun eventCode(): String {
        return EVENT_CODE
    }

    companion object {
        private const val EVENT_CODE = "niumu"
    }
}