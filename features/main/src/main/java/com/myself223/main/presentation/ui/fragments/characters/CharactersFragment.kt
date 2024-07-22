package com.myself223.main.presentation.ui.fragments.characters

import android.util.Log
import androidx.appcompat.widget.SearchView
import androidx.lifecycle.lifecycleScope
import by.kirich1409.viewbindingdelegate.viewBinding
import com.myself223.core.base.BaseFragment
import com.myself223.main.R
import com.myself223.main.databinding.FragmentCharactersBinding
import com.myself223.main.presentation.ui.adapters.character.CharacterAdapter
import com.myself223.main.presentation.ui.fragments.FilterFragment
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding, CharacterViewModel>(R.layout.fragment_characters) {
    override val viewModel: CharacterViewModel by viewModel()
    private val characterAdapter: CharacterAdapter by lazy { CharacterAdapter() }
    override val binding: FragmentCharactersBinding by viewBinding(FragmentCharactersBinding::bind)

    override fun init() {
        binding.rvCharacters.adapter = characterAdapter
    }

    override fun constructorListeners() {
        binding.btnSearch.setOnClickListener {
            val bottomSheetFragment = FilterFragment()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
        }
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    viewModel.searchCharacters(it)
                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                newText?.let {
                    viewModel.searchCharacters(it)
                }
                return true
            }
        })
    }

    override fun launchObserver() {
        Log.e("CharactersFragment", "ViewModel initialized")

        lifecycleScope.launch {
            viewModel.searchResults.collectLatest { pagingData ->
                characterAdapter.submitData(pagingData)
            }
        }
    }
}
