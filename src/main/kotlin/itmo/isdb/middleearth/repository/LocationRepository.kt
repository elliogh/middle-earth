package itmo.isdb.middleearth.repository

import itmo.isdb.middleearth.model.Location
import org.springframework.data.repository.CrudRepository
import java.util.*
import kotlin.collections.ArrayList

interface LocationRepository : CrudRepository<Location, Int> {
    override fun findById(id: Int): Optional<Location>
    override fun findAll(): ArrayList<Location>
}
