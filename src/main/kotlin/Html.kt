val html = html {
    head {
        title = "My Website"
        css("styles.css")
        css("boostrap.css")
    }
    body {
        h1("Title")
        +"Some Text"
        h2("Subtitle")
        +"Some other text"
    }
}

@DslMarker
annotation class HtmlDSL

fun html(init: HtmlBuilder.() -> Unit): HtmlBuilder {
    val builder = HtmlBuilder()
    builder.init()
    return builder
}

@HtmlDSL
data class HtmlBuilder(
        private var head: HeadBuilder? = null,
        private var body: BodyBuilder? = null
) {
    fun head(init: HeadBuilder.() -> Unit) {
        val builder = HeadBuilder()
        builder.init()
        head = builder
    }

    fun body(init: BodyBuilder.() -> Unit) {
        val builder = BodyBuilder()
        builder.init()
        body = builder
    }
}

@HtmlDSL
data class HeadBuilder(var title: String? = "", private var css: List<String> = emptyList()) {
    fun css(content: String) {
        css += content
    }
}

@HtmlDSL
data class BodyBuilder(private var elements: List<Any> = emptyList()) {
    fun h1(text: String) {
        elements += H1(text)
    }

    fun h2(text: String) {
        elements += H2(text)
    }

    operator fun String.unaryPlus() {
        elements += this
    }
}

data class H1(val text: String)
data class H2(val text: String)



fun main() {
    print(html)
}