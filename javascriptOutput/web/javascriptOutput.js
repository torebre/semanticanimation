if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'javascriptOutput'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'javascriptOutput'.");
}
var javascriptOutput = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main(args) {
    var message = 'Hello JavaScript!';
    println(message);
  }
  var package$com = _.com || (_.com = {});
  var package$kjipo = package$com.kjipo || (package$com.kjipo = {});
  var package$trellis = package$kjipo.trellis || (package$kjipo.trellis = {});
  package$trellis.main_kand9s$ = main;
  main([]);
  Kotlin.defineModule('javascriptOutput', _);
  return _;
}(typeof javascriptOutput === 'undefined' ? {} : javascriptOutput, kotlin);
