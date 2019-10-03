package com.kjipo.experiments

import com.kjipo.mathml3.*

object MatrixCreator {


    fun createMatrix(matrix: Matrix<Int>, idPrefix:String): Math {
        val math = Math()
        val mrow = Mrow()
        math.children.add(mrow)

        val moStart = Mo()
        moStart.setvalue("[")
        moStart.id = idPrefix +"_start"
        mrow.elements.add(moStart)
        val table = Mtable()

        for (row in 0 until matrix.numberOfRows) {
            table.mtrOrMlabeledtr.add(Mtr().let {
                for (column in 0 until matrix.numberOfColumns) {
                    val mtd = Mtd()
                    mtd.elements.let { elements ->
                        Mn().let {
                            it.setvalue(matrix[row, column].toString())
                            it.id = idPrefix +"_" +row +"_" +column
                            elements.add(it)
                        }
                    }
                    it.mtd.add(mtd)
                }
                it
            })
        }

        mrow.elements.add(table)

        val moEnd = Mo()
        moEnd.setvalue("]")
        moEnd.id = idPrefix +"_end"
        mrow.elements.add(moEnd)

        return math
    }

}