package com.myself223.main.presentation.ui.fragments.locations

import by.kirich1409.viewbindingdelegate.viewBinding
import com.myself223.core.base.BaseFragment
import com.myself223.main.R
import com.myself223.main.databinding.FragmentLocationBinding
import com.myself223.main.presentation.ui.adapters.location.LocationAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class LocationFragment : BaseFragment<FragmentLocationBinding, LocationViewModel>(R.layout.fragment_location) {
    private val locationAdapter: LocationAdapter by lazy { LocationAdapter() }
    override val binding:FragmentLocationBinding by viewBinding(FragmentLocationBinding::bind)
    override val viewModel: LocationViewModel by viewModel()


    override fun init() {
        binding.rvCharacters.adapter = locationAdapter
    }


    override fun launchObserver() {
        viewModel.getLocation().observeUIPaging {location->
            locationAdapter.submitData(location)
        }
    }





}