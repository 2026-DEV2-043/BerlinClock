package com.berlinclock.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
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

@Composable
fun BerlinClock(clockState: BerlinClockUIState) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
    ) {
        SecondsLight(clockState.secondLight)
        HourLights(clockState)
        MinuteLights(clockState)
    }
}

@Composable
fun SecondsLight(light: LightColorUI) {
    Box(
        modifier = Modifier
            .padding(vertical = 8.dp)
            .size(80.dp)
            .clip(CircleShape)
            .border(2.dp, Color.Black, CircleShape)
            .background(light.color)
            .semantics {
                testTag = if (light == LightColorUI.OFF) TEST_TAG_OFF else TEST_TAG_ON
                contentDescription = TEST_SECOND_TAG
            }
    )
}

@Composable
fun HourLights(clockState: BerlinClockUIState) {
    val modifier = Modifier.fillMaxWidth()
    TopHourLights(modifier, clockState.topHourLight)
    BottomHourLights(modifier, clockState.bottomHourLight)
}

@Composable
fun TopHourLights(modifier: Modifier, lights: List<LightColorUI>) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(lights.size) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                val light = lights[it]
                ClockLight(
                    tag = TEST_TOP_HOUR_TAG,
                    light = light
                )
            }
        }
    }
}

@Composable
fun BottomHourLights(modifier: Modifier, lights: List<LightColorUI>) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center
    ) {
        repeat(lights.size) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                val light = lights[it]
                ClockLight(
                    tag = TEST_BOTTOM_HOUR_TAG,
                    light = light
                )
            }
        }
    }
}

@Composable
fun MinuteLights(clockState: BerlinClockUIState) {
    TopMinuteLights(clockState.topMinuteLight)
    BottomMinuteLights(clockState.bottomMinuteLight)
}

@Composable
fun TopMinuteLights(lights: List<LightColorUI>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(lights.size) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                val light = lights[it]
                ClockLight(
                    tag = TEST_TOP_MINUTES_TAG,
                    light = light
                )
            }
        }
    }
}

@Composable
fun BottomMinuteLights(lights: List<LightColorUI>) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        repeat(lights.size) {
            Row(
                modifier = Modifier.weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                val light = lights[it]
                ClockLight(
                    tag = TEST_BOTTOM_MINUTES_TAG,
                    light = light
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun BerlinClockPreview() {
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