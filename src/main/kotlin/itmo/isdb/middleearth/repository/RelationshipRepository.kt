package itmo.isdb.middleearth.repository

import itmo.isdb.middleearth.model.Key
import itmo.isdb.middleearth.model.Relationship
import org.springframework.data.repository.CrudRepository

interface RelationshipRepository : CrudRepository<Relationship, Key> {
    override fun findAll(): MutableIterable<Relationship>
}
