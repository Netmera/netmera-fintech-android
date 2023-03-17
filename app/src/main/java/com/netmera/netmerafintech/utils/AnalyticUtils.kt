/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.utils

import com.netmera.netmerafintech.data.model.Card

object AnalyticsUtil {

    fun forgotYourPinEvent() {
        NetmeraAnalyticsUtil.forgotYourPinEvent()
        FirebaseAnalyticsUtil.forgotYourPinEvent()
    }

    fun freezeCardEvent(card: Card) {
        NetmeraAnalyticsUtil.freezeCardEvent(card)
        FirebaseAnalyticsUtil.freezeCardEvent(card)
    }

    fun getStartedEvent() {
        NetmeraAnalyticsUtil.getStartedEvent()
        FirebaseAnalyticsUtil.getStartedEvent()
    }

    fun manageEvent() {
        NetmeraAnalyticsUtil.manageEvent()
        FirebaseAnalyticsUtil.manageEvent()
    }

    fun paymentDetailEvent(index: Int?) {
        index?.let {
            NetmeraAnalyticsUtil.paymentDetailEvent(it)
            FirebaseAnalyticsUtil.paymentDetailEvent(it)
        }
    }

    fun paymentTransferEvent(whoToTransfer: String) {
        NetmeraAnalyticsUtil.paymentTransferEvent(whoToTransfer)
        FirebaseAnalyticsUtil.paymentTransferEvent(whoToTransfer)
    }

    fun purchaseEvent(amount: String, message: String?) {
        NetmeraAnalyticsUtil.purchaseEvent(amount, message)
        FirebaseAnalyticsUtil.purchaseEvent(amount, message)
    }

    fun signInEvent() {
        NetmeraAnalyticsUtil.signInEvent()
        FirebaseAnalyticsUtil.signInEvent()
    }

    fun signOutEvent() {
        NetmeraAnalyticsUtil.signOutEvent()
        FirebaseAnalyticsUtil.signOutEvent()
    }

    fun updateUser() {
        NetmeraAnalyticsUtil.updateUser()
    }
}