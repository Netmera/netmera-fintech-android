/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.netmera.netmerafintech.data.CardType
import com.netmera.netmerafintech.data.model.Transaction
import com.netmera.netmerafintech.databinding.FragmentHomeBinding

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel

    private val onTransactionClick = { transaction: Transaction ->
//        TransactionDetailActivity.open(requireActivity(), transaction) TODO open it after transaction detail is created
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.fetchCards()
        viewModel.fetchTransactions()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.cardList.observe(viewLifecycleOwner) {
            binding.cardViewPager.adapter = CardViewPagerAdapter(it)
            binding.cardViewPager.currentItem = CardType.BLUE.value
        }

        viewModel.transactionList.observe(viewLifecycleOwner) {
            binding.transactionsRecyclerView.adapter = TransactionsAdapter(requireContext(), onTransactionClick, it)
        }
    }
}