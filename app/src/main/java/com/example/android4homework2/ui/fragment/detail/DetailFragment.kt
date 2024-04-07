package com.example.android4homework2.ui.fragment.detail

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.android4homework2.R
import com.example.android4homework2.databinding.FragmentDetailBinding
import com.example.android4homework2.utils.UiState
import com.google.android.material.snackbar.Snackbar
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment(R.layout.fragment_detail) {

    private val binding by viewBinding(FragmentDetailBinding::bind)
    private val viewModel by viewModels<DetailViewModel>()
    private val args by navArgs<DetailFragmentArgs>()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        args.id?.let { id ->
            viewModel.setId(id)
        }
        subscribeToDetail(view)
        setupListeners()
    }

    private fun subscribeToDetail(view: View) {
        viewModel.detailState.observe(viewLifecycleOwner) { uiState ->
            when (uiState) {
                is UiState.Error -> uiState.message?.let {
                    Snackbar.make(
                        requireView(), it, Snackbar.LENGTH_SHORT
                    ).show()
                }

                UiState.Loading -> binding.progressBar.isVisible = true

                is UiState.Success -> {
                    binding.progressBar.isVisible = false
                    uiState.data?.let {
                        binding.tvDetail.text = it.attributes.description
                        binding.tvDay.text = it.attributes.startDate
                        binding.tvName.text = it.attributes.titles.en
                        binding.tvRating.text = it.attributes.ageRating
                        it.attributes.coverImage?.large?.let { coverImage ->
                            Glide.with(binding.fonView).load(coverImage).into(binding.fonView)
                        }
                        Glide.with(binding.artView).load(it.attributes.posterImage.large)
                            .into(binding.artView)
                    }
                }
            }
        }
    }

    private fun setupListeners() {
        binding.tvBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }
}