package com.sergey.web

import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PostMapping

@Controller
class TestController {
    @GetMapping("/test")
    fun testGet(model: Model): String {
        model.addAttribute("testModelObject", TestObject())
        return "test"
    }

    @PostMapping("/test")
    fun testPost(@ModelAttribute testObject: TestObject, model: Model): String {
        model.addAttribute("testModelObject", testObject)
        println(testObject)
        return "testResult"
    }
}