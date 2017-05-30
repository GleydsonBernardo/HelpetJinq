package br.com.helpet.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.helpet.util.DateConvertUtils;

@Entity
@Table(name="ADOPTION")
public class Adoption extends BaseEntity implements Cloneable{

	private Animal animal;
	private Person person;
	private Date date;
	
	public Adoption() {
	}

	public Adoption(Animal animal, Person person, Date date) {
		this.animal = animal;
		this.person = person;
		this.date = date;
	}

	@OneToOne
	@JoinColumn(name="animal_id", nullable = false)
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@ManyToOne
	@JoinColumn(name="person_id", nullable=false)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Column(name = "adoption_date", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	@Override
	public String toString(){
		LocalDate localDate = DateConvertUtils.asLocalDate(this.date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return "Adoção   [Data: "+this.date+" \n\t "+this.person+" \n\t "+this.animal+"];";
	}
	
	@Override
	public Adoption clone() {
		try {
			return (Adoption) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}
}
