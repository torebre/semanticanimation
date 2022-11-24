package com.kjipo.regex

sealed class RegExpAction {

    override fun toString(): String {
        return this::class.simpleName ?: "none"
    }
}

class StackAdd(val fragment: Frag) : RegExpAction()

class StackRemove(val fragment: Frag): RegExpAction()

class HandleCharacterInPostfixNotation(val character: Char): RegExpAction()
