package com.example.android4homework2.ui.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.android4homework2.data.repository.AnimeRepository

class AnimeViewModel(private val repository: AnimeRepository) : ViewModel() {

    private val _isLastPage = MutableLiveData<Boolean>()
    val isLastPage: LiveData<Boolean> = _isLastPage

    init {
        loadData()
    }

    fun loadData() = repository.getAnime()
}