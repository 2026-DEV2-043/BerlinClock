package com.berlinclock.domain.usecase

import com.berlinclock.domain.model.BerlinClockHourState
import com.berlinclock.domain.model.BerlinClockMinuteState
import com.berlinclock.domain.model.BerlinClockSecondState
import com.berlinclock.domain.model.BerlinClockState

class BerlinClockStateUseCase {
    fun getBerlinClockState(formattedTime: String, hours: Int, minutes: Int, seconds: Int): BerlinClockState {
        return BerlinClockState (
            BerlinClockSecondState(),
            BerlinClockHourState(),
            BerlinClockMinuteState(),
            formattedTime
        )
    }
}
