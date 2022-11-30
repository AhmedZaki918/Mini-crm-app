package com.ahmed.crm.data.repository

import androidx.lifecycle.LiveData
import com.ahmed.crm.data.local.CustomerDao
import com.ahmed.crm.data.model.Customer
import javax.inject.Inject

class CustomerRepo @Inject constructor(private val dao: CustomerDao) {

    suspend fun createCustomer(model: Customer) {
        dao.addCustomer(model)
    }

    fun getCustomers(): LiveData<List<Customer>> {
        return dao.getCustomers()
    }

    suspend fun updateCustomer(customer: Customer?){
        dao.updateCustomer(customer)
    }

    suspend fun deleteCustomer(customer: Customer){
        dao.deleteCustomer(customer)
    }
}