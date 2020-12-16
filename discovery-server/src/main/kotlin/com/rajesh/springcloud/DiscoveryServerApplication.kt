package com.rajesh.springcloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer

@SpringBootApplication
@EnableEurekaServer
open class DiscoveryServerApplication{
	companion object{
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<DiscoveryServerApplication>(*args)
		}
	}
}
