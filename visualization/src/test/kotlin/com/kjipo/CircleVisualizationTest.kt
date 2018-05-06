package com.kjipo

import com.kjipo.state.Circle
import com.kjipo.state.LayoutState
import com.kjipo.state.moveInside
import com.kjipo.svg.SvgController
import com.kjipo.svg.startApplication
import tornadofx.*


fun moveCircle() {
    val circle1 = Circle(100, 100, 10, 1)

    startApplication()

    Thread.sleep(3000)
    println("Initialized: ${FX.initialized.value}")

    val svgController = FX.find(SvgController::class.java)

    FX.runAndWait { svgController.createCircle(circle1) }
    Thread.sleep(500)
    FX.runAndWait { svgController.move(circle1, 150, 150) }


}


fun moveCircle2() {
    val circle1 = Circle(100, 100, 10, 1)
    val circle2 = Circle(10, 10, 10, 1)

    val layoutState = LayoutState(listOf(circle1, circle2))
    val moveInsideTransition = moveInside(circle1, circle2, layoutState)

    startApplication()

    Thread.sleep(3000)
    println("Initialized: ${FX.initialized.value}")

    val svgController = FX.find(SvgController::class.java)

    FX.runAndWait { svgController.drawState(moveInsideTransition.originalState) }
    Thread.sleep(500)
    FX.runAndWait { svgController.drawTransition(moveInsideTransition) }
    Thread.sleep(500)
    FX.runAndWait { svgController.drawState(moveInsideTransition.newState) }


    FX.runAndWait { svgController.move(circle1, 150, 150) }
}

fun writeEquation() {
    startApplication()

    Thread.sleep(3000)
    println("Initialized: ${FX.initialized.value}")

    val svgController = FX.find(SvgController::class.java)
    FX.runAndWait { svgController.writeEquation() }
}


fun moveEquation() {
    val testSvg2 = """
        <svg id="svg_equation" xmlns:xlink="http://www.w3.org/1999/xlink" width="1.23ex" height="1.676ex" style="vertical-align: -0.338ex;" viewBox="0 -576.1 529.5 721.6" role="img" focusable="false" xmlns="http://www.w3.org/2000/svg" aria-labelledby="MathJax-SVG-1-Title">
<title id="MathJax-SVG-1-Title">Equation</title>
<defs aria-hidden="true">
<path stroke-width="1" id="E1-MJMATHI-61" d="M33 157Q33 258 109 349T280 441Q331 441 370 392Q386 422 416 422Q429 422 439 414T449 394Q449 381 412 234T374 68Q374 43 381 35T402 26Q411 27 422 35Q443 55 463 131Q469 151 473 152Q475 153 483 153H487Q506 153 506 144Q506 138 501 117T481 63T449 13Q436 0 417 -8Q409 -10 393 -10Q359 -10 336 5T306 36L300 51Q299 52 296 50Q294 48 292 46Q233 -10 172 -10Q117 -10 75 30T33 157ZM351 328Q351 334 346 350T323 385T277 405Q242 405 210 374T160 293Q131 214 119 129Q119 126 119 118T118 106Q118 61 136 44T179 26Q217 26 254 59T298 110Q300 114 325 217T351 328Z"></path>
</defs>
<g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)" aria-hidden="true">
<g id="a1">
 <use xlink:href="#E1-MJMATHI-61"></use>
</g>
</g>
</svg>""" //.replace("\"", "\\\"")

    val testSvg = """<svg id="svg_equation" xmlns:xlink="http://www.w3.org/1999/xlink" width="1.23ex" height="1.676ex" style="vertical-align: -0.338ex;" viewBox="0 -576.1 529.5 721.6" role="img" focusable="false" xmlns="http://www.w3.org/2000/svg" aria-labelledby="MathJax-SVG-1-Title"><title id="MathJax-SVG-1-Title">Equation</title><defs aria-hidden="true"><path stroke-width="1" id="E1-MJMATHI-61" d="M33 157Q33 258 109 349T280 441Q331 441 370 392Q386 422 416 422Q429 422 439 414T449 394Q449 381 412 234T374 68Q374 43 381 35T402 26Q411 27 422 35Q443 55 463 131Q469 151 473 152Q475 153 483 153H487Q506 153 506 144Q506 138 501 117T481 63T449 13Q436 0 417 -8Q409 -10 393 -10Q359 -10 336 5T306 36L300 51Q299 52 296 50Q294 48 292 46Q233 -10 172 -10Q117 -10 75 30T33 157ZM351 328Q351 334 346 350T323 385T277 405Q242 405 210 374T160 293Q131 214 119 129Q119 126 119 118T118 106Q118 61 136 44T179 26Q217 26 254 59T298 110Q300 114 325 217T351 328Z"></path></defs><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)" aria-hidden="true"><g id="a1"><use xlink:href="#E1-MJMATHI-61"></use></g></g></svg>""""

    startApplication()

    val svgController = FX.find(SvgController::class.java)

//    moveEquation(${newPath}, "${id}");

//    FX.runAndWait { svgController.loadContent(testSvg) }
    FX.runAndWait { svgController.executeScript("""
        element = Snap.parse('${testSvg}');

        // const equation = Snap.select("#" +id);

        var g = snap.group().append( element );

//        g.animate(
//            {
//                d: "M500"
//            },
//            1000);

            g.animate({ transform: 't300,0r45,0,0' }, 2000);

        """) }


//    FX.runAndWait { svgController.executeScript("""
////var s = Snap("#svgout");
//
//var fobjectSVG = '<svg><foreignObject width="80" height="200"><body><p>Here is a paragraph that requires word wrap</p></body></foreignObject></svg>';
//
//var p = Snap.parse( fobjectSVG );
//
//var p2 = element = Snap.parse('${testSvg}');
//
//var g = snap.group().append( p );
//
//g.animate({ transform: 't300,0r45,50,50' }, 2000);
//        """) }



}


fun main(args: Array<String>) {
//    moveCircle()
//    moveCircle2()
//    writeEquation()

    moveEquation()

}