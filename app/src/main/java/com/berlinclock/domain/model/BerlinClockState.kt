package com.berlinclock.domain.model

data class BerlinClockState(
    val secondState: BerlinClockSecondState,
    val houtState: BerlinClockHourState,
    val minuteState: BerlinClockMinuteState,
    val time: String
)