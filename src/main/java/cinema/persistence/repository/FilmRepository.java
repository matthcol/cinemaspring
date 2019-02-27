package cinema.persistence.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cinema.persistence.entity.Film;

public interface FilmRepository extends JpaRepository<Film, Integer>{

}
