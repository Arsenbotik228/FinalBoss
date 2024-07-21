package com.myself223.main.presentation.ui.fragments.characters

import android.os.Bundle
import androidx.appcompat.widget.SearchView
import androidx.core.widget.addTextChangedListener
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.paging.cachedIn
import by.kirich1409.viewbindingdelegate.viewBinding
import com.google.android.material.textfield.TextInputEditText
import com.myself223.core.base.BaseFragment
import com.myself223.main.R
import com.myself223.main.databinding.FragmentCharactersBinding
import com.myself223.main.presentation.ui.adapters.character.CharacterAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding,CharacterViewModel>(R.layout.fragment_characters) {
    override val viewModel: CharacterViewModel by viewModel()
    private val characterAdapter: CharacterAdapter by lazy { CharacterAdapter() }
    override val binding:FragmentCharactersBinding by viewBinding(FragmentCharactersBinding::bind)


    override fun init() {
        binding.rvCharacters.adapter = characterAdapter
    }

    override fun constructorListeners() {
        binding.searchBar.queryHint = "Поиск..."
        binding.btnSearch.setOnClickListener{
            findNavController().navigate(R.id.action_charactersFragment_to_filterFragment)
        }
        binding.searchBar.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                query?.let {
                    searchCharacters(it)

                }
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })

        observeCharacters()


    }
    private fun observeCharacters() {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.getCharacter().cachedIn(this).collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }
    private fun searchCharacters(name: String) {
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.searchByName(name).cachedIn(this).collectLatest {
                characterAdapter.submitData(it)
            }
        }
    }


    override fun launchObserver() {
        viewModel.getCharacter().observeUIPaging {character->
            characterAdapter.submitData(character)
        }
    }
   /* private fun setupSearch() {
        val searchBar = view?.findViewById<TextInputEditText>(R.id.search_bar)
        searchBar?.addTextChangedListener { text ->
            searchViewModel.searchCharacter(text.toString())
        }
    }*/





}