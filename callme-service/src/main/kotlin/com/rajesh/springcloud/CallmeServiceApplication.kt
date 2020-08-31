package com.rajesh.springcloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class CallmeServiceApplication

fun main(args: Array<String>) {
	runApplication<CallmeServiceApplication>(*args)
}
