package com.berlinclock.presentation.screen
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.berlinclock.R
import com.berlinclock.constants.BOTTOM_MINUTE_LIGHT_COUNT
import com.berlinclock.constants.HOUR_LIGHT_COUNT
import com.berlinclock.constants.LightColorUI
import com.berlinclock.constants.TOP_MINUTE_LIGHT_COUNT
import com.berlinclock.presentation.component.BerlinClock
import com.berlinclock.presentation.model.BerlinClockUIState
import com.berlinclock.presentation.viewmodel.BerlinClockViewModel

@Composable
fun BerlinClockScreen(
    berlinClockViewModel: BerlinClockViewModel = hiltViewModel()
) {
    val berlinClockUIState = berlinClockViewModel.berlinClockState.collectAsStateWithLifecycle().value
    BerlinClockScreen(berlinClockUIState)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerlinClockScreen(berlinClockUIState: BerlinClockUIState) {
    Scaffold (modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.screen_title),
                        modifier = Modifier.fillMaxWidth(),
                        textAlign = TextAlign.Center,
                        color = Color.Black,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 30.sp
                    )
                }
            )
        }
    ) {
        innerPadding ->
        Column (modifier = Modifier.padding(innerPadding), content = {
            BerlinClock(berlinClockUIState)
            Text(berlinClockUIState.formattedTime,
                modifier = Modifier.fillMaxWidth().padding(40.dp),
                textAlign = TextAlign.Center,
                color = Color.Black,
                fontSize = 30.sp,
                fontWeight = FontWeight.Bold)
        })
    }
}

@Preview(showBackground = true)
@Composable
fun BerlinClockScreenPreview() {
    val berlinUIClockState= BerlinClockUIState(
        LightColorUI.OFF,
        List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
        List(HOUR_LIGHT_COUNT) { LightColorUI.OFF },
        List(TOP_MINUTE_LIGHT_COUNT) { LightColorUI.OFF },
        List(BOTTOM_MINUTE_LIGHT_COUNT) { LightColorUI.OFF },
        "00:00:00"
    )
    BerlinClockScreen(berlinUIClockState)
}