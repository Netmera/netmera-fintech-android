/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.payments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.data.model.Contact
import com.netmera.netmerafintech.data.model.Favorites
import com.netmera.netmerafintech.databinding.FragmentPaymentsBinding
import com.netmera.netmerafintech.ui.decorators.DividerItemDecorator
import com.netmera.netmerafintech.utils.AnalyticsUtil
import com.netmera.netmerafintech.utils.toast

class PaymentsFragment: Fragment() {
    private lateinit var binding: FragmentPaymentsBinding
    private lateinit var viewModel: PaymentsViewModel

    private val onContactsClick = { contact: Contact ->
//        ContactDetailActivity.open(requireActivity(), contact) TODO open it after contact detail is created
        toast("Contacts event was called")
    }
    private val onFavoritesClick = { favorite: Favorites ->
        favorite.name?.let { AnalyticsUtil.paymentTransferEvent(it) }
        SendMoneyActivity.start(requireActivity(), favorite)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentPaymentsBinding.inflate(layoutInflater, container, false)
        setOnClickActions()

        // code block below sets a divider between recyclerview items
        context?.let {
            val dividerItem = DividerItemDecorator(ContextCompat.getDrawable(it, R.drawable.item_divider_recyclerview))
            binding.contactsRecyclerView.addItemDecoration(dividerItem)
        }

        viewModel = ViewModelProvider(this).get(PaymentsViewModel::class.java)
        viewModel.fetchFavorites()
        viewModel.fetchContacts()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.favoritesList.observe(viewLifecycleOwner) {
            binding.favoritesRecyclerView.adapter = PayAgainRecyclerAdapter(it, onFavoritesClick)
        }

        viewModel.contactsList.observe(viewLifecycleOwner) {
            binding.contactsRecyclerView.adapter = ContactRecyclerAdapter(it, onContactsClick, requireContext())
        }
    }

    private fun setOnClickActions() {
        binding.apply {
            locationButtonContainer.setOnClickListener { toast("Nearby event was called.") }
            paySomeoneLayout.setOnClickListener { toast("Pay someone event was called.") }
            requestMoneyLayout.setOnClickListener { toast("Request money event was called.") }
            searchBarCard.setOnClickListener { toast("Search for payees event was called.") }
        }
    }
}