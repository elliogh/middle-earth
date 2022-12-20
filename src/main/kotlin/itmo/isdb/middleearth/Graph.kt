package itmo.isdb.middleearth

import itmo.isdb.middleearth.model.Location
import itmo.isdb.middleearth.service.LocationService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Component

@Component
class Graph(
    @Autowired
    val locationService: LocationService
) {
    private val graph: Map<Int, Location> = locationService.getAll()
        .associateBy { it.id }

    fun bfs(begin: Int, end: Int): ArrayList<Location> {
        val visited = HashSet<Location>()
        val queue = ArrayDeque<Location>()
        graph[begin]?.let { queue.add(it) }
        val parents = HashMap<Location, Location>()
        while (queue.isNotEmpty()) {
            val currentLocation = queue.removeFirst()
            for (location in currentLocation.neighbours) {
                if (!visited.contains(location)) {
                    queue.add(location)
                    visited.add(location)
                    parents[location] = currentLocation
                }
            }
            if (currentLocation.id == end) break
        }
        return getPath(parents, graph.getValue(begin), graph.getValue(end))
    }

    fun getPath(parents: HashMap<Location, Location>, startLocation: Location, finalLocation: Location): ArrayList<Location> {
        val path = arrayListOf<Location>()
        var currentLocation = finalLocation
        while (currentLocation.id != startLocation.id) {
            path.add(currentLocation)
            val nextLocation = parents[currentLocation]
            currentLocation = nextLocation!!
        }
        path.add(startLocation)
        path.reverse()
        return path
    }
}
