package itmo.isdb.middleearth.controller

import itmo.isdb.middleearth.Form
import itmo.isdb.middleearth.Graph
import itmo.isdb.middleearth.service.LocationService
import itmo.isdb.middleearth.service.RaceService
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
    private val graph: Graph
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
        val path = graph.bfs(form.firstLocation!!.toLong(), form.secondLocation!!.toLong())
        model.addAttribute("start", path.first())
        model.addAttribute("finish", path.last())
        model.addAttribute("path", path)
        return "route"
    }
}
