package itmo.isdb.middleearth.repository

import itmo.isdb.middleearth.model.Race
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional
import java.util.Optional

interface RaceRepository : CrudRepository<Race, Int> {
    override fun findAll(): ArrayList<Race>
    override fun findById(id: Int): Optional<Race>

    @Procedure("visit_time")
    fun countVisitTime(@Param("location_id") locationId: Int, @Param("race_id") raceId: Int): Int?

//    @Transactional
//    @Modifying
//    @Query(value = "SELECT r.passPrice FROM Race INNER JOIN Relationship r on Race.id = r.firstRaceId INNER JOIN Race r2 on r2.id = r.secondRaceId WHERE (r.firstRaceId = :first_race_id)")
//    fun getPassPrices(@Param("first_race_id") firstRaceId: Int): ArrayList<Int>
}

