package com.example.a29
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class WaterTrackerTest {
    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Test
    fun testAddWaterButton() {
        composeTestRule.onNodeWithText("+250 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("+250 мл").performClick()
        composeTestRule.onNodeWithText("250 мл").assertIsDisplayed()
    }

    @Test
    fun testEndDayButton() {
        composeTestRule.onNodeWithText("Завершить день").assertIsDisplayed()
        repeat(4) { composeTestRule.onNodeWithText("+250 мл").performClick() }
        composeTestRule.onNodeWithText("1000 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 дней подряд").assertIsDisplayed()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 дней подряд").assertIsDisplayed()
    }

    @Test
    fun testStreak() {
        composeTestRule.onNodeWithText("0 дней подряд").assertIsDisplayed()
        repeat(6) { composeTestRule.onNodeWithText("+250 мл").performClick() }
        composeTestRule.onNodeWithText("1500 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("1 дней подряд").assertIsDisplayed()
        repeat(3) { composeTestRule.onNodeWithText("+250 мл").performClick() }
        composeTestRule.onNodeWithText("750 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("Завершить день").performClick()
        composeTestRule.onNodeWithText("0 мл").assertIsDisplayed()
        composeTestRule.onNodeWithText("0 дней подряд").assertIsDisplayed()
    }
}