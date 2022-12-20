package itmo.isdb.middleearth.repository

import itmo.isdb.middleearth.model.Race
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import java.util.Optional

interface RaceRepository : CrudRepository<Race, Long> {
    override fun findAll(): ArrayList<Race>
    override fun findById(id: Long): Optional<Race>

    @Procedure("visit_time")
    fun countVisitTime(@Param("location_id") locationId: Int, @Param("race_id") raceId: Int): Int?
}
