package com.example.chat_appui.data.remote

import com.example.chat_appui.data.remote.dto.MessageDto
import com.example.chat_appui.domain.model.Message
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.request.url
import io.ktor.client.statement.HttpResponse

class MessageServiceImpl(
    private val client: HttpClient
): MessageService {
    override suspend fun getAllMessage(): List<Message> {
        return try {
            val response: HttpResponse = client.get { url(MessageService.Endpoints.GetAllMessages.url) }
            val responseBody: List<MessageDto> =  response.body<List<MessageDto>>()
            responseBody.map { it.toMessage() }
        }
        catch (e:Exception){
            emptyList()
        }
    }
}
