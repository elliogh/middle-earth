package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Race
import java.util.*

interface RaceService {
    fun getAll(): List<Race>
    fun getRaceById(id: Long): Optional<Race>
}
