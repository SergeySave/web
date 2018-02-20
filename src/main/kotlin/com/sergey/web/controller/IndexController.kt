package com.sergey.web.controller

import com.sergey.web.data.setPage
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping

@Controller
class IndexController {
    @GetMapping("")
    fun indexGet(model: Model): String = model.setPage("aboutme")

    @GetMapping("home")
    fun homeGet(model: Model): String = model.setPage("aboutme")

}