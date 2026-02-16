package com.berlinclock.domain.model

import com.berlinclock.constants.LightColor

class BerlinClockSecondState {
    private var _secondLightState = LightColor.OFF

    val secondLightState: LightColor
        get() = _secondLightState
}