package com.kjipo

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

fun writeEquation() {
    startApplication()

    Thread.sleep(3000)
    println("Initialized: ${FX.initialized.value}")

    val svgController = FX.find(SvgController::class.java)

    FX.runAndWait { svgController.writeEquation() }

}


fun main(args: Array<String>) {
//    moveCircle()
    writeEquation()


}