package com.berlinclock.domain.usecase

import com.berlinclock.constants.LightColor
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclock.domain.model.BerlinClockHourState
import com.berlinclock.domain.model.BerlinClockMinuteState
import com.berlinclock.domain.model.BerlinClockSecondState
import com.berlinclock.domain.model.BerlinClockState
import com.berlinclock.domain.model.TimeComponent
import com.berlinclock.domain.utils.TimeUtil
import io.mockk.every
import io.mockk.mockk
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BerlinClockStateUseCaseTest {

    private var timeUtil = mockk<TimeUtil>(relaxed = true)

    private lateinit var berlinClockStateUseCase: BerlinClockStateUseCase

    @Before
    fun setup() {
        berlinClockStateUseCase = BerlinClockStateUseCase(timeUtil)
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

        Assert.assertEquals( true,  berlinClockState.hourState.topHourLightState.all{ it == LightColor.OFF})
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with all top hour lights On`() {
        val formattedDate = "21:04:02"
        val hours = 21
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.hourState.topHourLightState.all{ it == LightColor.RED})
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with some top hour lights On`() {
        val formattedDate = "15:04:02"
        val hours = 15
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.hourState.topHourLightState.any { it == LightColor.RED })
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with all bottom hour lights Off`() {
        val formattedDate = "20:04:02"
        val hours = 20
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.hourState.bottomHourLightState.all{ it == LightColor.OFF})
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with some bottom hour lights On`() {
        val formattedDate = "16:04:02"
        val hours = 16
        val minutes = 4
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.hourState.bottomHourLightState.any{ it == LightColor.OFF })
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

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with some top minute lights On`() {
        val formattedDate = "15:30:02"
        val hours = 15
        val minutes = 30
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.minuteState.topMinuteLightState.any { it != LightColor.OFF })
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with all bottom minute lights Off`() {
        val formattedDate = "15:55:02"
        val hours = 15
        val minutes = 55
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.minuteState.bottomMinuteLightState.all{ it == LightColor.OFF })
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with all bottom minute lights On`() {
        val formattedDate = "15:55:02"
        val hours = 15
        val minutes = 59
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals(true,  berlinClockState.minuteState.bottomMinuteLightState.all { it == LightColor.YELLOW })
    }

    @Test
    fun `check getBerlinClockState() for a given formatted time and return BerlinClockState with some bottom minute lights On`() {
        val formattedDate = "16:56:02"
        val hours = 16
        val minutes = 56
        val seconds = 2

        val berlinClockState = berlinClockStateUseCase.getBerlinClockState(formattedDate, hours, minutes, seconds)

        Assert.assertEquals( true,  berlinClockState.minuteState.bottomMinuteLightState.any { it == LightColor.YELLOW })
    }

    @Test
    fun `test BerlinClockStateUseCase() for a time 23-59-59`() {
        val formattedTime = "23:59:59"
        val hours = 23
        val minutes = 59
        val seconds = 59

        val secondState = BerlinClockSecondState()
        secondState.updateSecondLightState(seconds)

        val hourState = BerlinClockHourState()
        hourState.updateHourLightState(hours)

        val minuteState = BerlinClockMinuteState()
        minuteState.updateMinuteLightState(minutes)

        val expectedBerlinClockState = BerlinClockState(
            secondState = secondState,
            hourState = hourState,
            minuteState = minuteState,
            time = formattedTime
        )

        every { timeUtil.getFormattedTime() } returns formattedTime
        every { timeUtil.getTimeComponent() } returns TimeComponent(hours, minutes, seconds)

        val actualBerlinClockState = berlinClockStateUseCase()

        Assert.assertEquals( actualBerlinClockState.time,  expectedBerlinClockState.time)
        Assert.assertEquals( actualBerlinClockState.secondState.secondLightState,  expectedBerlinClockState.secondState.secondLightState)
        Assert.assertEquals( actualBerlinClockState.hourState.topHourLightState,  expectedBerlinClockState.hourState.topHourLightState)
        Assert.assertEquals( actualBerlinClockState.hourState.bottomHourLightState,  expectedBerlinClockState.hourState.bottomHourLightState)
        Assert.assertEquals( actualBerlinClockState.minuteState.topMinuteLightState,  expectedBerlinClockState.minuteState.topMinuteLightState)
        Assert.assertEquals( actualBerlinClockState.minuteState.bottomMinuteLightState,  expectedBerlinClockState.minuteState.bottomMinuteLightState)
    }
}