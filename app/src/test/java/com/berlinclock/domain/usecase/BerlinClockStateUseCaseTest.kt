package com.berlinclock.domain.usecase

import com.berlinclock.constants.LightColor
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BerlinClockStateUseCaseTest {

    private lateinit var berlinClockStateUseCase: BerlinClockStateUseCase

    @Before
    fun setup() {
        berlinClockStateUseCase = BerlinClockStateUseCase()
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with second light Off`() {
        val formattedDate = "14:04:01"
        val hours = 14
        val minutes = 4
        val seconds = 1

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( LightColor.OFF,  berlinClockState.secondState.secondLightState)
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with second light On`() {
        val formattedDate = "14:04:02"
        val hours = 14
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( LightColor.YELLOW,  berlinClockState.secondState.secondLightState)
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with all top hour lights Off`() {
        val formattedDate = "04:04:02"
        val hours = 4
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.houtState.topHourLightState.all{ it == LightColor.OFF})
    }
}