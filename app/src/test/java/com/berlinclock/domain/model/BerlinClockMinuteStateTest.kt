package com.berlinclock.domain.model

import com.berlinclock.constants.LightColor
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class BerlinClockMinuteStateTest {
    private lateinit var berlinClockMinuteState: BerlinClockMinuteState

    @Before
    fun setup() {
        berlinClockMinuteState = BerlinClockMinuteState()
    }

    @Test
    fun `check topMinuteLightState all top minute lights are initially Off`() {
        val topMinuteLightState = berlinClockMinuteState.topMinuteLightState

        Assert.assertEquals(true, topMinuteLightState.all {  it == LightColor.OFF })
    }

    @Test
    fun `check topMinuteLightState all top minute lights are Off when minute is in between 0 to 5`() {
        val minutes = 4

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val topMinuteLightState = berlinClockMinuteState.topMinuteLightState

        Assert.assertEquals(true, topMinuteLightState.all {  it == LightColor.OFF })
    }

    @Test
    fun `check topMinuteLightState all top minute lights are On when minute is in between 55 to 60`() {
        val minutes = 55

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val topMinuteLightState = berlinClockMinuteState.topMinuteLightState

        Assert.assertEquals(true, topMinuteLightState.any {  it != LightColor.OFF })
    }

    @Test
    fun `check topMinuteLightState some top minute lights are On when minute is greater than 5`() {
        val minutes = 10

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val topMinuteLightState = berlinClockMinuteState.topMinuteLightState

        Assert.assertEquals(true, topMinuteLightState.any {  it != LightColor.OFF })
    }

    @Test
    fun `check topMinuteLightState some top minute light would be of red color when minute is greater than 15`() {
        val minutes = 15

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val topMinuteLightState = berlinClockMinuteState.topMinuteLightState

        Assert.assertEquals(true, topMinuteLightState.any {  it == LightColor.RED })
    }

    @Test
    fun `check topMinuteLightState top minute lights would contain two red color lights when minute is in between 30 to 45`() {
        val minutes = 35

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val topMinuteLightState = berlinClockMinuteState.topMinuteLightState

        Assert.assertEquals(2, topMinuteLightState.count { it == LightColor.RED })
    }

    @Test
    fun `check topMinuteLightState top minute lights would contain three red color lights when minute is in between 45 to 60`() {
        val minutes = 59

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val topMinuteLightState = berlinClockMinuteState.topMinuteLightState

        Assert.assertEquals(3, topMinuteLightState.count { it == LightColor.RED })
    }

    @Test
    fun `check bottomMinuteLightState all bottom minute lights are initially Off`() {
        val bottomMinuteLightState = berlinClockMinuteState.bottomMinuteLightState

        Assert.assertEquals(true, bottomMinuteLightState.all {  it == LightColor.OFF })
    }

    @Test
    fun `check bottomMinuteLightState all bottom minute lights are Off when minute is divisible by 5`() {
        val minutes = 20

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val bottomMinuteLightState = berlinClockMinuteState.bottomMinuteLightState

        Assert.assertEquals(true, bottomMinuteLightState.all {  it == LightColor.OFF })
    }

    @Test
    fun `check bottomMinuteLightState all bottom minute lights are On when minute divided by 5 gives remainder less than 5`() {
        val minutes = 19

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val bottomMinuteLightState = berlinClockMinuteState.bottomMinuteLightState

        Assert.assertEquals(true, bottomMinuteLightState.all {  it == LightColor.YELLOW })
    }

    @Test
    fun `check bottomMinuteLightState some bottom minute lights are On when minute divided by 5 gives remainder between 1 to 4`() {
        val minutes = 16

        berlinClockMinuteState.updateMinuteLightState(minutes)
        val bottomMinuteLightState = berlinClockMinuteState.bottomMinuteLightState

        Assert.assertEquals(true, bottomMinuteLightState.any {  it == LightColor.YELLOW })
    }
}