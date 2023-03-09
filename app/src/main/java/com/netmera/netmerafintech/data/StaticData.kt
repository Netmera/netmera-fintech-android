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

        fun getContacts(): List<Contact> {
            return listOf(
                Contact(
                    0,
                    Color.rgb(88,86, 214),
                    "Alfredo Johnson",
                ),
                Contact(
                    1,
                    Color.rgb(255,149, 0),
                    "Charlie Smith",
                ),
            )
        }

        fun getFavorites(): List<Favorites> {
            return listOf(
                Favorites(
                    0,
                    "Sarah",
                    R.drawable.contact_red,
                ),
                Favorites(
                    1,
                    "Sam",
                    R.drawable.avatar_curly_boy,
                ),
                Favorites(
                    2,
                    "Adam",
                    R.drawable.contact_blue,
                ),
                Favorites(
                    3,
                    "Cynthia",
                    R.drawable.contact_pink,
                ),
                Favorites(
                    4,
                    "Daniel",
                    null,
                ),
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
                    Color.rgb(52, 199, 89),
                    "Income",
                    Color.rgb(52, 199, 89)
                ),
                Transaction(
                    2,
                    "Electricity",
                    "$58.99",
                    R.drawable.bulb,
                    Color.rgb(255, 149, 0),
                    "Expense",
                ),
            )
        }
    }
}