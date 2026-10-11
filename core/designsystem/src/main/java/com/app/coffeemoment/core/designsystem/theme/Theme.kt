package com.app.coffeemoment.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.platform.LocalContext
import com.app.coffeemoment.core.accessibility.AccessibilitySettings

internal val LightColorScheme = lightColorScheme(
    primary = Green900,
    onPrimary = Cream50,
    primaryContainer = Green100,
    onPrimaryContainer = Green900,
    secondary = Gray600,
    onSecondary = Cream50,
    secondaryContainer = Green100,
    onSecondaryContainer = Gray900,
    tertiary = Green900,
    onTertiary = Cream50,
    tertiaryContainer = Green100,
    onTertiaryContainer = Gray900,
    background = Cream50,
    onBackground = Gray900,
    surface = Cream50,
    onSurface = Gray900,
    surfaceVariant = Green100,
    onSurfaceVariant = Gray600,
    surfaceTint = Green900,
    surfaceBright = Cream50,
    surfaceDim = Green100,
    surfaceContainerLowest = Cream50,
    surfaceContainerLow = Cream50,
    surfaceContainer = Cream50,
    surfaceContainerHigh = Green100,
    surfaceContainerHighest = Green100,
    outline = Gray600,
    outlineVariant = Green100,
    inverseSurface = Gray900,
    inverseOnSurface = Cream50,
    inversePrimary = Green100,
)

internal val DarkColorScheme = darkColorScheme(
    primary = Green100,
    onPrimary = Green900,
    primaryContainer = Green900,
    onPrimaryContainer = Cream50,
    secondary = Green100,
    onSecondary = Gray900,
    secondaryContainer = Gray600,
    onSecondaryContainer = Cream50,
    tertiary = Green100,
    onTertiary = Green900,
    tertiaryContainer = Green900,
    onTertiaryContainer = Cream50,
    background = Gray900,
    onBackground = Cream50,
    surface = Gray900,
    onSurface = Cream50,
    surfaceVariant = Gray600,
    onSurfaceVariant = Green100,
    surfaceTint = Green100,
    surfaceBright = Gray600,
    surfaceDim = Gray900,
    surfaceContainerLowest = Gray900,
    surfaceContainerLow = Gray900,
    surfaceContainer = Gray900,
    surfaceContainerHigh = Green900,
    surfaceContainerHighest = Gray600,
    outline = Green100,
    outlineVariant = Gray600,
    inverseSurface = Cream50,
    inverseOnSurface = Gray900,
    inversePrimary = Green900,
)

internal val HighContrastLightColorScheme = lightColorScheme(
    primary = Green900,
    onPrimary = PureWhite,
    primaryContainer = Green100,
    onPrimaryContainer = PureBlack,
    secondary = Gray900,
    onSecondary = PureWhite,
    secondaryContainer = Green100,
    onSecondaryContainer = PureBlack,
    tertiary = Gray900,
    onTertiary = PureWhite,
    tertiaryContainer = Green100,
    onTertiaryContainer = PureBlack,
    background = PureWhite,
    onBackground = PureBlack,
    surface = PureWhite,
    onSurface = PureBlack,
    surfaceVariant = Green100,
    onSurfaceVariant = PureBlack,
    outline = PureBlack,
)

internal val HighContrastDarkColorScheme = darkColorScheme(
    primary = Green100,
    onPrimary = PureBlack,
    primaryContainer = Green900,
    onPrimaryContainer = PureWhite,
    secondary = PureWhite,
    onSecondary = PureBlack,
    secondaryContainer = Gray900,
    onSecondaryContainer = PureWhite,
    tertiary = Green100,
    onTertiary = PureBlack,
    tertiaryContainer = Green900,
    onTertiaryContainer = PureWhite,
    background = PureBlack,
    onBackground = PureWhite,
    surface = PureBlack,
    onSurface = PureWhite,
    surfaceVariant = Gray900,
    onSurfaceVariant = PureWhite,
    outline = PureWhite,
)

@Composable
fun CoffeeMomentTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    accessibilitySettings: AccessibilitySettings = AccessibilitySettings(),
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        accessibilitySettings.useHighContrast && darkTheme -> HighContrastDarkColorScheme
        accessibilitySettings.useHighContrast -> HighContrastLightColorScheme
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    CompositionLocalProvider(
        LocalTextScale provides if (accessibilitySettings.useLargeText) 1.2f else 1f,
    ) {
        MaterialTheme(
            colorScheme = colorScheme,
            typography = coffeeTypography(),
            content = content,
        )
    }
}
