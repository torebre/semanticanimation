package io.kjipo

import kotlinx.browser.document
import org.w3c.dom.svg.SVGElement


fun main() {
    MatrixOutput.drawMatrix()

    val testElement = document.getElementById("test2_3_0") as SVGElement
    testElement.setAttribute("color", "red")

    val testElement2: dynamic = document.getElementById("test2_start")
    testElement2.setAttribute("color", "yellow")

}
