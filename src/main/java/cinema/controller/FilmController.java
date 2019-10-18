package cinema.controller;

import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cinema.persistence.entity.Film;
import cinema.persistence.repository.FilmRepository;



@RestController
@RequestMapping("/api/film")
public class FilmController {
	
	@Autowired
	FilmRepository filmRepo;
	
	@GetMapping
	@ResponseBody
	List<Film> findAll(){
		return filmRepo.findAll();
	}
	
	@GetMapping(value="/{id}")
	@ResponseBody
	Film findById(@PathVariable("id") Integer id) {
		return filmRepo.getOne(id);
	}

	@PostMapping
	@ResponseBody
	public Film createFilm(@RequestBody Film film) {
		return filmRepo.save(film);
	}
}
