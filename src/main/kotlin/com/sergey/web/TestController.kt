package com.sergey.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestMethod
import org.springframework.web.bind.annotation.RequestParam

@Controller
class TestController {
    @RequestMapping("/test", method = arrayOf(RequestMethod.GET))
    fun test(@RequestParam(value="p", required=false, defaultValue="World") p: String, model: Model): String {
        model.addAttribute("p", p)
        return "test"
    }
}