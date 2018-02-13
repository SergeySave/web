package com.sergey.web.controller

import com.sergey.web.data.getPages
import com.sergey.web.data.projects.Project
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class ProjectsController {
    val projects = arrayOf(
            Project(name = "Space Game",
                    link = "/projects/space_game",
                    image = "/projects/space_game/icon.png",
                    desc = ""),
            Project(name = "Chess Neural Network",
                    link = "/projects/chess_neural_network",
                    image = "/projects/chess_neural_network/icon.png",
                    desc = "An Artificial Neural Network written from scratch and taught to play chess"),
            Project(name = "Planet Renderer",
                    link = "/projects/planet_renderer",
                    image = "/projects/planet_renderer/icon.png",
                    desc = "A 3D planet renderer using a custom LOD algorithm"))

    @GetMapping("/projects")
    fun projectsMain(model: Model): String {
        model.addAttribute("pages", getPages("/projects"))
        model.addAttribute("projects", projects)
        return "projects/projects"
    }

    @GetMapping("/projects/{project}")
    fun subProject(model: Model, @PathVariable("project") project: String): String {
        model.addAttribute("pages", getPages("/projects/$project"))
        return "projects/$project/$project"
    }
}