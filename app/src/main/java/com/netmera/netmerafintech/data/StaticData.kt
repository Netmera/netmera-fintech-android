package com.netmera.netmerafintech.data

import android.graphics.Color
import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.utils.CARD_BLACK
import com.netmera.netmerafintech.utils.CARD_BLUE
import com.netmera.netmerafintech.utils.CARD_YELLOW

class StaticData {
    companion object {
        fun getCards(): List<Card> {
            return listOf(
                Card(CARD_BLACK),
                Card(CARD_BLUE),
                Card(CARD_YELLOW),
            )
        }

        fun getTransactions(): List<Transaction> {
            return listOf(
                Transaction(
                    0,
                    "Impact Music App Premium",
                    "$9.99",
                    R.drawable.shopping_bag,
                    Color.rgb(0,122, 255 ),
                    "Expense",
                ),
                Transaction(
                    1,
                    "Salary",
                    "+$5,384.99",
                    R.drawable.money,
                    Color.rgb(34, 199, 59),
                    "Income",
                    Color.rgb(34, 199, 59)
                ),
                Transaction(
                    2,
                    "Electricity",
                    "$58.99",
                    R.drawable.bulb,
                    Color.rgb(255, 95, 0),
                    "Expense",
                ),
            )
        }
    }
}