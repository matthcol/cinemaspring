var urlFilmRestApi = "api/film"

function displayFilms() {
		$("#listFilm").empty()
        $.getJSON(urlFilmRestApi)
        .fail(function(){
        	console.log("unable to access rest api:"+urlFilmRestApi)
        })
        .done(function(data){
        	$.each( data, function( i, item ) {
        		console.log("Film:" + item)
        		var filmHTML = 	$( "<li></li>" ).text(
        				item['title'] + '(' 
        				+  item['year'] + ')'
        				)
        		$("#listFilm").append(filmHTML)
        	})
        })
}

function prepareSendFilm() {
	$("#formFilm").submit(function(event){
		// prevent default submit mechanism
		event.preventDefault()	
		// retrieve data from form as a JSon
		var title = $(this).find( "input[name='title']").val()
		var year = $(this).find( "input[name='year']").val()
		var filmJSONObject = {"title":title, "year":year}
		var filmJSONString = JSON.stringify(filmJSONObject)
		console.log("Film to be sent:")
		console.log(filmJSONString)
		// send the JSON data to rest api in POST
//		$.post(urlFilmRestApi, filmJSONString)
//			.done(function(filmJSONResponse) {
//					console.log("Film added:")
//					console.log(filmJSONResponse)
//					// refresh list film
//					displayFilms()
//					// TODO : instead retrieve response data 
//					// and just add it to the html list
//			})
//			.fail(function(jqXHR, textStatus, errorThrown){
//					console.log("Fail adding film:")
//					console.log(textStatus)
//					console.log(errorThrown)
//			})	
	})
}

$(window).on('load',function(){
	displayFilms()
	prepareSendFilm()
})

