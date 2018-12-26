import org.w3c.dom.Element
import org.w3c.dom.get
import org.w3c.dom.parsing.DOMParser
import kotlin.browser.document
import kotlin.dom.clear


class EquationAnimation {
    private val testSvg =              """
                <div id="svg_test">

                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="3.125ex" height="2.625ex" viewBox="0 -941.2 1343 1117.2" style="vertical-align: -0.5ex; margin: 1px 0ex;">

    <defs id="MathJax_SVG_glyphs">
    <path stroke-width="10" id="MJMAIN-32"
    d="M109 429Q82 429 66 447T50 491Q50 562 103 614T235 666Q326 666 387 610T449 465Q449 422 429 383T381 315T301 241Q265 210 201 149L142 93L218 92Q375 92 385 97Q392 99 409 186V189H449V186Q448 183 436 95T421 3V0H50V19V31Q50 38 56 46T86 81Q115 113 136 137Q145 147 170 174T204 211T233 244T261 278T284 308T305 340T320 369T333 401T340 431T343 464Q343 527 309 573T212 619Q179 619 154 602T119 569T109 550Q109 549 114 549Q132 549 151 535T170 489Q170 464 154 447T109 429Z"></path>
    <path stroke-width="10" id="MJMAIN-221A"
    d="M95 178Q89 178 81 186T72 200T103 230T169 280T207 309Q209 311 212 311H213Q219 311 227 294T281 177Q300 134 312 108L397 -77Q398 -77 501 136T707 565T814 786Q820 800 834 800Q841 800 846 794T853 782V776L620 293L385 -193Q381 -200 366 -200Q357 -200 354 -197Q352 -195 256 15L160 225L144 214Q129 202 113 190T95 178Z"></path>
    </defs>

    <g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)">
    <use xlink:href="#MJMAIN-221A" x="0" y="52"></use>

    <path stroke-width="10" id="MJMAIN-32"
    d="M109 429Q82 429 66 447T50 491Q50 562 103 614T235 666Q326 666 387 610T449 465Q449 422 429 383T381 315T301 241Q265 210 201 149L142 93L218 92Q375 92 385 97Q392 99 409 186V189H449V186Q448 183 436 95T421 3V0H50V19V31Q50 38 56 46T86 81Q115 113 136 137Q145 147 170 174T204 211T233 244T261 278T284 308T305 340T320 369T333 401T340 431T343 464Q343 527 309 573T212 619Q179 619 154 602T119 569T109 550Q109 549 114 549Q132 549 151 535T170 489Q170 464 154 447T109 429Z" x="0" y="52"></path>

    <rect stroke="none" width="505" height="60" x="838" y="802"></rect>
    <use xlink:href="#MJMAIN-32" x="838" y="0"></use>

    <path stroke-width="10" id="MJMAIN-221"
    d="M95 178Q89 178 81 186T72 200T103 230T169 280T207 309Q209 311 212 311H213Q219 311 227 294T281 177Q300 134 312 108L397 -77Q398 -77 501 136T707 565T814 786Q820 800 834 800Q841 800 846 794T853 782V776L620 293L385 -193Q381 -200 366 -200Q357 -200 354 -197Q352 -195 256 15L160 225L144 214Q129 202 113 190T95 178Z"></path>

    </g>
    </svg>
    </div>
"""

    fun draw() {
        val svgElement = document.getElementById("trellis")

        svgElement?.let {
            setupSvg(it)

            val equation = Snap.select("#MJMAIN-32")
            val animateProperties: dynamic = Any()
            animateProperties.d = "M94.2,265.7L82,203.4c43.3-15.6,83.8-29.2,137.1-20.2c61.5-27.6,126.1-56.9,202.6 46.1c18.7,18.9,21.5,39.8,12.2,62.3C322.7,231.9,208.2,247.6,94.2,265.7z"

            equation.animate(animateProperties, 1000)
        }

    }


    fun setupSvg(topElement: Element) {
        val parser = DOMParser()
        val svgData = parser.parseFromString(testSvg, "application/xml")

        svgData.getElementById("svg_test")?.let {
            topElement.appendChild(it)
        }
    }

    fun moveEquation() {
        val math = """
            <math id="block1" identifier="block1">
<mfrac id="frac1">
    <mrow>
        <mn id="number1"> 1 </mn>
        <mo> + </mo>
        <msqrt>
            <mn> 5 </mn>
        </msqrt>
    </mrow>
    <mn> 2 </mn>
</mfrac>
    <mo>=</mo>
    <mi>x</mi>
</math>
        """.trimIndent()

        val equation = """
            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" id="block1" identifier="block1" width="9.633ex" height="3.716ex" viewBox="0 -1201.6 4136 1624.7" style="vertical-align: -0.963ex; margin: 1px 0ex;">
            <g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)"><g id="frac1"><g transform="translate(120,0)"><rect stroke="none" width="1980" height="60" x="0" y="220"></rect><g transform="translate(60,556)"><g id="number1"><use transform="scale(0.707)" xlink:href="#MJMAIN-31"></use></g><use transform="scale(0.707)" xlink:href="#MJMAIN-2B" x="505" y="0"></use><g transform="translate(910,0)"><use transform="scale(0.707)" xlink:href="#MJMAIN-221A" x="0" y="19"></use><rect stroke="none" width="357" height="42" x="592" y="543"></rect><use transform="scale(0.707)" xlink:href="#MJMAIN-35" x="838" y="0"></use></g></g><use transform="scale(0.707)" xlink:href="#MJMAIN-32" x="1147" y="-565"></use></g></g><use xlink:href="#MJMAIN-3D" x="2498" y="0"></use><use xlink:href="#MJMATHI-78" x="3558" y="0"></use></g>
            </svg>
        """.trimIndent()

        val equation2 = """
            <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink"><defs id="MathJax_SVG_glyphs"><path stroke-width="10" id="MJMAIN-32" d="M109 429Q82 429 66 447T50 491Q50 562 103 614T235 666Q326 666 387 610T449 465Q449 422 429 383T381 315T301 241Q265 210 201 149L142 93L218 92Q375 92 385 97Q392 99 409 186V189H449V186Q448 183 436 95T421 3V0H50V19V31Q50 38 56 46T86 81Q115 113 136 137Q145 147 170 174T204 211T233 244T261 278T284 308T305 340T320 369T333 401T340 431T343 464Q343 527 309 573T212 619Q179 619 154 602T119 569T109 550Q109 549 114 549Q132 549 151 535T170 489Q170 464 154 447T109 429Z"></path><path stroke-width="10" id="MJMAIN-221A" d="M95 178Q89 178 81 186T72 200T103 230T169 280T207 309Q209 311 212 311H213Q219 311 227 294T281 177Q300 134 312 108L397 -77Q398 -77 501 136T707 565T814 786Q820 800 834 800Q841 800 846 794T853 782V776L620 293L385 -193Q381 -200 366 -200Q357 -200 354 -197Q352 -195 256 15L160 225L144 214Q129 202 113 190T95 178Z"></path><path stroke-width="10" id="MJMATHI-79" d="M21 287Q21 301 36 335T84 406T158 442Q199 442 224 419T250 355Q248 336 247 334Q247 331 231 288T198 191T182 105Q182 62 196 45T238 27Q261 27 281 38T312 61T339 94Q339 95 344 114T358 173T377 247Q415 397 419 404Q432 431 462 431Q475 431 483 424T494 412T496 403Q496 390 447 193T391 -23Q363 -106 294 -155T156 -205Q111 -205 77 -183T43 -117Q43 -95 50 -80T69 -58T89 -48T106 -45Q150 -45 150 -87Q150 -107 138 -122T115 -142T102 -147L99 -148Q101 -153 118 -160T152 -167H160Q177 -167 186 -165Q219 -156 247 -127T290 -65T313 -9T321 21L315 17Q309 13 296 6T270 -6Q250 -11 231 -11Q185 -11 150 11T104 82Q103 89 103 113Q103 170 138 262T173 379Q173 380 173 381Q173 390 173 393T169 400T158 404H154Q131 404 112 385T82 344T65 302T57 280Q55 278 41 278H27Q21 284 21 287Z"></path><path stroke-width="10" id="MJSZ1-221A" d="M263 249Q264 249 315 130T417 -108T470 -228L725 302Q981 837 982 839Q989 850 1001 850Q1008 850 1013 844T1020 832V826L741 243Q645 43 540 -176Q479 -303 469 -324T453 -348Q449 -350 436 -350L424 -349L315 -96Q206 156 205 156L171 130Q138 104 137 104L111 130L263 249Z"></path><path stroke-width="10" id="MJMAIN-31" d="M213 578L200 573Q186 568 160 563T102 556H83V602H102Q149 604 189 617T245 641T273 663Q275 666 285 666Q294 666 302 660V361L303 61Q310 54 315 52T339 48T401 46H427V0H416Q395 3 257 3Q121 3 100 0H88V46H114Q136 46 152 46T177 47T193 50T201 52T207 57T213 61V578Z"></path><path stroke-width="10" id="MJMAIN-2B" d="M56 237T56 250T70 270H369V420L370 570Q380 583 389 583Q402 583 409 568V270H707Q722 262 722 250T707 230H409V-68Q401 -82 391 -82H389H387Q375 -82 369 -68V230H70Q56 237 56 250Z"></path><path stroke-width="10" id="MJMAIN-35" d="M164 157Q164 133 148 117T109 101H102Q148 22 224 22Q294 22 326 82Q345 115 345 210Q345 313 318 349Q292 382 260 382H254Q176 382 136 314Q132 307 129 306T114 304Q97 304 95 310Q93 314 93 485V614Q93 664 98 664Q100 666 102 666Q103 666 123 658T178 642T253 634Q324 634 389 662Q397 666 402 666Q410 666 410 648V635Q328 538 205 538Q174 538 149 544L139 546V374Q158 388 169 396T205 412T256 420Q337 420 393 355T449 201Q449 109 385 44T229 -22Q148 -22 99 32T50 154Q50 178 61 192T84 210T107 214Q132 214 148 197T164 157Z"></path><path stroke-width="10" id="MJMAIN-3D" d="M56 347Q56 360 70 367H707Q722 359 722 347Q722 336 708 328L390 327H72Q56 332 56 347ZM56 153Q56 168 72 173H708Q722 163 722 153Q722 140 707 133H70Q56 140 56 153Z"></path><path stroke-width="10" id="MJMATHI-78" d="M52 289Q59 331 106 386T222 442Q257 442 286 424T329 379Q371 442 430 442Q467 442 494 420T522 361Q522 332 508 314T481 292T458 288Q439 288 427 299T415 328Q415 374 465 391Q454 404 425 404Q412 404 406 402Q368 386 350 336Q290 115 290 78Q290 50 306 38T341 26Q378 26 414 59T463 140Q466 150 469 151T485 153H489Q504 153 504 145Q504 144 502 134Q486 77 440 33T333 -11Q263 -11 227 52Q186 -10 133 -10H127Q78 -10 57 16T35 71Q35 103 54 123T99 143Q142 143 142 101Q142 81 130 66T107 46T94 41L91 40Q91 39 97 36T113 29T132 26Q168 26 194 71Q203 87 217 139T245 247T261 313Q266 340 266 352Q266 380 251 392T217 404Q177 404 142 372T93 290Q91 281 88 280T72 278H58Q52 284 52 289Z"></path></defs></svg>
        """.trimIndent()

//        <svg xmlns:xlink="http://www.w3.org/1999/xlink" id="block1" width="9.633ex" height="3.716ex" viewBox="0 -1201.6 4136 1624.7" style="vertical-align: -0.963ex; margin: 1px 0ex;">
        val temp = """
           <div id="svg_test">

    <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" width="9.633ex" height="3.716ex" viewBox="0 -1201.6 4136 1624.7" style="vertical-align: -0.5ex; margin: 1px 0ex;">

        <defs id="MathJax_SVG_glyphs">
            <path stroke-width="10" id="MJMAIN-32"
                  d="M109 429Q82 429 66 447T50 491Q50 562 103 614T235 666Q326 666 387 610T449 465Q449 422 429 383T381 315T301 241Q265 210 201 149L142 93L218 92Q375 92 385 97Q392 99 409 186V189H449V186Q448 183 436 95T421 3V0H50V19V31Q50 38 56 46T86 81Q115 113 136 137Q145 147 170 174T204 211T233 244T261 278T284 308T305 340T320 369T333 401T340 431T343 464Q343 527 309 573T212 619Q179 619 154 602T119 569T109 550Q109 549 114 549Q132 549 151 535T170 489Q170 464 154 447T109 429Z"></path>
            <path stroke-width="10" id="MJMAIN-221A"
                  d="M95 178Q89 178 81 186T72 200T103 230T169 280T207 309Q209 311 212 311H213Q219 311 227 294T281 177Q300 134 312 108L397 -77Q398 -77 501 136T707 565T814 786Q820 800 834 800Q841 800 846 794T853 782V776L620 293L385 -193Q381 -200 366 -200Q357 -200 354 -197Q352 -195 256 15L160 225L144 214Q129 202 113 190T95 178Z"></path>
            <path stroke-width="10" id="MJMATHI-79"
                  d="M21 287Q21 301 36 335T84 406T158 442Q199 442 224 419T250 355Q248 336 247 334Q247 331 231 288T198 191T182 105Q182 62 196 45T238 27Q261 27 281 38T312 61T339 94Q339 95 344 114T358 173T377 247Q415 397 419 404Q432 431 462 431Q475 431 483 424T494 412T496 403Q496 390 447 193T391 -23Q363 -106 294 -155T156 -205Q111 -205 77 -183T43 -117Q43 -95 50 -80T69 -58T89 -48T106 -45Q150 -45 150 -87Q150 -107 138 -122T115 -142T102 -147L99 -148Q101 -153 118 -160T152 -167H160Q177 -167 186 -165Q219 -156 247 -127T290 -65T313 -9T321 21L315 17Q309 13 296 6T270 -6Q250 -11 231 -11Q185 -11 150 11T104 82Q103 89 103 113Q103 170 138 262T173 379Q173 380 173 381Q173 390 173 393T169 400T158 404H154Q131 404 112 385T82 344T65 302T57 280Q55 278 41 278H27Q21 284 21 287Z"></path>
            <path stroke-width="10" id="MJSZ1-221A"
                  d="M263 249Q264 249 315 130T417 -108T470 -228L725 302Q981 837 982 839Q989 850 1001 850Q1008 850 1013 844T1020 832V826L741 243Q645 43 540 -176Q479 -303 469 -324T453 -348Q449 -350 436 -350L424 -349L315 -96Q206 156 205 156L171 130Q138 104 137 104L111 130L263 249Z"></path>
            <path stroke-width="10" id="MJMAIN-31"
                  d="M213 578L200 573Q186 568 160 563T102 556H83V602H102Q149 604 189 617T245 641T273 663Q275 666 285 666Q294 666 302 660V361L303 61Q310 54 315 52T339 48T401 46H427V0H416Q395 3 257 3Q121 3 100 0H88V46H114Q136 46 152 46T177 47T193 50T201 52T207 57T213 61V578Z"></path>
            <path stroke-width="10" id="MJMAIN-2B"
                  d="M56 237T56 250T70 270H369V420L370 570Q380 583 389 583Q402 583 409 568V270H707Q722 262 722 250T707 230H409V-68Q401 -82 391 -82H389H387Q375 -82 369 -68V230H70Q56 237 56 250Z"></path>
            <path stroke-width="10" id="MJMAIN-35"
                  d="M164 157Q164 133 148 117T109 101H102Q148 22 224 22Q294 22 326 82Q345 115 345 210Q345 313 318 349Q292 382 260 382H254Q176 382 136 314Q132 307 129 306T114 304Q97 304 95 310Q93 314 93 485V614Q93 664 98 664Q100 666 102 666Q103 666 123 658T178 642T253 634Q324 634 389 662Q397 666 402 666Q410 666 410 648V635Q328 538 205 538Q174 538 149 544L139 546V374Q158 388 169 396T205 412T256 420Q337 420 393 355T449 201Q449 109 385 44T229 -22Q148 -22 99 32T50 154Q50 178 61 192T84 210T107 214Q132 214 148 197T164 157Z"></path>
            <path stroke-width="10" id="MJMAIN-3D"
                  d="M56 347Q56 360 70 367H707Q722 359 722 347Q722 336 708 328L390 327H72Q56 332 56 347ZM56 153Q56 168 72 173H708Q722 163 722 153Q722 140 707 133H70Q56 140 56 153Z"></path>
            <path stroke-width="10" id="MJMATHI-78"
                  d="M52 289Q59 331 106 386T222 442Q257 442 286 424T329 379Q371 442 430 442Q467 442 494 420T522 361Q522 332 508 314T481 292T458 288Q439 288 427 299T415 328Q415 374 465 391Q454 404 425 404Q412 404 406 402Q368 386 350 336Q290 115 290 78Q290 50 306 38T341 26Q378 26 414 59T463 140Q466 150 469 151T485 153H489Q504 153 504 145Q504 144 502 134Q486 77 440 33T333 -11Q263 -11 227 52Q186 -10 133 -10H127Q78 -10 57 16T35 71Q35 103 54 123T99 143Q142 143 142 101Q142 81 130 66T107 46T94 41L91 40Q91 39 97 36T113 29T132 26Q168 26 194 71Q203 87 217 139T245 247T261 313Q266 340 266 352Q266 380 251 392T217 404Q177 404 142 372T93 290Q91 281 88 280T72 278H58Q52 284 52 289Z"></path>
        </defs>

        <g stroke="currentColor" fill="currentColor" stroke-width="0" transform="matrix(1 0 0 -1 0 0)">
            <g id="frac1">
                <g transform="translate(120,0)">
                    <rect stroke="none" width="1980" height="60" x="0" y="220"></rect>
                    <g transform="translate(60,556)">
                        <g id="number1">
                            <use transform="scale(0.707)" xlink:href="#MJMAIN-31"></use>
                        </g>
                        <use transform="scale(0.707)" xlink:href="#MJMAIN-2B" x="505" y="0"></use>
                        <g transform="translate(910,0)">
                            <use transform="scale(0.707)" xlink:href="#MJMAIN-221A" x="0" y="19"></use>
                            <rect stroke="none" width="357" height="42" x="592" y="543"></rect>
                            <use transform="scale(0.707)" xlink:href="#MJMAIN-35" x="838" y="0"></use>
                        </g>
                    </g>
                    <use transform="scale(0.707)" xlink:href="#MJMAIN-32" x="1147" y="-565"></use>
                </g>
            </g>
            <use xlink:href="#MJMAIN-3D" x="2498" y="0"></use>
            <use xlink:href="#MJMATHI-78" x="3558" y="0"></use>
        </g>
    </svg>
</div>
        """.trimIndent()


        val parser = DOMParser()
        val svgData = parser.parseFromString(equation, "application/xml")
        val defsData = parser.parseFromString(equation2, "application/xml")
        val svgElement = document.getElementById("trellis")

        val tempData = parser.parseFromString(temp, "application/xml")


//        val svgData2 = parser.parseFromString(testSvg, "application/xml")
//        svgData2.getElementById("svg_test")?.let {
//            svgElement?.appendChild(it)
//        }

        println("Top level: $svgElement")

        svgElement?.let { topLevel ->
//            tempData.getElementById("svg_test")?.let {
//                svgElement.appendChild(it)
//            }

//            topLevel.clear()

            println("Defs data: ${defsData.firstElementChild}")

            defsData.firstElementChild?.let {
                topLevel.appendChild(it)
            }
            svgData.firstElementChild?.let {
                topLevel.appendChild(it)
            }
        }



//        defsData.firstElementChild?.let {
//            document.append(it)
//        }
//        svgData.firstElementChild?.let {
//            document.append(it)
//        }

    }


}