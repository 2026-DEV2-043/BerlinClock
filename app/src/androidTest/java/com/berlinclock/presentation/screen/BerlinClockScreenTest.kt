package com.berlinclock.presentation.screen

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.berlinclock.constants.BOTTOM_MINUTE_LIGHT_COUNT
import com.berlinclock.constants.HOUR_LIGHT_COUNT
import com.berlinclock.constants.LightColorUI
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclock.presentation.model.BerlinClockUIState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BerlinClockScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTitleVisibility_isNotVisible() {
        val berlinUIClockState= BerlinClockUIState(
            LightColorUI.OFF,
            List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
            List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
            List(TOP_MINUTE_LIGHT_COUNT) { LightColorUI.OFF },
            List(BOTTOM_MINUTE_LIGHT_COUNT) { LightColorUI.OFF },
            "00:00:00"
        )

        composeTestRule.setContent {
            BerlinClockScreen(berlinUIClockState)
        }
        composeTestRule.onNodeWithText("Title").assertIsNotDisplayed()
    }

    @Test
    fun testTitleVisibility_isVisible() {
        val berlinUIClockState= BerlinClockUIState(
            LightColorUI.OFF,
            List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
            List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
            List(TOP_MINUTE_LIGHT_COUNT) { LightColorUI.OFF },
            List(BOTTOM_MINUTE_LIGHT_COUNT) { LightColorUI.OFF },
            "00:00:00"
        )

        composeTestRule.setContent {
            BerlinClockScreen(berlinUIClockState)
        }
        composeTestRule.onNodeWithText("Berlin Clock").assertIsDisplayed()
    }
}