package com.kjipo.state

class LayoutState(val objects: Collection<LayoutObject>) {


}


interface LayoutObject {
    val id: Int


}

class Transition(val transitionScript: String, val changedObjects: Map<LayoutObject, LayoutObject>,
                 val originalState: LayoutState, val newState: LayoutState) {


}


class Circle(val xCenter: Int, val yCenter: Int, val radius: Int, override val id: Int) : LayoutObject {


}





