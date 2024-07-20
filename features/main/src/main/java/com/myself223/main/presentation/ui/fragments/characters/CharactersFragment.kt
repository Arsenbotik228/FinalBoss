package com.myself223.main.presentation.ui.fragments.characters

import by.kirich1409.viewbindingdelegate.viewBinding
import com.myself223.core.base.BaseFragment
import com.myself223.main.R
import com.myself223.main.databinding.FragmentCharactersBinding
import com.myself223.main.presentation.ui.adapters.character.CharacterAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class CharactersFragment : BaseFragment<FragmentCharactersBinding,CharacterViewModel>(R.layout.fragment_characters) {
    private val characterAdapter:CharacterAdapter by lazy { CharacterAdapter() }
    override val binding:FragmentCharactersBinding by viewBinding(FragmentCharactersBinding::bind)
    override val viewModel: CharacterViewModel by viewModel()


    override fun init() {
        binding.rvCharacters.adapter = characterAdapter
    }


    override fun launchObserver() {
        viewModel.getCharacter().observeUIPaging {character->
            characterAdapter.submitData(character)
        }
    }





}