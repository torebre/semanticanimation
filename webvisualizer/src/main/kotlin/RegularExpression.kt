data class Paren(val nalt: Int, val natom: Int)

data class State(var c: Int, var out: State? = null, val out1: State? = null) //, val lastList: Int)

//data class PtrList(val next: PtrList, val state: State)

data class Frag(val state: State, val ptrList: List<State>)

enum class StateValue(val value: Int) {
    Match(256),
    Split(257)

}


/**
 * Based on this: https://swtch.com/~rsc/regexp/nfa.c.txt
 */
object RegularExpression {


    fun parseExpression(regularExpression: String, inputString: String) {
        val postFixNotation = regularExpressionToPostfixNotation(regularExpression)

        println("Test23: ${postFixNotation}")

        val start = postfixToNfa(postFixNotation)

        println("Test24: ${start}")


    }


    fun regularExpressionToPostfixNotation(regularExpression: String): String {

        val parens = mutableListOf<Paren>()
        var nalt = 0
        var natom = 0
        var destination = ""


        for (character in regularExpression) {
            println(character)

            when (character) {
                '(' -> {
                    if (natom > 1) {
                        --natom
                        destination += '.'
                    }

                    parens.add(Paren(nalt, natom))
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
                    parens.last().let {
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
        var e1: Frag? = null
        var e2: Frag? = null
        var state: State? = null
        var e: Frag? = null

        val stack = mutableListOf<Frag>()

        for (character in postfix) {
            when (character) {
                '.' -> {
                    e2 = stack.last()
                    e1 = stack.last()

                    e1.ptrList.forEach { element ->
                        e2?.let {
                            element.out = it.state
                        }
                    }
                    stack.add(Frag(e1.state, e2.ptrList))
                }
                '|' -> {
                    e2 = stack.last()
                    e1 = stack.last()
                    state = State(StateValue.Split.value, e1.state, e2.state)
                    stack.add(Frag(state, listOf(e1.state, e2.state)))
                }
                '?' -> {
                    e = stack.last()
                    state = State(StateValue.Split.value, e.state, null)
                    stack.add(Frag(e.state, e.ptrList + listOfNotNull(state.out1)))
                }
                '*' -> {
                    stack.last().let { e ->
                        state = State(StateValue.Split.value, e.state, null).also { stateElement ->
                            e.ptrList.forEach { element ->
                                element.out = stateElement
                            }
                            stack.add(Frag(stateElement, listOfNotNull(stateElement.out1)))
                        }
                    }
                }
                '+' -> {
                    e = stack.last().also { eElement ->
                        run {
                            state = State(StateValue.Split.value, eElement.state, null).also { stateElement ->
                                eElement.ptrList.forEach {
                                    it.out = stateElement
                                }
                                stack.add(Frag(eElement.state, listOfNotNull(stateElement.out1)))
                            }

                        }
                    }
                }
                else -> {
                    state = State(character.code, null, null).also {
                        stack.add(Frag(it, listOf()))
                    }
                }
            }
        }

        e = stack.last().also { eElement ->
            run {
                eElement.state.c = StateValue.Match.value
            }
        }

        return e.state
    }



    fun match(state: State, inputData: String) {
        for(character in inputData) {
            // TODO


        }

    }


}