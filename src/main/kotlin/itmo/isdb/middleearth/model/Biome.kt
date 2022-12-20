package itmo.isdb.middleearth.model

import jakarta.persistence.*
import lombok.NoArgsConstructor

@NoArgsConstructor
@Entity
@Table(name = "biome")
class Biome(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    @ManyToMany(cascade = [ CascadeType.PERSIST, CascadeType.MERGE ])
    @JoinTable(
        name = "biome_equipment",
        joinColumns = [ JoinColumn(name = "biome_id") ],
        inverseJoinColumns = [ JoinColumn(name = "equipment_id") ]
    )
    val equipments: MutableList<Equipment> = mutableListOf()

)
