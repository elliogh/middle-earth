package itmo.isdb.middleearth.model

import jakarta.persistence.*
import lombok.Getter
import lombok.NoArgsConstructor
import lombok.Setter

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "location")
class Location(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Int,
    val name: String,
    @ManyToOne
    @JoinColumn(name = "biome_id")
    val biome: Biome,
    @ManyToOne
    @JoinColumn(name = "race_id")
    val race: Race,
    val visitTime: Int,
    val description: String,
    @ManyToMany(cascade = [ CascadeType.PERSIST, CascadeType.MERGE ], fetch = FetchType.EAGER)
    @JoinTable(
        name = "location_danger",
        joinColumns = [ JoinColumn(name = "location_id") ],
        inverseJoinColumns = [ JoinColumn(name = "danger_id") ]
    )
    val dangers: MutableList<Danger> = mutableListOf(),

    @ManyToMany(cascade = [ CascadeType.PERSIST, CascadeType.MERGE ], fetch = FetchType.EAGER)
    @JoinTable(
        name = "neighbours",
        joinColumns = [ JoinColumn(name = "first_location_id") ],
        inverseJoinColumns = [ JoinColumn(name = "second_location_id") ]
    )
    val neighbours: MutableList<Location> = mutableListOf()
)
