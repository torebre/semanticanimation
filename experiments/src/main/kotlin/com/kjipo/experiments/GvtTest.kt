package com.kjipo.experiments

import org.apache.batik.anim.dom.SAXSVGDocumentFactory
import org.apache.batik.bridge.BaseScriptingEnvironment
import org.apache.batik.bridge.BridgeContext
import org.apache.batik.bridge.GVTBuilder
import org.apache.batik.bridge.UserAgentAdapter
import org.apache.batik.gvt.CompositeGraphicsNode
import org.apache.batik.gvt.GraphicsNode
import org.apache.batik.util.XMLResourceDescriptor
import org.w3c.dom.Document
import java.io.IOException
import java.nio.file.Files
import java.nio.file.Paths
import java.util.*

object GvtTest {

    private fun runTest() {
        val parserClassName = XMLResourceDescriptor.getXMLParserClassName()
        val f = SAXSVGDocumentFactory(parserClassName)
        var doc: Document? = null

        Files.newBufferedReader(Paths.get("/home/student/workspace/semanticAnimation/matrix_test.svg")).use {
            doc = f.createDocument("matrix_test.svg", it)
        }

        val userAgent = UserAgentAdapter()
        val builder = GVTBuilder()
        val ctx = BridgeContext(userAgent)
        ctx.setDynamic(true)

        val gvtTree = builder.build(ctx, doc)
        val scriptEnvironment = BaseScriptingEnvironment(ctx)
        scriptEnvironment.loadScripts()
        scriptEnvironment.dispatchSVGLoadEvent()


        val queue = ArrayDeque<GraphicsNode>()
        queue.add(gvtTree.root)

        while(!queue.isEmpty()) {
            val gvtNode = queue.poll()
            if(gvtNode is CompositeGraphicsNode) {
                val compositeNode = gvtNode as CompositeGraphicsNode
                val children = compositeNode.children

                for (child in compositeNode.children) {
                    queue.add(child as GraphicsNode)
                }
            }
            else {
                println("Test23: $gvtNode")
            }
            println("Graphics node: ${gvtNode}")

            val element = ctx.getElement(gvtNode)

            println("Element: $element")

            if(element != null) {
                val attributes = element.attributes
                for(i in 0 until attributes.length) {
                    val attribute = attributes.item(i)

                    println("Attribute: ${attribute.nodeName}. Value: ${attribute.nodeValue}")

                }

            }
        }

        for (child in gvtTree.root.children) {
            println(child)
        }

    }


    @JvmStatic
    fun main(args: Array<String>) {
        runTest()

    }


}