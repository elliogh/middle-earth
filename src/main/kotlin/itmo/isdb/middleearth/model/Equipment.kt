package itmo.isdb.middleearth.model

import jakarta.persistence.*

@Entity
@Table(name = "equipment")
class Equipment(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val price: Int
)
