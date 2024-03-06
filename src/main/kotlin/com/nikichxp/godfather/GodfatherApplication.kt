package com.nikichxp.godfather

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.config.server.EnableConfigServer
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer
import org.springframework.scheduling.annotation.EnableScheduling

@EnableEurekaServer
@EnableConfigServer
@EnableScheduling
@SpringBootApplication
class GodfatherApplication

fun main(args: Array<String>) {
	runApplication<GodfatherApplication>(*args)
}
