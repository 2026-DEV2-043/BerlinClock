package com.berlinclock.presentation.model

import com.berlinclock.constants.HOUR_LIGHT_COUNT
import com.berlinclock.constants.LightColorUI
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT

data class BerlinClockUIState(
    val secondLight: LightColorUI = LightColorUI.OFF,
    val topHourLight: List<LightColorUI> = List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
    val bottomHourLight: List<LightColorUI> = List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
    val topMinuteLight: List<LightColorUI> = List(TOP_MINUTE_LIGHT_COUNT) { LightColorUI.OFF },
)