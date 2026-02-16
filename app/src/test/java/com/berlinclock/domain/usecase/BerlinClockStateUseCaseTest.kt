package com.berlinclock.domain.usecase

import com.berlinclock.constants.LightColor
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT
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

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with all top hour lights On`() {
        val formattedDate = "21:04:02"
        val hours = 21
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.houtState.topHourLightState.all{ it == LightColor.RED})
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with some top hour lights On`() {
        val formattedDate = "15:04:02"
        val hours = 15
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.houtState.topHourLightState.any { it == LightColor.RED })
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with all bottom hour lights Off`() {
        val formattedDate = "20:04:02"
        val hours = 20
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.houtState.bottomHourLightState.all{ it == LightColor.OFF})
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with some bottom hour lights On`() {
        val formattedDate = "16:04:02"
        val hours = 16
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.houtState.bottomHourLightState.any{ it == LightColor.OFF })
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with all top minute lights Off`() {
        val formattedDate = "15:04:02"
        val hours = 15
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.minuteState.topMinuteLightState.all{ it == LightColor.OFF })
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with all top minute lights On`() {
        val formattedDate = "15:55:02"
        val hours = 15
        val minutes = 55
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals(TOP_MINUTE_LIGHT_COUNT,  berlinClockState.minuteState.topMinuteLightState.count { it != LightColor.OFF })
    }
}