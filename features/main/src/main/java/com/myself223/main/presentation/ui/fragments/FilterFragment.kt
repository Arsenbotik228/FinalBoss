package com.myself223.main.presentation.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.myself223.main.databinding.FragmentFilterBinding

class FilterFragment:BottomSheetDialogFragment() {
    private val binding by lazy {
        FragmentFilterBinding.inflate(layoutInflater)
    }
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btnNoFiltre.setOnClickListener{
            findNavController().navigateUp()
        }
    }


}
