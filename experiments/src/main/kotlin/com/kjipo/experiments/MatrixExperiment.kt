package com.kjipo.experiments

import com.kjipo.mathml3.*
import java.io.StringWriter
import javax.xml.bind.JAXB


private object MatrixExperiment {


    fun createMatrix() {
        val mrow = Mrow()

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
        JAXB.marshal(mrow, stringWriter)

        println("Output: $stringWriter")


    }


    @JvmStatic
    fun main(args: Array<String>) {
        createMatrix()


    }


}