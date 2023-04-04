package de.tandamo.crowdcriticscmsservice

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient

@SpringBootApplication
@EnableDiscoveryClient
class CrowdcriticsCmsServiceApplication

fun main(args: Array<String>) {
	runApplication<CrowdcriticsCmsServiceApplication>(*args)
}
