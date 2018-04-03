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


fun main(args: Array<String>) {
//    moveCircle()
//    moveCircle2()
    writeEquation()


}