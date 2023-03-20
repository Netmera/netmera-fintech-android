/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.utils

import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.ImpactFintechUser

object AnalyticsUtil: IAnalyticsUtil {

    override fun forgotYourPinEvent() {
        NetmeraAnalyticsUtil.forgotYourPinEvent()
        FirebaseAnalyticsUtil.forgotYourPinEvent()
    }

    override fun freezeCardEvent(card: Card) {
        NetmeraAnalyticsUtil.freezeCardEvent(card)
        FirebaseAnalyticsUtil.freezeCardEvent(card)
    }

    override fun getStartedEvent() {
        NetmeraAnalyticsUtil.getStartedEvent()
        FirebaseAnalyticsUtil.getStartedEvent()
    }

    override fun manageEvent() {
        NetmeraAnalyticsUtil.manageEvent()
        FirebaseAnalyticsUtil.manageEvent()
    }

    override fun paymentDetailEvent(index: Int?) {
        NetmeraAnalyticsUtil.paymentDetailEvent(index)
        FirebaseAnalyticsUtil.paymentDetailEvent(index)
    }

    override fun paymentTransferEvent(whoToTransfer: String) {
        NetmeraAnalyticsUtil.paymentTransferEvent(whoToTransfer)
        FirebaseAnalyticsUtil.paymentTransferEvent(whoToTransfer)
    }

    override fun purchaseEvent(amount: String, message: String?) {
        NetmeraAnalyticsUtil.purchaseEvent(amount, message)
        FirebaseAnalyticsUtil.purchaseEvent(amount, message)
    }

    override fun signInEvent() {
        NetmeraAnalyticsUtil.signInEvent()
        FirebaseAnalyticsUtil.signInEvent()
    }

    override fun signOutEvent() {
        NetmeraAnalyticsUtil.signOutEvent()
        FirebaseAnalyticsUtil.signOutEvent()
    }

    override fun userUpdate(user: ImpactFintechUser) {
        NetmeraAnalyticsUtil.userUpdate(user)
        FirebaseAnalyticsUtil.userUpdate(user)
    }
}