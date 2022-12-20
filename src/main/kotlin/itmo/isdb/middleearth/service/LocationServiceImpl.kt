package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Location
import itmo.isdb.middleearth.repository.LocationRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class LocationServiceImpl(
    val locationRepository: LocationRepository
) : LocationService {

    override fun getAll(): List<Location> =
        locationRepository.findAll()

    override fun getLocationById(id: Int): Optional<Location> =
        locationRepository.findById(id)
}
