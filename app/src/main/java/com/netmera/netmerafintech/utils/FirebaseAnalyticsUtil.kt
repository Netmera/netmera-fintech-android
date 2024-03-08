/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.utils

import com.google.firebase.analytics.ktx.analytics
import com.google.firebase.analytics.ktx.logEvent
import com.google.firebase.ktx.Firebase
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.ImpactFintechUser

object FirebaseAnalyticsUtil: IAnalyticsUtil {
    private var firebaseAnalytics = Firebase.analytics

    private const val ACCOUNT = "account"
    private const val ADD_NOTES = "add_notes"
    private const val AMOUNT = "amount"
    private const val APP_SETTINGS = "app_settings"
    private const val CARD_SETTINGS = "card_settings"
    private const val CHANGE_ACCOUNT = "change_account"
    private const val CONTACTS = "contacts"
    private const val CONTACT_US_FOR_SUPPORT = "contact_us_for_support"
    private const val FORGOT_PIN = "forgot_pin"
    private const val FREEZE_CARD = "freeze_card"
    private const val GET_STARTED = "get_started"
    private const val MANAGE_ACCOUNT = "manage_account"
    private const val MESSAGE = "message"
    private const val NEARBY = "nearby"
    private const val PAYMENT_DETAIL = "payment_detail"
    private const val PAYMENT_TRANSFER = "payment_transfer"
    private const val PAY_SOMEONE = "pay_someone"
    private const val PURCHASE = "purchase"
    private const val REQUEST_MONEY = "request_money"
    private const val SEARCH_FOR_PAYEES = "search_for_payees"
    private const val SEE_ALL = "see_all"
    private const val SIGN_IN = "sign_in"
    private const val SIGN_OUT = "sign_out"
    private const val SOMETHING_WRONG = "something_wrong"
    private const val TRANSACTION_ID = "transaction_id"

    override fun addNotesEvent() {
        firebaseAnalytics.logEvent(ADD_NOTES, null)
    }

    override fun appSettingsEvent() {
        firebaseAnalytics.logEvent(APP_SETTINGS, null)
    }

    override fun cardSettingsEvent() {
        firebaseAnalytics.logEvent(CARD_SETTINGS, null)
    }

    override fun changeAccountEvent() {
        firebaseAnalytics.logEvent(CHANGE_ACCOUNT, null)
    }

    override fun contactsEvent() {
        firebaseAnalytics.logEvent(CONTACTS, null)
    }

    override fun contactUsForSupportEvent() {
        firebaseAnalytics.logEvent(CONTACT_US_FOR_SUPPORT, null)
    }

    override fun forgotYourPinEvent() {
        firebaseAnalytics.logEvent(FORGOT_PIN, null)
    }

    override fun freezeCardEvent(card: Card) {
        firebaseAnalytics.logEvent(FREEZE_CARD) {
            param(FREEZE_CARD, card.cardId.toString())
        }
    }

    override fun getStartedEvent() {
        firebaseAnalytics.logEvent(GET_STARTED, null)
    }

    override fun manageAccountEvent(lastFourDigits: String) {
        firebaseAnalytics.logEvent(MANAGE_ACCOUNT) {
            param(ACCOUNT, lastFourDigits)
        }
    }

    override fun nearbyEvent() {
        firebaseAnalytics.logEvent(NEARBY, null)
    }

    override fun paymentDetailEvent(index: Int?) {
        index?.let {
            firebaseAnalytics.logEvent(PAYMENT_DETAIL) {
                param(TRANSACTION_ID, it.toString()) // does not accept integer
            }
        }
    }

    override fun paymentTransferEvent(receiver: String) {
        firebaseAnalytics.logEvent(PAYMENT_TRANSFER) {
            param(TRANSACTION_ID, receiver)
        }
    }

    override fun paySomeoneEvent() {
        firebaseAnalytics.logEvent(PAY_SOMEONE, null)
    }

    override fun purchaseEvent(amount: String, message: String?) {
        firebaseAnalytics.logEvent(PURCHASE) {
            param(AMOUNT, amount)
            message?.let {
                param(MESSAGE, it)
            }
        }
    }

    override fun requestMoneyEvent() {
        firebaseAnalytics.logEvent(REQUEST_MONEY, null)
    }

    override fun seeAllEvent() {
        firebaseAnalytics.logEvent(SEE_ALL, null)
    }

    override fun searchForPayeesEvent() {
        firebaseAnalytics.logEvent(SEARCH_FOR_PAYEES, null)
    }

    override fun signInEvent() {
        firebaseAnalytics.logEvent(SIGN_IN, null)
    }

    override fun signOutEvent() {
        firebaseAnalytics.logEvent(SIGN_OUT, null)
    }

    override fun somethingWrongEvent() {
        firebaseAnalytics.logEvent(SOMETHING_WRONG, null)
    }

    override fun userUpdate(user: ImpactFintechUser) {
        firebaseAnalytics.setUserId(user.userId)
    }
}