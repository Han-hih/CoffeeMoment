package com.app.coffeemoment.core.accessibility

data class AccessibilitySettings(
    val useLargeText: Boolean = false,
    val useHighContrast: Boolean = false,
    val useVoiceGuide: Boolean = false,
    val useLowMode: Boolean = false,
)
