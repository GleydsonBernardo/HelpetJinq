package br.com.helpet.entities;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "ANIMAL")
public class Animal extends BaseEntity implements Cloneable{

	private String specie;
	private String breed;
	private String gender;
	private double weight;
	private int age;
	private String description;
	private Person person;
	
	private Adoption adoption;
	private Collection<Expense> expenses;
	
	public Animal() {
		
	}

	public Animal(String specie, String breed, String gender, double weight, int age, String description, Person person) {
		this.specie = specie;
		this.breed = breed;
		this.gender = gender;
		this.weight = weight;
		this.age = age;
		this.description = description;
		this.person = person;
	}

	@Column(name="specie", nullable = false)
	public String getSpecie() {
		return this.specie;
	}

	public void setSpecie(String specie) {
		this.specie = specie;
	}

	@Column(name="breed", nullable = false)
	public String getBreed() {
		return breed;
	}

	public void setBreed(String breed) {
		this.breed = breed;
	}

	@Column(name="gender", nullable = false)
	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Column(name="weight", nullable = false)
	public double getWeight() {
		return weight;
	}

	public void setWeight(double weight) {
		this.weight = weight;
	}

	@Column(name = "age", nullable = true)
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Column(name="description", nullable = false)
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@ManyToOne
	@JoinColumn(name="person_id", nullable = true, updatable = true)
	public Person getPerson() {
		return person;
	}

	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public String toString(){
		return "Animal  [Espécie: "+this.specie+" - Raça: "+this.breed+" - Gênero: "+this.gender+" - Peso: "+this.weight+" - Idade: "
				+ ""+this.age+" - Descrição: "+this.description+" \n\t Dono: "+this.person+"];";
	}
	
	@Override
	public Animal clone() {
		try {
			return (Animal) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}

	@OneToOne(mappedBy="animal", cascade = CascadeType.PERSIST)
	public Adoption getAdoption() {
		return adoption;
	}

	public void setAdoption(Adoption adoption) {
		this.adoption = adoption;
	}

	@OneToMany(mappedBy="animal", cascade = CascadeType.PERSIST)
	public Collection<Expense> getExpenses() {
		return expenses;
	}

	public void setExpenses(Collection<Expense> expenses) {
		this.expenses = expenses;
	}
}
