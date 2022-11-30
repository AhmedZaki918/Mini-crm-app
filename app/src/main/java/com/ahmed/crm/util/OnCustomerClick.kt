package com.ahmed.crm.util

import com.ahmed.crm.data.model.Customer

interface OnCustomerClick {

    fun onFollowingClicked(customer: Customer)
    fun onCallClicked(mobileNumber: String)
    fun onItemClicked(customer: Customer)
}