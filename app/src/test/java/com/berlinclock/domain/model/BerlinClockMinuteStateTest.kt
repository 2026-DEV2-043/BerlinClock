package com.berlinclock.domain.model

import com.berlinclock.constants.LightColor
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BerlinClockMinuteStateTest {
    private lateinit var berlinClockMinuteState: BerlinClockMinuteState

    @Before
    fun setup() {
        berlinClockMinuteState = BerlinClockMinuteState()
    }

    @Test
    fun `check topMinuteLightState all top minute lights are initially Off`() {
        val topMinuteLightState = berlinClockMinuteState.topMinuteLightState

        Assert.assertEquals(true, topMinuteLightState.all {  it == LightColor.OFF })
    }

    @Test
    fun `check topMinuteLightState all top minute lights are Off when minute is in between 0 to 5`() {
        val minutes = 4

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val topMinuteLightState = berlinClockMinuteState.topMinuteLightState

        Assert.assertEquals(true, topMinuteLightState.all {  it == LightColor.OFF })
    }
}