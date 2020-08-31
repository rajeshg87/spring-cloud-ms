package com.rajesh.springcloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.boot.web.client.RestTemplateBuilder
import org.springframework.cloud.client.loadbalancer.LoadBalanced
import org.springframework.cloud.openfeign.EnableFeignClients
import org.springframework.context.annotation.Bean
import org.springframework.web.client.RestTemplate

@SpringBootApplication
@EnableFeignClients
class CallerServiceApplication {

	@Bean
	@LoadBalanced
	fun template(): RestTemplate = RestTemplateBuilder().build()

}

fun main(args: Array<String>) {
	runApplication<CallerServiceApplication>(*args)
}
