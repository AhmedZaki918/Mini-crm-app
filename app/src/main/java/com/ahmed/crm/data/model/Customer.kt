package com.ahmed.crm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "customers")
data class Customer(
    @PrimaryKey
    val mobile:String = "",
    val name:String? = "",
    val email:String? = "",
    val following: Boolean? = false
)