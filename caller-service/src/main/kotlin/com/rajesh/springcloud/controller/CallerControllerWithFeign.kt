package com.rajesh.springcloud.controller

import com.rajesh.springcloud.client.CallmeClient
import com.rajesh.springcloud.model.CallmeRequest
import com.rajesh.springcloud.model.CallmeResponse
import com.rajesh.springcloud.model.Conversation
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/caller-with-feign")
class CallerControllerWithFeign(private val client: CallmeClient) {

    private var id: Int = 0

    @PostMapping("/send/{message}")
    fun send(@PathVariable message: String): CallmeResponse?{
        val request = CallmeRequest(++id, message)
        return client.call(request)
    }

    @PostMapping("/slow-send/{message}")
    fun slowSend(@PathVariable message: String): CallmeResponse?{
        val request = CallmeRequest(++id, message)
        return client.slowCall(request)
    }

    @GetMapping("/conversations")
    fun findAllConversations(): MutableList<Conversation> = client.findAllConversation()

    @GetMapping("/conversations/{id}")
    fun findByRequestId(@PathVariable id: Int): Conversation? = client.findCOnversationById(id)
}