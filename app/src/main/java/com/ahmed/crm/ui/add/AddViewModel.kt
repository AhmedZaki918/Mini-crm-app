package com.ahmed.crm.ui.add

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.ahmed.crm.data.model.Customer
import com.ahmed.crm.data.repository.AddRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddViewModel @Inject constructor(private val repo: AddRepo) : ViewModel() {

    fun addCustomer(model: Customer){
        viewModelScope.launch {
            repo.createCustomer(model)
        }
    }
}