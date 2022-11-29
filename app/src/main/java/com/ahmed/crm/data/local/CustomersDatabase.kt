package com.ahmed.crm.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ahmed.crm.data.model.Customer

@Database(
    entities = [Customer::class],
    version = 1, exportSchema = false
)
abstract class CustomersDatabase : RoomDatabase() {
    abstract fun getCustomerDao(): CustomerDao
}