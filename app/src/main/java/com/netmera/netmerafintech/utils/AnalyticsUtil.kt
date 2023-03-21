/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.utils

import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.ImpactFintechUser

object AnalyticsUtil: IAnalyticsUtil {

    override fun addNotesEvent() {
        NetmeraAnalyticsUtil.addNotesEvent()
        FirebaseAnalyticsUtil.addNotesEvent()
    }

    override fun appSettingsEvent() {
        NetmeraAnalyticsUtil.appSettingsEvent()
        FirebaseAnalyticsUtil.appSettingsEvent()
    }

    override fun cardSettingsEvent() {
        NetmeraAnalyticsUtil.cardSettingsEvent()
        FirebaseAnalyticsUtil.cardSettingsEvent()
    }

    override fun changeEvent() {
        NetmeraAnalyticsUtil.changeEvent()
        FirebaseAnalyticsUtil.changeEvent()
    }

    override fun contactsEvent() {
        NetmeraAnalyticsUtil.contactsEvent()
        FirebaseAnalyticsUtil.contactsEvent()
    }

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

    override fun nearbyEvent() {
        NetmeraAnalyticsUtil.nearbyEvent()
        FirebaseAnalyticsUtil.nearbyEvent()
    }

    override fun paymentDetailEvent(index: Int?) {
        NetmeraAnalyticsUtil.paymentDetailEvent(index)
        FirebaseAnalyticsUtil.paymentDetailEvent(index)
    }

    override fun paymentTransferEvent(receiver: String) {
        NetmeraAnalyticsUtil.paymentTransferEvent(receiver)
        FirebaseAnalyticsUtil.paymentTransferEvent(receiver)
    }

    override fun paySomeoneEvent() {
        NetmeraAnalyticsUtil.paySomeoneEvent()
        FirebaseAnalyticsUtil.paySomeoneEvent()
    }

    override fun purchaseEvent(amount: String, message: String?) {
        NetmeraAnalyticsUtil.purchaseEvent(amount, message)
        FirebaseAnalyticsUtil.purchaseEvent(amount, message)
    }

    override fun requestMoneyEvent() {
        NetmeraAnalyticsUtil.requestMoneyEvent()
        FirebaseAnalyticsUtil.requestMoneyEvent()
    }

    override fun seeAllEvent() {
        NetmeraAnalyticsUtil.seeAllEvent()
        FirebaseAnalyticsUtil.seeAllEvent()
    }

    override fun searchForPayeesEvent() {
        NetmeraAnalyticsUtil.searchForPayeesEvent()
        FirebaseAnalyticsUtil.searchForPayeesEvent()
    }

    override fun signInEvent() {
        NetmeraAnalyticsUtil.signInEvent()
        FirebaseAnalyticsUtil.signInEvent()
    }

    override fun signOutEvent() {
        NetmeraAnalyticsUtil.signOutEvent()
        FirebaseAnalyticsUtil.signOutEvent()
    }

    override fun somethingWrongEvent() {
        NetmeraAnalyticsUtil.somethingWrongEvent()
        FirebaseAnalyticsUtil.somethingWrongEvent()
    }

    override fun supportEvent() {
        NetmeraAnalyticsUtil.supportEvent()
        FirebaseAnalyticsUtil.supportEvent()
    }

    override fun userUpdate(user: ImpactFintechUser) {
        NetmeraAnalyticsUtil.userUpdate(user)
        FirebaseAnalyticsUtil.userUpdate(user)
    }
}