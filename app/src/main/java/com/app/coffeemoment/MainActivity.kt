package com.app.coffeemoment

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import com.app.coffeemoment.core.accessibility.AccessibilitySettings
import com.app.coffeemoment.core.designsystem.theme.CoffeeMomentTheme
import com.app.coffeemoment.feature.order.HomeScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var useLargeText by rememberSaveable { mutableStateOf(false) }
            var useHighContrast by rememberSaveable { mutableStateOf(false) }
            var useVoiceGuide by rememberSaveable { mutableStateOf(false) }
            var useLowMode by rememberSaveable { mutableStateOf(false) }
            val accessibilitySettings = AccessibilitySettings(
                useLargeText = useLargeText,
                useHighContrast = useHighContrast,
                useVoiceGuide = useVoiceGuide,
                useLowMode = useLowMode,
            )

            CoffeeMomentTheme(accessibilitySettings = accessibilitySettings) {
                HomeScreen(
                    useLargeText = useLargeText,
                    useHighContrast = useHighContrast,
                    useVoiceGuide = useVoiceGuide,
                    useLowMode = useLowMode,
                    onLargeTextChange = { useLargeText = it },
                    onHighContrastChange = { useHighContrast = it },
                    onVoiceGuideChange = { useVoiceGuide = it },
                    onLowModeChange = { useLowMode = it },
                    onStartOrder = {},
                )
            }
        }
    }
}
