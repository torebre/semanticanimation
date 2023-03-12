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

    @Test
    fun testOrInRegularExpression() {
        assertTrue { doRegExpMatch("a|b", "a") }
        assertTrue { doRegExpMatch("a|b|c", "c") }
        assertTrue { doRegExpMatch("a|b.*", "adefghijklmnop") }

        assertFalse { doRegExpMatch("a|b", "cdefghijklm") }
    }
}