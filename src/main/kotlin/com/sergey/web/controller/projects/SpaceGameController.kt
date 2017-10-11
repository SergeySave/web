package com.sergey.web.controller.projects

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