package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Location
import java.util.*

interface LocationService {
    fun getAll(): List<Location>
    fun getLocationById(id: Int): Optional<Location>
}
