package com.kjipo.regex


internal fun doRegExpMatch(regularExpression: String, inputString: String): Boolean {
    return RegularExpression(regularExpression, inputString).doMatch()
}
