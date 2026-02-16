package com.berlinclock.domain.model

import com.berlinclock.constants.LightColor
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BerlinClockHourStateTest {
    private lateinit var berlinClockHourState: BerlinClockHourState

    @Before
    fun setup() {
        berlinClockHourState = BerlinClockHourState()
    }

    @Test
    fun `check topHourLightState all top hour lights are initially Off`() {
        val topHourLightState = berlinClockHourState.topHourLightState

        Assert.assertEquals(true, topHourLightState.all {  it == LightColor.OFF })
    }

    @Test
    fun `check topHourLightState all top hour lights are Off when hour is in between 00 to 05`() {
        val hours = 4

        berlinClockHourState.updateHourLightState(hours)

        val topHourLightState = berlinClockHourState.topHourLightState

        Assert.assertEquals(true, topHourLightState.all {  it == LightColor.OFF })
    }

    @Test
    fun `check topHourLightState all top hour lights are On when hour is in between 20 to 24`() {
        val hours = 20

        berlinClockHourState.updateHourLightState(hours)
        val topHourLightState = berlinClockHourState.topHourLightState

        Assert.assertEquals(true, topHourLightState.all { it == LightColor.RED })
    }
}