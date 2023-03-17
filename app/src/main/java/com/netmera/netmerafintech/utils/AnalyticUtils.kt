/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.utils

import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.netmera.Netmera
import com.netmera.netmerafintech.Netmera.Events.*
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.NMImpactFintechUser

object AnalyticsUtil {
    private var firebaseAnalytics = Firebase.analytics

    private const val ACCOUNT = "account"
    private const val AMOUNT = "amount"
    private const val FORGOT_PIN = "forgot_pin"
    private const val FREEZE_CARD = "freeze_card"
    private const val GET_STARTED = "get_started"
    private const val MANAGE = "manage"
    private const val MESSAGE = "message"
    private const val PAYMENT_DETAIL = "payment_detail"
    private const val PAYMENT_TRANSFER = "payment_transfer"
    private const val PURCHASE = "purchase"
    private const val SIGN_IN = "sign_in"
    private const val SIGN_OUT = "sign_out"
    private const val TRANSACTION_ID = "transaction_id"

    //region FORGOT PIN EVENT
    fun forgotYourPinEvent() {
        forgotYourPinNetmeraEvent()
        forgotYourPinFirebaseEvent()
    }

    private fun forgotYourPinFirebaseEvent() {
        firebaseAnalytics.logEvent(FORGOT_PIN) {
            param(FORGOT_PIN, "")
        }
    }

    private fun forgotYourPinNetmeraEvent() {
        Netmera.sendEvent(ForgotYourPinEvent())
    }
    //endregion

    //region FREEZE CARD EVENT
    fun freezeCardEvent(card: Card) {
        freezeCardNetmeraEvent(card)
        freezeCardFirebaseEvent(card)
    }

    private fun freezeCardFirebaseEvent(card: Card) {
        firebaseAnalytics.logEvent(FREEZE_CARD) {
            param(FREEZE_CARD, card.cardId.toString())
        }
    }

    private fun freezeCardNetmeraEvent(card: Card) {
        val event = FreezeCardEvent()
        event.setCardId(card.cardId.toString())
        Netmera.sendEvent(event)
    }
    //endregion

    //region GET STARTED EVENT
    fun getStartedEvent() {
        getStartedNetmeraEvent()
        getStartedFirebaseEvent()
    }

    private fun getStartedFirebaseEvent() {
        firebaseAnalytics.logEvent(GET_STARTED) {
            param(GET_STARTED, "")
        }
    }

    private fun getStartedNetmeraEvent() {
        Netmera.sendEvent(GetStartedEvent())
    }
    //endregion

    //region MANAGE EVENT
    fun manageEvent() {
        manageNetmeraEvent()
        manageFirebaseEvent()
    }

    private fun manageFirebaseEvent() {
        firebaseAnalytics.logEvent(MANAGE) {
            param(ACCOUNT, "2183")
        }
    }

    private fun manageNetmeraEvent() {
        val event = ManageEvent()
        event.setAccount("2183")
        Netmera.sendEvent(event)
    }
    //endregion

    //region PAYMENT DETAIL EVENT
    fun paymentDetailEvent(index: Int) {
        paymentDetailNetmeraEvent(index)
        paymentDetailFirebaseEvent(index)
    }

    private fun paymentDetailFirebaseEvent(index: Int) {
        firebaseAnalytics.logEvent(PAYMENT_DETAIL) {
            param(TRANSACTION_ID, index.toString()) // does not accept integer
        }
    }

    private fun paymentDetailNetmeraEvent(index: Int) {
        val event = PaymentDetailEvent()
        event.setTransactionId(index)
        Netmera.sendEvent(event)
    }
    //endregion

    //region PAYMENT TRANSFER EVENT
    fun paymentTransferEvent(whoToTransfer: String) {
        paymentTransferNetmeraEvent(whoToTransfer)
        paymentTransferFirebaseEvent(whoToTransfer)
    }

    private fun paymentTransferFirebaseEvent(whoToTransfer: String) {
        firebaseAnalytics.logEvent(PAYMENT_TRANSFER) {
            param(TRANSACTION_ID, whoToTransfer)
        }
    }

    private fun paymentTransferNetmeraEvent(whoToTransfer: String) {
        val event = PaymentTransferEvent()
        event.setWho(whoToTransfer)
        Netmera.sendEvent(event)
    }
    //endregion

    //region PURCHASE EVENT
    fun purchaseEvent(amount: String, message: String?) {
        purchaseNetmeraEvent(amount, message)
        purchaseFirebaseEvent(amount, message)
    }

    private fun purchaseFirebaseEvent(amount: String, message: String?) {
        firebaseAnalytics.logEvent(PURCHASE) {
            param(AMOUNT, amount)
            message?.let {
                param(MESSAGE, it)
            }
        }
    }

    private fun purchaseNetmeraEvent(amount: String, message: String?) {
        val event = PurchaseEvent()
        event.setAmount(amount)
        event.setMessage(message)
        Netmera.sendEvent(event)
    }
    //endregion

    //region SIGN IN EVENT
    fun signInEvent() {
        signInNetmeraEvent()
        signInFirebaseEvent()
    }

    private fun signInFirebaseEvent() {
        firebaseAnalytics.logEvent(SIGN_IN) {
            param(SIGN_IN, "")
        }
    }

    private fun signInNetmeraEvent() {
        Netmera.sendEvent(SignInEvent())
    }
    //endregion

    //region SIGN OUT EVENT
    fun signOutEvent() {
        signOutNetmeraEvent()
        signOutFirebaseEvent()
    }

    private fun signOutFirebaseEvent() {
        firebaseAnalytics.logEvent(SIGN_OUT) {
            param(SIGN_OUT, "")
        }
    }

    private fun signOutNetmeraEvent() {
        Netmera.sendEvent(SignOutEvent())
    }
    //endregion

    fun updateNetmeraUser() {
        val netmerauser = NMImpactFintechUser()
        netmerauser.setUserId("burakaymaz@hotmail.com")
        netmerauser.setName("Burak")
        netmerauser.setType("black")
        Netmera.updateUser(netmerauser)
    }
}