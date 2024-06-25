package smart.server.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RestController
import smart.server.models.SignalingData

@RestController
class SignalingDataController {
    private var signalingWorkingState = "work"
    private var signalingState = true
    private var counter = 0
    private var SLEEPING_MILISECONDS = 5000L

    @GetMapping("/signaling-data")
    fun getFunctionTemperatureData(): ResponseEntity<SignalingData> {
        counter++
        if (counter > 30) {
            signalingState = false
        }
        if (counter > 40) {
            counter = 0
            signalingState = true
        }
        val signalingData = SignalingData(signalingWorkingState, signalingState)
        return ResponseEntity(signalingData, HttpStatus.OK)
    }

    @PostMapping("/signaling-data")
    fun postFunctionTemperatureData() {
        if (signalingWorkingState.equals("work")) {
            signalingWorkingState = "turns_off"
        } else if (signalingWorkingState.equals("switch_off")) {
            signalingWorkingState = "turns_on"
        }
        Thread.sleep(SLEEPING_MILISECONDS)
        if (signalingWorkingState.equals("turns_off")) {
            signalingWorkingState = "switch_off"
        } else if (signalingWorkingState.equals("turns_on")) {
            signalingWorkingState = "work"
        }
    }
}
