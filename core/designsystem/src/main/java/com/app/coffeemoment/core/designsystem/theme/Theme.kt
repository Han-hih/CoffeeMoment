package com.app.coffeemoment.core.designsystem.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext

private val LightColorScheme = lightColorScheme(
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

// Dark-mode adaptation of the supplied palette; not a separate Figma specification.
private val DarkColorScheme = darkColorScheme(
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

@Composable
fun CoffeeMomentTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Keep the brand palette by default; wallpaper colors are opt-in on Android 12+.
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
