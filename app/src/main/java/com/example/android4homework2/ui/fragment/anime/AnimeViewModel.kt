package com.example.android4homework2.ui.fragment.anime

import androidx.lifecycle.ViewModel
import com.example.android4homework2.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AnimeViewModel @Inject constructor(
    private val repositories: AnimeRepository
) : ViewModel() {
    fun fetchAnime() = repositories.fetchAnime()

    fun loadData() = repositories.fetchAnime()

}