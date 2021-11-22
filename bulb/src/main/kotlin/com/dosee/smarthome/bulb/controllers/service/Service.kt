package com.dosee.smarthome.bulb.controllers.service

import com.dosee.smarthome.bulb.model.Bulb
import org.springframework.stereotype.Component

@Component
class Service {
    val bulb = Bulb("000000001", false, 0.7, 0.012)

    fun on(): String {
        bulb.supply = true

        return "supply = ${bulb.supply}"
    }

    fun off(): String {
        bulb.supply = false

        return "supply = ${bulb.supply}"
    }

    fun newSupplyPower(power: Double): String {
        bulb.supplyPercentage = power

        return "new power percentage = ${bulb.supplyPercentage}"
    }
}