package cinema.persistence.repository;

//import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import cinema.Application;
import cinema.persistence.entity.Film;
import cinema.persistence.entity.Star;

@RunWith(SpringRunner.class)  // for Junit 4 only
@SpringBootTest
@DataJpaTest
//@SpringBootConfiguration(Application.class)
//@Import(MyTestsConfiguration.class)
public class TestFilmRepository {

	@Autowired
	FilmRepository filmRepo;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void testFilmAll() {
		//given
		Film film = new Film("Star Wars");
		entityManager.persist(film);
		entityManager.flush();
		int id = film.getId();
		// when
		Film found =  filmRepo.findOne(id);
		System.out.println(found);
		assertThat(found.getTitle())
			.isEqualTo(film.getTitle());
				
	}

}
