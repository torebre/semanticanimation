package com.kjipo.svg

import com.kjipo.state.Circle
import com.kjipo.state.LayoutObject
import com.kjipo.state.LayoutState
import com.kjipo.state.Transition
import tornadofx.*
import java.io.StringWriter
import java.nio.charset.StandardCharsets
import javax.xml.parsers.DocumentBuilderFactory
import javax.xml.transform.OutputKeys
import javax.xml.transform.TransformerFactory
import javax.xml.transform.dom.DOMSource
import javax.xml.transform.stream.StreamResult


class SvgController : Controller() {
    private val testDoc2 = """
                <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8"></meta>
    <title>Title</title>
</head>
<body>
        <svg><defs id="MathJax_SVG_glyphs"><path stroke-width="10" id="MJMAIN-32" d="M109 429Q82 429 66 447T50 491Q50 562 103 614T235 666Q326 666 387 610T449 465Q449 422 429 383T381 315T301 241Q265 210 201 149L142 93L218 92Q375 92 385 97Q392 99 409 186V189H449V186Q448 183 436 95T421 3V0H50V19V31Q50 38 56 46T86 81Q115 113 136 137Q145 147 170 174T204 211T233 244T261 278T284 308T305 340T320 369T333 401T340 431T343 464Q343 527 309 573T212 619Q179 619 154 602T119 569T109 550Q109 549 114 549Q132 549 151 535T170 489Q170 464 154 447T109 429Z"></path><path stroke-width="10" id="MJMAIN-221A" d="M95 178Q89 178 81 186T72 200T103 230T169 280T207 309Q209 311 212 311H213Q219 311 227 294T281 177Q300 134 312 108L397 -77Q398 -77 501 136T707 565T814 786Q820 800 834 800Q841 800 846 794T853 782V776L620 293L385 -193Q381 -200 366 -200Q357 -200 354 -197Q352 -195 256 15L160 225L144 214Q129 202 113 190T95 178Z"></path></defs></svg>

        <svg xmlns:xlink="http://www.w3.org/1999/xlink" width="3.125ex" height="2.625ex" viewBox="0 -941.2 1343 1117.2" style="vertical-align: -0.5ex; margin: 1px 0ex;"><g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#MJMAIN-221A" x="0" y="52"></use><rect stroke="none" width="505" height="60" x="838" y="802"></rect><use xmlns:xlink="http://www.w3.org/1999/xlink" xlink:href="#MJMAIN-32" x="838" y="0"></use></g></svg>

        </body>
        </html>
        """


    val visualizer: SvgVisualization by inject()

    fun drawState(layoutState: LayoutState) {
        val script = layoutState.objects.map { visualize(it) }.joinToString("\n")
        visualizer.webView.webEngine.executeScript(script)
    }

    fun drawTransition(transition: Transition) {
        visualizer.webView.webEngine.executeScript(transition.transitionScript)
    }

    fun createCircle(circle: Circle) {
        visualizer.webView.webEngine.executeScript("""
            drawCircle(${circle.xCenter}, ${circle.yCenter}, ${circle.radius}, "elemId${circle.id}");
            """)
    }

    fun move(circle: Circle, xNew: Int, yNew: Int) {
        val script = """
            move(${xNew}, ${yNew}, "elemId${circle.id}");
            """

        visualizer.webView.webEngine.executeScript(script)
    }

    // TODO Just here for testing

    val testDocument =
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

    fun writeEquation() {
//        val equation = """
//            <div>
//<div style="visibility: hidden; overflow: hidden; position: absolute; top: 0px; height: 1px; width: auto; padding: 0px; border: 0px; margin: 0px; text-align: left; text-indent: 0px; text-transform: none; line-height: normal; letter-spacing: normal; word-spacing: normal;">
//    <svg>
//        <defs id="MathJax_SVG_glyphs">
//            <path stroke-width="10" id="MJMAIN-32"
//                  d="M109 429Q82 429 66 447T50 491Q50 562 103 614T235 666Q326 666 387 610T449 465Q449 422 429 383T381 315T301 241Q265 210 201 149L142 93L218 92Q375 92 385 97Q392 99 409 186V189H449V186Q448 183 436 95T421 3V0H50V19V31Q50 38 56 46T86 81Q115 113 136 137Q145 147 170 174T204 211T233 244T261 278T284 308T305 340T320 369T333 401T340 431T343 464Q343 527 309 573T212 619Q179 619 154 602T119 569T109 550Q109 549 114 549Q132 549 151 535T170 489Q170 464 154 447T109 429Z"></path>
//            <path stroke-width="10" id="MJMAIN-221A"
//                  d="M95 178Q89 178 81 186T72 200T103 230T169 280T207 309Q209 311 212 311H213Q219 311 227 294T281 177Q300 134 312 108L397 -77Q398 -77 501 136T707 565T814 786Q820 800 834 800Q841 800 846 794T853 782V776L620 293L385 -193Q381 -200 366 -200Q357 -200 354 -197Q352 -195 256 15L160 225L144 214Q129 202 113 190T95 178Z"></path>
//        </defs>
//    </svg>
//</div>
//
//
//<svg width="3.125ex" height="2.625ex" viewBox="0 -941.2 1343 1117.2" style="vertical-align: -0.5ex; margin: 1px 0ex;">
//    <g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)">
//        <use href="#MJMAIN-221A" x="0" y="52"></use>
//        <rect stroke="none" width="505" height="60" x="838" y="802"></rect>
//        <use href="#MJMAIN-32" x="838" y="0"></use>
//    </g>
//</svg>
//
//</div>
//            """


        val documentBuilderFactory = DocumentBuilderFactory.newInstance()
        val documentBuilder = documentBuilderFactory.newDocumentBuilder()
        val document = documentBuilder.parse(testDoc2.byteInputStream(StandardCharsets.UTF_8))

//        val bodyElement = visualizer.webView.webEngine.document.createElement(HTML_NAMESPACE, "body")

        val source = DOMSource(document)

        val stringWriter = StringWriter()

        val result = StreamResult(stringWriter)
        val transformerFactory = TransformerFactory.newInstance()
        val transformer = transformerFactory.newTransformer()
        // Set output to be HTML. If this is not set it causes
        // empty tags to appear, which causes problems when used
        // with the webview-component
        transformer.setOutputProperty(OutputKeys.METHOD, "html")
        transformer.transform(source, result)

        visualizer.webView.webEngine.loadContent(stringWriter.toString())
    }


}
