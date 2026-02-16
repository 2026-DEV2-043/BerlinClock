package com.berlinclock.domain.model

import com.berlinclock.constants.HOUR_LIGHT_COUNT
import com.berlinclock.constants.LightColor

class BerlinClockHourState {
    private val _topHourLightState = MutableList(HOUR_LIGHT_COUNT) { LightColor.OFF }

    val topHourLightState: List<LightColor>
        get() = _topHourLightState

    fun updateHourLightState(hours: Int) {
        _topHourLightState.forEach { _ -> LightColor.OFF }
    }
}