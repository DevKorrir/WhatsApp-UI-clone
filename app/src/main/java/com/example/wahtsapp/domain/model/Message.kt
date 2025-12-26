package com.example.wahtsapp.domain.model

data class Message(
    val id: String,
    val text: String,
    val timestamp: Long,
    val isOutgoing: Boolean,
    val isRead: Boolean = false,
    val senderName: String? = null
)

