package com.kjipo.regex

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class RegularExpressionTest {

    @Test
    fun testRegularExpression() {
        val regularExpression = RegularExpression()
        val postfixNotation = regularExpression.regularExpressionToPostfixNotation("a(b|c)*d")

        assertEquals("abc|*.d.", postfixNotation)
    }


    @Test
    fun testRegularExpression2() {
        val regularExpression = RegularExpression()
//        val result = regularExpression.doMatch("a*aa", "aaabbaaa")
        val result = regularExpression.doMatch("a+", "a")

        println("Result: ${result}")

        assertTrue { result }
    }


}