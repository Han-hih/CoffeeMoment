package com.app.coffeemoment.feature.order

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.focusable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.safeDrawingPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusProperties
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.coffeemoment.core.designsystem.component.AccessibilityControls
import com.app.coffeemoment.core.designsystem.component.ProceedButton
import com.app.coffeemoment.core.designsystem.component.focusIndicator
import com.app.coffeemoment.core.designsystem.theme.CoffeeMomentTheme
import com.app.coffeemoment.core.designsystem.theme.Colors
import com.app.coffeemoment.core.designsystem.theme.TextStyles

@Composable
fun HomeScreen(
    useLargeText: Boolean,
    useHighContrast: Boolean,
    useVoiceGuide: Boolean,
    useLowMode: Boolean,
    onLargeTextChange: (Boolean) -> Unit,
    onHighContrastChange: (Boolean) -> Unit,
    onVoiceGuideChange: (Boolean) -> Unit,
    onLowModeChange: (Boolean) -> Unit,
    onStartOrder: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val screenFocusRequester = remember { FocusRequester() }
    val startOrderFocusRequester = remember { FocusRequester() }
    val largeTextFocusRequester = remember { FocusRequester() }
    val highContrastFocusRequester = remember { FocusRequester() }
    val voiceGuideFocusRequester = remember { FocusRequester() }
    val lowModeFocusRequester = remember { FocusRequester() }
    var isScreenFocused by remember { mutableStateOf(false) }
    val screenDescription = stringResource(R.string.home_screen_description)

    LaunchedEffect(Unit) {
        screenFocusRequester.requestFocus()
    }

    Box(
        modifier = modifier
            .fillMaxSize()
            .background(Colors.colors.background)
            .safeDrawingPadding(),
    ) {
        Column(modifier = Modifier.fillMaxSize()) {
            Column(
                modifier = Modifier
                    .weight(1f)
                    .verticalScroll(rememberScrollState())
                    .padding(horizontal = 20.dp, vertical = 24.dp),
                verticalArrangement = Arrangement.spacedBy(20.dp),
            ) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = stringResource(R.string.home_brand),
                        style = TextStyles.subText38r,
                        color = Colors.colors.primary,
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Text(
                        text = stringResource(R.string.home_welcome),
                        style = TextStyles.subText38r,
                        color = Colors.colors.onSurfaceVariant,
                    )
                }

                Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text(
                        text = stringResource(R.string.home_title),
                        style = TextStyles.title38b,
                        color = Colors.colors.onBackground,
                        modifier = Modifier.semantics { heading() },
                    )
                    Text(
                        text = stringResource(R.string.home_description),
                        style = TextStyles.subText38r,
                        color = Colors.colors.onSurfaceVariant,
                    )
                }

                RecommendationCard()

                    Text(
                        text = stringResource(R.string.home_order_guide_title),
                        style = TextStyles.label38b,
                        color = Colors.colors.onBackground,
                        modifier = Modifier.semantics { heading() },
                    )

            }

            ProceedButton(
                text = stringResource(R.string.home_start_order),
                onClick = onStartOrder,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp, vertical = 16.dp)
                    .focusRequester(startOrderFocusRequester)
                    .focusProperties {
                        right = lowModeFocusRequester
                        down = lowModeFocusRequester
                        left = screenFocusRequester
                        up = screenFocusRequester
                    },
            )

            Surface(color = Colors.colors.surfaceVariant) {
                AccessibilityControls(
                    useLargeText = useLargeText,
                    useHighContrast = useHighContrast,
                    useVoiceGuide = useVoiceGuide,
                    useLowMode = useLowMode,
                    onLargeTextChange = onLargeTextChange,
                    onHighContrastChange = onHighContrastChange,
                    onVoiceGuideChange = onVoiceGuideChange,
                    onLowModeChange = onLowModeChange,
                    lowModeModifier = Modifier
                        .focusRequester(lowModeFocusRequester)
                        .focusProperties {
                            right = largeTextFocusRequester
                            down = largeTextFocusRequester
                            left = startOrderFocusRequester
                            up = startOrderFocusRequester
                        },
                    largeTextModifier = Modifier
                        .focusRequester(largeTextFocusRequester)
                        .focusProperties {
                            right = highContrastFocusRequester
                            down = highContrastFocusRequester
                            left = lowModeFocusRequester
                            up = lowModeFocusRequester
                        },
                    highContrastModifier = Modifier
                        .focusRequester(highContrastFocusRequester)
                        .focusProperties {
                            right = voiceGuideFocusRequester
                            down = voiceGuideFocusRequester
                            left = largeTextFocusRequester
                            up = largeTextFocusRequester
                        },
                    voiceGuideModifier = Modifier
                        .focusRequester(voiceGuideFocusRequester)
                        .focusProperties {
                            right = screenFocusRequester
                            down = screenFocusRequester
                            left = highContrastFocusRequester
                            up = highContrastFocusRequester
                        },
                )
            }
        }

        Box(
            modifier = Modifier
                .fillMaxSize()
                .focusRequester(screenFocusRequester)
                .focusProperties {
                    right = startOrderFocusRequester
                    down = startOrderFocusRequester
                    left = voiceGuideFocusRequester
                    up = voiceGuideFocusRequester
                }
                .onFocusChanged { isScreenFocused = it.isFocused }
                .focusIndicator(
                    isFocused = isScreenFocused,
                    shape = RectangleShape,
                )
                .semantics { contentDescription = screenDescription }
                .focusable(),
        )
    }
}

@Composable
private fun RecommendationCard() {
    Surface(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(14.dp),
        color = Colors.colors.primaryContainer,
        contentColor = Colors.colors.onPrimaryContainer,
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
        ) {
            Text(
                text = stringResource(R.string.home_daily_coffee),
                style = TextStyles.subText38r,
            )
            Box(modifier = Modifier.fillMaxWidth(), contentAlignment = Alignment.Center) {
                Image(
                    painter = painterResource(R.drawable.latte_recommendation),
                    contentDescription = stringResource(R.string.home_latte_image_description),
                    modifier = Modifier.size(180.dp),
                    contentScale = ContentScale.Crop,
                )
            }
            Text(
                text = stringResource(R.string.home_recommendation_title),
                style = TextStyles.label38b,
            )
            Text(
                text = stringResource(R.string.home_recommendation_description),
                style = TextStyles.subText38r,
                color = Colors.colors.onSurfaceVariant,
            )
        }
    }
}

@Preview(showBackground = true, widthDp = 720, heightDp = 1280)
@Composable
private fun HomeScreenPreview() {
    CoffeeMomentTheme {
        HomeScreen(
            useLargeText = false,
            useHighContrast = false,
            useVoiceGuide = false,
            useLowMode = false,
            onLargeTextChange = {},
            onHighContrastChange = {},
            onVoiceGuideChange = {},
            onLowModeChange = {},
            onStartOrder = {},
        )
    }
}
