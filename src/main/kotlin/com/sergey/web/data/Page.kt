package com.sergey.web.data

data class Page(val link: String, val name: String, val current: Boolean)

fun getPages(current: String) : Array<Page>  = arrayOf<Page>(
        newPage("Home", current),
        newPage("About Me", current))


private fun newPage(name: String, current: String, link: String = "/${name.replace(' ', '_').toLowerCase()}")
        = Page(link, name, link == current)