function drawCircle(x, y, radius, id) {
    var circle = snap.circle(x, y, radius);
    circle.attr({
        id: id
    });
}


function move(xNew, yNew, circleId) {
    circle = Snap.select("#" + circleId);

    circle.animate(
        {
            cx: xNew,
            cy: yNew
        },
        1000);

}