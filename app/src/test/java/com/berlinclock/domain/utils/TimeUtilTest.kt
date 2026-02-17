package com.berlinclock.domain.utils

import io.mockk.every
import io.mockk.mockkStatic
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import java.time.LocalTime

class TimeUtilTest {
    private lateinit var timeUtil: TimeUtil

    @Before
    fun setup() {
        timeUtil = TimeUtil()
    }

    @Test
    fun `check getFormattedTime is giving expected formatted time`() {
        val formattedTime = timeUtil.getFormattedTime()

        Assert.assertNotNull(formattedTime)
    }

    @Test
    fun `check getFormattedTime is giving expected formatted time - 23-59-59`() {
        val expectedTime = "23:59:59"

        mockkStatic(LocalTime::class)
        every { LocalTime.now() } returns LocalTime.of(23, 59, 59)

        val formattedTime = timeUtil.getFormattedTime()

        Assert.assertEquals(true, expectedTime == formattedTime)
    }

    @Test
    fun `check getTimeComponent is giving expected TimeComponent`() {
        val expectedHour = 0
        val expectedMinute = 0
        val expectedSecond = 0

        mockkStatic(LocalTime::class)
        every { LocalTime.now() } returns LocalTime.of(0, 0, 0)

        val actualTimeComponent = timeUtil.getTimeComponent()

        Assert.assertEquals(true, expectedHour == actualTimeComponent.hour)
        Assert.assertEquals(true, expectedMinute == actualTimeComponent.minute)
        Assert.assertEquals(true, expectedSecond == actualTimeComponent.second)
    }

    @Test
    fun `check getTimeComponent is giving expected TimeComponent for 23-59-59`() {
        val expectedHour = 23
        val expectedMinute = 59
        val expectedSecond = 59

        mockkStatic(LocalTime::class)
        every { LocalTime.now() } returns LocalTime.of(23, 59, 59)

        val actualTimeComponent = timeUtil.getTimeComponent()

        Assert.assertEquals(true, expectedHour == actualTimeComponent.hour)
        Assert.assertEquals(true, expectedMinute == actualTimeComponent.minute)
        Assert.assertEquals(true, expectedSecond == actualTimeComponent.second)
    }
}