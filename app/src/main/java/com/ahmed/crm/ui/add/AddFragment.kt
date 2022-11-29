package com.ahmed.crm.ui.add

import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.ahmed.crm.R
import com.ahmed.crm.data.model.Customer
import com.ahmed.crm.databinding.FragmentAddBinding
import com.ahmed.crm.util.BaseFragment
import com.ahmed.crm.util.toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class AddFragment : BaseFragment<FragmentAddBinding>(FragmentAddBinding::inflate),
    View.OnClickListener {

    private lateinit var viewModel: AddViewModel
    private var name: String = ""
    private var email: String = ""
    private var mobile: String = ""

    override fun FragmentAddBinding.initialize() {
        viewModel = ViewModelProvider(this@AddFragment)[AddViewModel::class.java]
        btnSave.setOnClickListener(this@AddFragment)
    }

    override fun onClick(item: View) {
        if (item.id == R.id.btn_save) {
            if (getUserInput()) {
                saveCustomer()
            } else {
                requireContext().toast(getString(R.string.enter_missing))
            }
        }
    }

    private fun getUserInput(): Boolean {
        binding.apply {
            name = etName.text.toString().trim()
            email = etEmail.text.toString().trim()
            mobile = etMobile.text.toString().trim()
            return !(name.isEmpty() || email.isEmpty() || mobile.isEmpty())
        }
    }

    private fun saveCustomer() {
        viewModel.addCustomer(Customer(name, email, mobile))
        requireContext().toast(getString(R.string.customer_saved))
    }
}