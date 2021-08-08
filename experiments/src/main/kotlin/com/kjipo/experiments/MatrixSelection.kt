package com.kjipo.experiments

import com.kjipo.mathml3.Math
import java.io.StringWriter
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller

object MatrixSelection {

    private fun findElements() {
        val testMatrix = MathMlTransformationTest.createTestColumnMatrix()

        val stringWriter = StringWriter()
        val context = JAXBContext.newInstance(Math::class.java)

        val marshaller = context.createMarshaller()
//        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "")
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false)

        marshaller.marshal(testMatrix, stringWriter)

        val transformer = MathMlSvgTransformerImpl()

        val input = String(Files.readAllBytes(Paths.get("matrix_data.xml")), StandardCharsets.UTF_8)

        val svgData = transformer.tranformToSvg(stringWriter.toString())

        println("SVG data: $svgData")


    }


    @JvmStatic
    fun main(args:Array<String>) {
        findElements()
    }




}