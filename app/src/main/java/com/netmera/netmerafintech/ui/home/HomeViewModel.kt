package com.netmera.netmerafintech.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.StaticData
import com.netmera.netmerafintech.data.model.Transaction

class HomeViewModel: ViewModel() {
    private val _cardList = MutableLiveData<List<Card>>()
    private val _transactionList = MutableLiveData<List<Transaction>>()

    val cardList: LiveData<List<Card>> = _cardList
    val transactionList: LiveData<List<Transaction>> = _transactionList

    fun fetchCards() {
        _cardList.value = StaticData.getCards()
    }

    fun fetchTransactions() {
        _transactionList.value = StaticData.getTransactions()
    }
}