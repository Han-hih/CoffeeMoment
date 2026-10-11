package com.app.coffeemoment.core.designsystem.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.ui.graphics.Color
import org.junit.Assert.assertTrue
import org.junit.Test
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow

class ColorContrastTest {
    @Test
    fun normalColorSchemesMeetFourPointFiveToOne() {
        assertMinimumContrast(LightColorScheme, 4.5)
        assertMinimumContrast(DarkColorScheme, 4.5)
    }

    @Test
    fun highContrastColorSchemesMeetSevenToOne() {
        assertMinimumContrast(HighContrastLightColorScheme, 7.0)
        assertMinimumContrast(HighContrastDarkColorScheme, 7.0)
    }

    private fun assertMinimumContrast(colorScheme: ColorScheme, minimum: Double) {
        colorScheme.contentPairs().forEach { (foreground, background) ->
            val contrast = contrastRatio(foreground, background)
            assertTrue(
                "Contrast ratio $contrast is below $minimum",
                contrast >= minimum,
            )
        }
    }

    private fun ColorScheme.contentPairs() = listOf(
        onPrimary to primary,
        onPrimaryContainer to primaryContainer,
        onSecondary to secondary,
        onSecondaryContainer to secondaryContainer,
        onTertiary to tertiary,
        onTertiaryContainer to tertiaryContainer,
        onBackground to background,
        onSurface to surface,
        onSurfaceVariant to surfaceVariant,
    )

    private fun contrastRatio(first: Color, second: Color): Double {
        val firstLuminance = first.relativeLuminance()
        val secondLuminance = second.relativeLuminance()
        return (max(firstLuminance, secondLuminance) + 0.05) /
            (min(firstLuminance, secondLuminance) + 0.05)
    }

    private fun Color.relativeLuminance(): Double {
        fun linearize(channel: Float): Double {
            val value = channel.toDouble()
            return if (value <= 0.04045) {
                value / 12.92
            } else {
                ((value + 0.055) / 1.055).pow(2.4)
            }
        }

        return 0.2126 * linearize(red) +
            0.7152 * linearize(green) +
            0.0722 * linearize(blue)
    }
}
