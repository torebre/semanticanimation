var mjAPI = require("mathjax-node");


mjAPI.config({
    MathJax: {
        // traditional MathJax configuration
    }
});
mjAPI.start();


doTranformation(process.argv[2]);

async function doTranformation(inputMath) {
    var svg;

    let promise = new Promise((resolve, reject) => {
        mjAPI.typeset({
                math: inputMath,
                format: "MathML",
                svg: true,
            },
            function (data) {
                if (!data.errors) {
                    console.log(data.svg);

                    resolve(data.svg);
                }
                else {
                    reject(data.errors);
                }
            }
        )
    });


    await promise;

    return promise.svg;
}