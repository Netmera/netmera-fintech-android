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
    private const val CHANGE = "change"
    private const val CONTACTS = "contacts"
    private const val FORGOT_PIN = "forgot_pin"
    private const val FREEZE_CARD = "freeze_card"
    private const val GET_STARTED = "get_started"
    private const val MANAGE = "manage"
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
    private const val SUPPORT = "support"
    private const val TRANSACTION_ID = "transaction_id"

    override fun addNotesEvent() {
        firebaseAnalytics.logEvent(ADD_NOTES) {
            param(ADD_NOTES, "")
        }
    }

    override fun appSettingsEvent() {
        firebaseAnalytics.logEvent(APP_SETTINGS) {
            param(APP_SETTINGS, "")
        }
    }

    override fun cardSettingsEvent() {
        firebaseAnalytics.logEvent(CARD_SETTINGS) {
            param(CARD_SETTINGS, "")
        }
    }

    override fun changeEvent() {
        firebaseAnalytics.logEvent(CHANGE) {
            param(CHANGE, "")
        }
    }

    override fun contactsEvent() {
        firebaseAnalytics.logEvent(CONTACTS) {
            param(CONTACTS, "")
        }
    }

    override fun forgotYourPinEvent() {
        firebaseAnalytics.logEvent(FORGOT_PIN) {
            param(FORGOT_PIN, "")
        }
    }

    override fun freezeCardEvent(card: Card) {
        firebaseAnalytics.logEvent(FREEZE_CARD) {
            param(FREEZE_CARD, card.cardId.toString())
        }
    }

    override fun getStartedEvent() {
        firebaseAnalytics.logEvent(GET_STARTED) {
            param(GET_STARTED, "")
        }
    }

    override fun manageEvent() {
        firebaseAnalytics.logEvent(MANAGE) {
            param(ACCOUNT, "2183")
        }
    }

    override fun nearbyEvent() {
        firebaseAnalytics.logEvent(NEARBY) {
            param(NEARBY, "")
        }
    }

    override fun paymentDetailEvent(index: Int?) {
        index?.let {
            firebaseAnalytics.logEvent(PAYMENT_DETAIL) {
                param(TRANSACTION_ID, it.toString()) // does not accept integer
            }
        }
    }

    override fun paymentTransferEvent(whoToTransfer: String?) {
        whoToTransfer?.let {
            firebaseAnalytics.logEvent(PAYMENT_TRANSFER) {
                param(TRANSACTION_ID, it)
            }
        }
    }

    override fun paySomeoneEvent() {
        firebaseAnalytics.logEvent(PAY_SOMEONE) {
            param(PAY_SOMEONE, "")
        }
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
        firebaseAnalytics.logEvent(REQUEST_MONEY) {
            param(REQUEST_MONEY, "")
        }
    }

    override fun seeAllEvent() {
        firebaseAnalytics.logEvent(SEE_ALL) {
            param(SEE_ALL, "")
        }
    }

    override fun searchForPayeesEvent() {
        firebaseAnalytics.logEvent(SEARCH_FOR_PAYEES) {
            param(SEARCH_FOR_PAYEES, "")
        }
    }

    override fun signInEvent() {
        firebaseAnalytics.logEvent(SIGN_IN) {
            param(SIGN_IN, "")
        }
    }

    override fun signOutEvent() {
        firebaseAnalytics.logEvent(SIGN_OUT) {
            param(SIGN_OUT, "")
        }
    }

    override fun somethingWrongEvent() {
        firebaseAnalytics.logEvent(SOMETHING_WRONG) {
            param(SOMETHING_WRONG, "")
        }
    }

    override fun supportEvent() {
        firebaseAnalytics.logEvent(SUPPORT) {
            param(SUPPORT, "")
        }
    }

    override fun userUpdate(user: ImpactFintechUser) {
        firebaseAnalytics.setUserId(user.userId)
    }
}