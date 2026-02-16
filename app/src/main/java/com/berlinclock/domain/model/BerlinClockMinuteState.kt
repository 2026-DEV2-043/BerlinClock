package com.berlinclock.domain.model

import com.berlinclock.constants.LightColor
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT

class BerlinClockMinuteState {
    private val _topMinuteLightState = MutableList(TOP_MINUTE_LIGHT_COUNT) { LightColor.OFF }

    val topMinuteLightState: List<LightColor>
        get() = _topMinuteLightState


}