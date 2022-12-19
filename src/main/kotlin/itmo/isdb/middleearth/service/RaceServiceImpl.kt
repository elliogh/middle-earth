package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Race
import itmo.isdb.middleearth.repository.RaceRepository
import org.springframework.stereotype.Service
import java.util.*

@Service
class RaceServiceImpl(
    val raceRepository: RaceRepository
) : RaceService {
    override fun getAll(): List<Race> =
        raceRepository.findAll()

    override fun getRaceById(id: Long): Optional<Race> =
        raceRepository.findById(id)
}
