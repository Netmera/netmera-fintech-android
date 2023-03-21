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
        AnalyticsUtil.contactsEvent()
        toast("Contacts event was sent")
    }
    private val onFavoritesClick = { favorite: Favorites ->
        AnalyticsUtil.paymentTransferEvent(favorite.name)
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
            locationButtonContainer.setOnClickListener {
                AnalyticsUtil.nearbyEvent()
                toast("Nearby event was sent.")
            }
            paySomeoneLayout.setOnClickListener {
                AnalyticsUtil.paySomeoneEvent()
                toast("Pay someone event was sent.")
            }
            requestMoneyLayout.setOnClickListener {
                AnalyticsUtil.requestMoneyEvent()
                toast("Request money event was sent.")
            }
            searchBarCard.setOnClickListener {
                AnalyticsUtil.searchForPayeesEvent()
                toast("Search for payees event was sent.")
            }
        }
    }
}