package com.berlinclock.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.berlinclock.presentation.model.BerlinClockUIState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class BerlinClockViewModel: ViewModel() {
    private var _berlinClockState = MutableStateFlow(BerlinClockUIState())
    val berlinClockState: StateFlow<BerlinClockUIState>
        get() = _berlinClockState
}