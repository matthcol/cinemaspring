package cinema.persistence.entity;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class Film {
	private Integer id;
	private String title;
	private Short year;
	private Short duration;
	private Star director;
	private List<Star> actors;
	
	public Film() {
		super();
	}
	
	
	public Film(String title) {
		super();
		this.title = title;
	}


	public Film(String title, Short year) {
		super();
		this.title = title;
		this.year = year;
	}


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_film")
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	@Column(name="titre", nullable=false)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	@Column(name="annee")
	public Short getYear() {
		return year;
	}
	public void setYear(Short year) {
		this.year = year;
	}
	
	@Column(name="duree")
	public Short getDuration() {
		return duration;
	}

	public void setDuration(Short duration) {
		this.duration = duration;
	}
	
//	@ManyToOne
//	@JoinColumn(name="num_real")
	@Transient
	public Star getDirector() {
		return director;
	}
	public void setDirector(Star director) {
		this.director = director;
	}
	
//	@ManyToMany
//	@JoinTable(
//	        name = "jouer", 
//	        joinColumns =  @JoinColumn(name = "num_film") , 
//	        inverseJoinColumns =  @JoinColumn(name = "num_act"))
	@Transient
	public List<Star> getActors() {
		return actors;
	}
	public void setActors(List<Star> actors) {
		this.actors = actors;
	}

}
