package com.example.wahtsapp.presentation.theme

import androidx.compose.ui.graphics.Color

// ========== WHATSAPP BRAND COLORS ==========
// Primary brand colors
val WhatsAppGreen = Color(0xFF25D366)        // WhatsApp green
val WhatsAppDarkGreen = Color(0xFF075E54)    // Dark mode primary
val WhatsAppGreenAccent = Color(0xFF00A884)  // Dark accent green

// Secondary/Container colors
val WhatsAppGreenLight = Color(0xFFDCF8C6)   // Light mode chat bubble
val WhatsAppGreenDark = Color(0xFF128C7E)    // Secondary green
val WhatsAppDarkGreenLight = Color(0xFF2A6041) // Dark mode chat bubble

// ========== NEUTRAL PALETTE ==========
// Light mode neutrals
val Neutral10 = Color(0xFFFFFFFF)      // White background
val Neutral15 = Color(0xFFF8F9FA)      // Very light gray
val Neutral20 = Color(0xFFF0F0F0)      // Light surface
val Neutral25 = Color(0xFFE9ECEF)      // Lighter gray
val Neutral30 = Color(0xFFE0E0E0)      // Divider light
val Neutral40 = Color(0xFFD6D6D6)      // Light border
val Neutral50 = Color(0xFFADB5BD)      // Disabled light
val Neutral60 = Color(0xFF6C757D)      // Secondary text light
val Neutral70 = Color(0xFF495057)      // Hint text light
val Neutral80 = Color(0xFF343A40)      // Primary text light

// Dark mode neutrals
val Neutral85 = Color(0xFF2D3B2E)      // Dark divider
val Neutral90 = Color(0xFF1F2B20)      // Dark surface
val Neutral95 = Color(0xFF1A1A1A)      // Darker background
val Neutral100 = Color(0xFF121212)     // Dark background
val Neutral110 = Color(0xFF0D1418)     // WhatsApp dark chat background

// ========== CHAT SPECIFIC COLORS ==========
// Message bubbles
val OutgoingMessageLight = WhatsAppGreenLight
val IncomingMessageLight = Neutral10
val OutgoingMessageDark = WhatsAppDarkGreenLight
val IncomingMessageDark = Neutral90

// Chat backgrounds
val ChatBackgroundLight = Color(0xFFECE5DD)  // WhatsApp light chat background
val ChatBackgroundDark = Neutral110

// ========== STATUS COLORS ==========
val StatusOnline = Color(0xFF4CAF50)
val StatusOffline = Color(0xFF9E9E9E)
val StatusTyping = Color(0xFF2196F3)
val StatusRead = Color(0xFF34B7F1)           // Blue tick color

// ========== ICON/ACCENT COLORS ==========
val IconBlue = Color(0xFF0084FF)             // Camera, attach icons
val IconGreen = WhatsAppGreen
val IconGray = Color(0xFF9E9E9E)
val IconRed = Color(0xFFFF3B30)              // Call end, delete
val IconYellow = Color(0xFFFFD700)           // Starred messages

// ========== UI SPECIFIC COLORS ==========
// Tab colors
val StatusTabLight = Color(0xFFF2F2F2)
val StatusTabDark = Color(0xFF1F2B20)
val CameraTabLight = Color(0xFFF2F2F2)
val CameraTabDark = Color(0xFF000000)

// Badge/Indicator colors
val UnreadBadge = Color(0xFF25D366)
val PinnedChatColor = Color(0xFFFFD740)
val MutedChatColor = Color(0xFF9E9E9E)

// Call colors
val CallIncoming = Color(0xFF4CAF50)
val CallOutgoing = Color(0xFF2196F3)
val CallMissed = Color(0xFFFF3B30)

// Status screen colors
val StatusSeenBorder = Color(0xFF25D366)
val StatusUnseenBorder = Color(0xFF808080)
val StatusGradientStart = Color(0xFF667EEA)
val StatusGradientEnd = Color(0xFF764BA2)

// Search/Input colors
val SearchBarLight = Color(0xFFF0F2F5)
val SearchBarDark = Color(0xFF323739)