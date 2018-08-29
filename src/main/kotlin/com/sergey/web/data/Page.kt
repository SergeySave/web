package com.sergey.web.data

import com.sergey.web.exception.NotSupportedException
import org.springframework.ui.Model

fun getPages(curr: String): Array<Page> = pages {
    this.current = curr

    +"About Me"
    newPage {
        name = "Projects"
        showThis = true
        sub {
            +"Algorithm Visualizer"
            +"Space Game"
            +"Chess Neural Network"
            +"Planet Renderer"
        }
    }
}

fun Model.setPage(page: String, retVal: String = page): String {
    addAttribute("pages", getPages("/${page}"))
    return retVal
}

class Page(var link: String, var name: String, var current: Boolean, var isSubPage: Boolean, var showThis: Boolean, var overviewName: String, val subPages: Array<Page>)

private class PageBuilder {
    var link: String? = null
    var name: String? = null
    var overviewName: String? = null
    var current: Boolean? = null
    var showThis: Boolean? = null
    var subPages: Array<Page>? = null
        private set

    fun makePage(curr: String): Page {
        if (subPages != null) {
            val pages = subPages!!
            pages.forEach { page ->
                page.link = "${this@PageBuilder.link}${page.link}"
                page.current = curr.equals(page.link)
                page.isSubPage = true
                if (page.subPages.isNotEmpty()) {
                    throw NotSupportedException("Subpages may not have subpages")
                }
            }
        }
        return Page(link!!, name!!, current!!, false, showThis == true, overviewName ?: "Overview", subPages
                ?: arrayOf())
    }

    fun sub(func: PageArrayBuilder.()->Unit): Unit {
        subPages = pages(func)
    }
}

private class PageArrayBuilder(val list: MutableList<Page> = mutableListOf()) {
    var current: String = ""

    fun newPage(func: PageBuilder.()->Unit) {
        val builder = PageBuilder()
        builder.func()
        if (builder.link == null && builder.name != null) {
            builder.link = "/${builder.name!!.replace(' ', '_').toLowerCase()}"
        }
        if (builder.current == null) {
            builder.current = this.current == builder.link!!
        }
        list.add(builder.makePage(current))
    }

    fun newPage(name: String) = newPage { this.name = name }

    operator fun String.unaryPlus() = newPage(this)
}

private fun pages(func: PageArrayBuilder.()->Unit) : Array<Page> {
    val builder = PageArrayBuilder()
    builder.func()
    return builder.list.toTypedArray()
}
