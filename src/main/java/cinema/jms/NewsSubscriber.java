package cinema.jms;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;

import org.springframework.stereotype.Component;

import cinema.dto.FilmDto;

@Component
public class NewsSubscriber {
	
	Logger logger = LoggerFactory.getLogger(NewsSubscriber.class);

    @JmsListener(destination = "film") //, containerFactory = "myFactory")
    public void receiveMessage(FilmDto film) {
        logger.info("News received : "  + film);
    }
}
