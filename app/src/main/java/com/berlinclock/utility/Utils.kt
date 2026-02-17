package com.berlinclock.utility

import com.berlinclock.constants.LightColor
import com.berlinclock.constants.LightColorUI
import com.berlinclock.domain.model.BerlinClockState
import com.berlinclock.presentation.model.BerlinClockUIState

fun BerlinClockState.toBerlinClockUIState(): BerlinClockUIState {
    return BerlinClockUIState(
        secondLight = this.secondState.secondLightState.toLightUIColor(),
        topHourLight = this.hourState.topHourLightState.map { it.toLightUIColor() },
        bottomHourLight = this.hourState.bottomHourLightState.map { it.toLightUIColor() },
        topMinuteLight = this.minuteState.topMinuteLightState.map { it.toLightUIColor() },
        bottomMinuteLight = this.minuteState.bottomMinuteLightState.map { it.toLightUIColor() },
        formattedTime = this.time,
    )
}

fun LightColor.toLightUIColor(): LightColorUI {
    return when(this) {
        LightColor.OFF -> LightColorUI.OFF
        LightColor.YELLOW -> LightColorUI.YELLOW
        LightColor.RED -> LightColorUI.RED
    }
}