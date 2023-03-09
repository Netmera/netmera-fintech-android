package com.netmera.netmerafintech.ui.home

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.netmera.netmerafintech.data.model.Transaction
import com.netmera.netmerafintech.databinding.ItemTransactionBinding


class TransactionsAdapter(
    private val context: Context,
    private val onTransactionItemClick: (transaction: Transaction) -> Unit,
    private val transactions: List<Transaction>
) : ListAdapter<Transaction, TransactionsAdapter.TransactionViewHolder>(TransactionsComparator) {


    inner class TransactionViewHolder(private var binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Transaction) {
            binding.apply {
                transactionIcon.setImageResource(item.icon)
                transactionIconContainer.setCardBackgroundColor(ContextCompat.getColor(context, item.iconContainerColor))
                transactionName.text = item.name
                transactionPrice.text = item.price
                transactionPrice.setTextColor(ContextCompat.getColor(context, item.priceColor))
                transactionType.text = item.type
                root.setOnClickListener { onTransactionItemClick(item) }
            }
        }
        }

    object TransactionsComparator : DiffUtil.ItemCallback<Transaction>() {
        override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            // Id is unique.
            return oldItem.transactionId == newItem.transactionId
        }

        override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TransactionViewHolder {
        val binding = ItemTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return TransactionViewHolder(binding)
    }

    override fun onBindViewHolder(holder: TransactionViewHolder, position: Int) {
        val item = transactions.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return transactions.size
    }

}