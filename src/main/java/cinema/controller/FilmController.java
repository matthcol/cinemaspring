package cinema.controller;

import java.util.Collections;
import java.util.NavigableSet;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.Application;
import cinema.dto.FilmDto;
import cinema.service.IFilmService;

@RestController
@RequestMapping("/api/film")
public class FilmController {
	
	Logger logger = LoggerFactory.getLogger(FilmController.class);
	
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

	@PostMapping
	@ResponseBody
	public FilmDto createFilm(@RequestBody FilmDto film) {
		logger.info("Film DTO received : " +film);
		return filmService.createFilm(film);
		
	}
}
