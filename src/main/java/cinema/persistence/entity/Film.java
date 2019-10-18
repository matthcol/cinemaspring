package cinema.persistence.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
//@Table(name="movie")  // to map another table name
public class Film {
	private Integer id;
	private String title;
	private Integer year;
	private Integer duration;
	
	public Film() {
		super();
	}
	
	
	public Film(String title) {
		this();
		this.title = title;
	}


	public Film(String title, Integer year) {
		this(title);
		this.year = year;
	}

	

	public Film(String title, Integer year, Integer duration) {
		this(title, year);
		this.duration = duration;
	}

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	//@Column(name="num_film") // to map another column name
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	// @Column(name="titre", nullable=false) // different name + not null constraint
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	//@Column(name="annee")
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	
	//@Column(name="duree")
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
				.append(this.getId())
				.append(", ")
				.append(this.getYear())
				.append(", ")
				.append(this.getDuration())
				.append("mn)")
				.toString();
	}
}
