package com.berlinclock.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.berlinclock.presentation.screen.BerlinClockScreen
import com.berlinclock.presentation.ui.theme.BerlinClockTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            BerlinClockTheme {
                App()
            }
        }
    }
}

@Composable
fun App() {
    BerlinClockScreen()
}

@Preview(showBackground = true)
@Composable
fun AppPreview() {
    BerlinClockTheme {
        App()
    }
}