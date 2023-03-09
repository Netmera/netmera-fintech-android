package com.netmera.netmerafintech.data

import android.graphics.Color
import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.Contact
import com.netmera.netmerafintech.data.model.Favorites
import com.netmera.netmerafintech.data.model.Transaction

object StaticData {
    fun getCards() = listOf(
        Card(CardType.CARD_BLACK.value),
        Card(CardType.CARD_BLUE.value),
        Card(CardType.CARD_YELLOW.value),
    )

    fun getContacts() = listOf(
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

    fun getFavorites() = listOf(
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

    fun getTransactions() = listOf(
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