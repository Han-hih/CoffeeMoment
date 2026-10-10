package com.app.coffeemoment.core.designsystem.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.FlowRow
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.clearAndSetSemantics
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.liveRegion
import androidx.compose.ui.semantics.LiveRegionMode
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.app.coffeemoment.core.designsystem.R
import com.app.coffeemoment.core.designsystem.theme.CoffeeMomentTheme
import com.app.coffeemoment.core.designsystem.theme.Colors
import com.app.coffeemoment.core.designsystem.theme.TextStyles

@Composable
fun CartItem(
    name: String,
    priceText: String,
    quantity: Int,
    onIncrease: () -> Unit,
    onDecrease: () -> Unit,
    onRemove: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    increaseEnabled: Boolean = true,
    decreaseEnabled: Boolean = true,
) {
    val increaseLabel = stringResource(R.string.cart_item_increase, name)
    val decreaseLabel = stringResource(R.string.cart_item_decrease, name)
    val removeLabel = stringResource(R.string.cart_item_remove, name)
    val quantityLabel = stringResource(R.string.cart_item_quantity, name, quantity)

    Surface(
        modifier = modifier,
        shape = RoundedCornerShape(12.dp),
        color = Colors.colors.surface,
        contentColor = Colors.colors.onSurface,
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(8.dp),
        ) {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = name,
                    modifier = Modifier.weight(1f),
                    style = TextStyles.label26b,
                )
                TextButton(
                    onClick = onRemove,
                    enabled = enabled,
                    modifier = Modifier.sizeIn(minWidth = 48.dp, minHeight = 48.dp)
                        .semantics { contentDescription = removeLabel },
                ) {
                    Text(
                        text = stringResource(R.string.cart_item_remove_action),
                        style = TextStyles.label26b,
                        modifier = Modifier.clearAndSetSemantics {},
                    )
                }
            }
            FlowRow(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalArrangement = Arrangement.spacedBy(8.dp),
            ) {
                Text(
                    text = priceText,
                    modifier = Modifier.padding(end = 12.dp, top = 12.dp),
                    style = TextStyles.text24r,
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    TextButton(
                        onClick = onDecrease,
                        enabled = enabled && decreaseEnabled,
                        modifier = Modifier.sizeIn(minWidth = 48.dp, minHeight = 48.dp)
                            .semantics { contentDescription = decreaseLabel },
                    ) {
                        Text("−", style = TextStyles.label26b, modifier = Modifier.clearAndSetSemantics {})
                    }
                    Text(
                        text = quantity.toString(),
                        modifier = Modifier.padding(horizontal = 8.dp).clearAndSetSemantics {
                            contentDescription = quantityLabel
                            liveRegion = LiveRegionMode.Polite
                        },
                        style = TextStyles.label26b,
                    )
                    TextButton(
                        onClick = onIncrease,
                        enabled = enabled && increaseEnabled,
                        modifier = Modifier.sizeIn(minWidth = 48.dp, minHeight = 48.dp)
                            .semantics { contentDescription = increaseLabel },
                    ) {
                        Text("+", style = TextStyles.label26b, modifier = Modifier.clearAndSetSemantics {})
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 360)
@Preview(showBackground = true, widthDp = 320, fontScale = 2f)
@Composable
private fun CartItemPreview() {
    CoffeeMomentTheme {
        Column(verticalArrangement = Arrangement.spacedBy(12.dp)) {
            CartItem(
                name = "아메리카노",
                priceText = "3,000원",
                quantity = 1,
                onIncrease = {},
                onDecrease = {},
                onRemove = {},
                decreaseEnabled = false,
            )
            CartItem(
                name = "디카페인 바닐라 카페라테",
                priceText = "4,500원",
                quantity = 2,
                onIncrease = {},
                onDecrease = {},
                onRemove = {},
                enabled = false,
            )
        }
    }
}
