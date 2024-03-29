package io.kjipo.trellis

import kotlinx.browser.document
import org.w3c.dom.Element
import org.w3c.dom.parsing.DOMParser


class MatrixWebAnimation(svgElementId: String = "matrix") {
    private val svgElement: Element

    companion object {
        const val SVG_NAMESPACE_URI = "http://www.w3.org/2000/svg"

    }

    init {
        val element = document.getElementById(svgElementId)
        svgElement = if ("svg" == element?.tagName) {
            element
        } else {
            val createdElement = document.createElementNS(SVG_NAMESPACE_URI, "svg")
            createdElement.id = svgElementId
            document.body?.appendChild(createdElement)
            createdElement
        }

    }


    fun createMatrix() {
        // TODO

        val parser = DOMParser()
        val svgDocument = parser.parseFromString(testData, "text/xml")

        document.body?.let {bodyElement ->
            svgDocument.rootElement?.let {
                bodyElement.appendChild(it.cloneNode(true))

            }

        }


    }


    fun animateMatrix() {
//        val svgElement = document.getElementById("trellis")

        svgElement.let {
//            setupSvg(it)


            val equation = Snap.select("#mn_test")



            println("Equation: $equation")

            val animateProperties: dynamic = Any()
//            animateProperties.d = "M94.2,265.7L82,203.4c43.3-15.6,83.8-29.2,137.1-20.2c61.5-27.6,126.1-56.9,202.6 46.1c18.7,18.9,21.5,39.8,12.2,62.3C322.7,231.9,208.2,247.6,94.2,265.7z"
            animateProperties.transform = "t1000, 0"

            equation.animate(animateProperties, 1000)
        }


    }




}



val testData = """
    <svg xmlns:xlink="http://www.w3.org/1999/xlink" width="5.981ex" height="9.509ex" style="vertical-align: -4.171ex;" viewBox="0 -2298.3 2575 4094.3" role="img" focusable="false" xmlns="http://www.w3.org/2000/svg" aria-labelledby="MathJax-SVG-1-Title">
<title id="MathJax-SVG-1-Title">Equation</title>
<defs aria-hidden="true">
<path stroke-width="1" id="E1-MJMAIN-28" d="M94 250Q94 319 104 381T127 488T164 576T202 643T244 695T277 729T302 750H315H319Q333 750 333 741Q333 738 316 720T275 667T226 581T184 443T167 250T184 58T225 -81T274 -167T316 -220T333 -241Q333 -250 318 -250H315H302L274 -226Q180 -141 137 -14T94 250Z"></path>
<path stroke-width="1" id="E1-MJMAIN-31" d="M213 578L200 573Q186 568 160 563T102 556H83V602H102Q149 604 189 617T245 641T273 663Q275 666 285 666Q294 666 302 660V361L303 61Q310 54 315 52T339 48T401 46H427V0H416Q395 3 257 3Q121 3 100 0H88V46H114Q136 46 152 46T177 47T193 50T201 52T207 57T213 61V578Z"></path>
<path stroke-width="1" id="E1-MJMAIN-30" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z"></path>
<path stroke-width="1" id="E1-MJMAIN-29" d="M60 749L64 750Q69 750 74 750H86L114 726Q208 641 251 514T294 250Q294 182 284 119T261 12T224 -76T186 -143T145 -194T113 -227T90 -246Q87 -249 86 -250H74Q66 -250 63 -250T58 -247T55 -238Q56 -237 66 -225Q221 -64 221 250T66 725Q56 737 55 738Q55 746 60 749Z"></path>
<path stroke-width="1" id="E1-MJSZ4-239B" d="M837 1154Q843 1148 843 1145Q843 1141 818 1106T753 1002T667 841T574 604T494 299Q417 -84 417 -609Q417 -641 416 -647T411 -654Q409 -655 366 -655Q299 -655 297 -654Q292 -652 292 -643T291 -583Q293 -400 304 -242T347 110T432 470T574 813T785 1136Q787 1139 790 1142T794 1147T796 1150T799 1152T802 1153T807 1154T813 1154H819H837Z"></path>
<path stroke-width="1" id="E1-MJSZ4-239D" d="M843 -635Q843 -638 837 -644H820Q801 -644 800 -643Q792 -635 785 -626Q684 -503 605 -363T473 -75T385 216T330 518T302 809T291 1093Q291 1144 291 1153T296 1164Q298 1165 366 1165Q409 1165 411 1164Q415 1163 416 1157T417 1119Q417 529 517 109T833 -617Q843 -631 843 -635Z"></path>
<path stroke-width="1" id="E1-MJSZ4-239C" d="M413 -9Q412 -9 407 -9T388 -10T354 -10Q300 -10 297 -9Q294 -8 293 -5Q291 5 291 127V300Q291 602 292 605L296 609Q298 610 366 610Q382 610 392 610T407 610T412 609Q416 609 416 592T417 473V127Q417 -9 413 -9Z"></path>
<path stroke-width="1" id="E1-MJSZ4-239E" d="M31 1143Q31 1154 49 1154H59Q72 1154 75 1152T89 1136Q190 1013 269 873T401 585T489 294T544 -8T572 -299T583 -583Q583 -634 583 -643T577 -654Q575 -655 508 -655Q465 -655 463 -654Q459 -653 458 -647T457 -609Q457 -58 371 340T100 1037Q87 1059 61 1098T31 1143Z"></path>
<path stroke-width="1" id="E1-MJSZ4-23A0" d="M56 -644H50Q31 -644 31 -635Q31 -632 37 -622Q69 -579 100 -527Q286 -228 371 170T457 1119Q457 1161 462 1164Q464 1165 520 1165Q575 1165 577 1164Q582 1162 582 1153T583 1093Q581 910 570 752T527 400T442 40T300 -303T89 -626Q78 -640 75 -642T61 -644H56Z"></path>
<path stroke-width="1" id="E1-MJSZ4-239F" d="M579 -9Q578 -9 573 -9T554 -10T520 -10Q466 -10 463 -9Q460 -8 459 -5Q457 5 457 127V300Q457 602 458 605L462 609Q464 610 532 610Q548 610 558 610T573 610T578 609Q582 609 582 592T583 473V127Q583 -9 579 -9Z"></path>
</defs>
<g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)" aria-hidden="true">
<g transform="translate(0,2180)">
 <use xlink:href="#E1-MJSZ4-239B" x="0" y="-1156"></use>
<g transform="translate(0,-2093.5954863563406) scale(1,0.5427094703049762)">
 <use xlink:href="#E1-MJSZ4-239C"></use>
</g>
 <use xlink:href="#E1-MJSZ4-239D" x="0" y="-3217"></use>
</g>
<g transform="translate(1042,0)">
<g transform="translate(-11,0)">
 <use xlink:href="#E1-MJMAIN-31" x="0" y="1380"></use>
 <use xlink:href="#E1-MJMAIN-30" x="0" y="-50"></use>
<g transform="translate(0,-1481)">
<g id="mn_test">
 <use xlink:href="#E1-MJMAIN-30"></use>
</g>
</g>
</g>
</g>
<g transform="translate(1699,2180)">
 <use xlink:href="#E1-MJSZ4-239E" x="0" y="-1155"></use>
<g transform="translate(0,-2093.5762247191014) scale(1,0.5443146067415733)">
 <use xlink:href="#E1-MJSZ4-239F"></use>
</g>
 <use xlink:href="#E1-MJSZ4-23A0" x="0" y="-3217"></use>
</g>
</g>
</svg>
    
    
""".trimIndent()



fun main() {
    println("Test23")
//    val test = js("""require("matrix_test.svg")""")


//    File.readText("matrix_test.svg")

    val matrixWebAnimation = MatrixWebAnimation()
    matrixWebAnimation.createMatrix()
    matrixWebAnimation.animateMatrix()




}