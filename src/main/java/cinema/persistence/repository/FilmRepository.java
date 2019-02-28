package cinema.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistence.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{
	
	Set<Film> findByTitle(String title);

}
