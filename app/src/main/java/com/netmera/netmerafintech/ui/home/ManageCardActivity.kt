package com.netmera.netmerafintech.ui.home

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.netmera.netmerafintech.databinding.ActivityManageCardBinding

class ManageCardActivity: AppCompatActivity() {
    private lateinit var binding: ActivityManageCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageCardBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {
            backButton.setOnClickListener { finish() }
            freezeCardLayout.setOnClickListener {
                Toast.makeText(this@ManageCardActivity, "Freeze card event was called.", Toast.LENGTH_LONG).show()
            }
            forgotYourPinLayout.setOnClickListener {
                Toast.makeText(this@ManageCardActivity, "Forgot your pin event was called.", Toast.LENGTH_LONG).show()
            }
            settingsLayout.setOnClickListener {
                Toast.makeText(this@ManageCardActivity, "Settings event was called.", Toast.LENGTH_LONG).show()
            }
            supportLayout.setOnClickListener {
                Toast.makeText(this@ManageCardActivity, "Support event was called.", Toast.LENGTH_LONG).show()
            }
        }
    }
}