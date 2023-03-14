package com.netmera.netmerafintech.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.netmera.netmerafintech.databinding.ActivityManageCardBinding
import com.netmera.netmerafintech.utils.toast

class ManageCardActivity: AppCompatActivity() {
    private lateinit var binding: ActivityManageCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            backButton.setOnClickListener { finish() }
            freezeCardLayout.setOnClickListener {
                toast("Freeze card event was called.")
            }
            forgotYourPinLayout.setOnClickListener {
                toast("Forgot your pin event was called.")
            }
            settingsLayout.setOnClickListener {
                toast("Settings event was called.")
            }
            supportLayout.setOnClickListener {
                toast( "Support event was called.")
            }
        }
    }
}