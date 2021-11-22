package com.dosee.smarthome.bulb.controllers

import com.dosee.smarthome.bulb.controllers.service.Service
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class Controllers (
    val service: Service,
) {
    @GetMapping("/on")
    fun turnOn(): String {
        return service.on()
    }

    @GetMapping("/off")
    fun turnOff(): String {
        return service.off()
    }

    @GetMapping("/perc/{value}")
    fun supplyPower(@PathVariable("value") value: Double): String {
        return service.newSupplyPower(value)
    }
}