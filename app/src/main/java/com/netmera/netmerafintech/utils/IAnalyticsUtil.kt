/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.utils

import com.netmera.netmerafintech.data.model.Card

interface IAnalyticsUtil {
    fun forgotYourPinEvent()
    fun freezeCardEvent(card: Card)
    fun getStartedEvent()
    fun manageEvent()
    fun paymentDetailEvent(index: Int?)
    fun paymentTransferEvent(whoToTransfer: String)
    fun purchaseEvent(amount: String, message: String?)
    fun signInEvent()
    fun signOutEvent()
    fun userUpdate()
}