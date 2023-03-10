package com.kjipo.regex

sealed class RegExpAction {

    override fun toString(): String {
        return this::class.simpleName ?: "none"
    }
}

class StackAdd(val fragment: Frag) : RegExpAction() {

    override fun toString(): String {
        return "StackAdd: $fragment"
    }

}

class StackRemove(val fragment: Frag): RegExpAction() {

    override fun toString(): String {
        return "StackRemove: $fragment"
    }

}

class HandleCharacterInPostfixNotation(val character: Char): RegExpAction() {

    override fun toString(): String {
        return "HandleCharacterInPostfixNotation: $character"
    }


}
