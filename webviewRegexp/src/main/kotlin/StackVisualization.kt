import com.kjipo.regex.RegExpAction
import com.kjipo.regex.StackAdd
import com.kjipo.regex.StackRemove
import kotlinx.browser.document
import kotlinx.datetime.Clock
import org.w3c.dom.Element

class StackVisualization(private val actionScript: List<RegExpAction>, parentElement: String) {

    private val svgElement: Element
    private val stackElements = mutableListOf<StackElement>()

    private class StackElement(val stackFrame: Element, val textElement: Element)

    init {
        svgElement = document.createElementNS(SVG_NAMESPACE_URI, "svg")
        svgElement.setAttribute("width", "600")
        svgElement.setAttribute("height", "100")
        svgElement.setAttribute(
            "viewBox",
            "0 0 100 100"
        )

        document.getElementById(parentElement)!!.appendChild(svgElement)
    }


    fun runActionScript() {
        actionScript.forEach { action ->
            when (action) {
                is StackAdd -> {
                    val stackElement = svgElement.ownerDocument!!.createElementNS(SVG_NAMESPACE_URI, "rect")
                    stackElement.setAttribute("width", characterBoxWidth.toString())
                    stackElement.setAttribute("height", characterBoxHeight.toString())
                    stackElement.setAttribute("fill", "blue")

                    val textElement = svgElement.ownerDocument!!.createElementNS(SVG_NAMESPACE_URI, "rect")
                    textElement.textContent = action.fragment.start.c.toString()

                    textElement.setAttribute("x", "2")
                    textElement.setAttribute("y", "12")
                    textElement.setAttribute("fill", "black")
                    textElement.setAttribute("class", "characterbox")

                    svgElement.appendChild(stackElement)
                    svgElement.appendChild(textElement)

                    stackElements.add(StackElement(stackElement, textElement))

                }

                is StackRemove -> {
                    val poppedStackElement = stackElements.removeLast()

                    val animationElement = svgElement.ownerDocument!!.createElementNS(SVG_NAMESPACE_URI, "animate")
                    animationElement.setAttribute("attributeName", "x")
                    animationElement.setAttribute("values", "0;100;0")
                    animationElement.setAttribute("dur", "10s")
                    animationElement.setAttribute("repeatCount", "10")
//                    animationElement.setAttribute("begin", "wallclock($startTime)")
                    animationElement.setAttribute("begin", "indefinite")

                    poppedStackElement.stackFrame.appendChild(animationElement)

                    val temp: dynamic = animationElement
                    temp.beginElement()

                    // No value to return
                    Unit
                }

                else -> {
                    // Do nothing
                }

            }


        }


    }


}