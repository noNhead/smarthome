package com.dosee.smarthome.bulb

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BulbApplication

fun main(args: Array<String>) {
	runApplication<BulbApplication>(*args)
}
