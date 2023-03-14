package com.netmera.netmerafintech.ui.payments

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.data.model.Favorites
import com.netmera.netmerafintech.databinding.ActivitySendMoneyBinding
import com.netmera.netmerafintech.utils.*

class SendMoneyActivity : AppCompatActivity() {
    companion object {
        private const val ARG_SEND_MONEY = "ARG_SEND_MONEY"

        @JvmStatic
        fun open(activity: Activity?, favorite: Favorites) {
            activity?.startActivity(Intent(activity, SendMoneyActivity::class.java).apply {
                putExtra(ARG_SEND_MONEY, favorite)
            })
        }
    }

    private lateinit var binding: ActivitySendMoneyBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySendMoneyBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val favorite: Favorites? = intent.extras?.parcelable(ARG_SEND_MONEY)
        favorite?.let {
            initViews(it)
        } ?: run {
            toast("Error occurred while opening send money. Please try again.")
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

            backButton.setOnClickListener { finish() }
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
        }
    }
}