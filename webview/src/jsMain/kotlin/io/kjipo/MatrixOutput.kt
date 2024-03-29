package io.kjipo

import Snap
import Snap.Element
import Snap.parse
import kotlinx.browser.document

object MatrixOutput {
    private val svgMatrix = """
<svg xmlns:xlink="http://www.w3.org/1999/xlink" width="5.015ex" height="16.176ex" style="vertical-align: -7.505ex;" viewBox="0 -3733.5 2159 6964.6" role="img" focusable="false" xmlns="http://www.w3.org/2000/svg" aria-labelledby="MathJax-SVG-1-Title">
<title id="MathJax-SVG-1-Title">Equation</title>
<defs aria-hidden="true">
<path stroke-width="1" id="E1-MJMAIN-5B" d="M118 -250V750H255V710H158V-210H255V-250H118Z"></path>
<path stroke-width="1" id="E1-MJMAIN-31" d="M213 578L200 573Q186 568 160 563T102 556H83V602H102Q149 604 189 617T245 641T273 663Q275 666 285 666Q294 666 302 660V361L303 61Q310 54 315 52T339 48T401 46H427V0H416Q395 3 257 3Q121 3 100 0H88V46H114Q136 46 152 46T177 47T193 50T201 52T207 57T213 61V578Z"></path>
<path stroke-width="1" id="E1-MJMAIN-30" d="M96 585Q152 666 249 666Q297 666 345 640T423 548Q460 465 460 320Q460 165 417 83Q397 41 362 16T301 -15T250 -22Q224 -22 198 -16T137 16T82 83Q39 165 39 320Q39 494 96 585ZM321 597Q291 629 250 629Q208 629 178 597Q153 571 145 525T137 333Q137 175 145 125T181 46Q209 16 250 16Q290 16 318 46Q347 76 354 130T362 333Q362 478 354 524T321 597Z"></path>
<path stroke-width="1" id="E1-MJMAIN-5D" d="M22 710V750H159V-250H22V-210H119V710H22Z"></path>
<path stroke-width="1" id="E1-MJSZ4-23A1" d="M319 -645V1154H666V1070H403V-645H319Z"></path>
<path stroke-width="1" id="E1-MJSZ4-23A3" d="M319 -644V1155H403V-560H666V-644H319Z"></path>
<path stroke-width="1" id="E1-MJSZ4-23A2" d="M319 0V602H403V0H319Z"></path>
<path stroke-width="1" id="E1-MJSZ4-23A4" d="M0 1070V1154H347V-645H263V1070H0Z"></path>
<path stroke-width="1" id="E1-MJSZ4-23A6" d="M263 -560V1155H347V-644H0V-560H263Z"></path>
<path stroke-width="1" id="E1-MJSZ4-23A5" d="M263 0V602H347V0H263Z"></path>
</defs>
<g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)" aria-hidden="true">
<g id="test2_start" transform="translate(0,3611)">
 <use xlink:href="#E1-MJSZ4-23A1" x="0" y="-1155"></use>
<g transform="translate(0,-4965.884516556292) scale(1,5.33148344370861)">
 <use xlink:href="#E1-MJSZ4-23A2"></use>
</g>
 <use xlink:href="#E1-MJSZ4-23A3" x="0" y="-6078"></use>
</g>
<g transform="translate(834,0)">
<g transform="translate(-11,0)">
<g transform="translate(0,2811)">
<g id="test2_0_0">
 <use xlink:href="#E1-MJMAIN-31"></use>
</g>
</g>
<g transform="translate(0,1380)">
<g id="test2_1_0">
 <use xlink:href="#E1-MJMAIN-30"></use>
</g>
</g>
<g transform="translate(0,-50)">
<g id="test2_2_0">
 <use xlink:href="#E1-MJMAIN-31"></use>
</g>
</g>
<g transform="translate(0,-1481)">
<g id="test2_3_0">
 <use xlink:href="#E1-MJMAIN-30"></use>
</g>
</g>
<g transform="translate(0,-2912)">
<g id="test2_4_0">
 <use xlink:href="#E1-MJMAIN-30"></use>
</g>
</g>
</g>
</g>
<g id="test2_end" transform="translate(1491,3611)">
 <use xlink:href="#E1-MJSZ4-23A4" x="0" y="-1155"></use>
<g transform="translate(0,-4965.884516556292) scale(1,5.33148344370861)">
 <use xlink:href="#E1-MJSZ4-23A5"></use>
</g>
 <use xlink:href="#E1-MJSZ4-23A6" x="0" y="-6078"></use>
</g>
</g>
</svg>
    """.trimIndent()


    fun drawMatrix() {
        val svgRoot = document.createElement("div")
        document.rootElement?.appendChild(svgRoot)
        val fragment = parse(svgMatrix)
        val snap = Snap("#matrix")
        snap.append(fragment.unsafeCast<Element>())
    }


    fun animateTest() {
        val pathSelect = Snap.select("#E1-MJSZ4-23A4")
        val animateProperties: dynamic = Any()
        animateProperties.d = "M0 1070V1154H347V-645H263V1070H0Z"
        pathSelect.animate(animateProperties, 1000)

        val pathSelect2 = Snap.select("#E1-MJSZ4-23A5")
        val animateProperties2: dynamic = Any()
        animateProperties2.d = "M263 -560V1155H347V-644H0V-560H263Z"
        pathSelect2.animate(animateProperties, 1000)

        val pathSelect3 = Snap.select("#E1-MJSZ4-23A6")
        val animateProperties3: dynamic = Any()
        animateProperties3.d = "M263 0V602H347V0H263Z"
        pathSelect3.animate(animateProperties, 1000)
    }


}
