package com.kjipo.regex

data class Paren(val nalt: Int, val natom: Int)


class StateHolder(var state: State, val isOut: Boolean)
data class State(
    var c: Int, var out: State? = null,
    var out1: State? = null, var lastList: Int = 0
)

//data class PtrList(val next: PtrList, val state: com.kjipo.regex.State)

data class Frag(val start: State, val out: MutableList<StateHolder>)

enum class StateValue(val value: Int) {
    Match(256),
    Split(257)

}


/**
 * Based on this: https://swtch.com/~rsc/regexp/nfa.c.txt
 */
class RegularExpression {

    private var listId = 0

    private val matchState = State(StateValue.Match.value)
    private val splitState = State(StateValue.Split.value)


    fun regularExpressionToPostfixNotation(regularExpression: String): String {
        val parens = mutableListOf<Paren>()
        var nalt = 0
        var natom = 0
        var destination = ""

        for (character in regularExpression) {
            when (character) {
                '(' -> {
                    if (natom > 1) {
                        --natom
                        destination += '.'
                    }

                    parens.add(Paren(nalt, natom))
                    nalt = 0
                    natom = 0
                }
                '|' -> {
                    while (--natom > 0) {
                        destination += '.'
                    }
                    ++nalt
                }
                ')' -> {
                    while (--natom > 0) {
                        destination += '.'
                    }
                    while (nalt > 0) {
                        --nalt
                        destination += '|'
                    }
                    parens.removeLast().let {
                        nalt = it.nalt
                        natom = it.natom
                    }
                    ++natom
                }
                '*', '+', '?' -> {
                    destination += character
                }
                else -> {
                    if (natom > 1) {
                        --natom
                        destination += '.'
                    }
                    destination += character
                    ++natom
                }
            }
        }

        while (--natom > 0) {
            destination += '.'
        }
        while (nalt > 0) {
            --nalt
            destination += '|'
        }
        return destination
    }


    fun postfixToNfa(postfix: String): State {
        val stack = mutableListOf<Frag>()

        for (character in postfix) {
            when (character) {
                '.' -> {
                    val e2 = stack.removeLast()
                    val e1 = stack.removeLast()

                    e1.out.forEach { element ->
                        if (element.isOut) {
                            element.state.out = e2.start
                        } else {
                            element.state.out1 = e2.start
                        }
                    }
                    stack.add(Frag(e1.start, e2.out))
                }
                '|' -> {
                    val e2 = stack.removeLast()
                    val e1 = stack.removeLast()
                    val state = State(StateValue.Split.value, e1.start, e2.start)
                    val tempList = e1.out.toMutableList().also { it.addAll(e2.out) }
                    stack.add(Frag(state, tempList))
                }
                '?' -> {
                    val e = stack.removeLast()
                    val state = State(StateValue.Split.value, e.start, null)
                    stack.add(Frag(state, e.out.toMutableList().also { it.add(StateHolder(state, false)) }))
                }
                '*' -> {
                    val e = stack.removeLast()
                    val state = State(StateValue.Split.value, e.start, null)
                    e.out.forEach { stateHolder ->
                        if (stateHolder.isOut) {
                            stateHolder.state.out = state
                        } else {
                            stateHolder.state.out1 = state
                        }
                    }
                    stack.add(Frag(state, mutableListOf(StateHolder(state, false))))
                }
                '+' -> {
                    val eElement = stack.removeLast()
                    val state = State(StateValue.Split.value, eElement.start, null)

                    eElement.out.forEach {
                        if (it.isOut) {
                            it.state.out = state
                        } else {
                            it.state.out1 = state
                        }
                    }
                    stack.add(Frag(eElement.start, mutableListOf(StateHolder(state, false))))
                }
                else -> {
                    val state = State(character.code, null, null)
                    stack.add(Frag(state, mutableListOf(StateHolder(state, true))))
                }
            }
        }

        return stack.removeLast().let { fragment ->
            fragment.out.forEach {
                if (it.isOut) {
                    it.state.out = matchState
                } else {
                    it.state.out1 = matchState
                }
            }
            fragment.start
        }
    }

    fun match(state: State, inputData: String): Boolean {
        var clist = mutableListOf<State>()
        listId++
        addState(clist, state)
        var nlist = mutableListOf<State>()

        for (character in inputData) {
            step(clist, character.code, nlist)
            val temp = clist
            clist = nlist
            nlist = temp
        }
        return isMatch(clist)
    }

    private fun isMatch(clist: List<State>): Boolean {
        for (state in clist) {
            if (state.c == StateValue.Match.value) {
                return true
            }
        }
        return false
    }


    private fun addState(clist: MutableList<State>, state: State?) {
        if (state == null || state.lastList == listId) {
            return
        }

        state.lastList = listId
        if (state.c == StateValue.Split.value) {
            addState(clist, state.out)
            addState(clist, state.out1)
            return
        }

        clist.add(state)
    }

    private fun step(
        clist: List<State>,
        characterCode: Int,
        nlist: MutableList<State>
    ) {
        listId++
        nlist.clear()

        clist.forEach { state ->
            if (state.c == characterCode) {
                addState(nlist, state.out)
            }
        }
    }


    fun doMatch(regularExpression: String, inputString: String): Boolean {
        val postFixNotation = regularExpressionToPostfixNotation(regularExpression)
        val start = postfixToNfa(postFixNotation)

        return match(start, inputString)
    }


}