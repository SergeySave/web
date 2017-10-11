package com.sergey.web.controller

import com.sergey.web.data.getPages
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

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
