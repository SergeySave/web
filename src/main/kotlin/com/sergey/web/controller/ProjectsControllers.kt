package com.sergey.web.controller

import com.sergey.web.data.getPages
import com.sergey.web.data.projects.Project
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ProjectsController {
    @GetMapping("/projects")
    fun indexGet(model: Model): String {
        model.addAttribute("pages", getPages("/projects"))
        model.addAttribute("projects", arrayOf(
                Project(name = "Space Game",
                        link = "/projects/space_game",
                        image= "/projects/space_game/icon.png",
                        desc = ""),
                Project(name = "Chess Neural Network",
                        link = "/projects/chess_neural_network",
                        image= "/projects/chess_neural_network/icon.png",
                        desc = ""),
                Project(name = "Planet Renderer",
                        link = "/projects/planet_renderer",
                        image= "/projects/planet_renderer/icon.png",
                        desc = "")
        ))
        return "projects"
    }
}

@Controller
class SpaceGameController {
    @GetMapping("/projects/space_game")
    fun indexGet(model: Model): String {
        model.addAttribute("pages", getPages("/projects/space_game"))
        return "projects/space_game"
    }
}

@Controller
class ChessNeuralNetworkController {
    @GetMapping("/projects/chess_neural_network")
    fun indexGet(model: Model): String {
        model.addAttribute("pages", getPages("/projects/chess_neural_network"))
        return "projects/chess_neural_network"
    }
}

@Controller
class PlanetRendererController {
    @GetMapping("/projects/planet_renderer")
    fun indexGet(model: Model): String {
        model.addAttribute("pages", getPages("/projects/planet_renderer"))
        return "projects/planet_renderer"
    }
}
