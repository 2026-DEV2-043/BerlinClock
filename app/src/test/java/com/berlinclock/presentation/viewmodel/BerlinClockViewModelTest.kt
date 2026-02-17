package com.berlinclock.presentation.viewmodel

import app.cash.turbine.test
import com.berlinclock.constants.BOTTOM_MINUTE_LIGHT_COUNT
import com.berlinclock.constants.HOUR_LIGHT_COUNT
import com.berlinclock.constants.INITIAL_TIME
import com.berlinclock.constants.LightColorUI
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclock.domain.model.BerlinClockHourState
import com.berlinclock.domain.model.BerlinClockMinuteState
import com.berlinclock.domain.model.BerlinClockSecondState
import com.berlinclock.domain.model.BerlinClockState
import com.berlinclock.domain.usecase.BerlinClockStateUseCase
import com.berlinclock.presentation.model.BerlinClockUIState
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

class BerlinClockViewModelTest {
    private lateinit var berlinClockViewModel: BerlinClockViewModel

    private var berlinClockStateUseCase = mockk<BerlinClockStateUseCase>(relaxed = true)

    @Before
    fun setup() {
        berlinClockViewModel = BerlinClockViewModel(berlinClockStateUseCase)
    }

    @Test
    fun `check secondLight is initially Off`() {
        assertEquals(true, berlinClockViewModel.berlinClockState.value.secondLight == LightColorUI.OFF)
    }

    @Test
    fun `check topHourLight are initially OFF`() {
        assertEquals(true, berlinClockViewModel.berlinClockState.value.topHourLight.all { it == LightColorUI.OFF })
    }

    @Test
    fun `check bottomHourLight are initially OFF`() {
        assertEquals(true, berlinClockViewModel.berlinClockState.value.bottomHourLight.all { it == LightColorUI.OFF })
    }

    @Test
    fun `check topMinuteLight are initially OFF`() {
        assertEquals(true, berlinClockViewModel.berlinClockState.value.topMinuteLight.all { it == LightColorUI.OFF })
    }

    @Test
    fun `check bottomMinuteLight are initially OFF`() {
        assertEquals(true, berlinClockViewModel.berlinClockState.value.bottomMinuteLight.all { it == LightColorUI.OFF })
    }

    @Test
    fun `check initial formattedTime value`() {
        assertEquals(true, berlinClockViewModel.berlinClockState.value.formattedTime == "00:00:00")
    }

    @Test
    fun `check berlin clock ui states are updating as per system time`() = runTest {

        val  initialBerlinClockState = BerlinClockState(
            BerlinClockSecondState(),
            BerlinClockHourState(),
            BerlinClockMinuteState(),
            INITIAL_TIME
        )

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

        val berlinClockStateUIState = BerlinClockUIState(
            secondLight = LightColorUI.OFF,
            topHourLight = MutableList(HOUR_LIGHT_COUNT) { LightColorUI.RED },
            bottomHourLight = mutableListOf(
                LightColorUI.RED,
                LightColorUI.RED,
                LightColorUI.RED,
                LightColorUI.OFF
            ),
            topMinuteLight = mutableListOf(
                LightColorUI.YELLOW,
                LightColorUI.YELLOW,
                LightColorUI.RED,
                LightColorUI.YELLOW,
                LightColorUI.YELLOW,
                LightColorUI.RED,
                LightColorUI.YELLOW,
                LightColorUI.YELLOW,
                LightColorUI.RED,
                LightColorUI.YELLOW,
                LightColorUI.YELLOW),
            bottomMinuteLight = MutableList(BOTTOM_MINUTE_LIGHT_COUNT) { LightColorUI.YELLOW }
        )

        coEvery { berlinClockStateUseCase() } returns flow {
            emit(initialBerlinClockState)
            delay(100)
            emit(expectedBerlinClockState)
        }

        val berlinClockViewModel = BerlinClockViewModel(berlinClockStateUseCase)
        berlinClockViewModel.berlinClockState.test {
            val initialBerlinClockStateResult = awaitItem()
            assertEquals(LightColorUI.OFF, initialBerlinClockStateResult.secondLight)
            assertEquals(List(HOUR_LIGHT_COUNT) { LightColorUI.OFF }, initialBerlinClockStateResult.topHourLight)
            assertEquals(List(HOUR_LIGHT_COUNT) { LightColorUI.OFF }, initialBerlinClockStateResult.bottomHourLight)
            assertEquals(List(TOP_MINUTE_LIGHT_COUNT) { LightColorUI.OFF }, initialBerlinClockStateResult.topMinuteLight)
            assertEquals(List(BOTTOM_MINUTE_LIGHT_COUNT) { LightColorUI.OFF }, initialBerlinClockStateResult.bottomMinuteLight)

            val berlinClockStateResult = awaitItem()
            assertEquals(LightColorUI.OFF, berlinClockStateResult.secondLight)
            assertEquals(berlinClockStateUIState.topHourLight, berlinClockStateResult.topHourLight)
            assertEquals(berlinClockStateUIState.bottomHourLight, berlinClockStateResult.bottomHourLight)
            assertEquals(berlinClockStateUIState.topMinuteLight, berlinClockStateResult.topMinuteLight)
            assertEquals(berlinClockStateUIState.bottomMinuteLight, berlinClockStateResult.bottomMinuteLight)

            cancelAndIgnoreRemainingEvents()
        }
    }
}