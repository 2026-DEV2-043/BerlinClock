package com.berlinclock.domain.model

import com.berlinclock.constants.LightColor

class BerlinClockSecondState {
    private var _secondLightState = LightColor.OFF

    val secondLightState: LightColor
        get() = _secondLightState

    fun updateSecondLightState(second: Int) {
        _secondLightState =  if (second % 2 == 0) LightColor.YELLOW else LightColor.OFF
    }
}