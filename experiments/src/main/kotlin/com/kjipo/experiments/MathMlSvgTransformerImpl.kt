package com.kjipo.experiments

import java.io.File


class MathMlSvgTransformerImpl : MathMlSvgTransformer {

    override fun tranformToSvg(mathMlInput: String): String {
//        val process = ProcessBuilder("/home/student/Downloads/graalvm-ce-1.0.0-rc5/jre/bin/node",
//                "/home/student/projects/MathJax-node/transformToSvg.js",
//                mathMlInput)
//                .directory(File("/home/student/Downloads/graalvm-ce-1.0.0-rc5/jre/bin/"))
//                .redirectErrorStream(true)
//                .start()

        val process = ProcessBuilder("/home/student/.sdkman/candidates/java/1.0.0-rc7-graal/jre/bin/node",
//                "/home/student/projects/MathJax-node/transformToSvg.js",
                "/home/student/workspace/semanticAnimation/mathjaxCode/transformToSvg.js",
                mathMlInput)
                .directory(File("/home/student/.sdkman/candidates/java/1.0.0-rc7-graal/jre/bin"))
                .redirectErrorStream(true)
                .start()

        return process.inputStream.bufferedReader().lineSequence().joinToString("\n")
    }


}