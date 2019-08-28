package cinema.dto;

import java.io.Serializable;

import cinema.persistence.entity.Film;

public class FilmDto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -1120769420933840859L;
	
	private Integer id;
	private String title;
	private Integer year;
	private Integer duration;
	
	public FilmDto() {
		super();
	}

	public FilmDto(Integer id, String title, Integer year, Integer duration) {
		super();
		this.id = id;
		this.title = title;
		this.year = year;
		this.duration = duration;
	}
	
	public FilmDto(Film film) {
		this(film.getId(),film.getTitle(), film.getYear(), film.getDuration());
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Integer getYear() {
		return year;
	}

	public void setYear(Integer year) {
		this.year = year;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
	
	@Override
	public String toString() {
		return new StringBuilder(this.getTitle())
				.append(" (")
				.append(this.getYear())
				.append(", ")
				.append(this.getDuration())
				.append("mn)")
				.toString();
	}

}
