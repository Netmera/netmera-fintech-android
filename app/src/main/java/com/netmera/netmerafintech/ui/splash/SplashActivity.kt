/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.netmera.netmerafintech.ui.all_pages.AllPagesActivity
import com.netmera.netmerafintech.databinding.ActivitySplashBinding
import com.netmera.netmerafintech.utils.AnalyticsUtil
import com.netmera.netmerafintech.utils.AppUtils

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppUtils.getNotificationPermission(this)
        setOnClickActions()
    }

    private fun setOnClickActions() {
        binding.apply {
            getStartedButton.setOnClickListener {
                AnalyticsUtil.getStartedEvent()
                startActivity(Intent(this@SplashActivity, AllPagesActivity::class.java))
            }
            signInButton.setOnClickListener {
                AnalyticsUtil.updateNetmeraUser()
                AnalyticsUtil.signInEvent()
            }
        }
    }
}