package com.example.chat_appui.presentation.chat

import com.example.chat_appui.domain.model.Message

data class ChatState(
    val message: List<Message> = emptyList(),
    val isLoading:Boolean = false
)
