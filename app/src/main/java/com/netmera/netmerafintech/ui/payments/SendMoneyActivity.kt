/*
* Copyright (c) 2023 Netmera.
*/
package com.netmera.netmerafintech.ui.payments

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.activity.OnBackPressedCallback
import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.data.StaticData
import com.netmera.netmerafintech.data.model.Favorites
import com.netmera.netmerafintech.databinding.ActivitySendMoneyBinding
import com.netmera.netmerafintech.ui.all_pages.AllPagesActivity
import com.netmera.netmerafintech.utils.*

class SendMoneyActivity : AppCompatActivity() {
    companion object {
        private const val ARG_SEND_MONEY = "ARG_SEND_MONEY"

        @JvmStatic
        fun start(activity: Activity?, favorite: Favorites) {
            activity?.startActivity(Intent(activity, SendMoneyActivity::class.java).apply {
                putExtra(ARG_SEND_MONEY, favorite)
            })
        }
    }

    private lateinit var binding: ActivitySendMoneyBinding
    private var isComingFromDeeplink: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            it.classLoader = SendMoneyActivity::class.java.classLoader
        }

        isComingFromDeeplink = intent?.data?.let { true } ?: false

        val favorite: Favorites? = if (!isComingFromDeeplink) {
            bundle?.parcelable(ARG_SEND_MONEY)
        } else {
            StaticData.getFavorites()[0]
        }

        favorite?.let {
            initViews(it)
        } ?: run {
            toast("Error occurred while opening send money page. Please try again.")
            finish()
            return
        }

    }

    private fun initViews(favorite: Favorites) {
        binding.apply {
            lastFourNumber.text = favorite.lastFourDigit
            lastName.text = favorite.lastName
            name.text = favorite.name
            if (favorite.icon != null) {
                icon.setImageResource(favorite.icon!!)
            } else {
                icon.visibility = View.INVISIBLE
                imageBackground.visibility = View.VISIBLE
                letter.text = favorite.name?.substring(0, 1)
            }

            amount.onTextChanged {
                if (amount.text?.length == 0) {
                    sendButton.text = applicationContext.getString(R.string.send_dollar) + "0.00"
                } else {
                    sendButton.text = applicationContext.getString(R.string.send_dollar) + amount.text
                }
            }
            amount.clearFocusOnDone()
            addMessage.setOnClickListener {
                message.requestFocus()
                message.showKeyboard()
            }
            message.clearFocusOnDone()

            setOnClickActions()
        }
    }

    private fun onBackAction() {
        if (isComingFromDeeplink) startActivity(Intent(this@SendMoneyActivity, AllPagesActivity::class.java))
        finish()
    }

    private fun setOnClickActions() {
        binding.apply {
            backButton.setOnClickListener { onBackAction() }
            changeButton.setOnClickListener{
                AnalyticsUtil.changeAccountEvent()
                toast("Change account event was sent")
            }
            onBackPressedDispatcher.addCallback(
                this@SendMoneyActivity,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        onBackAction()
                    }
                })
            sendButton.setOnClickListener {
                if (amount.text.toString() != "" && amount.text.toString() != "0.00") {
                    AnalyticsUtil.purchaseEvent(amount.text.toString(), message.text.toString())
                    toast("Send money event was sent")
                } else {
                    toast("You need to enter an amount")
                }
            }
        }

    }
}