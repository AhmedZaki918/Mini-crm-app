package com.ahmed.crm.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.crm.data.model.Customer
import com.ahmed.crm.databinding.ListItemHomeBinding
import com.ahmed.crm.util.OnCustomerClick

class CustomersAdapter(
    private val customers: List<Customer>,
    private val onCustomerClick: OnCustomerClick
) :
    RecyclerView.Adapter<CustomerViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomerViewHolder {
        return CustomerViewHolder(
            ListItemHomeBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            ),
            onCustomerClick
        )
    }

    override fun onBindViewHolder(holder: CustomerViewHolder, position: Int) {
        holder.bind(customers[position])
    }

    override fun getItemCount() = customers.size
}