package itmo.isdb.middleearth.model

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "danger")
class Danger(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    val description: String,
    @ManyToMany(cascade = [ CascadeType.PERSIST, CascadeType.MERGE ])
    @JoinTable(
        name = "danger_equipment",
        joinColumns = [ JoinColumn(name = "danger_id") ],
        inverseJoinColumns = [ JoinColumn(name = "equipment_id") ]
    )
    val equipments: MutableList<Equipment> = mutableListOf()
)
