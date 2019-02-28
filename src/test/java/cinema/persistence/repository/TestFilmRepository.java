package cinema.persistence.repository;

//import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import cinema.assertions.FilmAssertions;
import cinema.persistence.entity.Film;


@RunWith(SpringRunner.class)  // for Junit 4 only
@SpringBootTest
@DataJpaTest
//@Transactional
public class TestFilmRepository {

	@Autowired
	FilmRepository filmRepo;
	
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void testFindOne() {
		//given
		Film film = new Film("Star Wars", 1977, 121);
		entityManager.persist(film);
		entityManager.flush();
		int id = film.getId();
		// when
		Film found =  filmRepo.findOne(id);
		System.out.println(found);
		// then
		assertThat(found)
			.isEqualToComparingFieldByField(film);
	}
	
	@Test
	public void testFindAll() {
		//given
		Film film = new Film("Star Wars", 1977, 121);
		entityManager.persist(film);
		film = new Film("Star Wars: Episode V - The Empire Strikes Back", 1980, 124);
		entityManager.persist(film);
		entityManager.flush();
		// when
		List<Film> found =  filmRepo.findAll();
		System.out.println(found);
		// then
		assertThat(found)
			.hasSize(2);
	}
	
	@Test
	public void testFindByTitle() {
		//given : 2 films with the same title
		String title = "The Man Who Knew Too Much";
		Film film = new Film(title, 1934, 75);
		entityManager.persist(film);
		film = new Film(title, 1956, 120);
		entityManager.persist(film);
		entityManager.flush();
		// when
		Set<Film> found =  filmRepo.findByTitle(title);
		System.out.println(found);
		// then
		assertThat(found)
			.hasSize(2);
		found.stream()
			.map(Film::getTitle)
			.forEach(t -> assertThat(t).isEqualTo(title));
	}
	
	

}
