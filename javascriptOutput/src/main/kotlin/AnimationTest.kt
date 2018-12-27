import Snap.Paper


class AnimationTest {



    fun draw() {
        var snap = Snap(600, 800)

        drawCircle(snap)

    }


    fun drawCircle(snap: Paper) {
        val circle = snap.circle(100, 200, 20)
        circle.node.onclick = {
            circle.attr("fill", "red")
        }

    }



    fun drawMatrix(snap: Paper) {
        // TODO




    }


}