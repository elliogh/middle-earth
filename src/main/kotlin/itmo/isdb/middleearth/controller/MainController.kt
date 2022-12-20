package itmo.isdb.middleearth.controller

import itmo.isdb.middleearth.Form
import itmo.isdb.middleearth.Graph
import itmo.isdb.middleearth.service.EquipmentService
import itmo.isdb.middleearth.service.LocationService
import itmo.isdb.middleearth.service.RaceService
import itmo.isdb.middleearth.service.RelationshipService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class MainController(
    @Autowired
    private val locationService: LocationService,
    @Autowired
    private val raceService: RaceService,
    private val graph: Graph,
    @Autowired
    private val equipmentService: EquipmentService,
    @Autowired
    private val relationshipService: RelationshipService
) {
    @GetMapping("/")
    fun getInitInformation(model: Model): String {
        val locations = locationService.getAll()
        val races = raceService.getAll()

        model.addAttribute("locations", locations)
        model.addAttribute("races", races)
        model.addAttribute("form", Form(null, null, null))
        return "init"
    }

    @GetMapping("/route")
    fun setRoute(): String {
        return "redirect:/"
    }

    @PostMapping("/route")
    fun calcRoute(@ModelAttribute form: Form, model: Model): String {
        val path = graph.bfs(form.firstLocation!!.toInt(), form.secondLocation!!.toInt())
        val necessaryEquipment = equipmentService.getNecessaryEquipment(path.map { it.id } as ArrayList<Int>, form.race!!.toInt())
        val totalEquipmentPrice = equipmentService.getTotalEquipmentPrice(necessaryEquipment)
        val relationships = relationshipService.getPassPrices(form.race.toInt(), path)
        val totalPassPrice = relationshipService.getTotalPassPrice(relationships)

        model.addAttribute("start", path.first())
        model.addAttribute("finish", path.last())
        model.addAttribute("path", path)
        model.addAttribute("necessaryEquipment", necessaryEquipment)
        model.addAttribute("totalEquipmentPrice", totalEquipmentPrice)
        model.addAttribute("relationships", relationships)
        model.addAttribute("totalPassPrice", totalPassPrice)
        return "route"
    }
}
