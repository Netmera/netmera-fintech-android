package com.netmera.netmerafintech.ui.home

import android.os.Bundle
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
        }
    }
}