/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.utils

import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.netmera.Netmera
import com.netmera.netmerafintech.Netmera.Events.*
import com.netmera.netmerafintech.data.model.NMImpactFintechUser

object AnalyticsUtil {
    private var firebaseAnalytics = Firebase.analytics

    private const val ACCOUNT = "account"
    private const val AMOUNT = "amount"
    private const val GET_STARTED = "get_started"
    private const val MANAGE = "manage"
    private const val MESSAGE = "message"
    private const val PAYMENT_DETAIL = "payment_detail"
    private const val PAYMENT_TRANSFER = "payment_transfer"
    private const val PURCHASE = "purchase"
    private const val SIGN_IN = "sign_in"
    private const val SIGN_OUT = "sign_out"
    private const val TRANSACTION_ID = "transaction_id"

    //region GET STARTED EVENT
    fun getStartedEvent() {
        getStartedNetmeraEvent()
        getStartedFirebaseEvent()
    }

    private fun getStartedFirebaseEvent() {
        firebaseAnalytics.logEvent(GET_STARTED) {
            param(GET_STARTED, "true")
        }
    }

    private fun getStartedNetmeraEvent() {
        val event = GetStartedEvent()
        event.setGetStarted(true)
        Netmera.sendEvent(event)
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
        val event = SignInEvent()
        event.setSignIn(true)
        Netmera.sendEvent(event)
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