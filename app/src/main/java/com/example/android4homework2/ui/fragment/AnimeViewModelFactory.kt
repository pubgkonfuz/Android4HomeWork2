package com.example.android4homework2.ui.fragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.android4homework2.data.remote.RetrofitClient
import com.example.android4homework2.data.remote.apiservice.KitsuApiService
import com.example.android4homework2.data.repository.AnimeRepository

class AnimeViewModelFactory : ViewModelProvider.Factory {
    private val apiService: KitsuApiService = RetrofitClient.apiService
    private val repository = AnimeRepository(apiService)
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(AnimeViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return AnimeViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}