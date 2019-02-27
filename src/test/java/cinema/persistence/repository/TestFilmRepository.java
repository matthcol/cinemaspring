package cinema.persistence.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;

import cinema.persistence.entity.Film;

@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
//@Import(MyTestsConfiguration.class)
class TestFilmRepository {

	@Autowired
	FilmRepository filmRepo;
	
	@Test
	void testFilmAll() {
		List<Film> films = filmRepo.findAll();
		System.out.println(films);
	}

}
