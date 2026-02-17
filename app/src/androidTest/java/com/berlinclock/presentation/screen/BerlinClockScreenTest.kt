package com.berlinclock.presentation.screen

import androidx.compose.ui.test.assertIsNotDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class BerlinClockScreenTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTitleVisibility_isNotVisible() {
        composeTestRule.setContent {
            BerlinClockScreen()
        }
        composeTestRule.onNodeWithText("Title").assertIsNotDisplayed()
    }
}