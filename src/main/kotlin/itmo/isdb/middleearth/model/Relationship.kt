package itmo.isdb.middleearth.model

import jakarta.persistence.*

@Entity
@Table(name = "relationship")
@IdClass(Key::class)
class Relationship(
    @Id
    val firstRaceId: Int,
    @Id
    val secondRaceId: Int,
    val passPrice: Int
)
