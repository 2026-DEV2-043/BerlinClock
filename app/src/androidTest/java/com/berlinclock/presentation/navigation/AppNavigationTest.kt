package com.berlinclock.presentation.navigation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class AppNavigationTest {
    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testTitleVisibility_isVisible() {
        composeTestRule.setContent {
            AppNavigation()
        }
        composeTestRule.onNodeWithText("Berlin Clock").assertIsDisplayed()
    }
}