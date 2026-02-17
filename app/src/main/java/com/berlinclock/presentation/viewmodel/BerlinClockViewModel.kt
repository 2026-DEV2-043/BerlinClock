package com.berlinclock.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.berlinclock.domain.usecase.BerlinClockStateUseCase
import com.berlinclock.presentation.model.BerlinClockUIState
import com.berlinclock.utility.toBerlinClockUIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class BerlinClockViewModel @Inject constructor(val berlinClockStateUseCase: BerlinClockStateUseCase): ViewModel() {
    val berlinClockState: StateFlow<BerlinClockUIState> by lazy {
        flow {
            berlinClockStateUseCase().collect  {
                emit(it.toBerlinClockUIState())
            }
        }.stateIn (
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(stopTimeoutMillis = 5000),
            initialValue = BerlinClockUIState()
        )
    }
}