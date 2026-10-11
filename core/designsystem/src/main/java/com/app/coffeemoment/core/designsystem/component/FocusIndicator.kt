package com.app.coffeemoment.core.designsystem.component

import androidx.compose.foundation.border
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.app.coffeemoment.core.designsystem.theme.FocusOrange

fun Modifier.focusIndicator(
    isFocused: Boolean,
    shape: Shape = RoundedCornerShape(8.dp),
    width: Dp = 5.dp,
): Modifier = if (isFocused) {
    border(
        width = width,
        color = FocusOrange,
        shape = shape,
    )
} else {
    this
}
