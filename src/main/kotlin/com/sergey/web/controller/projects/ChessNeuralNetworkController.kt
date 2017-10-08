package com.sergey.web.controller.projects

import com.sergey.web.data.getPages
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class ChessNeuralNetworkController {
    @GetMapping("/projects/chess_neural_network")
    fun indexGet(model: Model): String {
        model.addAttribute("pages", getPages("/projects/chess_neural_network"))
        return "projects/chess_neural_network"
    }

}