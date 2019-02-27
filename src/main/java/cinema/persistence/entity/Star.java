package cinema.persistence.entity;

import java.time.LocalDate;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Individu")
public class Star {
	private Integer id;
	private String firstName;
	private String lastName;
	private LocalDate birthdate;
	private String country;
	
	public Star(String firstName, String lastName, LocalDate birthdate, String country) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthdate = birthdate;
		this.country = country;
	}

	public Star(String firstName, String lastName, LocalDate birthdate) {
		this(firstName, lastName, birthdate, null);
	}

	public Star(String firstName, String lastName) {
		this(firstName, lastName, null);
	}

	public Star() {
		super();
	}
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="num_ind")
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name="prenom")
	public String getFirstName() {
		return firstName;
	}

	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Column(name="nom", nullable=false)
	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	@Column(name="date_naissance")
	public LocalDate getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(LocalDate birthdate) {
		this.birthdate = birthdate;
	}

	@Column(name="country")
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}
	
	@Override
	public String toString() {
		return new StringBuilder(firstName)
				.append(' ')
				.append(lastName)
				.append(" (")
				.append(Objects.toString(birthdate, "?"))
				.append(',')
				.append(Objects.toString(country, "?"))
				.append(')')
				.toString();
	}
	
}
