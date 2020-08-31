package com.rajesh.springcloud.client

import com.rajesh.springcloud.model.CallmeRequest
import com.rajesh.springcloud.model.CallmeResponse
import com.rajesh.springcloud.model.Conversation
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody

@FeignClient(name = "callme-service", path = "/callme")
interface CallmeClient {

    @PostMapping("/call")
    fun call(@RequestBody request: CallmeRequest) : CallmeResponse

    @PostMapping("/slow-call")
    fun slowCall(@RequestBody request: CallmeRequest) : CallmeResponse

    @GetMapping("/conversations")
    fun findAllConversation(): MutableList<Conversation>

    @GetMapping("/conversations/{requestId}")
    fun findCOnversationById(requestId: Int): Conversation?
}