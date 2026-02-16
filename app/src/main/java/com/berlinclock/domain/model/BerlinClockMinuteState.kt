package com.berlinclock.domain.model

import com.berlinclock.constants.LightColor
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclock.constants.TOP_MINUTE_LIGHT_VALUE

class BerlinClockMinuteState {
    private val _topMinuteLightState = MutableList(TOP_MINUTE_LIGHT_COUNT) { LightColor.OFF }

    val topMinuteLightState: List<LightColor>
        get() = _topMinuteLightState

    fun updateMinuteLightState(minutes: Int) {
        val topMinuteOnLightCount = minutes / TOP_MINUTE_LIGHT_VALUE
        (0..< topMinuteOnLightCount).forEach { index -> _topMinuteLightState[index] = LightColor.YELLOW }
    }
}