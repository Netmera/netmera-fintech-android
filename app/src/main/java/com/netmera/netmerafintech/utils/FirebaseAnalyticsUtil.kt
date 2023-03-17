/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.utils

import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.netmera.netmerafintech.data.model.Card

object FirebaseAnalyticsUtil {
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
    private const val SETTINGS = "settings"
    private const val SIGN_IN = "sign_in"
    private const val SIGN_OUT = "sign_out"
    private const val TRANSACTION_ID = "transaction_id"

    fun forgotYourPinEvent() {
        firebaseAnalytics.logEvent(FORGOT_PIN) {
            param(FORGOT_PIN, "")
        }
    }

    fun freezeCardEvent(card: Card) {
        firebaseAnalytics.logEvent(FREEZE_CARD) {
            param(FREEZE_CARD, card.cardId.toString())
        }
    }

    fun getStartedEvent() {
        firebaseAnalytics.logEvent(GET_STARTED) {
            param(GET_STARTED, "")
        }
    }

    fun manageEvent() {
        firebaseAnalytics.logEvent(MANAGE) {
            param(ACCOUNT, "2183")
        }
    }

    fun paymentDetailEvent(index: Int) {
        firebaseAnalytics.logEvent(PAYMENT_DETAIL) {
            param(TRANSACTION_ID, index.toString()) // does not accept integer
        }
    }

    fun paymentTransferEvent(whoToTransfer: String) {
        firebaseAnalytics.logEvent(PAYMENT_TRANSFER) {
            param(TRANSACTION_ID, whoToTransfer)
        }
    }

    fun purchaseEvent(amount: String, message: String?) {
        firebaseAnalytics.logEvent(PURCHASE) {
            param(AMOUNT, amount)
            message?.let {
                param(MESSAGE, it)
            }
        }
    }

    fun signInEvent() {
        firebaseAnalytics.logEvent(SIGN_IN) {
            param(SIGN_IN, "")
        }
    }

    fun signOutEvent() {
        firebaseAnalytics.logEvent(SIGN_OUT) {
            param(SIGN_OUT, "")
        }
    }
}