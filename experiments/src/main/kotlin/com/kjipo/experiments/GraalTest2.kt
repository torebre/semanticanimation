package com.kjipo.experiments

import java.io.File


private object GraalTest2 {


    private fun runNodeScript2() {
        val mathMl = "<math><mrow> <mo>(</mo> <mtable> <mtr> <mtd> <mn>1</mn> </mtd> </mtr> <mtr> <mtd> <mn>0</mn> </mtd> </mtr> <mtr> <mtd> <mn>0</mn> </mtd> </mtr> </mtable> <mo>)</mo> </mrow></math>"

        val process = ProcessBuilder("/home/student/Downloads/graalvm-ce-1.0.0-rc5/jre/bin/node",
                "/home/student/projects/MathJax-node/transformToSvg.js",
                mathMl)
                .directory(File("/home/student/Downloads/graalvm-ce-1.0.0-rc5/jre/bin/"))
                .redirectErrorStream(true)
                .start()

        val test = process.inputStream.bufferedReader().lineSequence().joinToString("\n")

        println("Test: $test")

    }


    @JvmStatic
    fun main(args: Array<String>) {
        runNodeScript2()

    }


}