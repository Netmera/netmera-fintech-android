/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.netmera.netmerafintech.data.StaticData
import com.netmera.netmerafintech.data.model.Transaction
import com.netmera.netmerafintech.databinding.ActivityTransactionDetailBinding
import com.netmera.netmerafintech.ui.all_pages.AllPagesActivity
import com.netmera.netmerafintech.utils.AnalyticsUtil
import com.netmera.netmerafintech.utils.parcelable
import com.netmera.netmerafintech.utils.toast


class TransactionDetailActivity : AppCompatActivity() {

    companion object {
        private const val ARG_TRANSACTION = "ARG_TRANSACTION"

        fun start(activity: Activity?, transaction: Transaction) {
            activity?.startActivity(Intent(activity, TransactionDetailActivity::class.java).apply {
                putExtra(ARG_TRANSACTION, transaction)
            })
        }
    }

    private lateinit var binding: ActivityTransactionDetailBinding
    private var isComingFromDeeplink: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        bundle?.let {
            it.classLoader = TransactionDetailActivity::class.java.classLoader
        }

        isComingFromDeeplink = intent?.data?.let { true } ?: false

        val transaction: Transaction? = if (!isComingFromDeeplink) {
            bundle?.parcelable(ARG_TRANSACTION)
        } else {
            StaticData.getTransactions()[0]
        }

        transaction?.let {
            initViews(it)
        } ?: run {
            toast("Error occurred while starting transaction detail. Please try again.")
            finish()
            return
        }
    }

    private fun initViews(transaction: Transaction) {
        binding.apply {
            averageSpentAmount.text = transaction.price
            averageSpentAmount.setTextColor(
                ContextCompat.getColor(
                    this@TransactionDetailActivity,
                    transaction.priceColor
                )
            )
            paymentsNumber.text = transaction.numberOfPayments
            paymentsNumber2.text = transaction.numberOfPayments
            totalSpentAmount.setTextColor(
                ContextCompat.getColor(
                    this@TransactionDetailActivity,
                    transaction.priceColor
                )
            )
            totalSpentAmount.text = transaction.totalAmount
            transactionCategory.text = transaction.category
            transactionIcon.setImageResource(transaction.icon)
            transactionIconBackground.setCardBackgroundColor(
                ContextCompat.getColor(
                    this@TransactionDetailActivity,
                    transaction.iconContainerColor
                )
            )
            transactionName.text = transaction.name
            transactionNumber.text = transaction.transactionNumber
            transactionType.text = transaction.type


            addNotesLayout.setOnClickListener {
                AnalyticsUtil.addNotesEvent()
                toast("Add notes event was sent.")
            }
            backButton.setOnClickListener { onBackAction() }
            onBackPressedDispatcher.addCallback(
                this@TransactionDetailActivity,
                object : OnBackPressedCallback(true) {
                    override fun handleOnBackPressed() {
                        onBackAction()
                    }
                })
            somethingWrongLayout.setOnClickListener {
                AnalyticsUtil.somethingWrongEvent()
                toast("Something wrong event was sent.")
            }
        }
    }

    private fun onBackAction() {
        if (isComingFromDeeplink) startActivity(Intent(this@TransactionDetailActivity, AllPagesActivity::class.java))
        finish()
    }
}