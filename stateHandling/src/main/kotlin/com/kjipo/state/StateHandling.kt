package com.kjipo.state


fun moveInside(circleToMove: Circle, circleStandingStill: Circle, originalState: LayoutState): Transition {
    val script = """
            move(${circleStandingStill.xCenter}, ${circleStandingStill.yCenter}, "elemId${circleToMove.id}");
            """

    val updatedCircle = Circle(circleStandingStill.xCenter, circleStandingStill.yCenter, circleToMove.radius, circleToMove.id)

    val updatedState = LayoutState(originalState.objects.map {
        if (it.id == circleToMove.id) {
            updatedCircle
        } else {
            it
        }
    })
    return Transition(script, mapOf(Pair(circleToMove, updatedCircle)), originalState, updatedState)
}