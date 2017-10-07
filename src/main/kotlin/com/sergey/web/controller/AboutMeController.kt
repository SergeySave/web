package com.sergey.web.controller

import com.sergey.web.data.getPages
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class AboutMeController {
    @GetMapping("/about_me")
    fun indexGet(model: Model): String {
        model.addAttribute("pages", getPages("/about_me"))
        return "aboutme"
    }

}