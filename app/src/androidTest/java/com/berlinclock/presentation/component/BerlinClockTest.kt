package com.berlinclock.presentation.component

import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.berlinclock.constants.BOTTOM_MINUTE_LIGHT_COUNT
import com.berlinclock.constants.HOUR_LIGHT_COUNT
import com.berlinclock.constants.LightColorUI
import com.berlinclock.constants.TEST_BOTTOM_HOUR_TAG
import com.berlinclock.constants.TEST_BOTTOM_MINUTES_TAG
import com.berlinclock.constants.TEST_SECOND_TAG
import com.berlinclock.constants.TEST_TAG_OFF
import com.berlinclock.constants.TEST_TOP_HOUR_TAG
import com.berlinclock.constants.TEST_TOP_MINUTES_TAG
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclock.presentation.model.BerlinClockUIState
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BerlinClockTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testAllLightAreInitiallyOFF() {
        composeTestRule.setContent {
            val initialBerlinUIClockState= BerlinClockUIState(
                LightColorUI.OFF,
                List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
                List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
                List(TOP_MINUTE_LIGHT_COUNT) { LightColorUI.OFF },
                List(BOTTOM_MINUTE_LIGHT_COUNT) { LightColorUI.OFF },
                "00:00:00"
            )
            BerlinClock(initialBerlinUIClockState)
        }
        composeTestRule.onAllNodesWithContentDescription(TEST_SECOND_TAG).assertAll(
            hasTestTag(TEST_TAG_OFF))
        composeTestRule.onAllNodesWithContentDescription(TEST_TOP_HOUR_TAG).assertAll(
            hasTestTag(TEST_TAG_OFF))
        composeTestRule.onAllNodesWithContentDescription(TEST_BOTTOM_HOUR_TAG).assertAll(
            hasTestTag(TEST_TAG_OFF))
        composeTestRule.onAllNodesWithContentDescription(TEST_TOP_MINUTES_TAG).assertAll(
            hasTestTag(TEST_TAG_OFF))
        composeTestRule.onAllNodesWithContentDescription(TEST_BOTTOM_MINUTES_TAG).assertAll(
            hasTestTag(TEST_TAG_OFF))
    }
}