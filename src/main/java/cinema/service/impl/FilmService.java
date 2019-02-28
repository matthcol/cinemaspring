package cinema.service.impl;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.dto.FilmDto;
import cinema.dto.DtoUtils;
import cinema.persistence.entity.Film;
import cinema.persistence.repository.FilmRepository;
import cinema.service.IFilmService;

@Service
@Transactional
public class FilmService implements IFilmService {
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
	FilmRepository filmRepo;
	
	@Override
	public Set<FilmDto> findAll() {
		return DtoUtils.setFromEntityStream(
				filmRepo.findAll().stream(),
				mapper,
				FilmDto.class);
	}

	@Override
	public FilmDto findOne(Integer id) {
		return mapper.map(
				filmRepo.findOne(id), 
				FilmDto.class);
	}

	@Override
	public FilmDto createFilm(FilmDto film) {
		Film filmEntity = mapper.map(film, Film.class); 
		return mapper.map(
				filmRepo.save(filmEntity), 
				FilmDto.class);
	}

}
