package com.app.coffeemoment.core.designsystem.theme

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.app.coffeemoment.core.designsystem.R

val Pretendard = FontFamily(
    Font(R.font.pretendard_regular, FontWeight.Normal),
    Font(R.font.pretendard_medium, FontWeight.Medium),
    Font(R.font.pretendard_semibold, FontWeight.SemiBold),
    Font(R.font.pretendard_bold, FontWeight.Bold),
)

@Composable
fun coffeeTypography(): Typography = Typography(
    displayLarge = TextStyles.text44b,
    displayMedium = TextStyles.text44b,
    displaySmall = TextStyles.text44b,
    headlineLarge = TextStyles.title38b,
    headlineMedium = TextStyles.title38b,
    headlineSmall = TextStyles.title38b,
    titleLarge = TextStyles.title38b,
    titleMedium = TextStyles.label38b,
    titleSmall = TextStyles.label38b,
    bodyLarge = TextStyles.text38r,
    bodyMedium = TextStyles.text38r,
    bodySmall = TextStyles.subText38r,
    labelLarge = TextStyles.label38b,
    labelMedium = TextStyles.subText38r,
    labelSmall = TextStyles.subText38r,
)
