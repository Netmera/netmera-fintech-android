package com.netmera.netmerafintech

import android.app.Application
import com.netmera.Netmera
import com.netmera.NetmeraConfiguration

class ImpactFintechApp: Application() {

    override fun onCreate() {
        super.onCreate()

        val configBuilder = NetmeraConfiguration.Builder()

        configBuilder.apiKey(BuildConfig.NETMERA_API_KEY)
            .firebaseSenderId(BuildConfig.FIREBASE_SENDER_ID)
            .logging(true)

        Netmera.init(configBuilder.build(this));
    }
}