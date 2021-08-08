package com.kjipo.svg.equation

import com.kjipo.svg.SvgController
import com.kjipo.svg.startApplication
import tornadofx.*


fun equationTest() {
    val equation = SvgEquation()

    equation.components.put(1,
            """
                <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Title</title>
</head>
<body>
<div>
    <svg>
        <defs id="MathJax_SVG_glyphs">
            <path stroke-width="10" id="MJMAIN-32"
                  d="M109 429Q82 429 66 447T50 491Q50 562 103 614T235 666Q326 666 387 610T449 465Q449 422 429 383T381 315T301 241Q265 210 201 149L142 93L218 92Q375 92 385 97Q392 99 409 186V189H449V186Q448 183 436 95T421 3V0H50V19V31Q50 38 56 46T86 81Q115 113 136 137Q145 147 170 174T204 211T233 244T261 278T284 308T305 340T320 369T333 401T340 431T343 464Q343 527 309 573T212 619Q179 619 154 602T119 569T109 550Q109 549 114 549Q132 549 151 535T170 489Q170 464 154 447T109 429Z"></path>
            <path stroke-width="10" id="MJMAIN-221A"
                  d="M95 178Q89 178 81 186T72 200T103 230T169 280T207 309Q209 311 212 311H213Q219 311 227 294T281 177Q300 134 312 108L397 -77Q398 -77 501 136T707 565T814 786Q820 800 834 800Q841 800 846 794T853 782V776L620 293L385 -193Q381 -200 366 -200Q357 -200 354 -197Q352 -195 256 15L160 225L144 214Q129 202 113 190T95 178Z"></path>
        </defs>
    </svg>
</div>

<svg xmlns:xlink="http://www.w3.org/1999/xlink" width="3.125ex" height="2.625ex" viewBox="0 -941.2 1343 1117.2"
     style="vertical-align: -0.5ex; margin: 1px 0ex;">
    <g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)">
        <use href="#MJMAIN-221A" x="0" y="52"></use>

        <path stroke-width="10" id="MJMAIN-32"
                  d="M109 429Q82 429 66 447T50 491Q50 562 103 614T235 666Q326 666 387 610T449 465Q449 422 429 383T381 315T301 241Q265 210 201 149L142 93L218 92Q375 92 385 97Q392 99 409 186V189H449V186Q448 183 436 95T421 3V0H50V19V31Q50 38 56 46T86 81Q115 113 136 137Q145 147 170 174T204 211T233 244T261 278T284 308T305 340T320 369T333 401T340 431T343 464Q343 527 309 573T212 619Q179 619 154 602T119 569T109 550Q109 549 114 549Q132 549 151 535T170 489Q170 464 154 447T109 429Z" x="0" y="52"></path>

        <rect stroke="none" width="505" height="60" x="838" y="802"></rect>
        <use href="#MJMAIN-32" x="838" y="0"></use>

                    <path stroke-width="10" id="MJMAIN-221A"
                  d="M95 178Q89 178 81 186T72 200T103 230T169 280T207 309Q209 311 212 311H213Q219 311 227 294T281 177Q300 134 312 108L397 -77Q398 -77 501 136T707 565T814 786Q820 800 834 800Q841 800 846 794T853 782V776L620 293L385 -193Q381 -200 366 -200Q357 -200 354 -197Q352 -195 256 15L160 225L144 214Q129 202 113 190T95 178Z"></path>

    </g>
</svg>

</body>

                """
    )


    startApplication()

    Thread.sleep(3000)
    println("Initialized: ${FX.initialized.value}")

    val svgController = FX.find(SvgEquationController::class.java)

//    FX.runAndWait { svgController.renderEquation(equation) }

//    FX.runAndWait { svgController.load() }
//    Thread.sleep(500)
    FX.runAndWait { svgController.createPath() }
        Thread.sleep(500)
    FX.runAndWait { svgController.moveEquation() }
    Thread.sleep(500)
//    FX.runAndWait { svgController.drawTestPath() }


//    FX.runAndWait { svgController.move(circle1, 150, 150) }


}


fun main(args: Array<String>) {
    equationTest()

}