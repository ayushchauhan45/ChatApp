package com.example.chat_appui.data.remote

import com.example.chat_appui.domain.model.Message

interface MessageService {

    suspend fun getAllMessage():List<Message>

    companion object{
        const val BASE_URL = "http://192.168.167.165:8080"
    }

    sealed class Endpoints(val url:String){
        data object GetAllMessages: Endpoints("$BASE_URL/message")
    }
}