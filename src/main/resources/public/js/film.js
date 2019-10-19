// configure AJAX dialog to be in JSON
var urlFilmRestApi = "api/film"
$.ajaxSetup({
	contentType:"application/json; charset=utf-8"
})
	

// display data in the HTML
function displayOneFilmMore(film){
	console.log("Display film:")
	console.log(film)
	var filmHTML = 	$("<li></li>").text(
			film['title'] + '(' 
			+  film['year'] + ')'
			)
	$("#listFilm").append(filmHTML)
}

function displayFilms(films) {
	$("#listFilm").empty()
	$.each(films, function( i, film) {
		displayOneFilmMore(film)
	})
}

function getAndDisplayAllFilms() {
	// get data from the rest API
    $.getJSON(urlFilmRestApi)
    .fail(function(jqXHR, textStatus, errorThrown){
    	console.log("unable to access rest api ("
    			+urlFilmRestApi
    			+"):" +textStatus)
    })
    .done(displayFilms)
}

// send the data from the form to the Rest API
function postFilm(){		
	// retrieve data from form as a JSon
	var film = {
			title: $('#title').val(),
			year:  $('#year').val()
	}
	var filmJSON = JSON.stringify(film)
	console.log("Film sent:")
	console.log(film)
	console.log(filmJSON)
	// send the JSON data to rest api in POST
	$.post(urlFilmRestApi,filmJSON)
		.done(function(filmResponse) {
				console.log("Film added:")
				console.log(filmResponse)
				// refresh list film
				displayOneFilmMore(filmResponse)
		})
		.fail(function(jqXHR, textStatus, errorThrown){
				console.log("Fail adding film:"+textStatus)
		})	
}

// After the page is loaded :
// display films (GET)
// and attach event to submit form (prepare POST)
$(window).on('load',function(){
	getAndDisplayAllFilms()
	$("#formFilm").submit(function(event) {
		// prevent default submit mechanism
		event.preventDefault()
		postFilm()
	})
})