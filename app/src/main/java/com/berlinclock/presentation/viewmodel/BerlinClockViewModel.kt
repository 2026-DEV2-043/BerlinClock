package com.berlinclock.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berlinclock.domain.usecase.BerlinClockStateUseCase
import com.berlinclock.presentation.model.BerlinClockUIState
import com.berlinclock.utility.toBerlinClockUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class BerlinClockViewModel @Inject constructor(val berlinClockStateUseCase: BerlinClockStateUseCase): ViewModel() {
    private var _berlinClockState = MutableStateFlow(BerlinClockUIState())
    val berlinClockState: StateFlow<BerlinClockUIState>
        get() = _berlinClockState

    init {
        viewModelScope.launch {
            berlinClockStateUseCase().collect {
                _berlinClockState.tryEmit(it.toBerlinClockUIState())
            }
        }
    }
}