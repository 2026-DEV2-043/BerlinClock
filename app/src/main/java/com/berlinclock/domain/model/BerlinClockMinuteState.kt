package com.berlinclock.domain.model

import com.berlinclock.constants.BOTTOM_MINUTE_LIGHT_COUNT
import com.berlinclock.constants.LightColor
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclock.constants.TOP_MINUTE_LIGHT_VALUE
import kotlin.collections.MutableList

class BerlinClockMinuteState {
    private val _topMinuteLightState = MutableList(TOP_MINUTE_LIGHT_COUNT) { LightColor.OFF }

    val topMinuteLightState: List<LightColor>
        get() = _topMinuteLightState

    private val _bottomMinuteLightState = MutableList(BOTTOM_MINUTE_LIGHT_COUNT) { LightColor.OFF }

    val bottomMinuteLightState: List<LightColor>
        get() = _bottomMinuteLightState

    fun updateMinuteLightState(minutes: Int) {
        val topMinuteOnLightCount = minutes / TOP_MINUTE_LIGHT_VALUE
        (0..<topMinuteOnLightCount).forEach { index -> _topMinuteLightState[index]  = if ((index + 1) % 3 == 0) LightColor.RED else LightColor.YELLOW }

        val bottomMinutesOnLightCount =  minutes % TOP_MINUTE_LIGHT_VALUE
        (0..< bottomMinutesOnLightCount).forEach { index -> _bottomMinuteLightState[index] = LightColor.YELLOW }
    }
}