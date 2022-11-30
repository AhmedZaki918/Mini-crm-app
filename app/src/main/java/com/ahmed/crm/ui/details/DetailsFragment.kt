package com.ahmed.crm.ui.details

import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.ahmed.crm.R
import com.ahmed.crm.data.model.Customer
import com.ahmed.crm.databinding.FragmentDetailsBinding
import com.ahmed.crm.util.BaseFragment
import com.ahmed.crm.util.SharedViewModel
import com.ahmed.crm.util.toast
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class DetailsFragment : BaseFragment<FragmentDetailsBinding>(FragmentDetailsBinding::inflate){

    private lateinit var viewModel: SharedViewModel
    private val args by navArgs<DetailsFragmentArgs>()

    override fun FragmentDetailsBinding.initialize() {
        viewModel = ViewModelProvider(this@DetailsFragment)[SharedViewModel::class.java]
        updateUi(args.customer)

        imageButton.setOnClickListener{
            viewModel.deleteCustomer(args.customer)
            requireContext().toast(getString(R.string.customer_deleted))
            findNavController().navigateUp()
        }
    }

    private fun updateUi(customer: Customer) {
        binding.apply {
            tvName.text = customer.name
            tvMail.text = customer.email
            tvMobile.text = customer.mobile
            tvStatus.text = if (customer.following!!){
                getString(R.string.following)
            } else {
                getString(R.string.unfollowing)
            }
        }
    }
}