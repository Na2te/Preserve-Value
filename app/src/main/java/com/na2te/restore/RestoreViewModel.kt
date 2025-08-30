package com.na2te.restore

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class RestoreViewModel @Inject constructor(private val savedStateHandle: SavedStateHandle) : ViewModel() {
    private val _memoryCount = MutableStateFlow(0)
    val memoryCount = _memoryCount.asStateFlow()

    // 만약 saveStateHandle에 저장된 값이 있으면 불러오고 아니면 0으로 초기화
    val savedStateCount = savedStateHandle.getStateFlow(key = "saved_count", initialValue = 0)

    fun increment() {
        _memoryCount.value++
        savedStateHandle["saved_count"] = savedStateCount.value + 1
    }
}