package itmo.isdb.middleearth.repository

import itmo.isdb.middleearth.model.Equipment
import org.springframework.data.jpa.repository.query.Procedure
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface EquipmentRepository : CrudRepository<Equipment, Long> {
    @Procedure("necessary_equipment")
    fun getNecessaryEquipment(@Param("location_id") locationId: Int, @Param("race_id") raceId: Int): ArrayList<Long>
    fun findByIdIn(ids: List<Long>): ArrayList<Equipment>
}
