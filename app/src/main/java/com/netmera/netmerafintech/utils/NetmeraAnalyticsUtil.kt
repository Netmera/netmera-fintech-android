/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.utils

import com.netmera.Netmera
import com.netmera.netmerafintech.Netmera.Events.*
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.NMImpactFintechUser

object NetmeraAnalyticsUtil: IAnalyticsUtil {

    override fun forgotYourPinEvent() {
        Netmera.sendEvent(ForgotYourPinEvent())
    }

    override fun freezeCardEvent(card: Card) {
        val event = FreezeCardEvent()
        event.setCardId(card.cardId.toString())
        Netmera.sendEvent(event)
    }

    override fun getStartedEvent() {
        Netmera.sendEvent(GetStartedEvent())
    }

    override fun manageEvent() {
        val event = ManageEvent()
        event.setAccount("2183")
        Netmera.sendEvent(event)
    }

    override fun paymentDetailEvent(index: Int?) {
        index?.let {
            val event = PaymentDetailEvent()
            event.setTransactionId(it)
            Netmera.sendEvent(event)
        }
    }

    override fun paymentTransferEvent(whoToTransfer: String) {
        val event = PaymentTransferEvent()
        event.setWho(whoToTransfer)
        Netmera.sendEvent(event)
    }

    override fun purchaseEvent(amount: String, message: String?) {
        val event = PurchaseEvent()
        event.setAmount(amount)
        event.setMessage(message)
        Netmera.sendEvent(event)
    }

    override fun signInEvent() {
        Netmera.sendEvent(SignInEvent())
    }

    override fun signOutEvent() {
        Netmera.sendEvent(SignOutEvent())
    }

    override fun userUpdate() {
        val netmerauser = NMImpactFintechUser()
        netmerauser.setUserId("burakaymaz@hotmail.com")
        netmerauser.setName("Burak")
        netmerauser.setType("black")
        Netmera.updateUser(netmerauser)
    }
}