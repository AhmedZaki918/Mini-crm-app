package com.ahmed.crm.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "customers")
data class Customer(
    val name:String? = "",
    val email:String? = "",
    val mobile:String? = "",
    val following: Boolean? = false
){
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}
