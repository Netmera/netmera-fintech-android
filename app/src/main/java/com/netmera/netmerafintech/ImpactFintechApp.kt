package com.netmera.netmerafintech

import android.app.Application
import androidx.startup.AppInitializer
import com.netmera.NMInitializer
import com.netmera.Netmera
import com.netmera.NetmeraConfiguration
import com.netmera.netmerafintech.utils.FIREBASE_SENDER_ID
import com.netmera.netmerafintech.utils.NETMERA_API_KEY
import com.netmera.nmfcm.NMFCMProviderInitializer

class ImpactFintechApp: Application() {

    override fun onCreate() {
        super.onCreate()

        NMInitializer.initializeComponents(this)

        AppInitializer.getInstance(this)

        AppInitializer.getInstance(this).run {
            initializeComponent(NMFCMProviderInitializer::class.java)
        }

        val configBuilder = NetmeraConfiguration.Builder()

        configBuilder.apiKey(NETMERA_API_KEY)
            .firebaseSenderId(FIREBASE_SENDER_ID)
            .logging(true)

        Netmera.init(configBuilder.build(this));
    }
}