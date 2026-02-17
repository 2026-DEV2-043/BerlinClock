package com.berlinclock.presentation.component

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.berlinclock.constants.LightColorUI
import com.berlinclock.constants.TEST_TAG_OFF
import com.berlinclock.constants.TEST_TOP_HOUR_TAG
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ClockLightTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun test_ClockLight_isOff() {
        composeTestRule.setContent {
            ClockLight(TEST_TOP_HOUR_TAG, LightColorUI.OFF)
        }
        composeTestRule.onNodeWithTag(TEST_TAG_OFF).assertIsDisplayed()
    }
}