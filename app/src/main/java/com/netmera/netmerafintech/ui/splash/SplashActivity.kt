/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.splash

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.netmera.Netmera
import com.netmera.netmerafintech.data.model.ImpactFintechUser
import com.netmera.netmerafintech.ui.all_pages.AllPagesActivity
import com.netmera.netmerafintech.databinding.ActivitySplashBinding
import com.netmera.netmerafintech.utils.AnalyticsUtil
import com.netmera.netmerafintech.utils.AppUtils
import com.netmera.netmerafintech.utils.toast

@SuppressLint("CustomSplashScreen")
class SplashActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySplashBinding
    private var user = ImpactFintechUser()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySplashBinding.inflate(layoutInflater)
        setContentView(binding.root)
        AppUtils.getNotificationPermission(this)
        setOnClickActions()
        binding.externalIdInput.setText(Netmera.getCurrentExternalId())
    }

    private fun setOnClickActions() {
        binding.apply {
            getStartedButton.setOnClickListener {
                AnalyticsUtil.getStartedEvent()
                toast("Get started event was sent", true)
                startActivity(Intent(this@SplashActivity, AllPagesActivity::class.java))
            }
            signInButton.setOnClickListener {
                if (externalIdInput.text.toString() != "") {
                    user.userName = "Burak"
                    user.userId = externalIdInput.text.toString()
                    user.type = "black"
                    AnalyticsUtil.userUpdate(user)
                    AnalyticsUtil.signInEvent()
                    toast("The user update is completed and the sign-In event was sent.")
                } else {
                    toast("Please enter an email.")
                }
            }
        }
    }
}