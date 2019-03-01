package cinema.persistence.repository;

//import static org.junit.Assert.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;

import org.junit.Before;
import org.junit.BeforeClass;
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
//@AutoConfigureTestDatabase(replace=Replace.NONE) // don't replace mysql with h2
//@ActiveProfiles("test")  	// with AutoConfigureTestDatabase/replace/None 
//							// allow to load application-test.properties 
//							// instead of application.properties
//							// to address another mysql database for tests only
public class TestFilmRepositoryDatabaseH2Exo {

	@Autowired
	FilmRepository filmRepo;
	
	// **********************************************************************
	// use classic entityManager initialized from configuration application
	//@Autowired
	//EntityManager entityManager;

	// **** ^^^^^^^^^^^^^  versus    vvvvvvvvvvvvvvvvvv  ****
	
	// use special test H2 entityManager different from configuration application
	@Autowired
	TestEntityManager entityManager;
	// *************************************************************************
	

	
	
	@Test
	public void testFindByTitleAndYear() {
		//given : 2 films with the same title but different year
				// TODO
		// when : find one of both
				// TODO
		// then : check you find the right one
				// TODO
		fail("TODO : testFindByTitleAndYear");
	}
	
	@Test
	public void testFindByDurationGreaterThanEqual() {
		//given : one duration,  2 films under this duration, one equal, 2 above
				// TODO
		// when : find all above or equal this duration
				// TODO
		// then : check you have the right number and the good ones
				// TODO
		fail("TODO : testFindByDurationGreaterThanEqual");
	}
	
	@Test
	public void testFindByDurationLessThanEqual() {
				// TODO
		fail("TODO : testFindByDurationGreaterThanEqual");
	}


	@Test 
	public void testSave() {
		// given : one new Film
		// when : save the film with the repository
		// then : the film has been saved and given a new ID
	}
}
