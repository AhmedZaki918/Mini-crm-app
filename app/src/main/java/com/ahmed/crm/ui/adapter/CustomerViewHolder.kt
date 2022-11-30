package com.ahmed.crm.ui.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.ahmed.crm.R
import com.ahmed.crm.data.model.Customer
import com.ahmed.crm.databinding.ListItemHomeBinding
import com.ahmed.crm.util.OnCustomerClick

class CustomerViewHolder(
    private val binding: ListItemHomeBinding,
    private val onCustomerClick: OnCustomerClick
) :
    RecyclerView.ViewHolder(binding.root), View.OnClickListener {

    init {
        binding.btnFollow.setOnClickListener(this)
        binding.ibCall.setOnClickListener(this)
    }

    var customer: Customer? = null


    // Bind data
    fun bind(currentItem: Customer) {
        customer = currentItem

        binding.apply {
            tvMail.text = currentItem.email
            tvMobile.text = currentItem.mobile
            tvName.text = currentItem.name

            if (customer?.following!!) {
                btnFollow.alpha = 0.4f
                btnFollow.text = root.context.getString(R.string.following)
            } else {
                btnFollow.alpha = 1f
                btnFollow.text = root.context.getString(R.string.follow)
            }
        }
    }

    override fun onClick(item: View) {
        if (item.id == R.id.btn_follow) {

            binding.apply {
                if (customer?.following!!) {
                    btnFollow.alpha = 1f
                    btnFollow.text = root.context.getString(R.string.follow)

                    onCustomerClick.onFollowingClicked(
                        Customer(
                            customer?.mobile!!,
                            customer?.name,
                            customer?.email,
                            false
                        )
                    )

                } else {
                    btnFollow.alpha = 0.4f
                    btnFollow.text = root.context.getString(R.string.following)

                    onCustomerClick.onFollowingClicked(
                        Customer(
                            customer?.mobile!!,
                            customer?.name,
                            customer?.email,
                            true
                        )
                    )
                }
            }
        } else {
            onCustomerClick.onCallClicked(customer?.mobile!!)
        }
    }
}