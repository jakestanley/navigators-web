var health = 100;
var polarity = "decrementing";

function getHealth(){
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
	return health; // I really want this to connect to node js to get information. Node js then must access a database or local variable to get information and this function will return what it gets
}

function loaded(){
	return "Successfully loaded game logic";
}

function gameLoop(){
	$('dyn#healthVal').html(getHealth());
	$('#statusBar').html("Information shows up here that does not change when you change interfaces, if that makes sense.<br>Shield health: " + polarity);
}