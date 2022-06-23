
data class Paren(val nalt: Int, val natom: Int)

data class State(val c: Int, var out: State, val out1: State, val lastList: Int)

//data class PtrList(val next: PtrList, val state: State)

data class Frag(val state: State, val ptrList: List<State>)


/**
 * Based on this: * https://swtch.com/~rsc/regexp/nfa.c.txt
 */
object RegularExpression {


    fun parseExpression(regularExpression: String, inputString: String) {
        val postFixNotation = regularExpressionToPostfixNotation(regularExpression)

        println("Test23: ${postFixNotation}")



    }


    fun regularExpressionToPostfixNotation(regularExpression: String): String {

        val parens = mutableListOf<Paren>()
        var nalt = 0
        var natom = 0
        var destination = ""


        for(character in regularExpression) {
            println(character)

            when(character) {
                '(' -> {
                    if(natom > 1) {
                        --natom
                        destination += '.'
                    }

                    parens.add(Paren(nalt, natom))
                }
                '|' -> {
                    while(--natom > 0) {
                        destination += '.'
                    }
                    ++nalt
                }
                ')' -> {
                    while(--natom > 0) {
                        destination += '.'
                    }
                    while(nalt > 0) {
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
                    if(natom > 1) {
                        --natom
                        destination += '.'
                    }
                    destination += character
                    ++natom
                }
            }
        }
        while(--natom > 0) {
            destination += '.'
        }
        while(nalt > 0) {
            --nalt
            destination += '|'
        }

        return destination

    }


    fun postfixToNfa(postfix: String) {
        var e1: Frag? = null
        var e2: Frag? = null

        val stack = mutableListOf<Frag>()

        for(character in postfix) {
            when(character) {
               '.' -> {
                   e1 = stack.last()
                   e2 = stack.last()

                   e1.ptrList.forEach {
                       it.out = e2.state
                   }

                   stack.add(Frag(e1.state, e2.ptrList))



               }


                // TODO

            }


        }




    }


}