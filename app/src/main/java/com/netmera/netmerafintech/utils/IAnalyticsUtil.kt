/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.utils

import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.ImpactFintechUser

interface IAnalyticsUtil {
    fun addNotesEvent()
    fun appSettingsEvent()
    fun cardSettingsEvent()
    fun changeAccountEvent()
    fun contactsEvent()
    fun contactUsForSupportEvent()
    fun forgotYourPinEvent()
    fun freezeCardEvent(card: Card)
    fun getStartedEvent()
    fun manageAccountEvent(lastFourDigits: String)
    fun nearbyEvent()
    fun paymentDetailEvent(index: Int?)
    fun paymentTransferEvent(receiver: String)
    fun paySomeoneEvent()
    fun purchaseEvent(amount: String, message: String?)
    fun requestMoneyEvent()
    fun seeAllEvent()
    fun searchForPayeesEvent()
    fun signInEvent()
    fun signOutEvent()
    fun somethingWrongEvent()
    fun userUpdate(user: ImpactFintechUser)
}