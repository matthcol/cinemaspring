package cinema.service.impl;

import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cinema.dto.FilmDto;
import cinema.dto.DtoUtils;
import cinema.persistence.repository.FilmRepository;
import cinema.service.IFilmService;

@Service
@Transactional
public class FilmService implements IFilmService {

	@Autowired
	FilmRepository filmRepo;
	
	@Override
	public Set<FilmDto> findAll() {
		return DtoUtils.setFromEntityStream(
				filmRepo.findAll().stream(), 
				FilmDto::new);
	}

	@Override
	public FilmDto findOne(Integer id) {
		return DtoUtils.dtoFromEntity(filmRepo.findOne(id), FilmDto::new);
	}

}
