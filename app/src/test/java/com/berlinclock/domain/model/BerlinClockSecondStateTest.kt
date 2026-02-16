package com.berlinclock.domain.model

import com.berlinclock.constants.LightColor
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BerlinClockSecondStateTest {
    private lateinit var berlinClockSecondState: BerlinClockSecondState

    @Before
    fun setup() {
        berlinClockSecondState = BerlinClockSecondState()
    }

    @Test
    fun `check secondLightState is initially Off`() {
        Assert.assertEquals(true, berlinClockSecondState.secondLightState == LightColor.OFF)
    }

    @Test
    fun `check secondLightState is Off for odd seconds`() {
        val seconds = 5
        berlinClockSecondState.updateSecondLightState(seconds)
        Assert.assertEquals(true, berlinClockSecondState.secondLightState == LightColor.OFF)
    }

    @Test
    fun `check secondLightState is On for even seconds`() {
        val seconds = 10

        berlinClockSecondState.updateSecondLightState(seconds)

        Assert.assertEquals(true, berlinClockSecondState.secondLightState == LightColor.YELLOW)
    }
}