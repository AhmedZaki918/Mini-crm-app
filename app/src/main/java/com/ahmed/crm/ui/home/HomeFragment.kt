package com.ahmed.crm.ui.home

import android.content.Intent
import android.net.Uri
import android.view.View.INVISIBLE
import android.view.View.VISIBLE
import androidx.lifecycle.ViewModelProvider
import com.ahmed.crm.data.local.CustomerDao
import com.ahmed.crm.data.model.Customer
import com.ahmed.crm.databinding.FragmentHomeBinding
import com.ahmed.crm.ui.adapter.CustomersAdapter
import com.ahmed.crm.util.BaseFragment
import com.ahmed.crm.util.OnCustomerClick
import com.ahmed.crm.util.SharedViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject


@AndroidEntryPoint
class HomeFragment : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate),
    OnCustomerClick {

    private lateinit var viewModel: SharedViewModel

    @Inject
    lateinit var customerDao: CustomerDao


    override fun FragmentHomeBinding.initialize() {
        viewModel = ViewModelProvider(this@HomeFragment)[SharedViewModel::class.java]
        viewModel.getAllCustomers().observe(viewLifecycleOwner) { customers ->
            updateUi(customers)
        }
    }

    override fun onFollowingClicked(customer: Customer) {
        viewModel.updateSelectedCustomer(customer)
    }

    override fun onCallClicked(mobileNumber: String) {
        startActivity(
            Intent(Intent.ACTION_DIAL, Uri.parse("tel:$mobileNumber"))
        )
    }

    private fun updateUi(customers: List<Customer>) {
        binding.apply {
            if (customers.isEmpty()) {
                recyclerView.visibility = INVISIBLE
                group.visibility = VISIBLE
            } else {
                recyclerView.visibility = VISIBLE
                group.visibility = INVISIBLE
                recyclerView.adapter = CustomersAdapter(customers, this@HomeFragment)
            }
        }
    }
}