package br.com.helpet.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="ADDRESS")
public class Address extends BaseEntity implements Cloneable{

	private String street;
	private String city;
	private String state;
	private String complement;
	
	private Person person;
	
	public Address() {
	}
	
	public Address(String street, String city, String state, String complement) {
		this.street = street;
		this.city = city;
		this.state = state;
		this.complement = complement;
	}

	@Column(name="street", nullable=false)
	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	@Column(name="city", nullable=false)
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name="state", nullable=false)
	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	@Column(name="complement", nullable=false)
	public String getComplement() {
		return complement;
	}

	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	@OneToOne(mappedBy="address", cascade=CascadeType.REMOVE)
	public Person getPerson() {
		return person;
	}
	
	public void setPerson(Person person) {
		this.person = person;
	}
	
	@Override
	public String toString(){
		return "Endereço [Rua: "+this.street+" - Cidade: "+this.city+" - Estado: "+this.state+" - Complement: "+this.complement+"];";
	}
	
	@Override
	public Address clone() {
		try {
			return (Address) super.clone();
		} catch (CloneNotSupportedException e) {
			throw new InternalError(e.getMessage());
		}
	}

}
