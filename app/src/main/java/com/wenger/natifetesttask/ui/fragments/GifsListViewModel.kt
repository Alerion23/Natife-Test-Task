package com.wenger.natifetesttask.ui.fragments

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.wenger.natifetesttask.domain.IGifsRepository
import com.wenger.natifetesttask.model.TrendingGifResponse
import com.wenger.natifetesttask.utils.ViewState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch
import retrofit2.Response
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class GifsListViewModel @Inject constructor(
    private val repository: IGifsRepository
) : ViewModel() {

    private val _gifsList = MutableLiveData<ViewState<TrendingGifResponse>>()
    val gisList: LiveData<ViewState<TrendingGifResponse>>
    get() = _gifsList

    init {
        viewModelScope.launch(Dispatchers.Main) {
            val response = repository.getAllGifs()
            if (response.isSuccessful) {
                response.body()?.let { resultResponse ->
                    _gifsList.value = ViewState.Success(resultResponse)
                }
            } else {
                Timber.e(response.message())
                _gifsList.value = ViewState.Error(response.message())
            }
        }
    }
}