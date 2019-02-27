package cinema.dto;

import cinema.persistence.entity.Film;

public class FilmDto {
	private Integer id;
	private String title;
	private Short year;
	private Short duration;
	
	public FilmDto(Integer id, String title, Short year, Short duration) {
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

	public Short getYear() {
		return year;
	}

	public void setYear(Short year) {
		this.year = year;
	}

	public Short getDuration() {
		return duration;
	}

	public void setDuration(Short duration) {
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
