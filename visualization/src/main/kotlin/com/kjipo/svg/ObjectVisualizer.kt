package com.kjipo.svg

import com.kjipo.state.Circle
import com.kjipo.state.LayoutObject


fun visualize(layoutObject: LayoutObject): String {
    return when(layoutObject) {
        is Circle -> visualize(layoutObject)
        else -> ""
    }

}


fun visualize(circle: Circle) = """drawCircle(${circle.xCenter}, ${circle.yCenter}, ${circle.radius}, "elemId${circle.id}");"""