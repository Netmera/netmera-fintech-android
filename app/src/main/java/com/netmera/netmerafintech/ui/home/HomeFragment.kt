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
import androidx.viewpager.widget.ViewPager
import com.netmera.netmerafintech.data.CardType
import com.netmera.netmerafintech.data.model.Card
import com.netmera.netmerafintech.data.model.Transaction
import com.netmera.netmerafintech.databinding.FragmentHomeBinding
import com.netmera.netmerafintech.utils.toast

class HomeFragment: Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var viewModel: HomeViewModel
    private var card: Card = Card(CardType.BLUE.value)

    private val onManageClick = { card: Card ->
        ManageCardActivity.start(requireActivity(), card)
    }
    private val onTransactionClick = { transaction: Transaction ->
        TransactionDetailActivity.start(requireActivity(), transaction)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        setOnClickActions()

        viewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        viewModel.fetchCards()
        viewModel.fetchTransactions()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.cardList.observe(viewLifecycleOwner) {
            setViewPager(it)
        }

        viewModel.transactionList.observe(viewLifecycleOwner) {
            binding.transactionsRecyclerView.adapter = TransactionsAdapter(requireContext(), onTransactionClick, it)
        }
    }

    private fun setOnClickActions() {
        binding.apply {
            manageButton.setOnClickListener { onManageClick(card) }
            settings.setOnClickListener { toast("Settings event was called.") }
        }
    }

    private fun setViewPager(cardList: List<Card>) {
        binding.cardViewPager.apply {
            adapter = CardViewPagerAdapter(cardList)
            currentItem = card.cardId
            pageMargin = 40
            addOnPageChangeListener(object: ViewPager.OnPageChangeListener {
                override fun onPageScrolled(
                    position: Int,
                    positionOffset: Float,
                    positionOffsetPixels: Int
                ) {}

                override fun onPageSelected(position: Int) {
                    card.cardId = position
                }

                override fun onPageScrollStateChanged(state: Int) {}

            })
        }
    }
}