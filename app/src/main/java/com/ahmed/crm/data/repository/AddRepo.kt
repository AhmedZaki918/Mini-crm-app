package com.ahmed.crm.data.repository

import com.ahmed.crm.data.local.CustomerDao
import com.ahmed.crm.data.model.Customer
import javax.inject.Inject


class AddRepo @Inject constructor(private val customerDao: CustomerDao) {

    suspend fun createCustomer(model: Customer) {
         customerDao.addCustomer(model)
    }
}