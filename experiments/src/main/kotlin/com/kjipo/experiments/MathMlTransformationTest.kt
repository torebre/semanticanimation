package com.kjipo.experiments

import com.kjipo.mathml3.*
import java.io.StringWriter
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Paths
import java.nio.file.StandardOpenOption
import javax.xml.bind.JAXBContext
import javax.xml.bind.Marshaller


private object MathMlTransformationTest {


    fun transformTest() {
        val math = Math()

        val mrow = Mrow()
        math.children.add(mrow)

        val moStart = Mo()
        moStart.setvalue("(")
        mrow.elements.add(moStart)

        val table = Mtable()

        // Row 1
        table.mtrOrMlabeledtr.add(Mtr().let {
            val mtd = Mtd()
            mtd.elements.let { elements ->
                Mn().let {
                    it.setvalue("1")
                    elements.add(it)
                }
            }
            it.mtd.add(mtd)
            it
        })

        table.mtrOrMlabeledtr.add(Mtr().let {
            val mtd = Mtd()
            mtd.elements.let { elements ->
                Mn().let {
                    it.setvalue("0")
                    elements.add(it)
                }
            }
            it.mtd.add(mtd)
            it
        })


        table.mtrOrMlabeledtr.add(Mtr().let {
            val mtd = Mtd()
            mtd.elements.let { elements ->
                Mn().let {
                    it.setvalue("0")
                    elements.add(it)
                    it.id = "mn_test"
                }
            }
            it.mtd.add(mtd)
            it
        })


        mrow.elements.add(table)

        val moEnd = Mo()
        moEnd.setvalue(")")
        mrow.elements.add(moEnd)


        val stringWriter = StringWriter()

        val context = JAXBContext.newInstance(Math::class.java)

        val marshaller = context.createMarshaller()
//        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "")
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false)

        marshaller.marshal(math, stringWriter)

        Files.write(Paths.get("matrix_data.xml"), stringWriter.toString().toByteArray(StandardCharsets.UTF_8), StandardOpenOption.CREATE)

        val transformer = MathMlSvgTransformerImpl()

        val input = String(Files.readAllBytes(Paths.get("matrix_data.xml")), StandardCharsets.UTF_8)

        println("Input: $input")

        Files.write(Paths.get("matrix_test.svg"),
                transformer.tranformToSvg(input).toByteArray())
//        Files.write(Paths.get("matrix_test.svg"), transformer.tranformToSvg(stringWriter.toString()).toByteArray(StandardCharsets.UTF_8))


//        println("Output: $stringWriter")


    }


    private fun creationTest(matrix: Matrix<Int>, idPrefix: String, fileName: String) {
        val stringWriter = StringWriter()

        val context = JAXBContext.newInstance(Math::class.java)

        val marshaller = context.createMarshaller()
//        marshaller.setProperty(Marshaller.JAXB_NO_NAMESPACE_SCHEMA_LOCATION, "")
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, false)

        val math = MatrixCreator.createMatrix(matrix, idPrefix)
        marshaller.marshal(math, stringWriter)

        Files.write(Paths.get(fileName +".xml"), stringWriter.toString().toByteArray(StandardCharsets.UTF_8), StandardOpenOption.CREATE)

        val transformer = MathMlSvgTransformerImpl()

        val input = String(Files.readAllBytes(Paths.get(fileName +".xml")), StandardCharsets.UTF_8)

//        println("Input: $input")

        Files.write(Paths.get(fileName +".svg"),
                transformer.tranformToSvg(input).toByteArray())
    }


    @JvmStatic
    fun main(args: Array<String>) {
//        transformTest()

        val matrix = Matrix(5, 5, {row, column ->
            if(row == column) {
                1
            }
            else {
                0
            }
        })

        creationTest(matrix, "test", "matrix_test")

        val matrix2 = Matrix(5, 1) { row, column ->
            when (row) {
                0, 2 -> 1
                else -> 0
            }
        }

        creationTest(matrix2, "test2", "matrix_test2")

    }


}