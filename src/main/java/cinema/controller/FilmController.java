package cinema.controller;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.dto.FilmDto;
import cinema.service.IFilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController {
	
	@Autowired
	IFilmService filmService;
	
	@GetMapping
	@ResponseBody
	Set<FilmDto> findAll(){
		return filmService.findAll();
	}
	
	@GetMapping(value="/{id}")
	@ResponseBody
	FilmDto findById(@PathVariable("id") Integer id) {
		return filmService.findOne(id);
	}

}
