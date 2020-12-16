package com.rajesh.springcloud

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer

@SpringBootApplication
@EnableConfigServer
open class ConfigServerApplication{
	companion object{
		@JvmStatic
		fun main(args: Array<String>) {
			runApplication<ConfigServerApplication>(*args)
		}
	}
}