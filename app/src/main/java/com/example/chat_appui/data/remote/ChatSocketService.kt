package com.example.chat_appui.data.remote

import com.example.chat_appui.domain.model.Message
import com.example.chat_appui.util.Resource
import kotlinx.coroutines.flow.Flow

interface ChatSocketService {

    suspend fun initSession(
        username:String
    ):Resource<Unit>

    suspend fun sendMessage(message:String)

     fun observeMessages():Flow<Message>

     suspend fun closeSession()

    companion object{
        const val BASE_URL = "ws://192.168.167.165:8080"
    }

    sealed class Endpoints(val url:String){
        data object ChatSocket: Endpoints("$BASE_URL/chat-session")
    }
}