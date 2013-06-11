var health = 100;
var polarity = "decrementing";
var connection = new WebSocket('ws://localhost:8080');
connection.onopen = function(){ // could put this stuff in another js file
    console.log("Opened connection.");
	connection.send("CLIENT: My name is Jake.");
};

connection.onmessage = function(evt){
	if(evt.data == "err"){
		console.log(evt.data);
	}
	health = evt.data;
}

function gameLoop(){ // Need a loop for listening on the connection also
	$('dyn#healthVal').html(getHealth());
	$('#statusBar').html("Information shows up here that does not change when you change interfaces, if that makes sense.<br>Shield health: " + polarity);
}

function getHealth(){
	// if(polarity == "decrementing"){
	// 	health--;
	// } else {
	// 	health++
	// }
	// if(health == 0){
	// 	polarity = "incrementing";
	// } else if(health == 100) {
	// 	polarity = "decrementing"
	// }
	return health; // I really want this to connect to node js to get information. Node js then must access a database or local variable to get information and this function will return what it gets
}

function loaded(){
	return "Successfully loaded game logic";
}

