/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.payments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.netmera.netmerafintech.data.model.Contact
import com.netmera.netmerafintech.data.model.Favorites
import com.netmera.netmerafintech.data.StaticData

class PaymentsViewModel: ViewModel() {
    private val _contactsList = MutableLiveData<List<Contact>>()
    private val _favoritesList = MutableLiveData<List<Favorites>>()

    val contactsList: LiveData<List<Contact>> = _contactsList
    val favoritesList: LiveData<List<Favorites>> = _favoritesList

    fun fetchContacts() {
        _contactsList.value = StaticData.getContacts()
    }

    fun fetchFavorites() {
        _favoritesList.value = StaticData.getFavorites()
    }
}