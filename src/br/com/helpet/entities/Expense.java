package br.com.helpet.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import br.com.helpet.util.DateConvertUtils;

@Entity
@Table(name="EXPENSE")
public class Expense extends BaseEntity implements Cloneable{

	private Animal animal;
	private Service service;
	private Date date;
	
	public Expense() {
	}

	public Expense(Animal animal, Service service, Date date) {
		this.animal = animal;
		this.service = service;
		this.date = date;
	}

	@ManyToOne
	@JoinColumn(name="animal_id", nullable = false)
	public Animal getAnimal() {
		return animal;
	}

	public void setAnimal(Animal animal) {
		this.animal = animal;
	}

	@ManyToOne
	@JoinColumn(name="service_id", nullable = false)
	public Service getService() {
		return service;
	}

	public void setService(Service service) {
		this.service = service;
	}

	@Column(name = "expense_date", nullable = false)
	@Temporal(TemporalType.DATE)
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	public String toString(){
		LocalDate localDate = DateConvertUtils.asLocalDate(this.date);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
		return "Despesa  [Data: "+this.date+"  \n\t "+this.animal+" \n\t "+this.service+"];";
	}
	
	@Override
	public Expense clone() {
		try {
			return (Expense) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}
}
