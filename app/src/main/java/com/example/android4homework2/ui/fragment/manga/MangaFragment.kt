package com.example.android4homework2.ui.fragment.manga

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4homework2.R
import com.example.android4homework2.databinding.FragmentMangaBinding
import com.example.android4homework2.ui.adapter.AnimeAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class MangaFragment : Fragment(R.layout.fragment_manga) {

    private val binding by viewBinding(FragmentMangaBinding::bind)
    private val mangaAdapter = AnimeAdapter()
    private val viewModels by viewModels<MangaViewModel>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        subscribe()
        viewLifecycleOwner.lifecycleScope.launch {
            delay(2000)
            if (binding.progressBar.isVisible) {
                binding.progressBar.isVisible = false
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                mangaAdapter.loadStateFlow.collect {
                    binding.appendProgress.isVisible = it.source.prepend is LoadState.Loading
                    binding.prependProgress.isVisible = it.source.append is LoadState.Loading
                }
            }
        }
    }

    private fun initialize() {
        binding.rv.apply {
            adapter = mangaAdapter
        }
    }

    private fun subscribe() {
        viewModels.getManga().observe(viewLifecycleOwner) {
            viewLifecycleOwner.lifecycleScope.launch {
                mangaAdapter.submitData(it)
            }
        }
    }
}