package com.sergey.web.config

import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter

@Configuration
@EnableWebMvc
class WebConfiguration : WebMvcConfigurerAdapter() {

    override fun addResourceHandlers(registry: ResourceHandlerRegistry) {
        registry.addResourceHandler("/semantic/**")
                .addResourceLocations("classpath:/static_private/semantic/dist/")
        registry.addResourceHandler("/**")
                .addResourceLocations("classpath:/static/")
    }
}