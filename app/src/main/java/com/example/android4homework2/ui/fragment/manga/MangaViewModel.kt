package com.example.android4homework2.ui.fragment.manga

import androidx.lifecycle.ViewModel
import com.example.android4homework2.data.repository.AnimeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MangaViewModel @Inject constructor(
    private val repositories: AnimeRepository
) : ViewModel() {

    fun getManga() = repositories.fetchManga()
}