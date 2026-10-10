package com.app.coffeemoment.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilterChip
import androidx.compose.material3.FilterChipDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.coffeemoment.core.designsystem.theme.CoffeeMomentTheme
import com.app.coffeemoment.core.designsystem.theme.Colors
import com.app.coffeemoment.core.designsystem.theme.TextStyles

@Composable
fun SelectableChip(
    text: String,
    selected: Boolean,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    FilterChip(
        selected = selected,
        onClick = onClick,
        label = { Text(text = text, style = TextStyles.label26b) },
        modifier = modifier.heightIn(min = 48.dp),
        enabled = enabled,
        shape = RoundedCornerShape(8.dp),
        border = null,
        colors = FilterChipDefaults.filterChipColors(
            containerColor = Colors.colors.surfaceVariant,
            labelColor = Colors.colors.onSurfaceVariant,
            selectedContainerColor = Colors.colors.primary,
            selectedLabelColor = Colors.colors.onPrimary,
        ),
    )
}

@Preview(showBackground = true)
@Preview(showBackground = true, fontScale = 2f)
@Composable
private fun SelectableChipPreview() {
    CoffeeMomentTheme {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            SelectableChip("전체", selected = true, onClick = {})
            SelectableChip("커피", selected = false, onClick = {})
            SelectableChip("음료", selected = false, onClick = {}, enabled = false)
            SelectableChip("디저트", selected = true, onClick = {}, enabled = false)
        }
    }
}
