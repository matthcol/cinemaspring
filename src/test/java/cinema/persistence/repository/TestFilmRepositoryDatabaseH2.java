package cinema.persistence.repository;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.ActiveProfiles;

import cinema.persistence.entity.Film;


@DataJpaTest // imply H2, disable full auto-config, keep only jpa part and rollback transactions
//@AutoConfigureTestDatabase(replace=Replace.NONE) // don't replace mysql with h2
//@ActiveProfiles("test")  	// with AutoConfigureTestDatabase/replace/None 
//							// allow to load application-test.properties 
//							// instead of application.properties
//							// to address another mysql database for tests only
public class TestFilmRepositoryDatabaseH2 {

	@Autowired
	FilmRepository filmRepo;
		
	// use special test H2 entityManager different from configuration application
	@Autowired
	TestEntityManager entityManager;
	
	@Test
	public void testFindOne() {
		//given
		var title = "Star Wars";
		Integer year = 1977;
		Integer duration = 121;
		var filmInserted = new Film(title, year, duration);
		entityManager.persist(filmInserted);
		entityManager.flush();
		var id = filmInserted.getId();
		// when
		var found =  filmRepo.getOne(id);
		// then
		assertAll(
				()->assertEquals(id, found.getId()),
				()->assertEquals(title,  found.getTitle()),
				()->assertEquals(year,  found.getYear()),
				()->assertEquals(duration,  found.getDuration())
		);
	}
	
	@Test
	public void testFindAll() {
		//given
		var film = new Film("Star Wars", 1977, 121);
		entityManager.persist(film);
		film = new Film("Star Wars: Episode V - The Empire Strikes Back", 1980, 124);
		entityManager.persist(film);
		entityManager.flush();
		// when
		var found =  filmRepo.findAll();
		// then
		assertEquals(2, found.size());
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
		assertAll(
				()-> assertEquals(2, found.size()),
				()-> assertAll(found.stream()
						.map(Film::getTitle)
						.map(t-> ()->assertEquals(title,t)))
		);
	}
	
	@Test
	public void testFindByTitleAndYear() {
		//given : 2 films with the same title but different year
				// TODO
		// when : find one of both
				// TODO
		// then : check you find the right one
				// TODO
		//fail("TODO : testFindByTitleAndYear");
	}
	
	@Test
	public void testFindByDurationGreaterThanEqual() {
		//given : one duration,  2 films under this duration, one equal, 2 above
				// TODO
		// when : find all above or equal this duration
				// TODO
		// then : check you have the right number and the good ones
				// TODO
		//fail("TODO : testFindByDurationGreaterThanEqual");
	}
	
	@Test
	public void testFindByDurationLessThanEqual() {
				// TODO
		//fail("TODO : testFindByDurationGreaterThanEqual");
	}


	@Test 
	public void testSave() {
		// given : one new Film
		// when : save the film with the repository
		// then : the film has been saved and given a new ID
	}

}
