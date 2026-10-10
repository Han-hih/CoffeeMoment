package com.app.coffeemoment.core.designsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxScope
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.coffeemoment.core.designsystem.theme.CoffeeMomentTheme
import com.app.coffeemoment.core.designsystem.theme.Colors
import com.app.coffeemoment.core.designsystem.theme.TextStyles

@Composable
fun ProductCard(
    name: String,
    priceText: String,
    image: @Composable BoxScope.() -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Card(
        onClick = onClick,
        modifier = modifier.semantics(mergeDescendants = true) {},
        enabled = enabled,
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(
            containerColor = Colors.colors.surface,
            contentColor = Colors.colors.onSurface,
        ),
    ) {
        Column(
            modifier = Modifier.padding(12.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Box(
                modifier = Modifier.fillMaxWidth().aspectRatio(1f)
                    .clip(RoundedCornerShape(8.dp)),
                contentAlignment = Alignment.Center,
                content = image,
            )
            Text(text = name, style = TextStyles.label26b)
            Text(text = priceText, style = TextStyles.text24r)
        }
    }
}

@Preview(showBackground = true)
@Preview(showBackground = true, fontScale = 2f)
@Composable
private fun ProductCardPreview() {
    CoffeeMomentTheme {
        ProductCard(
            name = "아메리카노",
            priceText = "3,000원",
            image = {
                Box(Modifier.matchParentSize().background(Colors.colors.primaryContainer))
            },
            onClick = {},
            modifier = Modifier.width(180.dp).padding(8.dp),
        )
    }
}
