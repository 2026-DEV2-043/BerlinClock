package com.berlinclock.domain.model

data class BerlinClockState(
    val secondState: BerlinClockSecondState,
    val hourState: BerlinClockHourState,
    val minuteState: BerlinClockMinuteState,
    val time: String
)