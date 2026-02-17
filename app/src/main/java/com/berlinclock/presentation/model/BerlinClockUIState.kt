package com.berlinclock.presentation.model

import com.berlinclock.constants.HOUR_LIGHT_COUNT
import com.berlinclock.constants.LightColorUI

data class BerlinClockUIState(
    val secondLight: LightColorUI = LightColorUI.OFF,
    val topHourLight: List<LightColorUI> = List(HOUR_LIGHT_COUNT) { LightColorUI.OFF }
)