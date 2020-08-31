package com.rajesh.springcloud.controller

import com.rajesh.springcloud.model.CallmeRequest
import com.rajesh.springcloud.model.CallmeResponse
import com.rajesh.springcloud.model.Conversation
import org.springframework.web.bind.annotation.*
import org.springframework.web.client.RestTemplate

@RestController
@RequestMapping("/caller")
class CallerController(private val template: RestTemplate) {

    private var id: Int = 0

    @PostMapping("/send/{message}")
    fun send(@PathVariable message: String): CallmeResponse?{
        val request = CallmeRequest(++id, message)
        return template.postForObject("http://callme-service/callme/call",
                request,
                CallmeResponse::class.java
        )
    }

    @PostMapping("/slow-send/{message}")
    fun slowSend(@PathVariable message: String): CallmeResponse?{
        val request = CallmeRequest(++id, message)
        return template.postForObject("http://callme-service/callme/slow-call",
                request,
                CallmeResponse::class.java
        )
    }

    @GetMapping("/conversations")
    fun findAllConversations(): Array<Conversation>? = template.getForObject("http://callme-service/callme/conversations",
                Array<Conversation>::class.java)

    @GetMapping("/conversations/{id}")
    fun findByRequestId(@PathVariable id: Int): Conversation? = template.getForObject("http://callme-service/callme/conversations/{requestId}"
                , Conversation::class.java)
}