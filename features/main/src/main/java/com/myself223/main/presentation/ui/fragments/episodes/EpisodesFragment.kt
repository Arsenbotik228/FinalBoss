package com.myself223.main.presentation.ui.fragments.episodes

import by.kirich1409.viewbindingdelegate.viewBinding
import com.myself223.core.base.BaseFragment
import com.myself223.main.R
import com.myself223.main.databinding.FragmentEpisodesBinding
import com.myself223.main.presentation.ui.adapters.episodes.EpisodesAdapter
import com.myself223.main.presentation.ui.fragments.characters.CharacterViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class EpisodesFragment : BaseFragment<FragmentEpisodesBinding, EpisodesViewModel>(R.layout.fragment_episodes) {
    private val episodesAdapter: EpisodesAdapter by lazy { EpisodesAdapter() }
    override val binding:FragmentEpisodesBinding by viewBinding(FragmentEpisodesBinding::bind)
    override val viewModel: EpisodesViewModel by viewModel()


    override fun init() {
        binding.rvCharacters.adapter = episodesAdapter
    }


    override fun launchObserver() {
        viewModel.getEpisodes().observeUIPaging {episodes->
            episodesAdapter.submitData(episodes)
        }
    }





}