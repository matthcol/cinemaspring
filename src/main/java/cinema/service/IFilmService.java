package cinema.service;

import java.util.Set;

import cinema.dto.FilmDto;

public interface IFilmService {
	Set<FilmDto> findAll();
	FilmDto findOne(Integer id);
}
