#!/usr/bin/env bash

# TODO Why is the module not found is the path is not explicitly set like this?
export NODE_PATH=/home/student/.nvm/versions/node/v8.9.4/lib/node_modules
/home/student/.nvm/versions/node/v8.9.4/bin/node testFormula.js > equation_svg.svg