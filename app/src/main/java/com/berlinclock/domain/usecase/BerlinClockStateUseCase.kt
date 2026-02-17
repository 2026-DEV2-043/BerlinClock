package com.berlinclock.domain.usecase

import com.berlinclock.domain.model.BerlinClockHourState
import com.berlinclock.domain.model.BerlinClockMinuteState
import com.berlinclock.domain.model.BerlinClockSecondState
import com.berlinclock.domain.model.BerlinClockState
import com.berlinclock.domain.utils.TimeUtil
import javax.inject.Inject

class BerlinClockStateUseCase @Inject constructor(val timeUtil: TimeUtil) {
    operator fun invoke(): BerlinClockState {
        val formattedTime = timeUtil.getFormattedTime()
        val timeComponent = timeUtil.getTimeComponent()

        return getBerlinClockState(formattedTime, timeComponent.hour, timeComponent.minute, timeComponent.second)
    }

    fun getBerlinClockState(formattedTime: String, hours: Int, minutes: Int, seconds: Int): BerlinClockState {

        val berlinClockSecondState = BerlinClockSecondState()
        berlinClockSecondState.updateSecondLightState(seconds)

        val berlinClockHourState = BerlinClockHourState()
        berlinClockHourState.updateHourLightState(hours)

        val berlinClockMinuteState = BerlinClockMinuteState()
        berlinClockMinuteState.updateMinuteLightState(minutes)

        return BerlinClockState (
            berlinClockSecondState,
            berlinClockHourState,
            berlinClockMinuteState,
            formattedTime
        )
    }
}
