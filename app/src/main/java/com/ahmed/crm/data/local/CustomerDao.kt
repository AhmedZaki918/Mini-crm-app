package com.ahmed.crm.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import com.ahmed.crm.data.model.Customer

@Dao
interface CustomerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCustomer(customer: Customer)

    @Query("SELECT * FROM customers")
    fun getCustomers(): LiveData<List<Customer>>

    @Update
    suspend fun updateCustomer(customer: Customer?)

    @Delete
    suspend fun deleteCustomer(customer: Customer)
}