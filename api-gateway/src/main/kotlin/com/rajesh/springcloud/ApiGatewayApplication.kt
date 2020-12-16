package com.rajesh.springcloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver
import org.springframework.context.annotation.Bean
import reactor.core.publisher.Mono

@SpringBootApplication
open class ApiGatewayApplication {

    companion object{
        @JvmStatic
        fun main(args: Array<String>) {
            runApplication<ApiGatewayApplication>(*args)
        }

        @Bean
        fun keyResolver(): KeyResolver = KeyResolver { _ -> Mono.just("1") }
    }
}
