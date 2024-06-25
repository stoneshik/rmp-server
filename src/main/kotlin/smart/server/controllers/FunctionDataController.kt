package smart.server.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import smart.server.models.*


@RestController
class FunctionHumidityDataController {
    private var dataMap = mapOf(
        "1" to FunctionHumidityData(1, arrayOf("humidity_room", "lights_room", "temperature_room"), 40.0),
        "2" to FunctionHumidityData(2, arrayOf("humidity_room", "lights_room", "temperature_room"), 41.0),
        "3" to FunctionHumidityData(3, arrayOf("humidity_room", "lights_room", "temperature_room"), 42.0),
        "4" to FunctionHumidityData(4, arrayOf("lights_room", "temperature_room"), 43.0),
        "5" to FunctionHumidityData(5, arrayOf("temperature_room"), 44.0),
    )

    @GetMapping("/humidity-data/{id}")
    fun getFunctionHumidityData(@PathVariable("id") id: String): ResponseEntity<FunctionHumidityData> {
        val data = dataMap[id]
        return ResponseEntity(data, HttpStatus.OK)
    }

    @PostMapping("/humidity-data")
    fun postFunctionHumidityData(@RequestBody functionHumidityDataRequest: FunctionHumidityDataRequest) {
        dataMap[functionHumidityDataRequest.idRoom.toString()]!!.humidity = functionHumidityDataRequest.humidity
    }
}

@RestController
class FunctionLightsDataController {
    private val dataMap = mapOf(
        "1" to FunctionLightsData(1, arrayOf("humidity_room", "lights_room", "temperature_room"), 90.0),
        "2" to FunctionLightsData(2, arrayOf("humidity_room", "lights_room", "temperature_room"), 91.0),
        "3" to FunctionLightsData(3, arrayOf("humidity_room", "lights_room", "temperature_room"), 92.0),
        "4" to FunctionLightsData(4, arrayOf("lights_room", "temperature_room"), 93.0),
        "5" to FunctionLightsData(5, arrayOf("temperature_room"), 94.0),
    )

    @GetMapping("/lights-data/{id}")
    fun getFunctionLightsData(@PathVariable("id") id: String): ResponseEntity<FunctionLightsData> {
        val data = dataMap[id]
        return ResponseEntity(data, HttpStatus.OK)
    }

    @PostMapping("/lights-data")
    fun postFunctionLightsData(@RequestBody functionLightsDataRequest: FunctionLightsDataRequest) {
        dataMap[functionLightsDataRequest.idRoom.toString()]!!.lights = functionLightsDataRequest.lights
    }
}

@RestController
class FunctionTemperatureDataController {
    private val dataMap = mapOf(
        "1" to FunctionTemperatureData(1, arrayOf("humidity_room", "lights_room", "temperature_room"), 30.0),
        "2" to FunctionTemperatureData(2, arrayOf("humidity_room", "lights_room", "temperature_room"), 31.0),
        "3" to FunctionTemperatureData(3, arrayOf("humidity_room", "lights_room", "temperature_room"), 32.0),
        "4" to FunctionTemperatureData(4, arrayOf("lights_room", "temperature_room"), 33.0),
        "5" to FunctionTemperatureData(5, arrayOf("temperature_room"), 34.0),
    )

    @GetMapping("/temperature-data/{id}")
    fun getFunctionTemperatureData(@PathVariable("id") id: String): ResponseEntity<FunctionTemperatureData> {
        val data = dataMap[id]
        return ResponseEntity(data, HttpStatus.OK)
    }

    @PostMapping("/temperature-data")
    fun postFunctionTemperatureData(@RequestBody functionTemperatureDataRequest: FunctionTemperatureDataRequest) {
        dataMap[functionTemperatureDataRequest.idRoom.toString()]!!.temperature = functionTemperatureDataRequest.temperature
    }
}
