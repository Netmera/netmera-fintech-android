package com.netmera.netmerafintech

import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage
import com.netmera.Netmera

class ImpactFintechMessagingService : FirebaseMessagingService() {

    override fun onMessageReceived(remoteMessage: RemoteMessage) {
        super.onMessageReceived(remoteMessage)
        if (Netmera.isNetmeraRemoteMessage(remoteMessage)) {
            Netmera.onNetmeraPushMessageReceived(remoteMessage)
        }
    }

    override fun onNewToken(token: String) {
        super.onNewToken(token)
        Netmera.onNetmeraNewToken(token)
    }
}