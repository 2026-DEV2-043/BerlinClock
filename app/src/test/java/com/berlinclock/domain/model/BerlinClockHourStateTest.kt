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

    @Test
    fun `check topHourLightState where some top hour lights are On when hour is greater than 5`() {
        val hours = 15

        berlinClockHourState.updateHourLightState(hours)
        val topHourLightState = berlinClockHourState.topHourLightState

        Assert.assertEquals(true, topHourLightState.any { it == LightColor.RED })
    }

    @Test
    fun `check bottomHourLightState all bottom hour lights are Off when hour is factor of 5`() {
        val hours = 15

        berlinClockHourState.updateHourLightState(hours)
        val bottomHourLightState = berlinClockHourState.bottomHourLightState

        Assert.assertEquals(true, bottomHourLightState.all {  it == LightColor.OFF })
    }
}