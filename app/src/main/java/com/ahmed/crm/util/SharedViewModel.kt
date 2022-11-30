package com.ahmed.crm.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.crm.data.model.Customer
import com.ahmed.crm.data.repository.CustomerRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SharedViewModel @Inject constructor(val repo: CustomerRepo) : ViewModel() {

    fun addCustomer(model: Customer){
        viewModelScope.launch {
            repo.createCustomer(model)
        }
    }

    fun getAllCustomers() = repo.getCustomers()

    fun updateSelectedCustomer(customer: Customer?){
        viewModelScope.launch {
            repo.updateCustomer(customer)
        }
    }
}