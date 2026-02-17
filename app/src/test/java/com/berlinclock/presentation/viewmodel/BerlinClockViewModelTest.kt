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
}