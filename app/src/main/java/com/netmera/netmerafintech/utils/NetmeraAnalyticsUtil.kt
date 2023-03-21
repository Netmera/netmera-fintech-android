/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.utils

import com.netmera.Netmera
import com.netmera.netmerafintech.Netmera.Events.*
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.ImpactFintechUser
import com.netmera.netmerafintech.data.model.NMImpactFintechUser

object NetmeraAnalyticsUtil: IAnalyticsUtil {

    override fun addNotesEvent() {
        Netmera.sendEvent(AddNotesEvent())
    }

    override fun appSettingsEvent() {
        Netmera.sendEvent(AppSettingsEvent())
    }

    override fun cardSettingsEvent() {
        Netmera.sendEvent(CardSettingsEvent())
    }

    override fun changeEvent() {
        Netmera.sendEvent(ChangeEvent())
    }

    override fun contactsEvent() {
        Netmera.sendEvent(ContactsEvent())
    }

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

    override fun nearbyEvent() {
        Netmera.sendEvent(NearbyEvent())
    }

    override fun paymentDetailEvent(index: Int?) {
        index?.let {
            val event = PaymentDetailEvent()
            event.setTransactionId(it)
            Netmera.sendEvent(event)
        }
    }

    override fun paymentTransferEvent(receiver: String) {
        val event = PaymentTransferEvent()
        event.setWho(receiver)
        Netmera.sendEvent(event)
    }

    override fun paySomeoneEvent() {
        Netmera.sendEvent(PaySomeoneEvent())
    }

    override fun purchaseEvent(amount: String, message: String?) {
        val event = PurchaseEvent()
        event.setAmount(amount)
        event.setMessage(message)
        Netmera.sendEvent(event)
    }

    override fun requestMoneyEvent() {
        Netmera.sendEvent(RequestMoneyEvent())
    }

    override fun seeAllEvent() {
        Netmera.sendEvent(SeeAllEvent())
    }

    override fun searchForPayeesEvent() {
        Netmera.sendEvent(SearchForPayeesEvent())
    }

    override fun signInEvent() {
        Netmera.sendEvent(SignInEvent())
    }

    override fun signOutEvent() {
        Netmera.sendEvent(SignOutEvent())
    }

    override fun somethingWrongEvent() {
        Netmera.sendEvent(SomethingWrongEvent())
    }

    override fun supportEvent() {
        Netmera.sendEvent(SupportEvent())
    }

    override fun userUpdate(user: ImpactFintechUser) {
        val netmeraUser = NMImpactFintechUser()
        user.userName.let { netmeraUser.setName(it) }
        user.userId.let { netmeraUser.setUserId(it) }
        user.type.let { netmeraUser.setType(it) }
        Netmera.updateUser(netmeraUser)
    }
}