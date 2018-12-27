import org.w3c.dom.Element
import org.w3c.dom.css.CSSStyleDeclaration
import org.w3c.dom.parsing.DOMParser
import kotlin.browser.document


class TrellisOutput {


    fun setup() {


        val snap = Snap(600, 800)

        val line = snap.line(10, 10, 100, 10)
        line.attr("stroke", "red")
        line.attr("stroke-dasharray", "3")


        val topRect = snap.rect(0, 0, 40, 40)
        val text = snap.text(20, 20, "Test")


        val bottomLine = snap.line(10, 100, 100, 100)














    }


}