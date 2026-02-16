package com.berlinclock.domain.usecase

import com.berlinclock.domain.model.BerlinClockHourState
import com.berlinclock.domain.model.BerlinClockMinuteState
import com.berlinclock.domain.model.BerlinClockSecondState
import com.berlinclock.domain.model.BerlinClockState

class BerlinClockStateUseCase {
    fun getBerlinClockState(formattedTime: String, hours: Int, minutes: Int, seconds: Int): BerlinClockState {

        val berlinClockSecondState = BerlinClockSecondState()
        berlinClockSecondState.updateSecondLightState(seconds)

        return BerlinClockState (
            berlinClockSecondState,
            BerlinClockHourState(),
            BerlinClockMinuteState(),
            formattedTime
        )
    }
}
