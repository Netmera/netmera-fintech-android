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
            "Entertainment",
            R.drawable.shopping_bag,
            R.color.blue,
            "Impact Music App Premium",
            "26 payments",
            "$9.99",
            R.color.black,
            "$259.74",
            0,
            "26",
            "Expense",
        ),
        Transaction(
            "Income",
            R.drawable.money,
            R.color.green,
            "Salary",
            "3 payments",
            "+$5,384.99",
            R.color.green,
            "+$16,154.97",
            1,
            "3",
            "Income",
        ),
        Transaction(
            "Bill",
            R.drawable.bulb,
            R.color.orange_dark,
            "Electricity",
            "13 payments",
            "$58.99",
            R.color.black,
            "$766.87",
            2,
            "13",
            "Expense",
        ),
    )
}