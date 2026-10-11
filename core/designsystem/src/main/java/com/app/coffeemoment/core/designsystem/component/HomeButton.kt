package com.app.coffeemoment.core.designsystem.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.coffeemoment.core.designsystem.R
import com.app.coffeemoment.core.designsystem.theme.CoffeeMomentTheme
import com.app.coffeemoment.core.designsystem.theme.Colors
import com.app.coffeemoment.core.designsystem.theme.TextStyles

@Composable
fun HomeButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    var isFocused by remember { mutableStateOf(false) }

    OutlinedButton(
        onClick = onClick,
        modifier = modifier
            .onFocusChanged { isFocused = it.isFocused }
            .focusIndicator(
                isFocused = isFocused,
            )
            .heightIn(min = 56.dp),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.outlinedButtonColors(
            contentColor = Colors.colors.primary,
        ),
        border = BorderStroke(
            width = 1.dp,
            color = Colors.colors.outline,
        ),
    ) {
        Text(
            text = stringResource(R.string.accessibility_go_home),
            style = TextStyles.label38b,
        )
    }
}

@Preview(showBackground = true, widthDp = 720)
@Composable
private fun HomeButtonPreview() {
    CoffeeMomentTheme {
        HomeButton(
            onClick = {},
            modifier = Modifier.fillMaxWidth().padding(16.dp),
        )
    }
}
