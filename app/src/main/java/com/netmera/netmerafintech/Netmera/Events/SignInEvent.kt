/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.Netmera.Events

import com.google.gson.annotations.SerializedName

import com.netmera.NetmeraEvent


class SignInEvent : NetmeraEvent() {
    @SerializedName("fg")
    private var signIn: Boolean? = null
    override fun eventCode(): String {
        return EVENT_CODE
    }

    fun setSignIn(signIn: Boolean?) {
        this.signIn = signIn
    }

    companion object {
        private const val EVENT_CODE = "uwvhh"
    }
}