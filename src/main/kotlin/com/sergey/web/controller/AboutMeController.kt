package com.sergey.web.controller

import com.sergey.web.data.setPage
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AboutMeController {
    @GetMapping("/about_me")
    fun indexGet(model: Model): String = model.setPage("about_me", "aboutme")
}