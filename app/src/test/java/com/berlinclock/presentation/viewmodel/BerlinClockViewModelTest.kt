package com.berlinclock.presentation.viewmodel

import com.berlinclock.constants.LightColorUI
import org.junit.Assert.*
import org.junit.Before
import org.junit.Test

class BerlinClockViewModelTest {
    private lateinit var berlinClockViewModel: BerlinClockViewModel

    @Before
    fun setup() {
        berlinClockViewModel = BerlinClockViewModel()
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
}