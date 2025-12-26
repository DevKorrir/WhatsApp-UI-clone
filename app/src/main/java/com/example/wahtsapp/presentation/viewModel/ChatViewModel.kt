package com.example.wahtsapp.presentation.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.wahtsapp.domain.model.Message
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ChatViewModel : ViewModel() {
    
    private val _messages = MutableStateFlow<List<Message>>(emptyList())
    val messages: StateFlow<List<Message>> = _messages.asStateFlow()
    
    private val _messageText = MutableStateFlow("")
    val messageText: StateFlow<String> = _messageText.asStateFlow()
    
    init {
        loadSampleMessages()
    }
    
    private fun loadSampleMessages() {
        val sampleMessages = listOf(
            Message(
                id = "1",
                text = "Hey! How are you?",
                timestamp = System.currentTimeMillis() - 3600000,
                isOutgoing = false,
                senderName = "vertiGO"
            ),
            Message(
                id = "2",
                text = "I'm good! Just working on some projects.",
                timestamp = System.currentTimeMillis() - 3000000,
                isOutgoing = true
            ),
            Message(
                id = "3",
                text = "That's great! What kind of projects?",
                timestamp = System.currentTimeMillis() - 2400000,
                isOutgoing = false,
                senderName = "vertiGO"
            )
        )
        _messages.value = sampleMessages
    }
    
    fun onMessageTextChanged(text: String) {
        _messageText.value = text
    }
    
    fun sendMessage() {
        if (_messageText.value.isBlank()) return
        
        val newMessage = Message(
            id = System.currentTimeMillis().toString(),
            text = _messageText.value.trim(),
            timestamp = System.currentTimeMillis(),
            isOutgoing = true
        )
        
        viewModelScope.launch {
            _messages.value = _messages.value + newMessage
            _messageText.value = ""
        }
    }
}

