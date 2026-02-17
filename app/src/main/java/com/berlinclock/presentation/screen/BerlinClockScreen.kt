package com.berlinclock.presentation.screen
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.berlinclock.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BerlinClockScreen() {
    Scaffold (modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(
                title = {
                    Text(stringResource(R.string.screen_title))
                }
            )
        }
    ) { innerPadding ->

    }
}

@Preview(showBackground = true)
@Composable
fun BerlinClockScreenPreview() {
    BerlinClockScreen()
}