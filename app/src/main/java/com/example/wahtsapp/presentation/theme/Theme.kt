package com.example.wahtsapp.presentation.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

// ========== WHATSAPP LIGHT COLOR SCHEME ==========
private val WhatsAppLightColorScheme = lightColorScheme(
    // Primary colors - WhatsApp Green
    primary = WhatsAppGreen,
    onPrimary = Neutral10,
    primaryContainer = WhatsAppGreenLight,
    onPrimaryContainer = Color(0xFF004040),

    // Secondary - Dark Green
    secondary = WhatsAppDarkGreen,
    onSecondary = Neutral10,
    secondaryContainer = WhatsAppGreen.copy(alpha = 0.1f),
    onSecondaryContainer = WhatsAppDarkGreen,

    // Tertiary - Blue for accent elements
    tertiary = IconBlue,
    onTertiary = Neutral10,
    tertiaryContainer = IconBlue.copy(alpha = 0.1f),
    onTertiaryContainer = IconBlue,

    // Background & Surface
    background = Neutral15,
    onBackground = Neutral80,
    surface = Neutral10,
    onSurface = Neutral80,
    surfaceVariant = Neutral20,
    onSurfaceVariant = Neutral60,

    // Chat specific surfaces
    // Using inverseSurface for chat backgrounds
    inverseSurface = ChatBackgroundLight,
    inverseOnSurface = Neutral80,

    // Outline & Error
    outline = Neutral30,
    outlineVariant = Neutral25,
    error = IconRed,
    onError = Neutral10,
    errorContainer = IconRed.copy(alpha = 0.1f),
    onErrorContainer = IconRed,

    // Status colors
    // Using scrim for status indicators
    scrim = StatusOnline
)

// ========== WHATSAPP DARK COLOR SCHEME ==========
private val WhatsAppDarkColorScheme = darkColorScheme(
    // Primary - Accent Green for dark mode
    primary = WhatsAppGreenAccent,
    onPrimary = Neutral10,
    primaryContainer = WhatsAppDarkGreenLight,
    onPrimaryContainer = Color(0xFFA8D8CA),

    // Secondary - Dark Green
    secondary = WhatsAppDarkGreen,
    onSecondary = Neutral10,
    secondaryContainer = WhatsAppGreenAccent.copy(alpha = 0.2f),
    onSecondaryContainer = WhatsAppGreenAccent,

    // Tertiary - Blue for accent elements
    tertiary = IconBlue,
    onTertiary = Neutral10,
    tertiaryContainer = IconBlue.copy(alpha = 0.2f),
    onTertiaryContainer = IconBlue.copy(alpha = 0.8f),

    // Background & Surface
    background = Neutral100,
    onBackground = Neutral10,
    surface = Neutral90,
    onSurface = Neutral10,
    surfaceVariant = Neutral85,
    onSurfaceVariant = Neutral50,

    // Chat specific surfaces
    inverseSurface = ChatBackgroundDark,
    inverseOnSurface = Neutral10,

    // Outline
    outline = Neutral70,
    outlineVariant = Neutral80,
    error = Color(0xFFFF6B6B), // Brighter red for dark mode
    onError = Neutral10,
    errorContainer = IconRed.copy(alpha = 0.2f),
    onErrorContainer = Color(0xFFFFA8A8),

    // Status
    scrim = StatusOnline
)

// ========== WHATSAPP THEME ==========
@Composable
fun WahtsappTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = false,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }
        darkTheme -> WhatsAppDarkColorScheme
        else -> WhatsAppLightColorScheme
    }

//    val view = LocalView.current
//    if (!view.isInEditMode) {
//        SideEffect {
//            val window = (view.context as Activity).window
//            window.statusBarColor = colorScheme.primary.toArgb()
//            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !darkTheme
//        }
//    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}

// ========== WHATSAPP SPECIFIC COLOR EXTENSIONS ==========
data class WhatsAppColors(
    val messageBubbleOutgoing: Color,
    val messageBubbleIncoming: Color,
    val chatBackground: Color,
    val statusOnline: Color,
    val statusOffline: Color,
    val iconBlue: Color,
    val iconRed: Color,
    val searchBar: Color,
    val unreadBadge: Color
)

val MaterialTheme.whatsAppColors: WhatsAppColors
    @Composable
    get() {
        val isDark = isSystemInDarkTheme()
        return WhatsAppColors(
            messageBubbleOutgoing = if (isDark) OutgoingMessageDark else OutgoingMessageLight,
            messageBubbleIncoming = if (isDark) IncomingMessageDark else IncomingMessageLight,
            chatBackground = if (isDark) ChatBackgroundDark else ChatBackgroundLight,
            statusOnline = StatusOnline,
            statusOffline = StatusOffline,
            iconBlue = IconBlue,
            iconRed = IconRed,
            searchBar = if (isDark) SearchBarDark else SearchBarLight,
            unreadBadge = UnreadBadge
        )
    }

// Quick access to chat colors
val MaterialTheme.chatBubbleOutgoing: Color
    @Composable
    get() = if (isSystemInDarkTheme()) OutgoingMessageDark else OutgoingMessageLight

val MaterialTheme.chatBubbleIncoming: Color
    @Composable
    get() = if (isSystemInDarkTheme()) IncomingMessageDark else IncomingMessageLight

val MaterialTheme.whatsAppChatBackground: Color
    @Composable
    get() = if (isSystemInDarkTheme()) ChatBackgroundDark else ChatBackgroundLight