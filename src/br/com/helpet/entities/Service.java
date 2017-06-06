package br.com.helpet.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="SERVICE")
public class Service extends BaseEntity implements Cloneable{

	private double value;
	private String description;
	
	private Collection<Expense> expenses;
	
	public Service() {
	}

	public Service(double value, String description) {
		this.value = value;
		this.description = description;
	}

	@Column(name="value", nullable = false)
	public double getValue() {
		return value;
	}

	public void setValue(double value) {
		this.value = value;
	}

	@Column(name="description", nullable=false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@Override
	public String toString(){
		return "Serviço  [Descrição: "+this.description+" Valor: "+this.value+"];";
	}
	
	@Override
	public Service clone() {
		try {
			return (Service) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}

	@OneToMany(mappedBy="service", cascade = CascadeType.PERSIST)
	public Collection<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Collection<Expense> expenses) {
		this.expenses = expenses;
	}
}
