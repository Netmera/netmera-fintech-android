package com.netmera.netmerafintech.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.PagerAdapter
import com.netmera.netmerafintech.R
import com.netmera.netmerafintech.data.Card
import com.netmera.netmerafintech.databinding.FragmentHomeBinding
import com.netmera.netmerafintech.utils.CARD_BLACK
import com.netmera.netmerafintech.utils.CARD_YELLOW

class CardViewPagerAdapter(private var cardList: List<Card>) : PagerAdapter() {
    private lateinit var binding: FragmentHomeBinding

    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view === `object`
    }

    override fun getCount(): Int {
        return cardList.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        binding = FragmentHomeBinding.inflate(LayoutInflater.from(container.context), container, false)
        binding.cardContainer.setImageResource(getDrawable(position))
        if (binding.cardContainer.parent != null) {
            (binding.cardContainer.parent as ViewGroup).removeView(binding.cardContainer)
        }
        container.addView(binding.cardContainer)
        return binding.cardContainer
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }

    private fun getDrawable(index: Int): Int {
        return when (index) {
            CARD_BLACK -> {
                R.drawable.black_card
            }
            CARD_YELLOW -> {
                R.drawable.yellow_card
            }
            else -> {
                R.drawable.blue_card
            }
        }
    }
}