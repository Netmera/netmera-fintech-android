package com.netmera.netmerafintech.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.data.CardType
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.databinding.ActivityManageCardBinding
import com.netmera.netmerafintech.utils.parcelable
import com.netmera.netmerafintech.utils.toast

class ManageCardActivity: AppCompatActivity() {

    companion object {
        private const val ARG_CARD = "ARG_CARD"

        fun start(activity: Activity?, card: Card) {
            activity?.startActivity(Intent(activity, ManageCardActivity::class.java).apply {
                putExtra(ARG_CARD, card)
            })
        }
    }

    private lateinit var binding: ActivityManageCardBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityManageCardBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            it.classLoader = ManageCardActivity::class.java.classLoader
        }
        val card: Card? = bundle?.parcelable(ARG_CARD)
        card?.let {
            initViews(it)
        } ?: run {
            toast("Error occurred while starting manage card page. Please try again.")
            finish()
            return
        }
    }

    private fun initViews(card: Card) {
        binding.apply {
            when (card.cardId) {
                CardType.BLACK.value -> cardView.setImageResource(R.drawable.black_card)
                CardType.YELLOW.value -> cardView.setImageResource(R.drawable.yellow_card)
                else -> cardView.setImageResource(R.drawable.blue_card)
            }
            setOnClickActions()
        }
    }

    private fun setOnClickActions() {
        binding.apply {
            backButton.setOnClickListener { finish() }
            freezeCardLayout.setOnClickListener { toast("Freeze card event was called.") }
            forgotYourPinLayout.setOnClickListener { toast("Forgot your pin event was called.") }
            settingsLayout.setOnClickListener { toast("Settings event was called.") }
            supportLayout.setOnClickListener { toast( "Support event was called.") }
        }
    }
}