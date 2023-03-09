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
    private val transactions: List<Transaction>,
    private val onTransactionItemClick: (transaction: Transaction) -> Unit,
    private val context: Context,
) : ListAdapter<Transaction, TransactionsAdapter.TransactionViewHolder>(TransactionsComparator) {


    inner class TransactionViewHolder(private var binding: ItemTransactionBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Transaction) {
            binding.apply {
                transactionIconContainer.setCardBackgroundColor(ContextCompat.getColor(context, item.iconContainerColor))
                transactionIcon.setImageResource(item.icon)
                transactionName.text = item.name
                transactionType.text = item.type
                transactionPrice.text = item.price
                item.priceColor?.let { transactionPrice.setTextColor(ContextCompat.getColor(context, it)) }
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