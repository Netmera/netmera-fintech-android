/*
* Copyright (c) 2023 Netmera.
*/

package com.netmera.netmerafintech.ui.payments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.netmera.netmerafintech.data.model.Favorites
import com.netmera.netmerafintech.databinding.ItemPayAgainBinding

class PayAgainRecyclerAdapter(
    private val favorites: List<Favorites>,
    private val onFavoriteItemClick: (favorite: Favorites) -> Unit
) : ListAdapter<Favorites, PayAgainRecyclerAdapter.FavoriteViewHolder>(FavoritesComparator) {


    inner class FavoriteViewHolder(private var binding: ItemPayAgainBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Favorites) {
            binding.apply {
                if (item.icon != null) {
                    icon.setImageResource(item.icon!!)
                } else {
                    icon.visibility = View.INVISIBLE
                    imageBackground.visibility = View.VISIBLE
                    letter.text = item.name?.substring(0, 1)
                }
                name.text = item.name
                root.setOnClickListener { onFavoriteItemClick(item) }
            }
        }
    }

    //ListAdapter computes diffs between Lists on a background thread and handles updates at different adapter positions
    object FavoritesComparator : DiffUtil.ItemCallback<Favorites>() {
        override fun areItemsTheSame(oldItem: Favorites, newItem: Favorites): Boolean {
            // Id is unique.
            // used to determine structural changes between old and new list (additions/removals/position changes)
            return oldItem.favoriteId == newItem.favoriteId
        }

        override fun areContentsTheSame(oldItem: Favorites, newItem: Favorites): Boolean {
            // determines if particular item was updated
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FavoriteViewHolder {
        val binding = ItemPayAgainBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return FavoriteViewHolder(binding)
    }

    override fun onBindViewHolder(holder: FavoriteViewHolder, position: Int) {
        val item = favorites.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return favorites.size
    }

}