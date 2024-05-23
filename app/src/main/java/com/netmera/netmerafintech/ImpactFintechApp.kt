/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech

import android.app.Application
import com.netmera.Netmera
import com.netmera.NetmeraConfiguration
import com.netmera.netmerafintech.utils.UserDefaultsHelper

class ImpactFintechApp: Application() {

    override fun onCreate() {
        super.onCreate()

        val configBuilder = NetmeraConfiguration.Builder()

        configBuilder.apiKey(BuildConfig.NETMERA_API_KEY)
            .firebaseSenderId(BuildConfig.FIREBASE_SENDER_ID)
            .logging(true)

        Netmera.init(configBuilder.build(this));
        UserDefaultsHelper.init(this)
    }
}