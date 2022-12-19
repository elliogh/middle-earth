package itmo.isdb.middleearth.repository

import itmo.isdb.middleearth.model.Race
import org.springframework.data.repository.CrudRepository
import java.util.Optional

interface RaceRepository : CrudRepository<Race, Long> {
    override fun findAll(): ArrayList<Race>
    override fun findById(id: Long): Optional<Race>
}
