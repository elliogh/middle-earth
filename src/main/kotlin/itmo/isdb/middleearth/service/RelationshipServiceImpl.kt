package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Location
import itmo.isdb.middleearth.model.Race
import itmo.isdb.middleearth.model.Relationship
import itmo.isdb.middleearth.repository.RelationshipRepository
import org.springframework.stereotype.Service

@Service
class RelationshipServiceImpl(
    val relationshipRepository: RelationshipRepository,
    val raceService: RaceService
) : RelationshipService {
    override fun getAll(): MutableIterable<Relationship> {
        return relationshipRepository.findAll()
    }

    override fun getPassPrices(raceId: Int, path: ArrayList<Location>): HashMap<Race, Int> {
        val prices = hashMapOf<Race, Int>()
        val racesOnPath = path.map { it.race.id }.toSet()

        getAll().filter { it.firstRaceId == raceId }.forEach {
            val race = raceService.getRaceById(it.secondRaceId).get()
            if (racesOnPath.contains(race.id)) {
                prices[race] = it.passPrice
            }
        }
        return prices
    }

    override fun getTotalPassPrice(passPrices: HashMap<Race, Int>): Int =
        passPrices.values.sum()
}
