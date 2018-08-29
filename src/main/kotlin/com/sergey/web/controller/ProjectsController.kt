package com.sergey.web.controller

import com.sergey.web.data.projects.Project
import com.sergey.web.data.setPage
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Controller
class ProjectsController {
    val projects = arrayOf(
            Project(name = "Algorithm Visualizer",
                    link = "/projects/algorithm_visualizer",
                    image = "/projects/algorithm_visualizer/icon.png",
                    desc = "A visualizer for various algorithms"),
            Project(name = "Space Game",
                    link = "/projects/space_game",
                    image = "/projects/space_game/icon.png",
                    desc = "A 2D real time strategy game set in space"),
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
        model.addAttribute("projects", projects)
        return model.setPage("projects")
    }

    @GetMapping("/projects/{project}")
    fun subProject(model: Model, @PathVariable("project") project: String): String {
        model.setPage("projects/$project")
        model.addAttribute("project", projects.find { p -> p.link == "/projects/${project}" })
        return "projects/$project/$project"
    }
}