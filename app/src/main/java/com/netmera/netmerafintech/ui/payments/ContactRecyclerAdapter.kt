package com.netmera.netmerafintech.ui.payments

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.netmera.netmerafintech.data.model.Contact
import com.netmera.netmerafintech.databinding.ItemContactsBinding

class ContactRecyclerAdapter(
    private val contacts: List<Contact>,
    private val onContactItemClick: (contact: Contact) -> Unit,
    private val context: Context,
) : ListAdapter<Contact, ContactRecyclerAdapter.ContactViewHolder>(ContactsComparator) {


    inner class ContactViewHolder(private var binding: ItemContactsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Contact) {
            binding.apply {
                cardBackground.setCardBackgroundColor(ContextCompat.getColor(context, item.containerColor))
                name.text = item.name
                letter.text = item.name?.substring(0, 1)
                root.setOnClickListener { onContactItemClick(item) }
            }
        }
    }

    object ContactsComparator : DiffUtil.ItemCallback<Contact>() {
        override fun areItemsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            // Id is unique.
            return oldItem.contactId == newItem.contactId
        }

        override fun areContentsTheSame(oldItem: Contact, newItem: Contact): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ContactViewHolder {
        val binding = ItemContactsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ContactViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ContactViewHolder, position: Int) {
        val item = contacts.get(position)
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return contacts.size
    }

}