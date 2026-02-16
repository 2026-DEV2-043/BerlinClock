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

        topHourLightState.forEach {
            Assert.assertEquals(LightColor.OFF, it)
        }
    }
}