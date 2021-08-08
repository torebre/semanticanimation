import org.w3c.dom.Element
import org.w3c.dom.css.CSSStyleDeclaration
import org.w3c.dom.events.KeyboardEvent
import org.w3c.dom.parsing.DOMParser
import org.w3c.dom.svg.SVGElement
import kotlin.browser.document




class TrellisOutput(svgElementId: String = "trellis") {

    private val svgElement: SVGElement


    init {
        val element = document.getElementById(svgElementId)

        svgElement = if("svg" == element?.tagName) {
            element as SVGElement
        }
        else {
            val createdElement = document.createElementNS(SVG_NAMESPACE_URI, "svg")
            createdElement.id = svgElementId
            createdElement.setAttribute("width", "600")
            createdElement.setAttribute("height", "800")
            document.body?.appendChild(createdElement)
            createdElement as SVGElement
        }
    }



    fun setup() {

//        val snap = Snap(600, 800)
        val snap = Snap(svgElement)

        val line = snap.line(10, 10, 100, 10)
        line.attr("stroke", "red")
        line.attr("stroke-dasharray", "3")

        val topRect = snap.rect(0, 0, 40, 40)
        val text = snap.text(20, 20, "Test")


        document.addEventListener("keyDown", {event ->
            val keyboardEvent = event as KeyboardEvent

            when(keyboardEvent.code) {

                "ArrowDown" -> {
                    val bottomLine = snap.line(10, 100, 100, 100)


                }

            }



        })


















    }


    companion object {
        const val SVG_NAMESPACE_URI = "http://www.w3.org/2000/svg"
    }


}