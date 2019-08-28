package cinema.service.impl;

import java.util.Set;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.converter.MappingJackson2MessageConverter;
import org.springframework.jms.support.converter.MessageConverter;
import org.springframework.jms.support.converter.MessageType;

import cinema.dto.FilmDto;
import cinema.controller.FilmController;
import cinema.dto.DtoUtils;
import cinema.persistence.entity.Film;
import cinema.persistence.repository.FilmRepository;
import cinema.service.IFilmService;

@Service
@Transactional
public class FilmService implements IFilmService {

	Logger logger = LoggerFactory.getLogger(FilmService.class);
	
	@Autowired
	private ModelMapper mapper;
	
	@Autowired
    private JmsTemplate jmsTemplate;
	
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
		FilmDto filmSaved =  mapper.map(
				filmRepo.save(filmEntity), 
				FilmDto.class);
		jmsTemplate.convertAndSend("FILM",filmSaved);
		logger.info("Film sent to JMS:" + filmSaved);
		return filmSaved;
	}
	
// Uncomment this block to send film as a text json message
	@Bean // Serialize message content to json using TextMessage
    public MessageConverter jacksonJmsMessageConverter() {
        MappingJackson2MessageConverter converter = new MappingJackson2MessageConverter();
        converter.setTargetType(MessageType.TEXT);
        converter.setTypeIdPropertyName("_type");
        return converter;
    }

}
