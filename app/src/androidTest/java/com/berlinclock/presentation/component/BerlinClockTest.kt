package com.berlinclock.presentation.component

import androidx.compose.ui.test.assertAll
import androidx.compose.ui.test.assertAny
import androidx.compose.ui.test.hasTestTag
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onAllNodesWithContentDescription
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.berlinclock.constants.BOTTOM_MINUTE_LIGHT_COUNT
import com.berlinclock.constants.HOUR_LIGHT_COUNT
import com.berlinclock.constants.LightColorUI
import com.berlinclock.constants.TEST_BOTTOM_HOUR_TAG
import com.berlinclock.constants.TEST_BOTTOM_MINUTES_TAG
import com.berlinclock.constants.TEST_SECOND_TAG
import com.berlinclock.constants.TEST_TAG_OFF
import com.berlinclock.constants.TEST_TAG_ON
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

    @Test
    fun testBerlinClockForSpecificTime() {
        val secondLight = LightColorUI.OFF

        val topHourLight = MutableList(HOUR_LIGHT_COUNT) { LightColorUI.OFF }
        topHourLight[0] = LightColorUI.RED
        topHourLight[1] = LightColorUI.RED

        val bottomHourLight = MutableList(HOUR_LIGHT_COUNT) { LightColorUI.OFF }
        bottomHourLight[0] = LightColorUI.RED
        bottomHourLight[1] = LightColorUI.RED
        bottomHourLight[2] = LightColorUI.RED

        val topMinuteLight = MutableList(TOP_MINUTE_LIGHT_COUNT) { LightColorUI.OFF }
        topMinuteLight[0] = LightColorUI.YELLOW

        val bottomMinuteLight = MutableList(BOTTOM_MINUTE_LIGHT_COUNT) { LightColorUI.OFF }
        bottomMinuteLight[0] = LightColorUI.YELLOW
        bottomMinuteLight[1] = LightColorUI.YELLOW
        bottomMinuteLight[2] = LightColorUI.YELLOW
        bottomMinuteLight[3] = LightColorUI.YELLOW

        val berlinClockState = BerlinClockUIState(
            secondLight = secondLight,
            topHourLight = topHourLight,
            bottomHourLight = bottomHourLight,
            topMinuteLight = topMinuteLight,
            bottomMinuteLight = bottomMinuteLight,
            formattedTime = "13:09:15"
        )

        composeTestRule.setContent {
            BerlinClock(berlinClockState)
        }

        composeTestRule.onNodeWithTag(TEST_TAG_OFF)
        composeTestRule.onAllNodesWithContentDescription(TEST_TOP_HOUR_TAG).assertAny(
            hasTestTag(TEST_TAG_ON))
        composeTestRule.onAllNodesWithContentDescription(TEST_BOTTOM_HOUR_TAG).assertAny(
            hasTestTag(TEST_TAG_ON))
        composeTestRule.onAllNodesWithContentDescription(TEST_TOP_MINUTES_TAG).assertAny(
            hasTestTag(TEST_TAG_ON))
        composeTestRule.onAllNodesWithContentDescription(TEST_BOTTOM_MINUTES_TAG).assertAny(
            hasTestTag(TEST_TAG_ON))
    }
}