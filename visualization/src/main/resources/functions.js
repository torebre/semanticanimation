function drawCircle(x, y, radius, id) {
    const circle = snap.circle(x, y, radius);
    circle.attr({
        id: id
    });
}


function move(xNew, yNew, circleId) {
   const circle = Snap.select("#" + circleId);

    circle.animate(
        {
            cx: xNew,
            cy: yNew
        },
        1000);

}


function moveEquation(newPath, id) {
    // const equation = Snap.select("#test");
    const equation = Snap.select("#" +id);

    equation.animate(
        {
            d: newPath
        },
        1000);
}


function createPath(path, id) {
    // const s = Snap(400, 620);

// <svg width="3.125ex" height="2.625ex" viewBox="0 -941.2 1343 1117.2"


    // const s = Snap("30.125ex", "20.625ex");
    // s.attr({viewBox: "0 -941.2 1343 1117.2"});
    const snapPath = snap.path(path);
    snapPath.attr({
        id: id
    })

}

function drawTestAnimation()  {
    // s = Snap(400, 620);

    var path = snap.path("M94.2,265.7L82,203.4c43.3-15.6,83.8-29.2,137.1-20.2c61.5-27.6,126.1-56.9,202.6 46.1c18.7,18.9,21.5,39.8,12.2,62.3C322.7,231.9,208.2,247.6,94.2,265.7z");

    // path.animate({ d: "M179.4,83.5l62.4-11.8c15.3,43.4-76,102.6-22.6,111.5c61.5-27.6,126.1-56.9,202.6-46.1c18.7,18.9,21.5,39.8,12.2,62.3C250.6,296.7,52.4,259.2,179.4,83.5z" }, 1000, mina.bounce);
    path.animate({ d: "M20" }, 1000, mina.bounce);


// var path2= s.path("M94.2,265.7L82,203.4c43.3-15.6,83.8-29.2,137.1-20.2c61.5-27.6,126.1-56.9,202.6 46.1c18.7,18.9,21.5,39.8,12.2,62.3C322.7,231.9,208.2,247.6,94.2,265.7z");
//
// path2.animate({ d: "M179.4,83.5l62.4-11.8c15.3,43.4-76,102.6-22.6,111.5c61.5-27.6,126.1-56.9,202.6-46.1c18.7,18.9,21.5,39.8,12.2,62.3C250.6,296.7,52.4,259.2,179.4,83.5z" }, 1000, mina.bounce);

}