package com.kjipo.regex

import mu.KotlinLogging

data class Paren(val nalt: Int, val natom: Int)


class StateHolder(var state: State, val isOut: Boolean) {


    override fun toString(): String {
        return "State: $state. Is out: $isOut"
    }


}

data class State(
    var c: Int, var out: State? = null,
    var out1: State? = null, var lastList: Int = 0
) {

    val id: Int = idCounter++

    override fun toString(): String {
        return "State(c=$c, out=${out?.c}, out1=${out1?.c}, lastList=$lastList)"
    }

    companion object {
        private var idCounter = 0
    }
}

data class Frag(val start: State, val out: MutableList<StateHolder>) {


    override fun toString(): String {
        return "Start: ${start.c}. Out: $out"
    }

}

enum class StateValue(val value: Int) {
    Match(256),
    Split(257)

}


/**
 * Based on this: https://swtch.com/~rsc/regexp/nfa.c.txt
 */
class RegularExpression(regularExpression: String, private val inputString: String) {

    private var listId = 0

    private val matchState = State(StateValue.Match.value)
    private val splitState = State(StateValue.Split.value)

    val postFixNotation: String = regularExpressionToPostfixNotation(regularExpression)
    private val start: State


    val actionSequence = mutableListOf<RegExpAction>()

    private val logger = KotlinLogging.logger {}

    private interface WrappedStack {

        fun addFragment(fragment: Frag)
        fun popFragment(): Frag


    }

    private interface WrappedDatastructures {
        fun addCList(state: State)

        fun addNList(state: State)

        fun switchLists()


        fun isMatch(): Boolean

        fun clearNList()
        fun populateNList(characterCode: Int)
    }

    private val wrappedDatastructures = object : WrappedDatastructures {
        private var clist = mutableListOf<State>()
        private var nlist = mutableListOf<State>()


        override fun addCList(state: State) {
            logger.info { "Adding state to clist: ${state.c}" }
            clist.add(state)
        }

        override fun addNList(state: State) {
            nlist.add(state)
        }

        override fun switchLists() {
            val temp = clist
            clist = nlist
            nlist = temp
        }

        override fun isMatch(): Boolean {
            return clist.firstOrNull { it.c == StateValue.Match.value } != null
        }

        override fun clearNList() {
            nlist.clear()
        }

        override fun populateNList(characterCode: Int) {
            clist.forEach { state ->
                if (state.c == characterCode) {
                    addState({ stateToAdd ->
                        getWrappedStack().addNList(stateToAdd)
                    }, state.out)
                }
            }
        }
    }


    private val wrappedStack = object : WrappedStack {
        val stack = mutableListOf<Frag>()

        override fun addFragment(fragment: Frag) {
            stack.add(fragment)
            actionSequence.add(StackAdd(fragment))
        }

        override fun popFragment(): Frag {
            return stack.removeLast().also {
                actionSequence.add(StackRemove(it))
            }
        }
    }


    init {
        start = postfixToNfa(postFixNotation)
    }

    private fun getStack(): WrappedStack {
        return wrappedStack
    }

    private fun getWrappedStack(): WrappedDatastructures {
        return wrappedDatastructures
    }


    fun postfixToNfa(postfix: String): State {
        val stack = getStack()

        for (character in postfix) {
            actionSequence.add(HandleCharacterInPostfixNotation(character))
            when (character) {
                '.' -> {
                    val e2 = stack.popFragment()
                    val e1 = stack.popFragment()

                    e1.out.forEach { element ->
                        if (element.isOut) {
                            element.state.out = e2.start
                        } else {
                            element.state.out1 = e2.start
                        }
                    }
                    stack.addFragment(Frag(e1.start, e2.out))
                }

                '|' -> {
                    val e2 = stack.popFragment()
                    val e1 = stack.popFragment()
                    val state = State(StateValue.Split.value, e1.start, e2.start)
                    val tempList = e1.out.toMutableList().also { it.addAll(e2.out) }
                    stack.addFragment(Frag(state, tempList))
                }

                '?' -> {
                    val e = stack.popFragment()
                    val state = State(StateValue.Split.value, e.start, null)
                    stack.addFragment(Frag(state, e.out.toMutableList().also { it.add(StateHolder(state, false)) }))
                }

                '*' -> {
                    val e = stack.popFragment()
                    val state = State(StateValue.Split.value, e.start, null)
                    e.out.forEach { stateHolder ->
                        if (stateHolder.isOut) {
                            stateHolder.state.out = state
                        } else {
                            stateHolder.state.out1 = state
                        }
                    }
                    stack.addFragment(Frag(state, mutableListOf(StateHolder(state, false))))
                }

                '+' -> {
                    val eElement = stack.popFragment()
                    val state = State(StateValue.Split.value, eElement.start, null)

                    eElement.out.forEach {
                        if (it.isOut) {
                            it.state.out = state
                        } else {
                            it.state.out1 = state
                        }
                    }
                    stack.addFragment(Frag(eElement.start, mutableListOf(StateHolder(state, false))))
                }

                else -> {
                    val state = State(character.code, null, null)
                    stack.addFragment(Frag(state, mutableListOf(StateHolder(state, true))))
                }
            }
        }

        return stack.popFragment().let { fragment ->
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
        listId++
        addState({ state ->
            getWrappedStack().addCList(state)
        }, state)

        for (character in inputData) {
            step(character.code)
            getWrappedStack().switchLists()
        }
        return getWrappedStack().isMatch()
    }


    private fun addState(addFunction: (state: State) -> Unit, state: State?) {
        if (state == null || state.lastList == listId) {
            return
        }

        state.lastList = listId
        if (state.c == StateValue.Split.value) {
            addState(addFunction, state.out)
            addState(addFunction, state.out1)
            return
        }

        addFunction(state)
    }

    private fun step(characterCode: Int) {
        listId++
        getWrappedStack().clearNList()
        getWrappedStack().populateNList(characterCode)
    }


    fun doMatch(): Boolean {
        return match(start, inputString)
    }


    companion object {

        fun doMatch(regularExpression: String, inputString: String): Boolean {
            val matcher = RegularExpression(regularExpression, inputString)
            val postFixNotation = regularExpressionToPostfixNotation(regularExpression)
            val start = matcher.postfixToNfa(postFixNotation)

            return matcher.match(start, inputString)
        }

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

    }

}