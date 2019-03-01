package cinema.persistence.repository;

//import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import cinema.persistence.entity.Film;


@RunWith(SpringRunner.class)  // for Junit 4 only
@DataJpaTest // imply H2, disable full auto-config, keep only jpa part and rollback transactions
@AutoConfigureTestDatabase(replace=Replace.NONE) // don't replace mysql with h2
@ActiveProfiles("test")  	// with AutoConfigureTestDatabase/replace/None 
							// allow to load application-test.properties 
							// instead of application.properties
							// to address another mysql database for tests only
public class TestFilmRepositoryDatabaseSameKind {

	@Autowired
	FilmRepository filmRepo;
	
	// **********************************************************************
	// use classic entityManager initialized from configuration application
	@Autowired
	EntityManager entityManager;

	// **** ^^^^^^^^^^^^^  versus    vvvvvvvvvvvvvvvvvv  ****
	
	// use special test H2 entityManager different from configuration application
//	@Autowired
//	TestEntityManager entityManager;
	// *************************************************************************

	
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
