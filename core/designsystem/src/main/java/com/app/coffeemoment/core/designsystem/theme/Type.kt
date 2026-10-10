package com.app.coffeemoment.core.designsystem.theme

import androidx.compose.material3.Typography
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

val Typography = Typography(
    displayLarge = TextStyles.text44b,
    displayMedium = TextStyles.text44b,
    displaySmall = TextStyles.text44b,
    headlineLarge = TextStyles.title38b,
    headlineMedium = TextStyles.title38b,
    headlineSmall = TextStyles.title38b,
    titleLarge = TextStyles.title38b,
    titleMedium = TextStyles.label26b,
    titleSmall = TextStyles.label26b,
    bodyLarge = TextStyles.text24r,
    bodyMedium = TextStyles.text24r,
    bodySmall = TextStyles.subText20r,
    labelLarge = TextStyles.label26b,
    labelMedium = TextStyles.subText20r,
    labelSmall = TextStyles.subText20r,
)
