package com.app.coffeemoment.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.toggleable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.coffeemoment.core.designsystem.R
import com.app.coffeemoment.core.designsystem.theme.CoffeeMomentTheme
import com.app.coffeemoment.core.designsystem.theme.Colors
import com.app.coffeemoment.core.designsystem.theme.TextStyles

@Composable
fun AccessibilityControls(
    useLargeText: Boolean,
    useHighContrast: Boolean,
    useVoiceGuide: Boolean,
    useLowMode: Boolean,
    onLargeTextChange: (Boolean) -> Unit,
    onHighContrastChange: (Boolean) -> Unit,
    onVoiceGuideChange: (Boolean) -> Unit,
    onLowModeChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
    largeTextModifier: Modifier = Modifier,
    highContrastModifier: Modifier = Modifier,
    voiceGuideModifier: Modifier = Modifier,
    lowModeModifier: Modifier = Modifier,
) {
    FlowRow(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp, vertical = 8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp),
    ) {
        AccessibilityToggle(
            text = stringResource(R.string.accessibility_low_mode),
            selected = useLowMode,
            onSelectedChange = onLowModeChange,
            modifier = lowModeModifier,
        )
        AccessibilityToggle(
            text = stringResource(R.string.accessibility_large_text),
            selected = useLargeText,
            onSelectedChange = onLargeTextChange,
            modifier = largeTextModifier,
        )
        AccessibilityToggle(
            text = stringResource(R.string.accessibility_high_contrast),
            selected = useHighContrast,
            onSelectedChange = onHighContrastChange,
            modifier = highContrastModifier,
        )
        AccessibilityToggle(
            text = stringResource(R.string.accessibility_voice_guide),
            selected = useVoiceGuide,
            onSelectedChange = onVoiceGuideChange,
            modifier = voiceGuideModifier,
        )
    }
}

@Composable
private fun AccessibilityToggle(
    text: String,
    selected: Boolean,
    onSelectedChange: (Boolean) -> Unit,
    modifier: Modifier = Modifier,
) {
    var isFocused by remember { mutableStateOf(false) }
    val containerColor = if (selected) Colors.colors.primary else Colors.colors.surface
    val contentColor = if (selected) Colors.colors.onPrimary else Colors.colors.onSurface

    Surface(
        modifier = modifier
            .onFocusChanged { isFocused = it.isFocused }
            .focusIndicator(
                isFocused = isFocused,
            )
            .heightIn(min = 48.dp)
            .toggleable(
                value = selected,
                role = Role.Switch,
                onValueChange = onSelectedChange,
            ),
        shape = RoundedCornerShape(8.dp),
        color = containerColor,
        contentColor = contentColor,
    ) {
        Text(
            text = text,
            style = TextStyles.text40b,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 10.dp),
        )
    }
}

@Preview(showBackground = true, widthDp = 720)
@Composable
private fun AccessibilityControlsPreview() {
    CoffeeMomentTheme {
        AccessibilityControls(
            useLargeText = true,
            useHighContrast = false,
            useVoiceGuide = false,
            useLowMode = false,
            onLargeTextChange = {},
            onHighContrastChange = {},
            onVoiceGuideChange = {},
            onLowModeChange = {},
            modifier = Modifier.padding(16.dp),
        )
    }
}
