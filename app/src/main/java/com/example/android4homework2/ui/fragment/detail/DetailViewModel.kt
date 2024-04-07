package com.example.android4homework2.ui.fragment.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.android4homework2.data.remote.models.DataItem
import com.example.android4homework2.data.repository.KitsuRepository
import com.example.android4homework2.utils.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val savedStateHandle: SavedStateHandle,
    private val detailKitsuApi: KitsuRepository,
) : ViewModel() {

    private val _detailState = MutableLiveData<UiState<DataItem>>(UiState.Loading)
    val detailState: LiveData<UiState<DataItem>> = _detailState
    private val id = savedStateHandle.get<String>(ID_KEY)

    fun setId(id: String) {
        savedStateHandle[ID_KEY] = id
    }

    init {
        getMangaById()
        getAnimeById()
    }

    private fun getAnimeById() {
        viewModelScope.launch {
            id?.let {
                detailKitsuApi.getAnimeById(id.toInt()).catch {
                    _detailState.value = UiState.Error(it, it.message ?: "Unknown error")
                }
                    .collect {
                        _detailState.value = UiState.Success(it)
                    }
            }
        }
    }

    private fun getMangaById() {
        viewModelScope.launch {
            id?.let {
                detailKitsuApi.getMangaById(id.toInt())
                    .catch {
                        _detailState.value = UiState.Error(it, it.message ?: "Unknown error")
                    }
                    .collect {
                        _detailState.value = UiState.Success(it)
                    }
            }
        }
    }

    companion object {
        private const val ID_KEY = "id"
    }
}