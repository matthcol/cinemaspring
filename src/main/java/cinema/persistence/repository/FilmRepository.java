package cinema.persistence.repository;

import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistence.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{
	// gifts : findAll/getOne(id)/getById(id)/save/delete/count/...
	
	// extensions for this entity :
	Set<Film> findByTitle(String title);
	Set<Film> findByYear(Integer year);
	Set<Film> findByTitleAndYear(String title, Integer year);
	Set<Film> findByDurationGreaterThanEqual(Integer duration);
	Set<Film> findByDurationLessThanEqual(Integer duration);
}
