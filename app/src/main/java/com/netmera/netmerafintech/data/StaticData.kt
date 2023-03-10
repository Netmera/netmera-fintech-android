/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.data

import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.Contact
import com.netmera.netmerafintech.data.model.Favorites
import com.netmera.netmerafintech.data.model.Transaction

object StaticData {
    fun getCards() = listOf(
        Card(CardType.BLACK.value),
        Card(CardType.BLUE.value),
        Card(CardType.YELLOW.value),
    )

    fun getContacts() = listOf(
        Contact(
            0,
            R.color.purple,
            "Alfredo Johnson",
        ),
        Contact(
            1,
            R.color.orange_dark,
            "Charlie Smith",
        ),
    )

    fun getFavorites() = listOf(
        Favorites(
            0,
            R.drawable.contact_red,
            "Sarah",
        ),
        Favorites(
            1,
            R.drawable.avatar_curly_boy,
            "Sam",
        ),
        Favorites(
            2,
            R.drawable.contact_blue,
            "Adam",
        ),
        Favorites(
            3,
            R.drawable.contact_pink,
            "Cynthia",
        ),
        Favorites(
            4,
            null,
            "Daniel",
        ),
    )

    fun getTransactions() = listOf(
        Transaction(
            R.drawable.shopping_bag,
            R.color.blue,
            "Impact Music App Premium",
            "$9.99",
            R.color.black,
            0,
            "Expense",
        ),
        Transaction(
            R.drawable.money,
            R.color.green,
            "Salary",
            "+$5,384.99",
            R.color.green,
            1,
            "Income",
        ),
        Transaction(
            R.drawable.bulb,
            R.color.orange_dark,
            "Electricity",
            "$58.99",
            R.color.black,
            2,
            "Expense",
        ),
    )
}