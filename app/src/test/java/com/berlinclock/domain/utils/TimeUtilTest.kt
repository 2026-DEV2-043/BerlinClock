package com.berlinclock.domain.utils

import org.junit.Assert
import org.junit.Before
import org.junit.Test

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
}