package itmo.isdb.middleearth.service

import itmo.isdb.middleearth.model.Location
import itmo.isdb.middleearth.model.Race
import itmo.isdb.middleearth.model.Relationship

interface RelationshipService {
    fun getAll(): MutableIterable<Relationship>
    fun getPassPrices(raceId: Int, path: ArrayList<Location>): HashMap<Race, Int>
    fun getTotalPassPrice(passPrices: HashMap<Race, Int>): Int
}
