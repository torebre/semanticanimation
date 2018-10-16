package com.kjipo.experiments

import svg.Svg
import java.nio.file.Files
import java.nio.file.Paths
import javax.xml.bind.JAXB
import javax.xml.bind.JAXBContext
import javax.xml.bind.ValidationEvent
import javax.xml.bind.ValidationEventHandler


object MatrixAnimation {

    fun moveMatrix() {
        val context = JAXBContext.newInstance(Svg::class.java)

        val unmarshaller = context.createUnmarshaller()

        unmarshaller.eventHandler = CustomValidationEventHandler()

        val svgData = Files.newInputStream(Paths.get("matrix_test.svg")).use {
            unmarshaller.unmarshal(it)
        } as Svg


//        val svgData = Files.newInputStream(Paths.get("matrix_test2.svg")).use {
//            JAXB.unmarshal(it, Svg::class.java)
//        }


        println("Children:")
        svgData.children.forEach {
            println("Child: $it")


        }




    }




    private class CustomValidationEventHandler : ValidationEventHandler {

        override fun handleEvent(evt: ValidationEvent): Boolean {
            println("Event Info: ${evt.message}")
//            return if (evt.getMessage().contains("unexpected element")) {
//                true
//            } else {
//                false
//            }

            return true
        }

    }


    @JvmStatic
    fun main(args:Array<String>) {
        moveMatrix()

    }




}