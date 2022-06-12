import kotlinx.browser.document

fun main() {
    document.write("Hello, world!")

    val mathjax = js("MathJax")

    document.write("MathJax: ${mathjax.version}")

}