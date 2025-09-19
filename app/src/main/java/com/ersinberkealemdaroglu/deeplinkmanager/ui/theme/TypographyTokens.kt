package com.ersinberkealemdaroglu.deeplinkmanager.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.PlatformTextStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.sp

object TypographyTokens {

    object Heading1 {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontFamily = FontFamilyTokens.Roboto.SemiBold,
            fontSize = 48.sp,
            lineHeight = 64.sp,
            letterSpacing = (-0.5).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }

    object Heading2 {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontFamily = FontFamilyTokens.Roboto.Bold,
            fontSize = 36.sp,
            lineHeight = 48.sp,
            letterSpacing = (-0.5).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }

    object Heading3 {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontFamily = FontFamilyTokens.Roboto.Regular,
            fontSize = 32.sp,
            lineHeight = 42.sp,
            letterSpacing = (-0.5).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }


    object Heading4 {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontFamily = FontFamilyTokens.Roboto.Bold,
            fontSize = 24.sp,
            lineHeight = 32.sp,
            letterSpacing = (-0.5).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }

    object Subtitle1 {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontFamily = FontFamilyTokens.Roboto.Bold,
            fontSize = 18.sp,
            lineHeight = 24.sp,
            letterSpacing = (-0.2).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }

    object Body1 {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontSize = 16.sp,
            lineHeight = 24.sp,
            letterSpacing = (-0.2).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }

    object Body2 {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontSize = 14.sp,
            lineHeight = 20.sp,
            letterSpacing = (-0.32).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }

    object Small1 {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontSize = 12.sp,
            lineHeight = 16.sp,
            letterSpacing = (-0.2).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }

    object Small2 {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontSize = 10.sp,
            lineHeight = 14.sp,
            letterSpacing = (-0.2).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }

    object ExtraSmall {
        private val baseTextStyle = DefaultTextStyle.copy(
            fontSize = 8.sp,
            lineHeight = 12.sp,
            letterSpacing = (-0.2).sp,
        )

        val Regular by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Regular,
            )
        }

        val Medium by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }

        val Bold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Bold,
            )
        }

        val SemiBold by lazy {
            baseTextStyle.copy(
                fontFamily = FontFamilyTokens.Roboto.Medium,
            )
        }
    }
}

private val DefaultTextStyle = TextStyle.Default.copy(
    platformStyle = PlatformTextStyle(includeFontPadding = false)
)

val typography = Typography(
    displayLarge = TypographyTokens.Heading1.Regular,
    displayMedium = TypographyTokens.Heading2.Bold,
    displaySmall = TypographyTokens.Heading3.Regular,
    headlineLarge = TypographyTokens.Heading3.Bold,
    headlineMedium = TypographyTokens.Heading4.Bold,
    headlineSmall = TypographyTokens.Subtitle1.Bold,
    titleLarge = TypographyTokens.Subtitle1.Medium,
    titleMedium = TypographyTokens.Body1.Bold,
    titleSmall = TypographyTokens.Body1.Medium,
    bodyLarge = TypographyTokens.Body1.Bold,
    bodyMedium = TypographyTokens.Body2.Medium,
    bodySmall = TypographyTokens.Body2.Regular,
    labelLarge = TypographyTokens.Small1.Bold,
    labelMedium = TypographyTokens.Small1.Medium,
    labelSmall = TypographyTokens.Small2.Regular,
)