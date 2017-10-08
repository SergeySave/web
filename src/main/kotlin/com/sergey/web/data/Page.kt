package com.sergey.web.data

import com.sergey.web.exception.NotSupportedException

fun getPages(current: String) : Array<Page>  = pages {
    this.current = current

    newPage {
        name = "Home"
    }
    newPage {
        name = "Projects"
        sub {
            newPage {
                name = "Chess Neural Network"
            }
        }
    }
    newPage {
        name = "About Me"
    }
}

class Page(var link: String, var name: String, var current: Boolean, var isSubPage: Boolean, val subPages: Array<Page>)

private class PageBuilder {
    var link: String? = null
    var name: String? = null
    var current: Boolean? = null
    var subPages: Array<Page>? = null
        private set

    fun makePage(): Page {
        if (subPages != null) {
            val pages = subPages!!
            pages.forEach { page ->
                page.link = "${this@PageBuilder.link}${page.link}"
                page.isSubPage = true
                if (page.subPages.isNotEmpty()) {
                    throw NotSupportedException("Subpages may not have subpages")
                }
            }
        }
        return Page(link!!, name!!, current!!, false, subPages ?: arrayOf())
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
            builder.current = this.current.split("/").contains(builder.link!!)
        }
        list.add(builder.makePage())
    }
}

private fun pages(func: PageArrayBuilder.()->Unit) : Array<Page> {
    val builder = PageArrayBuilder()
    builder.func()
    return builder.list.toTypedArray()
}
