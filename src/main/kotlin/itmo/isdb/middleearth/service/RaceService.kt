package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Race
import java.util.*

interface RaceService {
    fun getAll(): List<Race>
    fun getRaceById(id: Int): Optional<Race>
    fun getVisitTime(locationId: Int, raceId: Int): Int?
}
