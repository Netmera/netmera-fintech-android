/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.all_pages

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.ui.analytics.AnalyticsFragment
import com.netmera.netmerafintech.databinding.ActivityAllpagesBinding
import com.netmera.netmerafintech.ui.exit.ExitFragment
import com.netmera.netmerafintech.ui.history.HistoryFragment
import com.netmera.netmerafintech.ui.home.HomeFragment
import com.netmera.netmerafintech.ui.payments.PaymentsFragment

class AllPagesActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAllpagesBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAllpagesBinding.inflate(layoutInflater)
        setContentView(binding.root)
        loadFragment(HomeFragment())
        setOnNavigationBarClickListener()
    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer,fragment)
        transaction.commit()
    }

    private fun setOnNavigationBarClickListener() {
        binding.bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    loadFragment(HomeFragment())
                    true
                }
                R.id.payments -> {
                    loadFragment(PaymentsFragment())
                    true
                }
                R.id.history -> {
                    loadFragment(HistoryFragment())
                    true
                }
                R.id.analytics -> {
                    loadFragment(AnalyticsFragment())
                    true
                }
                R.id.exit -> {
                    loadFragment(ExitFragment())
                    true
                }
                else -> false
            }
        }
    }
}