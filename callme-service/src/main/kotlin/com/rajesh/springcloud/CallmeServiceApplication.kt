package com.rajesh.springcloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
open class CallmeServiceApplication{
	companion object{
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<CallmeServiceApplication>(*args)
		}
	}
}


