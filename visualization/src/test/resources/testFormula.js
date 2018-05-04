// a simple TeX-input example
// var mjAPI = require("./lib/main.js");

var mjAPI = require("mathjax-node");
mjAPI.config({
    MathJax: {
        // traditional MathJax configuration
    }
});
mjAPI.start();

// var yourMath = 'E = mc^2';

var yourMath = "<math><msqrt><mn>2</mn></msqrt><msqrt><mn>2</mn></msqrt><msqrt><mn>2</mn><mi id=\"1\">y</mi></msqrt></math>";

// var yourMath = "<math><mrow> <msup><mfenced><mrow><mi>a</mi><mo>+</mo><mi>b</mi></mrow></mfenced><mn>2</mn></msup></mrow></math>";



mjAPI.typeset({
    math: yourMath,
    format: "MathML", //"TeX", // or "inline-TeX", "MathML"
    //mml:true,      // or svg:true, or html:true
    svg:true
}, function (data) {
    if (!data.errors) {console.log(data.svg)}
});