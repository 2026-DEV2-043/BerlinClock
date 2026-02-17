package com.berlinclock.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.semantics.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.berlinclock.constants.LightColorUI
import com.berlinclock.constants.TEST_TAG_OFF
import com.berlinclock.constants.TEST_TAG_ON

@Composable
fun ClockLight(
    tag: String,
    light: LightColorUI
) {
    Column(modifier = Modifier.padding(2.dp)) {
        Box(
            modifier = Modifier
                .padding(horizontal = 0.dp, vertical = 5.dp)
                .fillMaxWidth()
                .size(60.dp)
                .border(2.dp, Color.Black)
                .background(light.color)
                .semantics {
                    testTag = if (light == LightColorUI.OFF) TEST_TAG_OFF else TEST_TAG_ON
                    contentDescription = tag
                }
        )
    }
}

@Preview(showBackground = true)
@Composable
fun ClockLightPreview() {
    ClockLight(
        "",
        LightColorUI.RED
    )
}