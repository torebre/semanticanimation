import kotlinx.browser.document
import mu.KotlinLogging
import org.w3c.dom.Element


const val SVG_NAMESPACE_URI = "http://www.w3.org/2000/svg"
const val characterBoxWidth = 20
const val characterBoxHeight = 20

class CharacterBox(val character: Char, private val svgElement: Element) {


    fun createCharacterBox(xStart: Int, yStart: Int, svgNameSpaceElementCreator: (name: String) -> Element): Element {
        return svgNameSpaceElementCreator("rect").also { rectangleElement ->
            rectangleElement.setAttribute("width", characterBoxWidth.toString())
            rectangleElement.setAttribute("height", characterBoxHeight.toString())
            rectangleElement.setAttribute("fill", "red")

            val textElement = svgNameSpaceElementCreator("text")
            textElement.textContent = character.toString()
            textElement.setAttribute("x", "2")
            textElement.setAttribute("y", "12")
            textElement.setAttribute("fill", "black")
            textElement.setAttribute("class", "characterbox")

            setupTranslatedElement(xStart, yStart).also {
                it.appendChild(rectangleElement)
                it.appendChild(textElement)
            }
        }
    }


    private fun setupTranslatedElement(xShift: Int, yShift: Int): Element {
        return document.let {
            val groupingElement = it.createElementNS(SVG_NAMESPACE_URI, "g")
            groupingElement.setAttribute("transform", "translate(${xShift}, ${yShift})")

            svgElement.appendChild(groupingElement)
            groupingElement
        }
    }

}


class CharacterSequence(
    inputData: String,
    parentElement: String
) {

    private val svgElement: Element
    private val characters: List<CharacterBox>



    init {
        svgElement = document.createElementNS(SVG_NAMESPACE_URI, "svg")
        svgElement.setAttribute("width", "600")
        svgElement.setAttribute("height", "100")
        svgElement.setAttribute(
            "viewBox",
            "0 0 ${characterBoxWidth * inputData.count()} ${characterBoxHeight}"
        )

        document.getElementById(parentElement)!!.appendChild(svgElement)
        characters = inputData.mapIndexed { index, character ->
            CharacterBox(character, svgElement).also { characterBox ->
                characterBox.createCharacterBox(index * characterBoxWidth, 0) { name ->
                    svgElement.ownerDocument!!.createElementNS(SVG_NAMESPACE_URI, name)
                }
            }
        }
    }


}