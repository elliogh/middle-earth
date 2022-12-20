package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Race
import itmo.isdb.middleearth.repository.RaceRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class RaceServiceImpl(
    val raceRepository: RaceRepository
) : RaceService {
    override fun getAll(): List<Race> =
        raceRepository.findAll()

    override fun getRaceById(id: Int): Optional<Race> =
        raceRepository.findById(id)

    @Transactional
    override fun getVisitTime(locationId: Int, raceId: Int): Int? =
        try {
            raceRepository.countVisitTime(locationId, raceId)
        } catch (e: Exception) {
            e.printStackTrace()
            null
        }
}
