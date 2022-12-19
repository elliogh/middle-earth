package itmo.isdb.middleearth.model

import jakarta.persistence.*

@Entity
@Table(name = "race")
class Race(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    val name: String
)
