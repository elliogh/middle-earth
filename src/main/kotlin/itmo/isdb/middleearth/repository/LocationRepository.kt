package itmo.isdb.middleearth.repository

import itmo.isdb.middleearth.model.Location
import org.springframework.data.repository.CrudRepository
import java.util.*
import kotlin.collections.ArrayList

interface LocationRepository : CrudRepository<Location, Long> {
    override fun findById(id: Long): Optional<Location>
    override fun findAll(): ArrayList<Location>
}
