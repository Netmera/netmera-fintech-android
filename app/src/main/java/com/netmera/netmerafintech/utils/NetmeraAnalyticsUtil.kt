/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.utils

import com.netmera.Netmera
import com.netmera.netmerafintech.Netmera.Events.*
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.NMImpactFintechUser

object NetmeraAnalyticsUtil {

    fun forgotYourPinEvent() {
        Netmera.sendEvent(ForgotYourPinEvent())
    }

    fun freezeCardEvent(card: Card) {
        val event = FreezeCardEvent()
        event.setCardId(card.cardId.toString())
        Netmera.sendEvent(event)
    }

    fun getStartedEvent() {
        Netmera.sendEvent(GetStartedEvent())
    }

    fun manageEvent() {
        val event = ManageEvent()
        event.setAccount("2183")
        Netmera.sendEvent(event)
    }

    fun paymentDetailEvent(index: Int) {
        val event = PaymentDetailEvent()
        event.setTransactionId(index)
        Netmera.sendEvent(event)
    }

    fun paymentTransferEvent(whoToTransfer: String) {
        val event = PaymentTransferEvent()
        event.setWho(whoToTransfer)
        Netmera.sendEvent(event)
    }

    fun purchaseEvent(amount: String, message: String?) {
        val event = PurchaseEvent()
        event.setAmount(amount)
        event.setMessage(message)
        Netmera.sendEvent(event)
    }

    fun signInEvent() {
        Netmera.sendEvent(SignInEvent())
    }

    fun signOutEvent() {
        Netmera.sendEvent(SignOutEvent())
    }

    fun updateUser() {
        val netmerauser = NMImpactFintechUser()
        netmerauser.setUserId("burakaymaz@hotmail.com")
        netmerauser.setName("Burak")
        netmerauser.setType("black")
        Netmera.updateUser(netmerauser)
    }
}