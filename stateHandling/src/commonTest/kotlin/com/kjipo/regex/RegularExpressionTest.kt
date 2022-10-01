package com.kjipo.regex

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class RegularExpressionTest {

    @Test
    fun testPostfixNotationConversion() {
        assertEquals("abc|*.d.", RegularExpression.regularExpressionToPostfixNotation("a(b|c)*d"))
        assertEquals("a+", RegularExpression.regularExpressionToPostfixNotation("a+"))
    }


    @Test
    fun testRegularExpression2() {
        assertTrue { doRegExpMatch("a", "a") }
        assertTrue { doRegExpMatch("a+", "a") }

        assertFalse { doRegExpMatch("a+", "b") }
    }

    private fun doRegExpMatch(regularExpression: String, inputString: String): Boolean {
        return RegularExpression(regularExpression, inputString).doMatch()
    }


}