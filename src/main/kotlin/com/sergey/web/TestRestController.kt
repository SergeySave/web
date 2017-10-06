package com.sergey.web

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class TestRestController {
    @GetMapping("/testrest")
    fun test(@RequestParam(value = "d1", required = false, defaultValue = "0") data1: Int,
             @RequestParam(value = "d2", required = false, defaultValue = "") data2: String)
            = TestObject(data1, data2)
}