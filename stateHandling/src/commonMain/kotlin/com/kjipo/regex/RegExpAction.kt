package com.kjipo.regex

sealed class RegExpAction

class StackAdd(val fragment: Frag) : RegExpAction()

class StackRemove(val fragment: Frag): RegExpAction()

