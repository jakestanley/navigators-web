var http = require("http"); 
var url = require("url");

var health = 100;var polarity = "decrementing";

var WebSocketServer = require('ws').Server // all ws handling stuff goes in this function, or it could be pass to another function
  , wss = new WebSocketServer({port: 8080});
wss.on('connection', function(ws) {
    wss.on('message', function(message) { // Need a message parser
		// if(message == "health"){
		// 	ws.send(health);
		// }
        console.log('received: %s', message);
    });
    ws.send('err');
	console.log("Connection received from " + ws.host + " on port " + ws.port);
});

function start(route, handle) {
function onRequest(request, response) {
var pathname = url.parse(request.url).pathname; console.log("Request for " + pathname + " received.");
    var content = route(handle, pathname);
    response.writeHead(200, {"Content-Type": "text/plain"});
    response.write(content);
    response.end();
}
  http.createServer(onRequest).listen(8888); // Seems connectionless. May need to poll for updates.
  console.log("Server has started.");
}

function parseMessage(message){
	// hue
}

function setHealth(){
	if(polarity == "decrementing"){
		health--;
	} else {
		health++
	}
	if(health == 0){
		polarity = "incrementing";
	} else if(health == 100) {
		polarity = "decrementing"
	}
	// console.log(health);
	// wss.send(health);
}



exports.start = start;

setInterval(setHealth, 30)

// Installed and working Node WebSockets implementation: npm install ws http://einaros.github.io/ws/

// Server needs to backup to some kind of database every now and then. If the server crashes, or power is lost, etc, then I don't want users to lose too much progress in the game.

// Another idea I have is 'intercept courses'. Players can intercept other ships, but because space is vast this will take a while.
// Communications interception: Find out where a ship is going and meet it there to attack it? Comms interception is a very advanced process, but it is highly effective because it can catch ships offguard without warning.