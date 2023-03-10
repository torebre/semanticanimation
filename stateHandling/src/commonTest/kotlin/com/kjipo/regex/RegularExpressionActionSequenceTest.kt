package com.kjipo.regex

import kotlin.test.Test


class RegularExpressionActionSequenceTest {


    @Test
    fun actionSequenceTest() {
        val regExp = RegularExpression("a", "bdceabcdebcd")
        val isMatch = regExp.doMatch()

        println("Action sequence:")

        regExp.actionSequence.forEach { regExpAction ->
            println(regExpAction)
        }

        println("Is match: $isMatch")

    }


    @Test
    fun nfaTest() {
        val regularExpression = "a|b"
        val matcher = RegularExpression(regularExpression, "abcd")
        val postFixNotation = RegularExpression.regularExpressionToPostfixNotation(regularExpression)

        val start = matcher.postfixToNfa(postFixNotation)

        val seenStates = mutableListOf<State>()
        val statesToExamine = mutableListOf<State>()

        statesToExamine.add(start)

        println("States:")
        while(statesToExamine.isNotEmpty()) {
            val state = statesToExamine.removeFirst()

            println("State: ${state.id}")

            handleOutState(state.out, seenStates, state, statesToExamine)
            handleOutState(state.out1, seenStates, state, statesToExamine)
        }




    }

    private fun handleOutState(
        out: State?,
        seenStates: MutableList<State>,
        state: State,
        statesToExamine: MutableList<State>
    ) {
        if (out == null) {
            println("Out is null")
        } else {
            if (!seenStates.contains(state)) {
                statesToExamine.add(state)
                seenStates.add(state)
            }
            println("Out: ${out.id}")
        }
    }


}