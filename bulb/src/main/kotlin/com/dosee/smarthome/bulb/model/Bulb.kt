package com.dosee.smarthome.bulb.model

data class Bulb(
    val uuid: String,
    var supply: Boolean,
    var supplyPercentage: Double,
    val kwtPerHours: Double
)
