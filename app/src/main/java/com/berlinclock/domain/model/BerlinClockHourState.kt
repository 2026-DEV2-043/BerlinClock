package com.berlinclock.domain.model

import com.berlinclock.constants.HOUR_LIGHT_COUNT
import com.berlinclock.constants.HOUR_LIGHT_VALUE
import com.berlinclock.constants.LightColor

class BerlinClockHourState {
    private val _topHourLightState = MutableList(HOUR_LIGHT_COUNT) { LightColor.OFF }

    val topHourLightState: List<LightColor>
        get() = _topHourLightState

    private val _bottomHourLightState = MutableList(HOUR_LIGHT_COUNT) { LightColor.OFF }

    val bottomHourLightState: List<LightColor>
        get() = _bottomHourLightState

    fun updateHourLightState(hours: Int) {
        val topHourOnLightCount = hours / HOUR_LIGHT_VALUE
        (0..< topHourOnLightCount).forEach { index -> _topHourLightState[index] = LightColor.RED }
    }
}