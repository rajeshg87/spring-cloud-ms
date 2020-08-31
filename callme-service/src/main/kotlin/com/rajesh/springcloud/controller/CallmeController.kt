package com.rajesh.springcloud.controller

import com.rajesh.springcloud.model.CallmeRequest
import com.rajesh.springcloud.model.CallmeResponse
import com.rajesh.springcloud.model.Conversation
import com.rajesh.springcloud.repository.ConversationRepository
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/callme")
class CallmeController(private val repository: ConversationRepository) {

    private val logger: Logger = LoggerFactory.getLogger(CallmeController::class.java)


    @PostMapping("/call")
    fun call(@RequestBody request: CallmeRequest) : CallmeResponse {
        val response = CallmeResponse(request.id, request.message.reversed())
        repository.add(Conversation(request = request, response = response))
        return response
    }

    @PostMapping("/slow-call")
    fun slowCall(@RequestBody request: CallmeRequest) : CallmeResponse {
        Thread.sleep(1000)
        val response = CallmeResponse(request.id, request.message.reversed())
        repository.add(Conversation(request = request, response = response))
        return response
    }

    @GetMapping("/conversations")
    fun findAllConversation(): MutableList<Conversation> = repository.findAll()

    @GetMapping("/conversations/{requestId}")
    fun findCOnversationById(requestId: Int): Conversation? = repository.findRequestById(requestId)

}