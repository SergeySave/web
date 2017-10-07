package com.sergey.web.controller

import com.sergey.web.data.getPages
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping("")
    fun indexGet(model: Model): String {
        model.addAttribute("pages", getPages("/home"))
        return "index"
    }

    @GetMapping("home")
    fun homeGet(model: Model): String {
        model.addAttribute("pages", getPages("/home"))
        return "index"
    }

}