/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.home

import android.app.Activity
import android.content.Intent
import android.os.Build
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import com.netmera.netmerafintech.data.model.Transaction
import com.netmera.netmerafintech.databinding.ActivityTransactionDetailBinding
import com.netmera.netmerafintech.utils.toast


class TransactionDetailActivity: AppCompatActivity() {

    companion object {
        private const val ARG_TRANSACTION = "ARG_TRANSACTION"

        @JvmStatic
        fun open(activity: Activity?, transaction: Transaction) {
            activity?.startActivity(Intent(activity, TransactionDetailActivity::class.java).apply {
                putExtra(ARG_TRANSACTION, transaction)
            })
        }
    }

    private lateinit var binding: ActivityTransactionDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityTransactionDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // getParcelable needs to be set class of data type after API level 33
        val transaction: Transaction? = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            intent.extras?.getParcelable(ARG_TRANSACTION, Transaction::class.java)
        } else {
            intent.extras?.getParcelable(ARG_TRANSACTION)
        }
        transaction?.let {
            initViews(it)
        } ?: run {
            toast("Error occurred while opening transaction detail. Please try again.")
            finish()
            return
        }

        setOnClickActions()
    }

    private fun initViews(transaction: Transaction) {
        binding.apply {
            averageSpentAmount.text = transaction.price
            averageSpentAmount.setTextColor(ContextCompat.getColor(this@TransactionDetailActivity, transaction.priceColor))
            totalSpentAmount.setTextColor(ContextCompat.getColor(this@TransactionDetailActivity, transaction.priceColor))
            transactionIcon.setImageResource(transaction.icon)
            transactionIconBackground.setCardBackgroundColor(ContextCompat.getColor(this@TransactionDetailActivity, transaction.iconContainerColor))
            transactionName.text = transaction.name
            transactionType.text = transaction.type

            // custom settigns, no need for id == 0, it's set already
            if (transaction.transactionId == 1) {
                paymentsNumber.text = "3 payments"
                paymentsNumber2.text = "3 payments"
                totalSpentAmount.text = "+$16,154.97"
                transactionCategory.text = "Income"
                transactionNumber.text = "3"
            } else if (transaction.transactionId == 2){
                paymentsNumber.text = "13 payments"
                paymentsNumber2.text = "13 payments"
                totalSpentAmount.text = "$766.87"
                transactionCategory.text = "Bill"
                transactionNumber.text = "13"
            }
        }
    }

    private fun setOnClickActions() {
        binding.apply {
            backButton.setOnClickListener { finish() }
            addNotesLayout.setOnClickListener {
                toast("Add notes event was called.")
            }
            somethingWrongLayout.setOnClickListener {
                toast("Something wrong event was called.")
            }
        }
    }
}