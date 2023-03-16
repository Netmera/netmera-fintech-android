package com.netmera.netmerafintech.utils

import android.app.Activity
import android.os.Build
import com.netmera.Netmera

object AppUtils {
    fun getNotificationPermission(activity: Activity) {
        if (Build.VERSION.SDK_INT >= 33) {
            Netmera.requestNotificationPermissions(activity)
        } // already granted for lower level
    }
}