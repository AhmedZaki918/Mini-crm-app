package com.ahmed.crm.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize


@Entity(tableName = "customers")
@Parcelize
data class Customer(
    @PrimaryKey
    val mobile:String = "",
    val name:String? = "",
    val email:String? = "",
    val following: Boolean? = false
): Parcelable