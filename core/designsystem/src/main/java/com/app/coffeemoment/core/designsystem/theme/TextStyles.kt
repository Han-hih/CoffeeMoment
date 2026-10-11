package com.app.coffeemoment.core.designsystem.theme

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp

object TextStyles {
    private val Text38r = TextStyle(
        fontFamily = Pretendard,
        fontSize = 38.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 55.1.sp,
        letterSpacing = 0.sp,
    )

    private val SubText38r = TextStyle(
        fontFamily = Pretendard,
        fontSize = 38.sp,
        fontWeight = FontWeight.Normal,
        lineHeight = 55.1.sp,
        letterSpacing = 0.sp,
    )

    private val Label38b = TextStyle(
        fontFamily = Pretendard,
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 55.1.sp,
        letterSpacing = 0.sp,
    )

    private val Title38b = TextStyle(
        fontFamily = Pretendard,
        fontSize = 38.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 55.1.sp,
        letterSpacing = 0.sp,
    )

    private val Text44b = TextStyle(
        fontFamily = Pretendard,
        fontSize = 44.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 63.8.sp,
        letterSpacing = 0.sp,
    )

    private val Text40b = TextStyle(
        fontFamily = Pretendard,
        fontSize = 40.sp,
        fontWeight = FontWeight.Bold,
        lineHeight = 58.sp,
        letterSpacing = 0.sp,
    )

    val text38r: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = Text38r.scaled()

    val subText38r: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = SubText38r.scaled()

    val label38b: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = Label38b.scaled()

    val title38b: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = Title38b.scaled()

    val text44b: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = Text44b.scaled()

    val text40b: TextStyle
        @Composable
        @ReadOnlyComposable
        get() = Text40b.scaled()
}

internal val LocalTextScale = staticCompositionLocalOf { 1f }

@Composable
@ReadOnlyComposable
private fun TextStyle.scaled(): TextStyle {
    val scale = LocalTextScale.current
    if (scale == 1f) return this
    return copy(
        fontSize = (fontSize.value * scale).sp,
        lineHeight = (lineHeight.value * scale).sp,
    )
}
