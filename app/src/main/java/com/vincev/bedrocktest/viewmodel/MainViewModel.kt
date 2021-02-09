package com.vincev.bedrocktest.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vincev.bedrocktest.data.Number
import com.vincev.bedrocktest.data.NumberDetail
import com.vincev.bedrocktest.repository.MainRepository
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import java.lang.Exception

class MainViewModel constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _numberListLiveData = MutableLiveData<List<Number>>(listOf())
    val numberListLiveData: LiveData<List<Number>> = _numberListLiveData

    private val _isListLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isListLoading: LiveData<Boolean> get() = _isListLoading

    private val _isDetailLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isDetailLoading: LiveData<Boolean> get() = _isDetailLoading

    private val _toastLiveData: MutableLiveData<String> = MutableLiveData()
    val toastLiveData: LiveData<String> get() = _toastLiveData

    private val _numberDetailLiveData: MutableLiveData<NumberDetail> = MutableLiveData()
    val numberDetailLiveData: LiveData<NumberDetail> get() = _numberDetailLiveData

    private val _isConnected: MutableLiveData<Boolean> = MutableLiveData(true)
    val isConnected: LiveData<Boolean> get() = _isConnected

    init {
        initLoad()
    }

    private suspend fun loadNumberList() {
        try {
            mainRepository.loadNumberList(
                onSuccess = {
                    _isListLoading.postValue(false)
                    _isConnected.postValue(true)
                },
                onError = { _toastLiveData.postValue(it) }
            ).collect { value -> _numberListLiveData.value = value }
        } catch (e: Exception) {
            _isConnected.postValue(false)
            _isListLoading.postValue(false)
            _toastLiveData.postValue(e.message)
        }

    }

    suspend fun loadNumberDetail(item: String) {
        try {
            mainRepository.loadNumberDetail(
                item,
                onSuccess = {
                    _isDetailLoading.postValue(false)
                    _isConnected.postValue(true)
                },
                onError = { _toastLiveData.postValue(it) }
            ).collect { value -> _numberDetailLiveData.value = value }
        } catch (e: Exception) {
            _isConnected.postValue(false)
            _isDetailLoading.postValue(false)
            _toastLiveData.postValue(e.message)
        }
    }

    fun initLoad() {
        viewModelScope.launch {
            _isListLoading.postValue(true)
            loadNumberList()
        }
    }
}