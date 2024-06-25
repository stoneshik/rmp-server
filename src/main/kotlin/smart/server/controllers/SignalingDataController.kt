package smart.server.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import smart.server.models.SignalingData

@RestController
class SignalingDataController {
    private val signalingWorkingState = "work"
    private val signalingState = true

    @GetMapping("/signaling-data")
    fun getFunctionTemperatureData(): ResponseEntity<SignalingData> {
        val signalingData = SignalingData(signalingWorkingState, signalingState)
        return ResponseEntity(signalingData, HttpStatus.OK)
    }
}
