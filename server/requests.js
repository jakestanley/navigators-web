// Does different stuff based on requests to the node.js server

var exec = require("child_process").exec;

function start() {
  console.log("Request handler 'start' was called.");
  var content = "empty";
  
  exec("ls -lah", function (error, stdout, stderr) { 
	  content = stdout;
  });
	return "Hello Start";
}

function sleep(milliSeconds) {
	var startTime = new Date().getTime();
	while (new Date().getTime() < startTime + milliSeconds);
}

function upload() {
console.log("Request handler 'upload' was called.");
return "Upload function";
}

exports.start = start;
exports.upload = upload;