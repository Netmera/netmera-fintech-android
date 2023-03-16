package com.netmera.netmerafintech.utils

import android.app.Activity
import android.os.Build
import com.netmera.Netmera
import com.netmera.netmerafintech.Netmera.Events.SignInEvent
import com.netmera.netmerafintech.Netmera.Events.GetStartedEvent
import com.netmera.netmerafintech.data.model.NMImpactFintechUser

object AnalyticsUtil {

    fun getStartedEvent() {
        val event = GetStartedEvent()
        event.setGetStarted(true)
        Netmera.sendEvent(event)
    }

    fun updateNetmeraUser() {
        val netmerauser = NMImpactFintechUser()
        netmerauser.setUserId("burakaymaz@hotmail.com")
        netmerauser.setName("Burak")
        netmerauser.setType("black")
        Netmera.updateUser(netmerauser)
    }

    fun signInEvent() {
        val event = SignInEvent()
        event.setSignIn(true)
        Netmera.sendEvent(event)
    }
}