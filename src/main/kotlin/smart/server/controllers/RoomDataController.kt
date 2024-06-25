package smart.server.controllers

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import smart.server.models.RoomData

@RestController
class RoomDataController {
    @GetMapping("/room-data")
    fun getRoomsData(): ResponseEntity<Array<RoomData>> {
        val dataRooms = arrayOf(
            RoomData(1, "Гостиная", "living_room"),
            RoomData(2, "Спальня", "bedroom"),
            RoomData(3, "Кухня", "kitchen"),
            RoomData(4, "Ванная", "bathroom"),
            RoomData(5, "Студия", "studio")
        )
        return ResponseEntity(dataRooms, HttpStatus.OK)
    }
}