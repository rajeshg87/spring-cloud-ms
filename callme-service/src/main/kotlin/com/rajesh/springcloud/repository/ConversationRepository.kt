package com.rajesh.springcloud.repository

import com.rajesh.springcloud.model.Conversation
import org.springframework.stereotype.Repository

@Repository
class ConversationRepository(private val conversations: MutableList<Conversation> = mutableListOf()) {

    fun findRequestById(requestId: Int): Conversation? = conversations.find { it.request.id == requestId }

    fun findAll(): MutableList<Conversation> = conversations

    fun add(conversation: Conversation) = conversations.add(conversation)

}