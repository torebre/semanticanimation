package com.kjipo.experiments

import java.math.BigDecimal
import org.graalvm.polyglot.*
import java.nio.file.Files
import java.nio.file.Paths


/**
 * TODO Try to use browserify to create a bundle that can be used with the JS engine used by GraalVM
 */
private object GraalTest {


    private fun runNodeScript() {
        val context = Context.create()

//        context.eval("js", "print('Hello polyglot world JavaScript!');");
//
//        context.eval("ruby", "puts 'Hello polyglot world Ruby!'");
//
//        context.eval("R", "print('Hello polyglot world R!');");
//
//        context.eval("python", "print('Hello polyglot world Python!');");


        val script = Files.readAllLines(Paths.get("/home/student/projects/MathJax-node/testFormula.js")).joinToString("\n")




        val requireJs = Files.readAllLines(Paths.get("require.js")).joinToString("\n")
        context.eval("js", requireJs)



        val mainJs = Files.readAllLines(Paths.get("/home/student/projects/MathJax-node/lib/main.js")).joinToString("\n")
        context.eval("js", mainJs);


        val eval = context.eval("js", script)
        println("Value: $eval")

        context.close()


    }


    @JvmStatic
    fun main(args: Array<String>) {
        runNodeScript()

    }


}