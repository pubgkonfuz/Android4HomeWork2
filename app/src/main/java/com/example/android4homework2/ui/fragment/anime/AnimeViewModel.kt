package com.example.android4homework2.ui.fragment.anime

import androidx.lifecycle.ViewModel
import com.example.android4homework2.data.repository.KitsuRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repositories: KitsuRepository
) : ViewModel() {

    fun fetchAnime() = repositories.fetchAnime()

}