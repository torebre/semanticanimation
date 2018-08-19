package com.kjipo.experiments

import javax.script.Invocable
import java.io.FileReader
import javax.script.ScriptEngine
import javax.script.ScriptEngineManager



object LoadMathJax {


    private fun loadMathJax() {
        val engineManager = ScriptEngineManager()
        val engine = engineManager.getEngineByName("nashorn")
//        engine.eval(FileReader("/home/student/projects/MathJax-node/lib/main.js"))
        engine.eval(FileReader("/home/student/projects/MathJax/MathJax/MathJax.js"))
        val invocable = engine as Invocable




    }



    @JvmStatic
    fun main(args: Array<String>) {
        loadMathJax()


    }



}